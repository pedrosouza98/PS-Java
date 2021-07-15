package br.com.supera.game.service;

import br.com.supera.game.repository.ProductRepository;
import br.com.supera.game.store.Product;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }
}
