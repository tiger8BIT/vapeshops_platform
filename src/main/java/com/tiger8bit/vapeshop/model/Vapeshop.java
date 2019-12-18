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
 * The persistent class for the vapeshop database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "add_vapeshop",
				procedureName = "vapeshop.add_vapeshop",
				parameters = {
						@StoredProcedureParameter(
								name = "p_address",
								type = String.class,
								mode = ParameterMode.IN),
						@StoredProcedureParameter(
								name = "p_city_fk",
								type = Integer.class,
								mode = ParameterMode.IN),
						@StoredProcedureParameter(
								name = "p_commercial_network_fk",
								type = Integer.class,
								mode = ParameterMode.IN),
						@StoredProcedureParameter(
								name = "p_pickup",
								type = Boolean.class,
								mode = ParameterMode.IN),
						@StoredProcedureParameter(
								name = "p_vapeshop_id",
								type = Integer.class,
								mode = ParameterMode.OUT)
				}
				)
})
@NamedQuery(name="Vapeshop.findAll", query="SELECT v FROM Vapeshop v")
public class Vapeshop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<ContactLink> contactLinks;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<PhoneNumber> phoneNumbers;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<DeliveryPrice> deliveryPrices;

	@ManyToOne
	@JoinColumn(name="address_fk")
	private Address address;

	@ManyToOne
	@JoinColumn(name="commercial_network_fk")
	private CommercialNetwork commercialNetwork;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<Price> prices;

	@ToString.Exclude
	@OneToMany(mappedBy="vapeshop")
	private List<Sale> sales;

	@ManyToMany
	@JoinTable(
			name = "vapeshop_currency",
			joinColumns = @JoinColumn(name = "vapeshop_fk"),
			inverseJoinColumns = @JoinColumn(name = "currency_fk"))
	private List<Currency> vepeshopCurrencies;

	@ManyToMany
	@JoinTable(
			name = "vapeshop_image",
			joinColumns = @JoinColumn(name = "vapeshop_fk"),
			inverseJoinColumns = @JoinColumn(name = "image_fk"))
	private List<Image> vepeshopImages;

	boolean pickup;
}