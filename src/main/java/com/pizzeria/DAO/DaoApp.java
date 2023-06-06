package com.pizzeria.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pizzeria.controller.PizzaBean;
import com.pizzeria.entities.Impasto;
import com.pizzeria.entities.Ingrediente;
import com.pizzeria.entities.Pizza;
import com.pizzeria.entities.Utente;

public class DaoApp {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	private Utente utente;

	private PizzaBean pizza;
	
	public List<Utente> loadAllUtenti() {
		return entityManager.createQuery("SELECT c FROM Utente c", Utente.class).getResultList();
	}
	

	public List<Ingrediente> loadAllIngredienti(){
		return entityManager.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class).getResultList();
	}
	
	public List<Impasto> loadAllImpasti(){
		return entityManager.createQuery("SELECT i FROM Impasto i", Impasto.class).getResultList();
	}
	

	public List<Pizza> loadAllPizze(){
		return entityManager.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
	}

	public Utente loginApp(String username, String password) throws IOException {
		
		boolean loggedIn = true;

		@SuppressWarnings("unchecked")
		List<Utente> results = entityManager
				.createQuery("select u from Utente u where u.username = :username and u.password = :password")
				.setParameter("username", username).setParameter("password", password).getResultList();	
		
		if (!results.isEmpty()) {
			utente = results.get(0);
			return utente;
		} else {
			loggedIn = false;
			return utente;
		}
	}

	public void logout() {
		utente = null;
	}

	public boolean isLoggedIn() {
		return utente != null;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public PizzaBean getPizza() {
		return pizza;
	}


	public void setPizza(PizzaBean pizza) {
		this.pizza = pizza;
	}


	public List<String> getNomeIngr(List<Ingrediente> listaIngredienti) {	
		List<String> nomeIngr = new ArrayList<String>();
		for(int i = 0; i < listaIngredienti.size(); i++) {
			
			Ingrediente ing = listaIngredienti.get(i);
			
			nomeIngr.add(ing.getNomeIngr());			
		}

		return nomeIngr;
	}


	public List<String> getNomeImpasti(List<Impasto> listaImpasti) {
		List<String> nomeImpasto = new ArrayList<String>();
		for(int i = 0; i < listaImpasti.size(); i++) {
			
			Impasto ing = listaImpasti.get(i);
			
			nomeImpasto.add(ing.getNomeImp());			
		}

		return nomeImpasto;
	}
	
	public void addNewPizza() {
		
	}
	
}
