package gr.codehub.crminnovative.controller;


import gr.codehub.crminnovative.exception.CustomerCreationException;
import gr.codehub.crminnovative.exception.CustomerNotFoundException;
import gr.codehub.crminnovative.exception.ProductCreationException;
import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Orders;
import gr.codehub.crminnovative.model.Product;
import gr.codehub.crminnovative.service.CustomerService;
import gr.codehub.crminnovative.service.OrdersService;
import gr.codehub.crminnovative.service.ProductService;
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

    private ProductService productService;
    @Autowired
    public CrmController(CustomerService customerService, OrdersService ordersService,ProductService productService) {
        this.customerService = customerService;
        this.ordersService = ordersService;
        this.productService = productService;
    }


    @GetMapping("customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

   @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable int id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }

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


    @GetMapping("product")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

//    @GetMapping("product/{id}")
//    public Customer getCustomer(@PathVariable int id) throws CustomerNotFoundException {
//        return customerService.getCustomer(id);
//    }

    @PostMapping("product")
    public Product addProduct(@RequestBody Product product) throws ProductCreationException {
        return productService.addProduct(product);
    }

    @PostMapping("orders/{customerId}")
    public Orders createOrders(@PathVariable int customerId) throws CustomerNotFoundException {
        return ordersService.createOrder(customerId);
    }


//    @PutMapping("customer/{id}")
//    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) throws CustomerNotFoundException {
//        return customerService.updateCustomer(customer, id);
//    }
//
//    @DeleteMapping("customer/{id}")
//    public boolean deleteCustomer(@PathVariable int id) {
//        return customerService.deleteCustomer(id);
//    }
}
