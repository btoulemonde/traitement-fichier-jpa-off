package fr.diginamic.off.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ALLERGENE")
public class Allergene  {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", length=255, nullable=true)
	private String nom;
	
	@ManyToMany
	@JoinTable(name="ID_ALLERGENE_ID_PRODUIT",
	joinColumns=@JoinColumn(name="ID_ALLERGENE", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="ID_PRODUIT", referencedColumnName="ID"))
	private List<Produit> produits= new ArrayList<Produit>();
	
	public Allergene(){}

	/**
	 * @param nom
	 */
	public Allergene(String nom) {
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
