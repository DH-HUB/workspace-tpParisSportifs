package fr.metz.mns.tp.tpParisSportifs.repositories;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.metz.mns.tp.tpParisSportifs.models.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    List findByType(String type);

    // Trouve les événements associés à un match donné
    List findByMatchId(int matchId);

	Optional<Evenement> findById(Long id);
}
