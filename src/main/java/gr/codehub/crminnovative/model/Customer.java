package gr.codehub.crminnovative.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Customer {
    private String name;
    private String address;
    private int age;
    private Date date;


    public Customer(String thename){
        this.name = thename;
    }
}
