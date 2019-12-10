package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


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
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private Integer percent;

	@ManyToOne
	@JoinColumn(name="price_fk")
	private Price price;
}