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
//      find free bike
        EBike availableEbike = getAvailableEbike(stationId);
        if (availableEbike == null) return null;

        User currentUser = userRepository.queryBy(email);

        // Invoice öffnen
        Invoice newInvoice = createInvoice(availableEbike, currentUser);
        invoiceRepository.save(newInvoice);

        return newInvoice;
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
        if (!eBikes.isEmpty()){
            availableEbike = eBikes.get(0);
        } else {
            return null;
        }
        return availableEbike;
    }

}
