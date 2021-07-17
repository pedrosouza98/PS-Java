package br.com.supera.game.repository;

import br.com.supera.game.store.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}

