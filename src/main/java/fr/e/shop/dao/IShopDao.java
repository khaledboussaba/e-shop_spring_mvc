package fr.e.shop.dao;

import java.util.List;

import com.mysql.cj.xdevapi.Client;

import fr.e.shop.entities.Categorie;
import fr.e.shop.entities.Commande;
import fr.e.shop.entities.Panier;
import fr.e.shop.entities.Produit;
import fr.e.shop.entities.Role;
import fr.e.shop.entities.User;

public interface IShopDao {

	public Long ajouterCategorie(Categorie categorie);
	public List<Categorie> listeCategories();
	public Categorie getCategorie(Long idCategorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie categorie);
	
	public Long ajouterProduit(Produit produit, Long idCategorie);
	public List<Produit> listeProduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCategorie);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idProduit);
	public void supprimerProduit(Long idProduit);
	public void modifierProduit(Produit produit);
	
	public void ajouterUser(User user);
	public void attribuerRole(Role role, Long idUser);
	
	public Commande enregisterCommande(Panier panier, Client client);
	
}
