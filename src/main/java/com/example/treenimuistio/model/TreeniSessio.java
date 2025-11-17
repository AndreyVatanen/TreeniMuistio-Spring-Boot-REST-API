package com.example.treenimuistio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity

public class TreeniSessio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessioId;
    private Date paivamaara;


    @ManyToOne
    @JoinColumn(name = "kayttaja_id")

    @JsonIgnore
    private  Kayttaja kayttaja;

    @OneToMany(mappedBy = "treeniSessio", cascade = CascadeType.ALL)

    @JsonManagedReference
    private List<TreeniLiike> treeniloki = new ArrayList<>();

}
