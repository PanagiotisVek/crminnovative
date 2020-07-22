package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Orders;

public interface OrdersService {
    Orders createOrder(Customer customer);
}
