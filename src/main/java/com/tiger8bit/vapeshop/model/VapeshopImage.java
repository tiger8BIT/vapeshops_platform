package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vapeshop_image database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="vapeshop_image")
@NamedQuery(name="VapeshopImage.findAll", query="SELECT v FROM VapeshopImage v")
public class VapeshopImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String image;

	@ManyToOne
	@JoinColumn(name="vapeshop_fk")
	private Vapeshop vapeshop;
}