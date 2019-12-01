package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sale database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer percent;

	//bi-directional many-to-one association to Price
	@ManyToOne
	@JoinColumn(name="price_fk")
	private Price price;
}