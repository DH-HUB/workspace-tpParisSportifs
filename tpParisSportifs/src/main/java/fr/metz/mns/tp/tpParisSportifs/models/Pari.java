package fr.metz.mns.tp.tpParisSportifs.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;



@Entity
public class Pari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float mise;
    private String statut;
    
    // Pour la relation avec le parieur
    @ManyToOne
    @JoinColumn(name = "parieur_id")
    private Parieur parieur;

    // Pour la relation avec le match
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    
    // Pour la relation avec la cote
    @OneToOne
    @JoinColumn(name = "cote_id")
    private Cote cote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getMise() {
		return mise;
	}

	public void setMise(float mise) {
		this.mise = mise;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Parieur getParieur() {
		return parieur;
	}

	public void setParieur(Parieur parieur) {
		this.parieur = parieur;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Cote getCote() {
		return cote;
	}

	public void setCote(Cote cote) {
		this.cote = cote;
	}

   
}