package fr.metz.mns.tp.tpParisSportifs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.metz.mns.tp.tpParisSportifs.models.Evenement;
import fr.metz.mns.tp.tpParisSportifs.repositories.EvenementRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    @Autowired
    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public java.util.List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evenement not found with id: " + id));
    }

    public Evenement createEvenement(Evenement evenement) {
        // Valide l'événement
        return evenementRepository.save(evenement);
    }

    public Evenement updateEvenement(Long id, Evenement evenementDetails) {
        Evenement evenement = getEvenementById(id);
        // MAJ des champs de l'événement
        evenement.setType(evenementDetails.getType());
        evenement.setDate(evenementDetails.getDate());
        return evenementRepository.save(evenement);
    }

    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }
}
