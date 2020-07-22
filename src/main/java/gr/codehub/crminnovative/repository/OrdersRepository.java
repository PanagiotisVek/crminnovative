package gr.codehub.crminnovative.repository;

import gr.codehub.crminnovative.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdersRepository
        extends JpaRepository<Orders, UUID> {

}
