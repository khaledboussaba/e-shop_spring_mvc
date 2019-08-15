package fr.e.shop.entities;

import java.io.Serializable;
import java.util.Collection;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String telephone;
	private Collection<Commande> commandes;
	
	public Client() {
	}

	public Client(String nomClient, String adresse, String email, String telephone) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

}
