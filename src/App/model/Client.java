package App.model;

//import java.sql.Date;

public class Client {

	int NumeroCompte;
	String PrenomClient;
	String NomClient;
	String VilleClient;
	double SoldeCompte;
	String AdresseClient;
	String MailClient;
	String TelClient;
	int CodeClient;
	
	public Client() {
		super();
	}
	
	public Client(String nomClient, String prenomClient, String adresseClient, String villeClient, String mailClient,
			String telClient, int codeClient) {
		super();
		this.NomClient = nomClient;
		this.PrenomClient = prenomClient;
		this.AdresseClient = adresseClient;
		this.VilleClient = villeClient;
		this.MailClient = mailClient;
		this.TelClient = telClient;
		this.CodeClient = codeClient;
	}



	public Client(int numeroCompte, String nomClient, String prenomClient, String villeClient, double soldeCompte) {
		super();
		NumeroCompte = numeroCompte;
		PrenomClient = prenomClient;
		NomClient = nomClient;
		VilleClient = villeClient;
		SoldeCompte = soldeCompte;
	}

	public int getNumeroCompte() {
		return NumeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		NumeroCompte = numeroCompte;
	}

	public String getPrenomClient() {
		return PrenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}

	public String getNomClient() {
		return NomClient;
	}

	public void setNomClient(String nomClient) {
		NomClient = nomClient;
	}

	public String getVilleClient() {
		return VilleClient;
	}

	public void setVilleClient(String villeClient) {
		VilleClient = villeClient;
	}

	public double getSoldeCompte() {
		return SoldeCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		SoldeCompte = soldeCompte;
	}

	public String getAdresseClient() {
		return AdresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.AdresseClient = adresseClient;
	}

	public String getMailClient() {
		return MailClient;
	}

	public void setMailClient(String mailClient) {
		MailClient = mailClient;
	}

	public String getTelClient() {
		return TelClient;
	}

	public void setTelClient(String telClient) {
		TelClient = telClient;
	}

	public int getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}
	
		
}
