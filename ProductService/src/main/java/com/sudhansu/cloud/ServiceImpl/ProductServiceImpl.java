package com.sudhansu.cloud.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudhansu.cloud.Entity.Product;
import com.sudhansu.cloud.Repository.ProductRepository;
import com.sudhansu.cloud.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

