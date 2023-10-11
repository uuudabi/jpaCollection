package org.jpa.jpacollection.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Cart_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer count;
    private String productName;
    private Integer price;

    public Cart_Product(Product product, User user, Integer count, String productName, Integer price) {
        this.product = product;
        this.user = user;
        this.count = count;
        this.productName = productName;
        this.price = price;
    }
}
