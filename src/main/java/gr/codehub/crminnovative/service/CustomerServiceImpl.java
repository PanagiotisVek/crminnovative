package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static List<Customer>
        customers  = new ArrayList<>();

    static {
        customers.add(new Customer("Giannis"));
        customers.add(new Customer("Elissavet"));
        customers.add(new Customer("Vangelis"));
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customers.get(customers.size()-1);
    }

    @Override
    public boolean deleteCustomer(int customerIndex) {
        if(customerIndex >= 0 && customerIndex < customers.size()){
            customers.remove(customerIndex);
            return true;
        }
        return false;
    }
}
