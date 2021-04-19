package at.campus02.gmc.ebike.repository;

import at.campus02.gmc.ebike.model.EBike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EbikeRepository extends CrudRepository<EBike, Integer> {

    @Query(value = "SELECT ebike FROM EBike ebike " +
            "INNER JOIN FETCH ebike.invoices inv " +
            "WHERE ebike.rentStation.id = :stationId " +
            "AND inv.endDate IS NOT NULL ")
    List<EBike> queryBy(@Param("stationId") Integer stationId);

}
