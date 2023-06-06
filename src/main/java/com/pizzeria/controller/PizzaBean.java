package com.pizzeria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.pizzeria.DAO.DaoApp;
import com.pizzeria.entities.Impasto;
import com.pizzeria.entities.Ingrediente;
import com.pizzeria.entities.Utente;

@ManagedBean(name = "pizzaBean")
@SessionScoped
public class PizzaBean implements Serializable {

	private static final long serialVersionUID = 9050078778027947511L;

	@Inject
	private DaoApp dao;

	private Utente utente;

	private List<Impasto> listaImpasti;

	private List<String> listNomeIngr;
	
	private List<String> listNomeImpasti;

	private List<Ingrediente> listaIngredienti;

	@ManagedProperty(value = "#{utenteBean}")
	UtenteBean utenteBean;

	@PostConstruct
	public void init() {
		dao = new DaoApp();

		utente = utenteBean.getUtente();
		
		listaIngredienti = dao.loadAllIngredienti();
		listaImpasti = dao.loadAllImpasti();
		
		listNomeIngr = dao.getNomeIngr(listaIngredienti);
		listNomeImpasti = dao.getNomeImpasti(listaImpasti);
	}
	
	public void addPizza() {
		dao = new DaoApp();
		
		dao.addNewPizza();
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Impasto> getListaImpasti() {
		return listaImpasti;
	}

	public void setListaImpasti(List<Impasto> listaImpasti) {
		this.listaImpasti = listaImpasti;
	}

	public List<Ingrediente> getListaIngredienti() {
		return listaIngredienti;
	}

	public void setListaIngredienti(List<Ingrediente> listaIngredienti) {
		this.listaIngredienti = listaIngredienti;
	}

	public void setUtenteBean(UtenteBean utenteBean) {
		this.utenteBean = utenteBean;
	}

	public List<String> getListNomeIngr() {
		return listNomeIngr;
	}

	public void setListNomeIngr(List<String> listNomeIngr) {
		this.listNomeIngr = listNomeIngr;
	}

	public UtenteBean getUtenteBean() {
		return utenteBean;
	}

	public List<String> getListNomeImpasti() {
		return listNomeImpasti;
	}

	public void setListNomeImpasti(List<String> listNomeImpasti) {
		this.listNomeImpasti = listNomeImpasti;
	}

	
}
