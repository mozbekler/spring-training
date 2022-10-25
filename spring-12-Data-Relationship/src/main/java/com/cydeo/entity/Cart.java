package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name="cart_item_rel",
            joinColumns =@JoinColumn(name="c.id"),
    inverseJoinColumns = @JoinColumn(name="i.id"))

    private List<Item> itemList;
}
