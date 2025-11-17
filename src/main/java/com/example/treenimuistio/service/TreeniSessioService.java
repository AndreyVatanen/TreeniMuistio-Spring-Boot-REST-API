package com.example.treenimuistio.service;

import com.example.treenimuistio.model.Kayttaja;
import com.example.treenimuistio.model.TreeniLiike;
import com.example.treenimuistio.model.TreeniSessio;
import com.example.treenimuistio.repo.KayttajaRepo;
import com.example.treenimuistio.repo.TreeniSessioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TreeniSessioService {

    @Autowired
    private TreeniSessioRepo treeniSessioRepo;

    @Autowired
    private KayttajaRepo kayttajaRepo;


    /** Hae kaikki sessiot  */
    public List<TreeniSessio> haeKaikki() {
        return treeniSessioRepo.findAll();
    }


    /** Hae sessio id:n mukaan */
    public TreeniSessio etsiSessio(Long sessioId) {
        return treeniSessioRepo.findById(sessioId)
                .orElseThrow(() -> new RuntimeException("Sessio ID " + sessioId + " ei löytynyt"));
    }


    /** Näytä sessioon liittyvät treenit */
    public List<TreeniLiike> naytaTreenit(Long sessioId) {
        TreeniSessio sessio = etsiSessio(sessioId);
        return sessio.getTreeniloki();
    }


    /** Luo uusi treenisessio tietylle käyttäjälle */
    public TreeniSessio luoSessio(Long kayttajaId) {
        TreeniSessio sessio = new TreeniSessio();
        sessio.setPaivamaara(new Date());

        Kayttaja kayttaja = kayttajaRepo.findById(kayttajaId)
                .orElseThrow(() -> new RuntimeException("Käyttäjää ei löydy id:llä " + kayttajaId));

        sessio.setKayttaja(kayttaja);

        return treeniSessioRepo.save(sessio);
    }


    public boolean  poistaSessio(Long sessioId) {
        TreeniSessio poistettavaSessio = etsiSessio(sessioId);

        if (treeniSessioRepo.existsById(sessioId)) {
            treeniSessioRepo.delete(poistettavaSessio);
        } else {
            System.out.println("Ei löytynyt");
            return false;
        }
        System.out.println("poistettu id:llä" + sessioId);
       return true;
    }
}

