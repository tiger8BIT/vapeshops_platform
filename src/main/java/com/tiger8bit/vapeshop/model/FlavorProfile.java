package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to ELiquidFlavorProfile
	@OneToMany(mappedBy="flavorProfile")
	private List<ELiquidFlavorProfile> ELiquidFlavorProfiles;
}