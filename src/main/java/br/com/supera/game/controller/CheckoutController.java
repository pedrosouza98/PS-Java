package br.com.supera.game.controller;

import br.com.supera.game.service.CheckoutService;
import br.com.supera.game.store.Checkout;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {this.checkoutService = checkoutService; }

    @PostMapping
    public Checkout post(@RequestBody List<Long> products) {
        return checkoutService.post(products);
    }

    @PutMapping("/{id}")
    public Checkout update(@PathVariable Long id, @RequestBody List<Long> products) {
        return checkoutService.update(id, products);
    }

    @GetMapping("/{id}")
    public Checkout get(@PathVariable Long id){
        return checkoutService.get(id);
    }

}
