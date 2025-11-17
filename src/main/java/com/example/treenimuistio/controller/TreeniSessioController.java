package com.example.treenimuistio.controller;
import com.example.treenimuistio.model.TreeniLiike;
import com.example.treenimuistio.model.TreeniSessio;
import com.example.treenimuistio.service.TreeniSessioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TreeniSessioController {
        @Autowired
        TreeniSessioService treeniSessioService;

        @RequestMapping("sessio/{id}/treenit")
        public List<TreeniLiike> naytaTreenit(@PathVariable("id") Long id) {
          return treeniSessioService.naytaTreenit(id);
        }

        @PostMapping("/luosessio/{kayttajaId}")
        public TreeniSessio luoSessio(@PathVariable Long kayttajaId) {
            return treeniSessioService.luoSessio(kayttajaId);
        }


        @DeleteMapping("/poista/sessio/{sessioId}")
        public boolean poistaTreenisessio(@PathVariable Long sessioId){
            return treeniSessioService.poistaSessio(sessioId);
        }


        @GetMapping("/kaikkiSessiot")
        public List<TreeniSessio> kaikkiSessiot() {
            return treeniSessioService.haeKaikki();
        }
}
