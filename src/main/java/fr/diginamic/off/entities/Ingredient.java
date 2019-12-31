package fr.diginamic.off.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * @author bapti
 *Classe permettant de creer la table ingredient dans la base de donnée
 */
@Entity
@Table(name="INGREDIENT")
public class Ingredient {
	
	/** ID généré automatiquement*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	/** nom de l'ingredient de type String. Cet attribut génère une colonne dans la base de donnée*/
	@Column(name="nom", length=255, nullable=true)
	private String nom;
	
	/** Renvoi à la liste des produits concernés par un ingredient, creation d'une table de jointure */
	@ManyToMany
	@JoinTable(name="ID_INGREDIENT_ID_PRODUIT",
	joinColumns=@JoinColumn(name="ID_INGREDIENT", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="ID_PRODUIT", referencedColumnName="ID"))
	private List<Produit> produits= new ArrayList<Produit>();


	/**
	 * Constructeur
	 */
	public Ingredient(){}
	

	/**
	 * @param nom
	 */
	public Ingredient(String nom) {
		super();
		this.nom = nom;
	}


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
}
