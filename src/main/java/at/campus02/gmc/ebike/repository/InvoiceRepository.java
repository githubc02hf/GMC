package at.campus02.gmc.ebike.repository;

import at.campus02.gmc.ebike.model.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

    @Query(value = "SELECT inv FROM Invoice inv " +
            "INNER JOIN FETCH inv.eBike " +
            "INNER JOIN FETCH inv.user user " +
            "WHERE user.email = :email AND " +
            "inv.endDate is NULL ")
    Invoice queryBy(@Param("email") String email);

}
