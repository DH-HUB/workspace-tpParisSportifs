package fr.metz.mns.tp.tpParisSportifs.models;



import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;




@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipeA;
    private String equipeB;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMatch;

    // Pour la relation avec les paris
    @OneToMany(mappedBy = "match")
    private Set<Pari> paris;

    // Pour la relation avec les événements
    @OneToMany(mappedBy = "match")
    private Set<Evenement> evenements;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipeA() {
		return equipeA;
	}

	public void setEquipeA(String equipeA) {
		this.equipeA = equipeA;
	}

	public String getEquipeB() {
		return equipeB;
	}

	public void setEquipeB(String equipeB) {
		this.equipeB = equipeB;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public Set<Pari> getParis() {
		return paris;
	}

	public void setParis(Set<Pari> paris) {
		this.paris = paris;
	}

	public Set<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

    
}

