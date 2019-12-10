package com.tiger8bit.vapeshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * The persistent class for the phone_number database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="phone_number")
@NamedQuery(name="PhoneNumber.findAll", query="SELECT p FROM PhoneNumber p")
public class PhoneNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private String number;

	private String description;

	@ManyToOne
	@JoinColumn(name="vapeshop_fk")
	private Vapeshop vapeshop;

	@ManyToOne
	@JoinColumn(name="country_fk")
	private Country country;

	public PhoneNumber(String number, Vapeshop vapeshop, Country country) {
		this.number = number;
		this.vapeshop = vapeshop;
		this.country = country;
	}
}