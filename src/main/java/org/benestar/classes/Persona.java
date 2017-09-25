package org.benestar.classes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name = "nom", length = 20)
    @NotNull
    private String nom;
	
	@Column(name = "cognoms", length = 30)
    @NotNull
    private String cognoms;
	
	@Column(name = "naixement")
    //@NotNull
    private LocalDate naixement;
	
	@Column(name = "correu", length = 50)
    @NotNull
    private String correu;
	
	@Column(name = "telefon", length = 20)
    @NotNull
    private String telefon;
	
	@Column(name = "mobil", length = 20)
    @NotNull
    private String mobil;
	
	@Column(name = "adreca", length = 40)
    @NotNull
    private String adreca;
	
	@Column(name = "localitat", length = 20)
    @NotNull
    private String localitat;
	
	@Column(name = "comarca", length = 20)
    @NotNull
    private String comarca;
	
	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public LocalDate getNaixement() {
		return naixement;
	}

	public void setNaixement(LocalDate naixement) {
		this.naixement = naixement;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getLocalitat() {
		return localitat;
	}

	public void setLocalitat(String localitat) {
		this.localitat = localitat;
	}

	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}
}
