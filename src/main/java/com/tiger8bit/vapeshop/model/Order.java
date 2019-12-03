package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date datetime;

	@ManyToOne
	@JoinColumn(name="delivery_fk")
	private Delivery delivery;

	@ToString.Exclude
	@OneToMany(mappedBy="order")
	private List<OrderPrice> orderPrices;
}