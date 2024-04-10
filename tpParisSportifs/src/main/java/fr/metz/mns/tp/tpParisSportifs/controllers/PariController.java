package fr.metz.mns.tp.tpParisSportifs.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.metz.mns.tp.tpParisSportifs.models.Pari;
import fr.metz.mns.tp.tpParisSportifs.services.PariService;

@RestController
@RequestMapping("/paris")
public class PariController {

    private final PariService pariService;

    @Autowired
    public PariController(PariService pariService) {
        this.pariService = pariService;
    }

    @GetMapping
    public List getAllParis() {
        return (List) pariService.getAllParis();
    }

    @GetMapping("/{id}")
    public Pari getPariById(@PathVariable Long id) {
        return pariService.getPariById(id);
    }

    // FIXME Points de terminaison pour placer un pari
}

