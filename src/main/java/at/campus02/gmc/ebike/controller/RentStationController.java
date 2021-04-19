package at.campus02.gmc.ebike.controller;

import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.model.RentStation;
import at.campus02.gmc.ebike.repository.InvoiceRepository;
import at.campus02.gmc.ebike.repository.RentStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/RentStation")
public class RentStationController {

    @Autowired
    private RentStationRepository rentstationRepository;

    @GetMapping(path = "/currentRentStation")
    public @ResponseBody
    List<RentStation> getCurrentRentStation() {
        return rentstationRepository.getAllStations();
    }

}

