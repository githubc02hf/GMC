package at.campus02.gmc.ebike.controller;

import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping(path = "/currentInvoice")
    public @ResponseBody
    Invoice getCurrentInvoice(@RequestParam String email) {
        return invoiceRepository.queryBy(email);
    }

}
