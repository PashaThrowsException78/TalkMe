package com.tabakov.talkme.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "program")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="program_id")
    private Set<ActionsDetail> actionsDetail;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "program_id")
    private Set<Category> categories = new HashSet<>();

    @Column(name = "gotolink")
    private String gotolink;

    @Column(name = "products_xml_link")
    private String productsXmlLink;
}
