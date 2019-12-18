package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double value;

	@ManyToOne
	@JoinColumn(name="product_fk")
	private Product product;

	@ManyToOne
	@JoinColumn(name="vapeshop_fk")
	private Vapeshop vapeshop;

	@ToString.Exclude
	@ManyToMany
	@JoinTable(
			name = "price_sale",
			joinColumns = @JoinColumn(name = "price_fk"),
			inverseJoinColumns = @JoinColumn(name = "sale_fk"))
	private List<Sale> sales;

	@ToString.Exclude
	@OneToMany(mappedBy="order")
	private List<OrderPrice> orderPrices;
}