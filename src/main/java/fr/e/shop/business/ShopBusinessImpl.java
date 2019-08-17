package fr.e.shop.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.xdevapi.Client;

import fr.e.shop.dao.IShopDao;
import fr.e.shop.entities.Categorie;
import fr.e.shop.entities.Commande;
import fr.e.shop.entities.Panier;
import fr.e.shop.entities.Produit;
import fr.e.shop.entities.Role;
import fr.e.shop.entities.User;

@Transactional
public class ShopBusinessImpl implements IAdminCategorieBusiness {
	
	private IShopDao dao;

	public void setDao(IShopDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Long ajouterProduit(Produit produit, Long idCategorie) {
		return dao.ajouterProduit(produit, idCategorie);
	}

	@Override
	public void supprimerProduit(Long idProduit) {
		dao.supprimerProduit(idProduit);
	}

	@Override
	public void modifierProduit(Produit produit) {
		dao.modifierProduit(produit);
	}

	@Override
	public List<Categorie> listeCategories() {
		return dao.listeCategories();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return dao.getCategorie(idCategorie);
	}

	@Override
	public List<Produit> listeProduits() {
		return dao.listeProduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCategorie) {
		return dao.produitsParCategorie(idCategorie);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return dao.getProduit(idProduit);
	}

	@Override
	public Commande enregisterCommande(Panier panier, Client client) {
		return dao.enregisterCommande(panier, client);
	}

	@Override
	public Long ajouterCategorie(Categorie categorie) {
		return dao.ajouterCategorie(categorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		dao.supprimerCategorie(idCategorie);
	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		dao.modifierCategorie(categorie);
	}

	@Override
	public void ajouterUser(User user) {
		dao.ajouterUser(user);
	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
		dao.attribuerRole(role, idUser);
	}

}
