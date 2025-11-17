package com.example.treenimuistio.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Kayttaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kayttajaId;


    private String nimi;
    private String sahkoposti;

    @OneToMany(mappedBy = "kayttaja", cascade = CascadeType.ALL)

    @JsonIgnore
    private List<TreeniSessio> treeniSessiot = new ArrayList<>();

}
