package org.benestar.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Copagaments {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long tipus;

    private String descripcio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipus() {
		return tipus;
	}

	public void setTipus(Long tipus) {
		this.tipus = tipus;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}      
}

