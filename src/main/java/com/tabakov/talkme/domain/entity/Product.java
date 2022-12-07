package com.tabakov.talkme.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "picture", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "picture")
    private List<String> pictures;

    @Column(name = "price")
    private Long price;

    @Column(name = "model")
    private String model;

    @Column(name = "url")
    private String url;
}
