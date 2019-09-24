package modeles;

import java.util.ArrayList;
import java.util.List;

public class Service {
	private int id;
	private String libelle;

	public List<Employe> getEmployes() {
		return Employes;
	}

	public void setEmployes(Employe e) {
		List<Employe> Employes = new ArrayList<Employe>();
		Employes.add(e);
		this.Employes = Employes;
	}

	private List<Employe> Employes = new ArrayList<Employe>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
