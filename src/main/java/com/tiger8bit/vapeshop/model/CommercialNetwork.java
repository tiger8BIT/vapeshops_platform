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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String info;

	private String name;

	private String username;

	private String password;

	@Transient
	private String passwordConfirm;

	@ToString.Exclude
	@OneToMany(mappedBy="commercialNetwork")
	private List<Vapeshop> vapeshops;

	@ManyToOne
	@JoinColumn(name="image_fk")
	private Image image;
}