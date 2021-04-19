package at.campus02.gmc.ebike.repository;

import at.campus02.gmc.ebike.model.EBike;
import at.campus02.gmc.ebike.model.Invoice;
import at.campus02.gmc.ebike.model.RentStation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentStationRepository extends CrudRepository<RentStation, Integer> {

    @Query(value = "SELECT rs from RentStation rs " +
            "INNER JOIN FETCH rs.address ")
    List<RentStation> findAll();

    //@Query(value = "SELECT rs FROM RentStation rs " +
    //        "INNER JOIN FETCH rs.ebikeList ebikes " +
    //        "INNER JOIN FETCH ebikes.invoices inv " +
    //        "WHERE rs.id = :stationId " +
    //        "AND inv.endDate IS NOT NULL ")
    //RentStation getEBike(@Param("stationId") Integer stationId);
}