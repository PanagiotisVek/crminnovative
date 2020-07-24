package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.CannotCrateOrderException;
import gr.codehub.crminnovative.exception.CustomerNotFoundException;
import gr.codehub.crminnovative.exception.ProductNotFoundException;
import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Orders;
import gr.codehub.crminnovative.model.OrdersProduct;

import java.util.List;
import java.util.UUID;

public interface OrdersService {
    Orders createOrder(int customerId)
            throws CustomerNotFoundException, CannotCrateOrderException;

    Orders getOrder(UUID OrdersId)
            throws CustomerNotFoundException;

    OrdersProduct addProductToOrders(int productId, UUID OrdersId)
            throws ProductNotFoundException, CustomerNotFoundException;

    List<OrdersProduct> getProductsFromOrders(UUID OrdersId)
            throws ProductNotFoundException;
 }
