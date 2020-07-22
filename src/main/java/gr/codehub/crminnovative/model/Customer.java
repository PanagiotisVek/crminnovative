package gr.codehub.crminnovative.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String street;
    private String number;
    private String vatNumber;
    private String email;
    private Date registrationDate;
    private Date dob;

    @ManyToOne
    private Customer recommender;

    @OneToMany(mappedBy="recommender")
    private List<Customer> recommended;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

}
