package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="DeliveryPrice.findAll", query="SELECT d FROM DeliveryPrice d")
public class DeliveryPrice {
    @Id
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="city_fk")
    private City city;

    @ManyToOne
    @JoinColumn(name="vapeshop_fk")
    private Vapeshop vapeshop;

    private double price;
}
