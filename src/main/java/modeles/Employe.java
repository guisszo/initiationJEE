package modeles;
import java.util.Date;
public class Employe {

	private int id;
	private String matricule;
	private String  nom;
	private String tel;
	private Date datenais;
	private int salaire;
	private Service idService = new Service();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDatenais() {
		return datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public Service getIdService() {
		return idService;
	}

	public void setIdService(Service idService) {
		this.idService = idService;
	}







}
