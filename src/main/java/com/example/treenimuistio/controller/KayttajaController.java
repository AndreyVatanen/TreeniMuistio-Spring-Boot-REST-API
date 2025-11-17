package com.example.treenimuistio.controller;
import com.example.treenimuistio.model.Kayttaja;
import com.example.treenimuistio.service.KayttajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api")
public class KayttajaController {

    @Autowired
    KayttajaService kayttajaService;

    @PostMapping("/lisaa")
    Kayttaja lisaaKayttaja(@RequestBody Kayttaja kayttaja) {
        return  kayttajaService.luoKayttaja(kayttaja);
    }

    @DeleteMapping("/poistakayttaja/{id}")
    boolean poistaKayttaja(@PathVariable Long id) {
        return kayttajaService.poistaKayttaja(id);
    }

    @GetMapping("/etsi/{id}")
    public Kayttaja etsiKayttaja(@PathVariable Long id) {
        return kayttajaService.etsiKayttaja(id);
    }

    @GetMapping("/kaikki")
    public List<Kayttaja> naytaKayttajat() {
        return kayttajaService.haeKaikki();
    }
}
