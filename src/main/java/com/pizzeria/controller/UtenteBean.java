package com.pizzeria.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.pizzeria.DAO.DaoApp;
import com.pizzeria.entities.Utente;

@ManagedBean(name="utenteBean")
@SessionScoped
public class UtenteBean implements Serializable{
	
	private static final long serialVersionUID = 2885976758176953037L;

	private List<Utente> utenti;
	
	@Inject
	private DaoApp dao;
	
	@Inject
	private String username;
	private String password;
	private Utente utente;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void logout() {
		dao = new DaoApp();
		
		dao.logout();
	}

	public String login() throws IOException {
		dao = new DaoApp();
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		utente = dao.loginApp(getUsername(), getPassword());
		
		if(utente != null) {
			context.addMessage(null, new FacesMessage("Successful", "Benvenuto: " + username));
			return "dashboard.xhtml";
		} else {
			context.addMessage(null, new FacesMessage("Loggin Error", "Credenziali non valide"));
			return "index.xhtml";
		}
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public DaoApp getDaoApp() {
		return dao;
	}

	public void setUtenteManager(DaoApp dao) {
		this.dao = dao;
	}
	
	public boolean isLoggedIn() {
		return utente != null;
	}
	
}