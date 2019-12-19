package fr.diginamic.off.entities;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	private List<Produit> produits = new ArrayList<>();
	private List<Allergene> allergenes = new ArrayList<Allergene>();
	private List <Additif> additifs = new ArrayList<Additif>();
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	
	/** Getter
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}
	/** Setter
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	/** Getter
	 * @return the allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}
	/** Setter
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}
	/** Getter
	 * @return the additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}
	/** Setter
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}
	/** Getter
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	/** Setter
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	

}
