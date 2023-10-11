package org.jpa.jpacollection.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product_name;
    private String image;
    private Integer price;
    private String p_desc;


    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Cart_Product> list = new ArrayList<>();

    @Builder
    public Product(String product_name, String image, Integer price, String p_desc) {
        this.product_name = product_name;
        this.image = image;
        this.price = price;
        this.p_desc = p_desc;
    }
}
