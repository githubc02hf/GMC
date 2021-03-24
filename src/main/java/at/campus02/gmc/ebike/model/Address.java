package at.campus02.gmc.ebike.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="address")
public class Address {
    @Id
    @Column(name="address_id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="address_streetname")
    private String streetName;

    @Getter
    @Setter
    @Column(name="address_streetnumber")
    private Integer streetNumber;

    @Getter
    @Setter
    @Column(name="address_postalcode")
    private Integer postalCode;

    @Getter
    @Setter
    @Column(name="address_city")
    private String city;

    @OneToMany(mappedBy = "address",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Setter
    @Getter
    private List<User> users;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RentStation rentStation;
}