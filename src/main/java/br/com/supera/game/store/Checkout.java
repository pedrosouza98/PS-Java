package br.com.supera.game.store;

import javax.persistence.*;
import java.util.List;

@Entity
public class Checkout {

    @Id
    @GeneratedValue
    public long id;

    @OneToMany
    @JoinColumn(name = "product_id")
    public List<Product> products;
}
