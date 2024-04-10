package fr.metz.mns.tp.tpParisSportifs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.metz.mns.tp.tpParisSportifs.models.Parieur;
import fr.metz.mns.tp.tpParisSportifs.repositories.ParieurRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ParieurService {

    private final ParieurRepository parieurRepository;

    @Autowired
    public ParieurService(ParieurRepository parieurRepository) {
        this.parieurRepository = parieurRepository;
    }

    public java.util.List<Parieur> getAllParieurs() {
        return parieurRepository.findAll();
    }

    public Parieur getParieurById(Long id) {
        return parieurRepository.findById((long) id)
                .orElseThrow(() -> new EntityNotFoundException("Parieur not found with id: " + id));
    }

    public Parieur createParieur(Parieur parieur) {
       
        return parieurRepository.save(parieur);
    }

    public Parieur updateParieur(Long id, Parieur parieurDetails) {
        Parieur parieur = getParieurById(id);
        // MAJ des champs de parieur
        parieur.setNom(parieurDetails.getNom());
        parieur.setPrenom(parieurDetails.getPrenom());
        parieur.setEmail(parieurDetails.getEmail());
        parieur.setDateInscription(parieurDetails.getDateInscription());
        return parieurRepository.save(parieur);
    }

    public void deleteParieur(Long id) {
        parieurRepository.deleteById((long) id);
    }
}