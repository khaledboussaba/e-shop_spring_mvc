package fr.e.shop.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();
	
	public void addArticle(Produit produit, int quantite) {
		if (items.get(produit.getIdProduit()) == null) {
			LigneCommande lc = new LigneCommande();
			lc.setProduit(produit);
			lc.setQuantite(quantite);
			lc.setPrix(produit.getPrix() * quantite);
		}
		else {
			LigneCommande lc = items.get(produit.getIdProduit());
			lc.setQuantite(produit.getQuantite() + quantite);
		}
	}
	
	public Collection<LigneCommande> getItems(){
		return items.values();
	}
	
	public double getTotal() {
		double total = 0.0;
		
		for (LigneCommande lc : items.values()) {
			total += lc.getPrix();
		}
		
		return total;
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void deleteItem(Long idProduit) {
		items.remove(idProduit);
	}

}
