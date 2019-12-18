package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String info;

	private String name;

	//bi-directional many-to-one association to ELiquid
	@OneToOne(mappedBy="product")
	private ELiquid ELiquid;

	@ToString.Exclude
	@OneToMany(mappedBy="product")
	private List<Price> prices;

	@ManyToOne
	@JoinColumn(name="brand_fk")
	private Brand brand;

	@ManyToMany
	@JoinTable(
			name = "product_image",
			joinColumns = @JoinColumn(name = "product_fk"),
			inverseJoinColumns = @JoinColumn(name = "image_fk"))
	private List<Image> productImages;

	public double getMinPrice(){
		if (prices == null || prices.isEmpty()) return -1;
		productImages.get(0);
		return Collections.min(
				prices.stream().map((v) -> v.getValue() * (!v.getSales().isEmpty() ?
						Collections.max(v.getSales().stream().map(Sale::getPercent).collect(Collectors.toList()))
						: 1)).collect(Collectors.toList()));
	}

	public double getMaxPrice(){
		if (prices == null || prices.isEmpty()) return -1;
		return Collections.max(
				prices.stream().map((v) -> v.getValue() * (!v.getSales().isEmpty() ?
						Collections.max(v.getSales().stream().map(Sale::getPercent).collect(Collectors.toList()))
						: 1)).collect(Collectors.toList()));
	}
}