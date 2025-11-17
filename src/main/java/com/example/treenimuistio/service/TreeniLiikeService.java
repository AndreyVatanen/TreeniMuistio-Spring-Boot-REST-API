package com.example.treenimuistio.service;
import com.example.treenimuistio.model.TreeniLiike;
import com.example.treenimuistio.model.TreeniSessio;
import com.example.treenimuistio.repo.TreeniLiikeRepo;
import com.example.treenimuistio.repo.TreeniSessioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeniLiikeService {

    @Autowired
    TreeniLiikeRepo treeniLiikeRepo;

    @Autowired
    TreeniSessioRepo treeniSessioRepo;

    public TreeniLiike lisaaLiike(Long id, TreeniLiike liike) {

        TreeniSessio sessio = treeniSessioRepo.findById(id).orElseThrow(() -> new RuntimeException("Sessio ei löytynyt"));
        liike.setTreeniSessio(sessio);
        sessio.getTreeniloki().add(liike);
        treeniSessioRepo.save(sessio);
        return liike;

    }


    public boolean poistaTreeni(Long id) {
        if (treeniLiikeRepo.existsById(id)) {
            treeniLiikeRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
