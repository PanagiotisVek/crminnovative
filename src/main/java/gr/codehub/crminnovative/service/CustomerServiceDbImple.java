package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.CustomerCreationException;
import gr.codehub.crminnovative.exception.CustomerNotFoundException;
import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ImplDb")
public class CustomerServiceDbImple implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerCreationException {
        if (customer == null) {
            throw new CustomerCreationException("null customer");
        }
        if (customer.getEmail() == null || !customer.getEmail().contains("@")) {
            throw new CustomerCreationException("null customer");
        }
        return customerRepository.save(customer);

    }


    @Override
    public boolean deleteCustomer(int customerIndex) {
        customerRepository.deleteById(customerIndex);
        return true;
    }

    @Override
    public Customer getCustomer(int customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer updateCustomer(Customer customer, int customerId)
            throws CustomerNotFoundException {

        Customer customerInDb = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("no customer"));

        customerInDb.setFirstname(customer.getFirstname());
        //klp

        customerRepository.save(customerInDb);
        return customerInDb;
    }
}
