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
 * The persistent class for the flavor_profile database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="flavor_profile")
@NamedQuery(name="FlavorProfile.findAll", query="SELECT f FROM FlavorProfile f")
public class FlavorProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private String name;

	@ToString.Exclude
	@OneToMany(mappedBy="flavorProfile")
	private List<ELiquidFlavorProfile> ELiquidFlavorProfiles;
}