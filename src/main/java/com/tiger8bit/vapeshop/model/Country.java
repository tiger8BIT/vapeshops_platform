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
 * The persistent class for the country database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private String name;

	private String phonePrefix;

	private String currency;

	@ToString.Exclude
	@OneToMany(mappedBy="country")
	private List<City> cities;

	@ToString.Exclude
	@OneToMany(mappedBy="country")
	private List<PhoneNumber> phoneNumbers;
}