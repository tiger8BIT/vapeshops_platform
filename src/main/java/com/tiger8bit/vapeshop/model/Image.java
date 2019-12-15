package com.tiger8bit.vapeshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "addImage",
                procedureName = "add_image",
                resultClasses = {Image.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "p_url",
                                type = String.class,
                                mode = ParameterMode.IN),
                }
        )
})
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @ToString.Exclude
    @OneToMany(mappedBy="image")
    private List<CommercialNetwork> commercialNetworks;

    @ToString.Exclude
    @OneToMany(mappedBy="image")
    private List<Brand> brands;

    @ManyToMany(mappedBy="vepeshopImages")
    private List<Vapeshop> vapeshops;

    @ManyToMany(mappedBy="productImages")
    private List<Product> products;
}
