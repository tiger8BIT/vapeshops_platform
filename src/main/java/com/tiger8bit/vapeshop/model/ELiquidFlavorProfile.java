package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


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
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="e_liquid_fk")
	private ELiquid ELiquid;

	@ManyToOne
	@JoinColumn(name="flavor_profile_fk")
	private FlavorProfile flavorProfile;
}