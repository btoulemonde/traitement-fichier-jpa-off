package fr.diginamic.off.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @author baptis
 *Classe permettant de creer la table categorie dans la base de donnée
 */
@Entity
@Table(name="CATEGORIE")
public class Categorie {
	
	/** ID généré automatiquement*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	/** nom de la catégorie de type String. Cet attribut génère une colonne dans la base de donnée*/
	@Column(name="nom", length=255, nullable=true)
	private String nom;
	
	/** Renvoi à la liste des produits concernés par une catégorie */
	@OneToMany(mappedBy ="categorie")
	private List<Produit> produits = new ArrayList<Produit>();
	
	
	/**
	 * Constructeur
	 */
	public Categorie(){}
	

	/**
	 * @param nom
	 */
	public Categorie(String nom) {
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
