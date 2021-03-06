package at.campus02.gmc.ebike.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="user")

public class User {
    @Id
    @Getter
    @Setter
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name="user_password")
    private String password;

    @Getter
    @Setter
    @Column(name="user_firstname")
    private String firstName;

    @Getter
    @Setter
    @Column(name="user_lastname")
    private String lastName;

    @Getter
    @Setter
    @Column(name="user_email")
    private String email;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoices;

}