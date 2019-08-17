package fr.e.shop.business;

import java.util.List;

import com.mysql.cj.xdevapi.Client;

import fr.e.shop.entities.Categorie;
import fr.e.shop.entities.Commande;
import fr.e.shop.entities.Panier;
import fr.e.shop.entities.Produit;

public interface InternauteBusiness {
	
	public List<Categorie> listeCategories();
	public Categorie getCategorie(Long idCategorie);
	
	public List<Produit> listeProduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCategorie);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idProduit);
	
	public Commande enregisterCommande(Panier panier, Client client);

}
