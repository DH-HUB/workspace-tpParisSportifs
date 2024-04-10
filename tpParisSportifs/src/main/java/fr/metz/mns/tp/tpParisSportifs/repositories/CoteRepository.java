package fr.metz.mns.tp.tpParisSportifs.repositories;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.metz.mns.tp.tpParisSportifs.models.Cote;

public interface CoteRepository extends JpaRepository<Cote, Long> {
    // Trouve les cotes par valeur
    List findByValeur(Float valeur);

	Optional<Cote> findById(Long id);
}
