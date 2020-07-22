package gr.codehub.crminnovative.repository;

import gr.codehub.crminnovative.model.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersProductRepository
        extends JpaRepository<OrdersProduct, Long> {

}

