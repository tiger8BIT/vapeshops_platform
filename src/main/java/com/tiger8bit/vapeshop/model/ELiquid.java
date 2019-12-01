package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the e_liquid database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="e_liquid")
@NamedQuery(name="ELiquid.findAll", query="SELECT e FROM ELiquid e")
public class ELiquid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="mint_menthol")
	private Boolean mintMenthol;

	private Integer nicotine;

	@Column(name="salt_nicotine")
	private Integer saltNicotine;

	private Integer volume;

	//bi-directional many-to-one association to BlendRatio
	@ManyToOne
	@JoinColumn(name="blend_ratio_fk")
	private BlendRatio blendRatio;

	//bi-directional many-to-one association to Product
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_fk", referencedColumnName = "id")
	private Product product;

	//bi-directional many-to-one association to ELiquidFlavorProfile
	@OneToMany(mappedBy="ELiquid")
	private List<ELiquidFlavorProfile> ELiquidFlavorProfiles;
}