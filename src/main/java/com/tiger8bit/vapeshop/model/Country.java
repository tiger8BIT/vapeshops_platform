package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
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