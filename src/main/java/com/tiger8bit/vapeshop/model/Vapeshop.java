package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to ContactLink
	@OneToMany(mappedBy="vapeshop")
	private List<ContactLink> contactLinks;

	//bi-directional many-to-one association to PhoneNumber
	@OneToMany(mappedBy="vapeshop")
	private List<PhoneNumber> phoneNumbers;

	@OneToMany(mappedBy="vapeshop")
	private List<DeliveryPrice> deliveryPrices;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_fk")
	private Address address;

	//bi-directional many-to-one association to CommercialNetwork
	@ManyToOne
	@JoinColumn(name="commercial_network_fk")
	private CommercialNetwork commercialNetwork;

	//bi-directional many-to-one association to VapeshopImage
	@OneToMany(mappedBy="vapeshop")
	private List<VapeshopImage> vapeshopImages;

	@OneToMany(mappedBy="vapeshop")
	private List<Price> prices;

	boolean pickup;
}