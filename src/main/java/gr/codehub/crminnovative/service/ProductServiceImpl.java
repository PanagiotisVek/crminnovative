package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.ProductCreationException;
import gr.codehub.crminnovative.exception.ProductNotFoundException;
import gr.codehub.crminnovative.model.Product;
import gr.codehub.crminnovative.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //check the paging method
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ProductCreationException {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(int productIndex) {
        productRepository.deleteById(productIndex);
        return true;
    }

    @Override
    public Product getProduct(int productId) throws ProductNotFoundException {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product updateProduct(Product product, int productId) throws ProductNotFoundException {
        return null;
    }
}
