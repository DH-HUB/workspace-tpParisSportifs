package fr.metz.mns.tp.tpParisSportifs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.metz.mns.tp.tpParisSportifs.models.Pari;

public interface PariRepository extends JpaRepository<Pari, Long> {
 
}