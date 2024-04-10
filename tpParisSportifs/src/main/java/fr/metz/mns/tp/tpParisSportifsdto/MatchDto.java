package fr.metz.mns.tp.tpParisSportifsdto;

import java.util.Date;

public class MatchDto {
    private int id;
    private String equipeA;
    private String equipeB;
    private Date dateMatch;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

    
}
