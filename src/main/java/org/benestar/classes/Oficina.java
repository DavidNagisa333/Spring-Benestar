package org.benestar.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "oficina") // This tells Hibernate to make a table out of this class
public class Oficina {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "codi_postal", length = 8)
    @NotNull
    private Integer CodiPostal;
	
	@Column(name = "poblacio", length = 50)
    @NotNull
    private String Poblacio;
     
	@Column(name = "provincia", length = 50)
    @NotNull
    private String Provincia;
    
	@Column(name = "direccio", length = 100)
    @NotNull
    private String Direccio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCodiPostal(){
		return CodiPostal;
	}
	
	public void setCodiPostal(Integer CodiPostal){
		this.CodiPostal = CodiPostal;
	}
	
	public String getPoblacio() {
		return Poblacio;
	}

	public void setPoblacio(String Poblacio) {
		this.Poblacio = Poblacio;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String Provincia) {
		this.Provincia = Provincia;
	}
    
	public String Direccio(){
		return Direccio;
	}
	
	public void setDireccio(String Direccio){
		this.Direccio = Direccio;
	}
    
}

