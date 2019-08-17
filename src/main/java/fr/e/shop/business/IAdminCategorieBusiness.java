package fr.e.shop.business;

import fr.e.shop.entities.Categorie;
import fr.e.shop.entities.Role;
import fr.e.shop.entities.User;

public interface IAdminCategorieBusiness extends IAdminProduitBusiness {

	public Long ajouterCategorie(Categorie categorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie categorie);
	
	public void ajouterUser(User user);
	public void attribuerRole(Role role, Long idUser);
	
	
}
