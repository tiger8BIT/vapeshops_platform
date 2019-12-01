package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String address;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city_fk")
	private City city;

	//bi-directional many-to-one association to Delivery
	@OneToMany(mappedBy="address")
	private List<Delivery> deliveries;

	//bi-directional many-to-one association to Vapeshop
	@OneToMany(mappedBy="address")
	private List<Vapeshop> vapeshops;
}