package fr.metz.mns.tp.tpParisSportifs.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.metz.mns.tp.tpParisSportifs.models.Parieur;
import fr.metz.mns.tp.tpParisSportifs.services.ParieurService;

@RestController
@RequestMapping("/parieurs")
public class ParieurController {

    private final ParieurService parieurService;

    @Autowired
    public ParieurController(ParieurService parieurService) {
        this.parieurService = parieurService;
    }

    @GetMapping
    public List getAllParieurs() {
        return (List) parieurService.getAllParieurs();
    }

    @GetMapping("/{id}")
    public Parieur getParieurById(@PathVariable Long id) {
        return parieurService.getParieurById(id);
    }

    @PostMapping
    public Parieur createParieur(@RequestBody Parieur parieur) {
        return parieurService.createParieur(parieur);
    }

    @DeleteMapping("/{id}")
    public void deleteParieur(@PathVariable Long id) {
        parieurService.deleteParieur(id);
    }

    
}
