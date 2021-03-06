package at.campus02.gmc.ebike.controller;

import at.campus02.gmc.ebike.DTO.RentStationDTO;
import at.campus02.gmc.ebike.model.EBike;
import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.model.RentStation;
import at.campus02.gmc.ebike.repository.RentStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/RentStation")
public class RentStationController {

    @Autowired
    private RentStationRepository rentstationRepository;

    @GetMapping(path = "/allStations")
    public @ResponseBody
    List<RentStationDTO> getAllStations() {
        List<RentStation> rentStations = rentstationRepository.findAll();

        return mapRentStationsToDTO(rentStations);
    }

    private List<RentStationDTO> mapRentStationsToDTO(List<RentStation> rentStations) {
        List<RentStationDTO> rentStationDTOList = new ArrayList<>();

        for (RentStation rentStation : rentStations) {
            RentStationDTO rentStationDTO = new RentStationDTO();

            rentStationDTO.setAddress(rentStation.getAddress());
            rentStationDTO.setId(rentStation.getId());
            rentStationDTO.setEbikeList(rentStation.getEbikeList());
            rentStationDTO.setAvailableBikes(getOnlyAvailableBikes(rentStation.getEbikeList()));

            rentStationDTOList.add(rentStationDTO);
        }
        return rentStationDTOList;
    }

    private Integer getOnlyAvailableBikes(List<EBike> eBikes) {
        int availableBikesCount = eBikes.size();
        for (EBike eBike : eBikes) {
            for (Invoice invoice : eBike.getInvoices()) {
                if(invoice.getEndDate() == null){
                    availableBikesCount--;
                    break;
                }
            }
        }

        return availableBikesCount;
    }


}

