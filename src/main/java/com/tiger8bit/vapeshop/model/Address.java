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
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private String address;

	@ManyToOne
	@JoinColumn(name="city_fk")
	private City city;

	@ToString.Exclude
	@OneToMany(mappedBy="address")
	private List<Delivery> deliveries;

	@ToString.Exclude
	@OneToMany(mappedBy="address")
	private List<Vapeshop> vapeshops;
}