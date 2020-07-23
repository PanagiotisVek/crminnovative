package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.ProductCreationException;
import gr.codehub.crminnovative.exception.ProductNotFoundException;
import gr.codehub.crminnovative.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product addProduct(Product product) throws ProductCreationException;

    boolean deleteProduct(int productIndex);

    Product getProduct(int productId) throws ProductNotFoundException;

    Product updateProduct(Product product, int productId) throws ProductNotFoundException;
}
