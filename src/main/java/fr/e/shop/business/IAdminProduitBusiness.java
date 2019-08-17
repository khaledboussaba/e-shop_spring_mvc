package fr.e.shop.business;

import fr.e.shop.entities.Produit;

public interface IAdminProduitBusiness extends InternauteBusiness {
	
	public Long ajouterProduit(Produit produit, Long idCategorie);
	public void supprimerProduit(Long idProduit);
	public void modifierProduit(Produit produit);
	
}
