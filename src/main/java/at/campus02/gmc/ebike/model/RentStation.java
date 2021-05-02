package at.campus02.gmc.ebike.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @Getter
    @Setter
    @JsonBackReference
    private Address address;

    @OneToMany(mappedBy = "rentStation")
    @Setter
    @Getter
    @JsonBackReference
    private List<EBike> ebikeList;

}
