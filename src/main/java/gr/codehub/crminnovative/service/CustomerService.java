package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.CustomerCreationException;
import gr.codehub.crminnovative.exception.CustomerNotFoundException;
import gr.codehub.crminnovative.model.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> getCustomers();

    Customer addCustomer(Customer customer) throws CustomerCreationException;

    boolean deleteCustomer(int customerIndex);

    Customer getCustomer(int customerId) throws CustomerNotFoundException;

    Customer updateCustomer(Customer customer, int customerId) throws CustomerNotFoundException;
}
