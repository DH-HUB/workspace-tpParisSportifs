package fr.metz.mns.tp.tpParisSportifsdto;

import java.util.Date;

public class PariDto {
    private int id;
    private int parieurId;
    private int matchId;
    private float mise;
    private String statut;
    private Date datePari;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParieurId() {
		return parieurId;
	}
	public void setParieurId(int parieurId) {
		this.parieurId = parieurId;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
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
	public Date getDatePari() {
		return datePari;
	}
	public void setDatePari(Date datePari) {
		this.datePari = datePari;
	}

    
}
