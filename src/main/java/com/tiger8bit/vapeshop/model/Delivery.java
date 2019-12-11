package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * The persistent class for the delivery database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date datetime;

	@ManyToOne
	@JoinColumn(name="address_fk")
	private Address address;

	@ToString.Exclude
	@OneToMany(mappedBy="delivery")
	private List<Order> orders;

	@ManyToOne
	@JoinColumn(name="price_fk")
	private DeliveryPrice deliveryPrice;
}