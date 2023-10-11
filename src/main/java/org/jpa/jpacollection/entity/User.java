package org.jpa.jpacollection.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;
    private String password;
    private String name;
    private String address;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Cart_Product> list = new ArrayList<>();




    @Builder
    public User(String phone, String password, String name, String address) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.address = address;
    }
}
