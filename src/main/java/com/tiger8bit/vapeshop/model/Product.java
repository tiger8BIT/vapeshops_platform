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
}