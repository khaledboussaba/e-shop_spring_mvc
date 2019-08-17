package fr.e.shop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.e.shop.business.IAdminCategorieBusiness;
import fr.e.shop.business.InternauteBusiness;
import fr.e.shop.entities.Categorie;
import fr.e.shop.entities.Produit;

public class TestJPA {
	
	ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	}
	
	@Test
	public void testConnexionBdd() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
			assertTrue(true);			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void testAddCategorie() {
		try {
			IAdminCategorieBusiness business = (IAdminCategorieBusiness)context.getBean("business");
			
			List<Categorie> categories1 = business.listeCategories();
			business.ajouterCategorie(new Categorie("Ordindateurs", "ordinateur 12345", null, "image1.png"));
			business.ajouterCategorie(new Categorie("Imprimantess", "printer 12345", null, "image2.png"));
			
			List<Categorie> categories2 = business.listeCategories();
			assertTrue(categories1.size() + 2 == categories2.size());			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void testDeleteCategorie() {
		try {
			IAdminCategorieBusiness business = (IAdminCategorieBusiness)context.getBean("business");
			
			business.supprimerCategorie(1L);
			
			assertTrue(business.getCategorie(1L) == null);			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void testAddProduit() {
		try {
			IAdminCategorieBusiness business = (IAdminCategorieBusiness)context.getBean("business");
			
			List<Produit> produit1 = business.listeProduits();
			business.ajouterProduit(new Produit("Produit 1", "Le premier produit ajouter", 30.99, 2, false, null), 2L);
			
			List<Produit> produit2 = business.listeProduits();
			assertTrue(produit1.size() + 1 == produit2.size());			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void detProduit() {
		try {
			InternauteBusiness business = (InternauteBusiness)context.getBean("business");
			Produit p = business.getProduit(1L);
			assertTrue(p.getIdProduit() == business.getProduit(1L).getIdProduit());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
}
