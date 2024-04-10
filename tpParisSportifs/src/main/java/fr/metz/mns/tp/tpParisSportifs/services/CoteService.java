package fr.metz.mns.tp.tpParisSportifs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.metz.mns.tp.tpParisSportifs.models.Cote;
import fr.metz.mns.tp.tpParisSportifs.models.Match;
import fr.metz.mns.tp.tpParisSportifs.repositories.CoteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CoteService {
	
	 private final CoteRepository coteRepository;
	    private final MatchService matchService;

	    @Autowired
	    public CoteService(CoteRepository coteRepository, MatchService matchService) {
	        this.coteRepository = coteRepository;
	        this.matchService = matchService;
	    }


    public java.util.List<Cote> getAllCotes() {
        return coteRepository.findAll();
    }

    public Cote getCoteById(Long id) {
        return coteRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("Cote introuvable avec l'ID : " + id));
    }
    
    public Cote createCote(Cote cote) {
        // Valide cote 
        return coteRepository.save(cote);
    }

    public Cote updateCote(Long id, Cote coteDetails) {
        Cote cote = getCoteById(id);
        // MAJ des champs de cote
        cote.setValeur(coteDetails.getValeur());
        return coteRepository.save(cote);
    }

    public void deleteCote(Long id) {
        coteRepository.deleteById(id);
    }

    /**
     * Vérifie si la cote est valide pour un match donné.
     * @param cote La cote à vérifier.
     * @param match Le match associé à la cote.
     * @return vrai si la cote est valide pour le match.
     */
    public boolean isCoteValidForMatch(Cote cote, Match match) {
        // Vérifier que la cote est positive
        if (cote.getValeur() <= 0) {
            return false;
        }
        
        // Vérifier que la cote correspond au match en question
        if (!cote.getMatch().equals(match)) {
            return false;
        }
        
        // Vérifier que le match n'a pas déjà commencé
        if (matchService.isMatchAvailableForBetting(match)) {
            return true;
        }
        
        return false;
    }
}