package at.campus02.gmc.ebike.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="rentstation")
public class RentStation {

    @Id
    @Getter
    @Setter
    @Column(name="rentstation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="rentstation_capacity")
    private Integer capacity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @Getter
    @Setter
    private Address address;

    @OneToMany(mappedBy = "rentStation")
    @Setter
    @Getter
    private List<EBike> ebikeList;

}
