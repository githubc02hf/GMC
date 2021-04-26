package at.campus02.gmc.ebike.controller;

import at.campus02.gmc.ebike.model.EBike;
import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.model.User;
import at.campus02.gmc.ebike.repository.EbikeRepository;
import at.campus02.gmc.ebike.repository.InvoiceRepository;
import at.campus02.gmc.ebike.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    EbikeRepository ebikeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/currentInvoice")
    public @ResponseBody
    Invoice getCurrentInvoice(@RequestParam String email) {
        return invoiceRepository.queryBy(email);
    }

    @PostMapping("/rentBike")
    public @ResponseBody
    Invoice rentBike(@RequestParam Integer stationId, @RequestParam String email) {

        // find available EBike
        EBike availableEbike = getAvailableEbike(stationId);

        if (availableEbike == null) return null;
        // check if user currently rents a bike
        Invoice openInvoice = invoiceRepository.queryBy(email);
        if (openInvoice != null) return null;

        // create new invoice for user
        User currentUser = userRepository.queryBy(email);
        Invoice newInvoice = createInvoice(availableEbike, currentUser);
        invoiceRepository.save(newInvoice);

        return newInvoice;
    }

    @PostMapping("/endRent")
    public @ResponseBody
    Invoice endRent(@RequestParam Integer invoiceId) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        Invoice invoice;

        if (invoiceOptional.isPresent()) {
            invoice = invoiceOptional.get();
        }else {
            return null;
        }

        invoice.setEndDate(new Date());
        invoice = invoiceRepository.save(invoice);

        return invoice;
    }

    private Invoice createInvoice(EBike availableEbike, User currentUser) {
        Invoice invoice = new Invoice();
        invoice.setUser(currentUser);
        invoice.setStartDate(new Date());
        invoice.setEBike(availableEbike);

        return invoice;
    }

    private EBike getAvailableEbike(Integer stationId) {
        List<EBike> eBikes = ebikeRepository.queryBy(stationId);

        EBike availableEbike;
        if (!eBikes.isEmpty()) {
            availableEbike = eBikes.get(0);
        } else {
            return null;
        }
        return availableEbike;
    }

}
