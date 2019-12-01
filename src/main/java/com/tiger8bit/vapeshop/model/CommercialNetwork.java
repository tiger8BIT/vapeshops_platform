package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the commercial_network database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="commercial_network")
@NamedQuery(name="CommercialNetwork.findAll", query="SELECT c FROM CommercialNetwork c")
public class CommercialNetwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String logo;

	private String name;

	//bi-directional many-to-one association to Vapeshop
	@OneToMany(mappedBy="commercialNetwork")
	private List<Vapeshop> vapeshops;
}