package organitzacions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "organitzacio")
public class Organitzacio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String nom;

    @Column(name = "telefon")
    @NotNull
    @Size(min = 6, max = 15)
    private String telefon;

    @Column(name = "pais", length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String pais;

    @Column(name = "correu", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String correu;

    @Column(name = "direccio", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String direccio;
    
    @Column(name = "tipus", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String tipus;

    @Column(name = "actiu")
    @NotNull
    private Boolean actiu;

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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public Boolean getActiu() {
		return actiu;
	}

	public void setActiu(Boolean actiu) {
		this.actiu = actiu;
	}    

}

