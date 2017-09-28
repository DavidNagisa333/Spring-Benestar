package org.benestar.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "familia")
public class Familia {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", length = 45, unique = true)
    @NotNull
    @Size(min = 4, max = 45)
    private String nom;

    private Set<Factura> factura = new HashSet<Factura>(0);
    
    
////////////////////////////////
    
    public Familia() {
	}

	public Familia(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Familia(Long id, String nom, Set<Factura> factura) {
		this.id = id;
		this.nom = nom;
		this.factura = factura;
	}
		
	
/////////////////////////
	

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
////////////////////////////
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familia")
	public Set<Factura> getFactura() {
		return this.factura;
	}

	public void setFactura(Set<Factura> factura) {
		this.factura = factura;
	}
    
}