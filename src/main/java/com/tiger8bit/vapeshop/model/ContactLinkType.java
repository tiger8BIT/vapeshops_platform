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
@Table(name="contact_link_type")
@NamedQuery(name="ContactLinkType.findAll", query="SELECT c FROM ContactLinkType c")
public class ContactLinkType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy="type")
    private List<ContactLink> contactLinks;
}
