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
 * The persistent class for the vapeshop database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Vapeshop.findAll", query="SELECT v FROM Vapeshop v")
public class Vapeshop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<ContactLink> contactLinks;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<PhoneNumber> phoneNumbers;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<DeliveryPrice> deliveryPrices;

	@ManyToOne
	@JoinColumn(name="address_fk")
	private Address address;

	@ManyToOne
	@JoinColumn(name="commercial_network_fk")
	private CommercialNetwork commercialNetwork;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<VapeshopImage> vapeshopImages;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<Price> prices;

	boolean pickup;
}