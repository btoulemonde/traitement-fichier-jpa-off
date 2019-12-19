package fr.diginamic.off.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", length=255, nullable=true)
	private String nom;
	
	@ManyToMany
	@JoinTable(name="ID_INGREDIENT_ID_PRODUIT",
	joinColumns=@JoinColumn(name="ID_INGREDIENT", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="ID_PRODUIT", referencedColumnName="ID"))
	private List<Produit> produits= new ArrayList<Produit>();

	public Ingredient(){}

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
