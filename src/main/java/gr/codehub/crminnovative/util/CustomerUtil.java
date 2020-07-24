package gr.codehub.crminnovative.util;

import gr.codehub.crminnovative.model.Customer;

import java.time.LocalDate;

public class CustomerUtil {
    public static int getAge(Customer customer){
        return  LocalDate.now().getYear() - customer.getDob().getYear(); }
}
