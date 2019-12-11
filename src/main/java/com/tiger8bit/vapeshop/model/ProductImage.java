package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


/**
 * The persistent class for the product_image database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="product_image")
@NamedQuery(name="ProductImage.findAll", query="SELECT p FROM ProductImage p")
public class ProductImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String image;

	@ManyToOne
	@JoinColumn(name="product_fk")
	private Product product;
}