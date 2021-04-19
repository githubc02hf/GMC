package at.campus02.gmc.ebike.controller;

import at.campus02.gmc.ebike.model.EBike;
import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.model.RentStation;
import at.campus02.gmc.ebike.repository.InvoiceRepository;
import at.campus02.gmc.ebike.repository.RentStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/RentStation")
public class RentStationController {

    @Autowired
    private RentStationRepository rentstationRepository;

    @GetMapping(path = "/allStations")
    public @ResponseBody
    List<RentStation> getAllStations() {
        List<RentStation> out = rentstationRepository.findAll();
        System.out.println("my out = "+ out.get(1).getAddress().getLatitude());
        return out;
    }

    @PostMapping(path = "/rentBike")
    public @ResponseBody
    EBike rentBike(@RequestParam Integer stationId, @RequestParam Integer userId) {
        // TODO: find free bike
        // RentStation rentStation = rentstationRepository.getEBike(stationId);
        // TODO: Invoice öffnen
        // TODO: Capacity reduzieren

        // return rentStation.getEbikeList().get(1);
        return null;
    }


}

