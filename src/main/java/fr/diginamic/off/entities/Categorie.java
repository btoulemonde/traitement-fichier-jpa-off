package fr.diginamic.off.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CATEGORIE")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", length=255, nullable=true)
	private String nom;
	
	@OneToMany(mappedBy ="categorie")
	private List<Produit> produits = new ArrayList<Produit>();

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

	
	

}
