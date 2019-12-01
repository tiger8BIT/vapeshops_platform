package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private double value;

	@ManyToOne
	@JoinColumn(name="product_fk")
	private Product product;

	//bi-directional many-to-one association to Vapeshop
	@ManyToOne
	@JoinColumn(name="vapeshop_fk")
	private Vapeshop vapeshop;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="price")
	private List<Sale> sales;

	@OneToMany(mappedBy="order")
	private List<OrderPrice> orderPrices;
}