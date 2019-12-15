package com.tiger8bit.vapeshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String link;

	@ManyToOne
	@JoinColumn(name="vapeshop_fk")
	private Vapeshop vapeshop;

	@ManyToOne
	@JoinColumn(name="type_fk")
	private ContactLinkType type;

	public ContactLink(String link, Vapeshop vapeshop, ContactLinkType type) {
		this.link = link;
		this.vapeshop = vapeshop;
		this.type = type;
	}
}