package fr.diginamic.off.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @author baptis
 *Classe permettant de creer la table prouits dans la base de donnée
 */
@Entity
@Table(name = "PRODUIT")
public class Produit {
	
	/** ID généré automatiquement*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	/** nom du produit de type String. Cet attribut génère une colonne dans la base de donnée*/
	@Column(name="NOM")
	private String nom;
	
	/** retourne la marque du produit*/
	@ManyToOne
	@JoinColumn(name="ID_MARQUE")
	private Marque marque;
	
	/** retourne la catégorie du produit*/
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie;
	
	/** retourne une liste d'ingredients pour un produit, génère une table de jointure*/
	@ManyToMany
	@JoinTable(name="ID_INGREDIENT_ID_PRODUIT",
	joinColumns=@JoinColumn(name="ID_PRODUIT", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="ID_INGREDIENT", referencedColumnName="ID"))
	private List<Ingredient> ingredients= new ArrayList<Ingredient>();
	
	/** colonne score nutritionel de type string. le grade est une lettre de allant de a à f afin de classer les produits */
	@Column(name ="SCORE_NUT")
	private String scoreNutritionnel;
	
	/** constructeur*/
	public Produit(){}
	
	
	

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}
	/** Setter
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	/** Getter
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
	/** Getter
	 * @return the scoreNutritionnel
	 */
	public String getScoreNutritionnel() {
		return scoreNutritionnel;
	}
	/** Setter
	 * @param scoreNutritionnel the scoreNutritionnel to set
	 */
	public void setScoreNutritionnel(String scoreNutritionnel) {
		this.scoreNutritionnel = scoreNutritionnel;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", scoreNutritionnel=" + scoreNutritionnel
				 + "]";
	}
	
	
	

}
