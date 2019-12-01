package com.tiger8bit.vapeshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact_link database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="contact_link")
@NamedQuery(name="ContactLink.findAll", query="SELECT c FROM ContactLink c")
public class ContactLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String link;

	//bi-directional many-to-one association to Vapeshop
	@ManyToOne
	@JoinColumn(name="vapeshop_fk")
	private Vapeshop vapeshop;

	public ContactLink(String link, Vapeshop vapeshop) {
		this.link = link;
		this.vapeshop = vapeshop;
	}
}