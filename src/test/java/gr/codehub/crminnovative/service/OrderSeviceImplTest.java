package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.*;
import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Orders;
import gr.codehub.crminnovative.model.OrdersProduct;
import gr.codehub.crminnovative.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderSeviceImplTest {

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrdersService ordersService;


    //@Test

//    void addProductToOrdersTest(){
//        ordersService.addProductToOrders(2,6af13050-a508-4faa-89d3-e4fd313e125c);
//    }

    @Test
    void getOrdersScenario() throws CustomerCreationException, ProductCreationException, CustomerNotFoundException, ProductNotFoundException, CannotCrateOrderException {

        Customer customer =  new Customer();
        customer.setFirstname("John");
        customer.setEmail("panos_vk@hotmail.com");

        customerService.addCustomer(customer);

        Product product =  new Product();
        product.setName("potatoes");

        productService.addProduct(product);

        Orders order =
        ordersService.createOrder(customer.getId());

        OrdersProduct ordersProduct =
                ordersService.addProductToOrders(product.getId(),order.getId());


        List<OrdersProduct> orderProductList =
                ordersService.getOrder(order.getId()).getOrdersProducts();

        assertEquals(1,orderProductList.size());

    }
}