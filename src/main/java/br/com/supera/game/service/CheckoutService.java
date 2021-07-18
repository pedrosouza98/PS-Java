package br.com.supera.game.service;

import br.com.supera.game.repository.CheckoutRepository;
import br.com.supera.game.repository.ProductRepository;
import br.com.supera.game.store.Checkout;
import br.com.supera.game.store.Product;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class CheckoutService {

    private CheckoutRepository checkoutRepository;
    private ProductRepository productRepository;

    public CheckoutService(CheckoutRepository checkoutRepository, ProductRepository productRepository) {
        this.checkoutRepository = checkoutRepository;
        this.productRepository = productRepository;
    }

    public Checkout post(List<Long> productIds) {
        Checkout checkout = new Checkout();
        updateValues(checkout, productIds);
        return checkoutRepository.save(checkout);
    }

    public Checkout update(Long checkoutId, List<Long> products){
        Checkout checkout = checkoutRepository.getOne(checkoutId);
        updateValues(checkout, products);
        return checkoutRepository.save(checkout);
    }

    private void updateValues(Checkout checkout, List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);
        checkout.setProducts(products);

        BigDecimal price = BigDecimal.ZERO;
        for (Product product : products) {
            price = price.add(product.getPrice());
        }
        checkout.setSubTotal(price);



        checkout.setShipping(BigDecimal.ZERO);
        if (price.compareTo(BigDecimal.valueOf(250)) < 0) {
            checkout.setShipping(BigDecimal.valueOf(products.size() * 10L));
        }

        checkout.setTotal(checkout.getSubTotal().add(checkout.getShipping()));
    }

    public Checkout get(Long id, String productOrder) {
        Checkout checkout = checkoutRepository.findById(id).get();
        if (productOrder != null && !productOrder.isEmpty()) {
            checkout.setProducts(getSortedProducts(checkout, productOrder));
        }
        return checkout;
    }

    private List<Product> getSortedProducts(Checkout checkout, String order) {
        List<Product> products = checkout.getProducts();
        switch (order) {
            case "price":
                products = checkout.getProducts().stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
                break;
            case "score":
                products = checkout.getProducts().stream().sorted(Comparator.comparing(Product::getScore)).collect(Collectors.toList());
                break;
            case "name":
                products = checkout.getProducts().stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
                break;
        }

        return products;
    }
}
