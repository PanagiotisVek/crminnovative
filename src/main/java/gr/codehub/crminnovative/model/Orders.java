package gr.codehub.crminnovative.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private Date ordersDate;
    private double totalAmount;

    @OneToMany(mappedBy = "orders") //lista one to many
    private List<OrdersProduct> ordersProducts;

    @ManyToOne //klasi many to one
    private Customer customer;

}
