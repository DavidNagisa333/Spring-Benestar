package org.benestar.classes;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factura")
public class Factura {
	@Id
    private Long id;
	
	@Column(name = "diners")
    @NotNull
    private String diners;
	
	@Column(name = "id_familia")
    @NotNull
    private Familia id_familia;

	
	//////////////////////////
	
	
	public Factura() {
	}

	public Factura(Long id, String diners) {
		this.id = id;
		this.diners = diners;
	}

	public Factura(Long id, String diners, Familia id_familia) {
		this.id = id;
		this.diners = diners;
		this.id_familia = id_familia;
	}
	
	
	////////////////////////
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiners() {
		return diners;
	}

	public void setDiners(String diners) {
		this.diners = diners;
	}

	public Familia getId_familia() {
		return id_familia;
	}

	public void setId_familia(Familia id_familia) {
		this.id_familia = id_familia;
	}
	
	
	/////////////////////////////////
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	public Familia getFamilia() {
		return this.id_familia;
	}

	public void setFamilia(Familia familia) {
		this.id_familia = familia;
	}
	
}
