package com.example.treenimuistio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TreeniLiike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long liikeId;


    String liikkeenNimi;
    int toistomaara;
    int painoKG;


    // treenisessiossa voi olla useampi liike;
    @ManyToOne
    @JoinColumn(name = "sessio_id")
    @JsonBackReference
    TreeniSessio treeniSessio;

}
