package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.CannotCrateOrderException;
import gr.codehub.crminnovative.exception.CustomerNotFoundException;
import gr.codehub.crminnovative.exception.ProductNotFoundException;
import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Orders;
import gr.codehub.crminnovative.model.OrdersProduct;
import gr.codehub.crminnovative.model.Product;
import gr.codehub.crminnovative.repository.CustomerRepository;
import gr.codehub.crminnovative.repository.OrdersProductRepository;
import gr.codehub.crminnovative.repository.OrdersRepository;
import gr.codehub.crminnovative.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderSeviceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrdersProductRepository ordersProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Orders createOrder(int customerId)
            throws CustomerNotFoundException, CannotCrateOrderException {
        Orders orders =  new Orders();
        Customer customerFromDb =
            customerRepository
                    .findById(customerId)
                    .orElseThrow(() -> new CustomerNotFoundException("Cannot Find Customer"));

        if(customerFromDb.getDob() ==null
                || customerFromDb.getAge()<18)
            throw new CannotCrateOrderException("Customer too young or no dob data");

        orders.setCustomer(customerFromDb);
        orders.setOrdersDate(new Date());
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrder(UUID OrdersId) throws CustomerNotFoundException {
        return ordersRepository
                .findById(OrdersId)
                .orElseThrow(() -> new CustomerNotFoundException("Cannot Find Customer"));
    }

    @Override
    public OrdersProduct addProductToOrders(int productId, UUID OrdersId)
            throws ProductNotFoundException, CustomerNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new
                        ProductNotFoundException("Cannot find product"));
        Orders orders = ordersRepository.findById(OrdersId).orElseThrow(() -> new
                CustomerNotFoundException("Cannot find Customer"));
        Optional<OrdersProduct> ordersProductOptional=
                ordersProductRepository.findAll()
                        .stream()
                        .filter( op-> op.getOrders().getId().equals(OrdersId) &&
                                op.getProduct().getId()==productId)
                        .findFirst();
        OrdersProduct orderProduct;
        if (ordersProductOptional.isPresent()) {
            orderProduct = ordersProductOptional.get();
            orderProduct.setQuantity(  orderProduct.getQuantity()+1 );
        }
        else {
            orderProduct = new OrdersProduct();
            orderProduct.setQuantity(1);
            orderProduct.setPrice(product.getPrice());
        }
        Product productInOrder = orderProduct.getProduct();
        productInOrder.setInventoryQantity(
                productInOrder.getInventoryQantity()-1 );
        productRepository.save(productInOrder);
        ordersProductRepository.save(orderProduct);
        return orderProduct;
    }

    @Override
    public List<OrdersProduct> getProductsFromOrders(UUID OrdersId) throws ProductNotFoundException {
        return
                ordersProductRepository
                .findAll()
                .stream()
                .filter(po -> po.getOrders().getId().equals(OrdersId))
                .collect(Collectors.toList());
    }
}
