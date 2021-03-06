package at.campus02.gmc.ebike.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    @Getter
    @Setter
    @Column(name="invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="invoice_startdate")
    private Date startDate;

    @Getter
    @Setter
    @Column(name="invoice_enddate")
    private Date endDate;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name="ebike_id")
    private EBike eBike;
}
