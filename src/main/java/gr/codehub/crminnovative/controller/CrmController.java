package gr.codehub.crminnovative.controller;


import gr.codehub.crminnovative.exception.CustomerCreationException;
import gr.codehub.crminnovative.exception.CustomerNotFoundException;
import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Orders;
import gr.codehub.crminnovative.service.CustomerService;
import gr.codehub.crminnovative.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrmController {

    //    @Autowired
    //    @Qualifier("ImplDb")
    private CustomerService customerService;

    //    @Autowired
    private OrdersService ordersService;

    @Autowired
    public CrmController(CustomerService customerService, OrdersService ordersService) {
        this.customerService = customerService;
        this.ordersService = ordersService;
    }

    @PostMapping("orders")
    public Orders createOrders() {
        return ordersService.createOrder(null);
    }


    @GetMapping("customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

//    @GetMapping("customer/{id}")
//    public List<Customer> getCustomer(@PathVariable int id)  {
//        return customerService.getCustomer(id);
//    }

    @PostMapping("customer")
    public Customer addCustomer(@RequestBody Customer customer) throws CustomerCreationException {
        return customerService.addCustomer(customer);
    }

    @PutMapping("customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) throws CustomerNotFoundException {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("customer/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }

}
