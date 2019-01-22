package App.model;

import java.sql.Date;


public class Compte {

	public int numeroCompte;
	public String nomClient;
	public String prenomClient;
	public Date dateCreation;
	public double soldeCompte;
	public int limiteRetrait;
	public int codeClient;

	public Compte() {
		super();
	}
	
	public Compte(int numeroCompte, String nomClient, String prenomClient, Date dateCreation, double soldeCompte,
			int limiteRetrait, int codeClient) {
		//super();
		this.numeroCompte = numeroCompte;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateCreation = dateCreation;
		this.soldeCompte = soldeCompte;
		this.limiteRetrait = limiteRetrait;
		this.codeClient = codeClient;
	}


	public Compte(int numeroCompte, String nomClient, String prenomClient, Date dateCreation, double soldeCompte,
			int limiteRetrait) {
		//super();
		this.numeroCompte = numeroCompte;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateCreation = dateCreation;
		this.soldeCompte = soldeCompte;
		this.limiteRetrait = limiteRetrait;
	}
	
	public Compte(int codeClient) {
		this.codeClient = codeClient;
	}
	
	public Compte(int numeroCompte, int limiteRetrait) {
		super();
		this.numeroCompte = numeroCompte;
		this.limiteRetrait = limiteRetrait;
	}
	
	public int getCodeClientInt() {
		return codeClient;
	}
	
	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	public int getLimiteRetrait() {
		return limiteRetrait;
	}
	public void setLimiteRetrait(int limiteRetrait) {
		this.limiteRetrait = limiteRetrait;
	}
	
	
	
	
	
	
}
