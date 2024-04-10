package fr.metz.mns.tp.tpParisSportifs.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.metz.mns.tp.tpParisSportifs.exceptions.BusinessException;
import fr.metz.mns.tp.tpParisSportifs.models.Cote;
import fr.metz.mns.tp.tpParisSportifs.models.Match;
import fr.metz.mns.tp.tpParisSportifs.models.Pari;
import fr.metz.mns.tp.tpParisSportifs.repositories.PariRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PariService {

    private final PariRepository pariRepository;
    private final MatchService matchService;
    private final CoteService coteService;

    @Autowired
    public PariService(PariRepository pariRepository, MatchService matchService, CoteService coteService) {
        this.pariRepository = pariRepository;
        this.matchService = matchService;
        this.coteService = coteService;
    }

    public List<Pari> getAllParis() {
        return pariRepository.findAll();
    }

    public Pari getPariById(Long id) {
        return pariRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pari introuvable avec l'identifiant :" + id));
    }

    @Transactional
    public Pari createPari(Pari pari) {
        
        validatePariData(pari);
        
        // récupére le match et la cote associés au pari
        
        Match match = matchService.getMatchById(pari.getMatch().getId());
        Cote cote = coteService.getCoteById(pari.getCote().getId());
        
        if(!matchService.isMatchAvailableForBetting(match)) {
            throw new BusinessException("Le match n'est plus disponible pour parier.");
        }
        if(!coteService.isCoteValidForMatch(cote, match)) {
            throw new BusinessException("La cote n'est pas valide pour le match sélectionné.");
        }
        
        pari.setMatch(match);
        pari.setCote(cote);
        return pariRepository.save(pari);
    }

    private void validatePariData(Pari pari) {
        if(pari.getMise() <= 0) {
            throw new BusinessException("La mise doit être supérieure à zéro.");
        }
    }
    @Transactional
    public Pari updatePari(Long id, Pari pariDetails) {
        Pari pari = getPariById(id);
        // MAJ des champs du pari
        pari.setMise(pariDetails.getMise());
        pari.setStatut(pariDetails.getStatut());
       

        return pariRepository.save(pari);
    }

    @Transactional
    public void deletePari(Long id) {
        pariRepository.deleteById(id);
    }


}