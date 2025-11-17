package com.example.treenimuistio.controller;

import com.example.treenimuistio.model.TreeniLiike;
import com.example.treenimuistio.model.TreeniSessio;
import com.example.treenimuistio.service.TreeniLiikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TreeniLiikeController {

    @Autowired
    TreeniLiikeService treeniLiikeService;


    @PostMapping("/lisaatreeni/{Id}")
    public TreeniLiike lisaaTreeni(@PathVariable("Id") Long Id, @RequestBody TreeniLiike lisattavaTreeni) {
       return treeniLiikeService.lisaaLiike(Id,lisattavaTreeni);
    }

    @DeleteMapping("/poistaliike/{Id}")
    public boolean poistaTreeni(@PathVariable("Id") Long Id) {
        return treeniLiikeService.poistaTreeni(Id);
    }

}
