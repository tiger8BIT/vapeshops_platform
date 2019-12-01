package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the e_liquid_flavor_profile database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="e_liquid_flavor_profile")
@NamedQuery(name="ELiquidFlavorProfile.findAll", query="SELECT e FROM ELiquidFlavorProfile e")
public class ELiquidFlavorProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to ELiquid
	@ManyToOne
	@JoinColumn(name="e_liquid_fk")
	private ELiquid ELiquid;

	//bi-directional many-to-one association to FlavorProfile
	@ManyToOne
	@JoinColumn(name="flavor_profile_fk")
	private FlavorProfile flavorProfile;
}