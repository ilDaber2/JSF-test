package com.pizzeria.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ingrediente")
public class Ingrediente {

	@ManyToMany
	private List<Pizza> pizza;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIngrediente;

	@Column(name = "nomeIngr")
	private String nomeIngr;

	public Ingrediente() {
		super();
	}

	public Ingrediente(List<Pizza> pizza, Long idIngrediente, String nomeIngr) {
		super();
		this.pizza = pizza;
		this.idIngrediente = idIngrediente;
		this.nomeIngr = nomeIngr;
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNomeIngr() {
		return nomeIngr;
	}

	public void setNomeIngr(String nomeIngr) {
		this.nomeIngr = nomeIngr;
	}

}