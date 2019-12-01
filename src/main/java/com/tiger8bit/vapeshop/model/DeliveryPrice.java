package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="DeliveryPrice.findAll", query="SELECT d FROM DeliveryPrice d")
public class DeliveryPrice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="city_fk")
    private City city;

    @ManyToOne
    @JoinColumn(name="vapeshop_fk")
    private Vapeshop vapeshop;

    private double price;
}
