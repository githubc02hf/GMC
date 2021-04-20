package at.campus02.gmc.ebike.DTO;

import at.campus02.gmc.ebike.model.Address;
import at.campus02.gmc.ebike.model.EBike;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RentStationDTO {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Integer capacity;

    @Getter
    @Setter
    private Address address;

    @Setter
    @Getter
    private List<EBike> ebikeList;

}
