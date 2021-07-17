package br.com.supera.game.service;

import br.com.supera.game.repository.CheckoutRepository;
import br.com.supera.game.repository.ProductRepository;
import br.com.supera.game.store.Checkout;
import br.com.supera.game.store.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    private CheckoutRepository checkoutRepository;
    private ProductRepository productRepository;

    public CheckoutService(CheckoutRepository checkoutRepository, ProductRepository productRepository) {
        this.checkoutRepository = checkoutRepository;
        this.productRepository = productRepository;
    }

    public Checkout post(List<Long> products) {
        List<Product> productList = productRepository.findAllById(products);
        Checkout checkout = new Checkout();
        checkout.products = productList;
        return checkoutRepository.save(checkout);
    }

    public Checkout update(Long id, List<Long> products){
        List<Product> productList = productRepository.findAllById(products);
        Checkout checkout = checkoutRepository.getOne(id);
        checkout.products = productList;
        return checkoutRepository.save(checkout);
    }
}
