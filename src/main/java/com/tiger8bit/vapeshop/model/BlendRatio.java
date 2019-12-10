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
 * The persistent class for the blend_ratio database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="blend_ratio")
@NamedQuery(name="BlendRatio.findAll", query="SELECT b FROM BlendRatio b")
public class BlendRatio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = SEQUENCE, generator = "hibernate_sequence")
	private Integer id;

	private Integer pg;

	private Integer vg;

	@ToString.Exclude
	@OneToMany(mappedBy="blendRatio")
	private List<ELiquid> ELiquids;

	public String getString(){
		return vg + "/" + pg;
	}
}