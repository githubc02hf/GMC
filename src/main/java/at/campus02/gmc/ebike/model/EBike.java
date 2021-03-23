package at.campus02.gmc.ebike.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ebike")
public class EBike {

    @Id
    @Getter
    @Setter
    @Column(name="ebike_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @Column(name="ebike_model")
    private String model;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name="rentstation_id")
    private RentStation rentStation;

    @Getter
    @Setter
    @OneToMany(mappedBy = "eBike")
    private List<Invoice> invoices;
}