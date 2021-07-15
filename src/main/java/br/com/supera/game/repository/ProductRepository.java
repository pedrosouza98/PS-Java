package br.com.supera.game.repository;

import br.com.supera.game.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
