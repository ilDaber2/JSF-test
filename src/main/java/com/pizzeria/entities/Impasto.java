package com.pizzeria.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Impasto")
public class Impasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImpasto;

	@Column(name = "nomeImp")
	private String nomeImp;

	@OneToMany
	private List<Pizza> pizze;

	public Impasto() {
		super();
	}

	public Impasto(Long idImpasto, String nomeImp, List<Pizza> pizze) {
		super();
		this.idImpasto = idImpasto;
		this.nomeImp = nomeImp;
		this.pizze = pizze;
	}

	public Long getIdImpasto() {
		return idImpasto;
	}

	public void setIdImpasto(Long idImpasto) {
		this.idImpasto = idImpasto;
	}

	public String getNomeImp() {
		return nomeImp;
	}

	public void setNomeImp(String nomeImp) {
		this.nomeImp = nomeImp;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

}