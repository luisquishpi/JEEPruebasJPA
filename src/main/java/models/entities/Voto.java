package models.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the voto database table.
 * 
 */
@Entity
@NamedQuery(name="Voto.findAll", query="SELECT v FROM Voto v")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nivelEstudio;

	private int valor;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="idTema")
	private Tema tema;

	public Voto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNivelEstudio() {
		return this.nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}