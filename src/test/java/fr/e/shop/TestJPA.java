package fr.e.shop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.e.shop.business.IAdminCategorieBusiness;
import fr.e.shop.entities.Categorie;

public class TestJPA {
	
	@Test
	public void testConnexion() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
			assertTrue(true);			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void testaddCategorie() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
			
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
	
}
