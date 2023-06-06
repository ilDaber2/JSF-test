package com.pizzeria.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pizza")
public class Pizza {
	
	@ManyToMany
	@JoinTable(
			  name = "Pizza_Ingrediente", 
			  joinColumns = @JoinColumn(name = "idPizza"), 
			  inverseJoinColumns = @JoinColumn(name = "idIngrediente"))
	private List<Ingrediente> ingrediente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUtente", nullable=false)
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="idImpasto", nullable=false)
	private Impasto impasto;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPizza;
	
	@Column(name="nomePiz")
	private String nomePiz;

	public Pizza() {
		super();
	}
	
	public Pizza(Utente utente, Impasto impasto, Long idPizza, String nomePiz, List<Ingrediente> ingrediente) {
		super();
		this.utente = utente;
		this.impasto = impasto;
		this.idPizza = idPizza;
		this.nomePiz = nomePiz;
		this.ingrediente = ingrediente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Impasto getImpasto() {
		return impasto;
	}

	public void setImpasto(Impasto impasto) {
		this.impasto = impasto;
	}

	public Long getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Long idPizza) {
		this.idPizza = idPizza;
	}

	public String getNomePiz() {
		return nomePiz;
	}

	public void setNomePiz(String nomePiz) {
		this.nomePiz = nomePiz;
	}

	public List<Ingrediente> getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(List<Ingrediente> ingrediente) {
		this.ingrediente = ingrediente;
	}
	
}
