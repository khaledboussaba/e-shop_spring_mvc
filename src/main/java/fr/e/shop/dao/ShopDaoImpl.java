package fr.e.shop.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mysql.cj.xdevapi.Client;

import fr.e.shop.entities.Categorie;
import fr.e.shop.entities.Commande;
import fr.e.shop.entities.LigneCommande;
import fr.e.shop.entities.Panier;
import fr.e.shop.entities.Produit;
import fr.e.shop.entities.Role;
import fr.e.shop.entities.User;

public class ShopDaoImpl implements IShopDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long ajouterCategorie(Categorie categorie) {
		em.persist(categorie);
		return categorie.getIdCategorie();
	}

	@Override
	public List<Categorie> listeCategories() {
		Query query = em.createQuery("SELECT c FROM Categorie c");
		return query.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return em.find(Categorie.class, idCategorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		Categorie categorie = em.find(Categorie.class, idCategorie);
		em.remove(categorie);		
	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		em.merge(categorie);
	}

	@Override
	public Long ajouterProduit(Produit produit, Long idCategorie) {
		Categorie categorie = getCategorie(idCategorie);
		produit.setCategorie(categorie);
		em.persist(produit);
		return produit.getIdProduit();
	}

	@Override
	public List<Produit> listeProduits() {
		Query query = em.createQuery("SELECT p FROM Produit p");
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query query = em.createQuery("SELECT p FROM Produit p WHERE p.designation LIKE :x OR p.description LIKE :x");
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCategorie) {
		Query query = em.createQuery("SELECT p FROM Produit p WHERE p.categorie.idCategorie = :x");
		query.setParameter("x", idCategorie);
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query query = em.createQuery("SELECT p FROM Produit p WHERE p.selected = true");
		return query.getResultList();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return em.find(Produit.class, idProduit);
	}

	@Override
	public void supprimerProduit(Long idProduit) {
		Produit produit = getProduit(idProduit);
		em.remove(produit);
	}

	@Override
	public void modifierProduit(Produit produit) {
		em.merge(produit);
	}

	@Override
	public void ajouterUser(User user) {
		em.persist(user);
	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
		User user = em.find(User.class, idUser);
		user.getRoles().add(role);
		em.persist(role);
	}

	@Override
	public Commande enregisterCommande(Panier panier, Client client) {
		em.persist(client);
		Commande commande = new Commande();
		commande.setDateCommande(new Date());
		commande.setItems(panier.getItems());
		for(LigneCommande lc : panier.getItems()) {
			em.persist(lc);
		}
		em.persist(commande);
		return commande;
	}

}
