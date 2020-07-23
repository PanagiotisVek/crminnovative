package gr.codehub.crminnovative.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrdersProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;
    private double price;

    @JsonIgnore
    @ManyToOne
    private Orders orders;

    @JsonIgnore
    @ManyToOne
    private Product product;
}
