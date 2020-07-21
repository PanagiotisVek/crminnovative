package gr.codehub.crminnovative.repository;

import gr.codehub.crminnovative.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
    extends JpaRepository<Customer, Integer>{

}
