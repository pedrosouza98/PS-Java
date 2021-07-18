package br.com.supera.game.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Checkout {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    private BigDecimal subTotal;
    private BigDecimal shipping;
    private BigDecimal total;
}
