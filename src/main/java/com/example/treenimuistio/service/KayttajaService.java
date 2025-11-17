package com.example.treenimuistio.service;
import com.example.treenimuistio.model.Kayttaja;
import com.example.treenimuistio.repo.KayttajaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class KayttajaService {

    @Autowired
    private KayttajaRepo kayttajaRepo;

    // Luo yhden käyttäjän
    public Kayttaja luoKayttaja(Kayttaja kayttaja) {
        return kayttajaRepo.save(kayttaja);
    }

    // Poista käyttäjä ID:llä
    public boolean poistaKayttaja(Long id) {
        if (kayttajaRepo.existsById(id)) {
            kayttajaRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Etsi käyttäjä ID:llä
    public Kayttaja etsiKayttaja(Long id) {
        return kayttajaRepo.findById(id).orElse(null);
    }

    // Hae kaikki käyttäjät
    public List<Kayttaja> haeKaikki() {
        return kayttajaRepo.findAll();
    }
}

