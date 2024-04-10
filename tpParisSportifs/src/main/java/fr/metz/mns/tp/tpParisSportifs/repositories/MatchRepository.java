package fr.metz.mns.tp.tpParisSportifs.repositories;

import java.util.Date;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.metz.mns.tp.tpParisSportifs.models.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
    // Recherche les matchs par date
    List findByDateMatch(Date date);

    // Trouve les matchs impliquant une certaine équipe
    List findByEquipeAOrEquipeB(String equipeA, String equipeB);
}