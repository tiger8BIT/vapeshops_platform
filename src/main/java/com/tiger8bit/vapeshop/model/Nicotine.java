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
@NamedQuery(name="Nicotine.findAll", query="SELECT n FROM Nicotine n")
public class Nicotine implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double value;

    @ManyToOne
    @JoinColumn(name="eliquid_fk")
    private ELiquid eLiquid;

    @Column(name = "nicotine_type")
    @Enumerated(EnumType.STRING)
    private NicotineType nicotineType;
}
