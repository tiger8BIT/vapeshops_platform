package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * The persistent class for the order_price database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="order_price")
@NamedQuery(name="OrderPrice.findAll", query="SELECT o FROM OrderPrice o")
public class OrderPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_fk")
	private Order order;

	//bi-directional many-to-one association to Price
	@ManyToOne
	@JoinColumn(name="price_fk")
	private Price price;

	private Integer amount;
}