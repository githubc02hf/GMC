package at.campus02.gmc.ebike.repository;

import at.campus02.gmc.ebike.model.EBike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EbikeRepository extends CrudRepository<EBike, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT DISTINCT eb.* " +
                    "FROM ebike eb " +
                    "WHERE eb.ebike_id IN (SELECT bike.ebike_id FROM ebike bike where bike.rentstation_id = :stationId) " +
                    "AND (NOT EXISTS(SELECT * FROM invoice inv where inv.ebike_id = eb.ebike_id AND inv.invoice_enddate IS NULL) " +
                    "or NOT EXISTS(SELECT * FROM invoice inv2 where inv2.ebike_id = eb.ebike_id));")
    List<EBike> queryBy(@Param("stationId") Integer stationId);

}
