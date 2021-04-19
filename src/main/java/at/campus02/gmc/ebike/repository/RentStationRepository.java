package at.campus02.gmc.ebike.repository;

import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.model.RentStation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentStationRepository extends CrudRepository<RentStation, Integer> {

    @Query(value = "SELECT rs from Rentstation rs " +
            "INNER JOIN FETCH rs.address ")
    List<RentStation> getAllStations();

}