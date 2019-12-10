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
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private String logo;

	private String info;

	private String name;

	@ToString.Exclude
	@OneToMany(mappedBy="commercialNetwork")
	private List<Vapeshop> vapeshops;
}