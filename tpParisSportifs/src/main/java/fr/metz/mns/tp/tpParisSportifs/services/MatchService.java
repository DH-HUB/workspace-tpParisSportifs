package fr.metz.mns.tp.tpParisSportifs.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.metz.mns.tp.tpParisSportifs.exceptions.BusinessException;
import fr.metz.mns.tp.tpParisSportifs.models.Match;
import fr.metz.mns.tp.tpParisSportifs.repositories.MatchRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public java.util.List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

 // Dans MatchService
    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("Match introuvable avec l'ID : " + id));
    }

    /**
     * Vérifie si le match est disponible pour les paris.
     * @param match Le match à vérifier.
     * @return vrai si le match est disponible pour les paris.
     */
    public boolean isMatchAvailableForBetting(Match match) {
    	
    	 return match.getDateMatch().after(new Date());
    }
    
    public Match createMatch(Match match) {
        // Valide match 
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match matchDetails) {
        // Trouver le match existant
        Match match = getMatchById(id);
        
        
        validateMatch(matchDetails);

        // MAJ des champs de match
        match.setEquipeA(matchDetails.getEquipeA());
        match.setEquipeB(matchDetails.getEquipeB());
        match.setDateMatch(matchDetails.getDateMatch());

      
        return matchRepository.save(match);
    }
    
    /**
     * Valide que les informations essentielles d'un match sont présentes.
     * Cette méthode vérifie que les noms des équipes participant au match ne sont pas nuls.
     *
     * @param match L'instance de {@link Match} à valider.
     * @throws BusinessException Si les informations de l'équipe sont incomplètes ou nulles.
     */
    private void validateMatch(Match match) {
        if(match.getEquipeA() == null || match.getEquipeB() == null) {
            throw new BusinessException("Les informations sur les équipes ne peuvent pas être nulles.");
        }
    }
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }


}
