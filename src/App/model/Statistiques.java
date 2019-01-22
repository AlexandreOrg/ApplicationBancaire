package App.model;

public class Statistiques {

	
	private int idTypeCompte;
	private String libelleType;
	private int idZoneGeo;
	private String libelleZoneGeo;
	private int idVille;
	private String libelleVille;
	
	private int pourCount;
	
	public Statistiques() {
		super();
	}
	
	
	public Statistiques(String libelleVille, int idTypeCompte, int pourCount) {
		super();
		this.libelleVille = libelleVille;
		this.idTypeCompte = idTypeCompte;
		this.pourCount = pourCount;
	}


	public Statistiques(int idTypeCompte, int idVille, String libelleVille) {
		super();
		this.idTypeCompte = idTypeCompte;
		this.idVille = idVille;
		this.libelleVille = libelleVille;
	}




	public Statistiques(String libelleZoneGeo) {
		super();
		this.libelleZoneGeo = libelleZoneGeo;
	}



	public Statistiques(int idTypeCompte, String libelleType, int idZoneGeo, String libelleZoneGeo, int idVille,
			String libelleVille) {
		super();
		this.idTypeCompte = idTypeCompte;
		this.libelleType = libelleType;
		this.idZoneGeo = idZoneGeo;
		this.libelleZoneGeo = libelleZoneGeo;
		this.idVille = idVille;
		this.libelleVille = libelleVille;
	}

	
	public int getPourCount() {
		return pourCount;
	}




	public void setPourCount(int pourCount) {
		this.pourCount = pourCount;
	}
	public int getIdTypeCompte() {
		return idTypeCompte;
	}

	public void setIdTypeCompte(int idTypeCompte) {
		this.idTypeCompte = idTypeCompte;
	}

	public String getLibelleType() {
		return libelleType;
	}

	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}

	public int getIdZoneGeo() {
		return idZoneGeo;
	}

	public void setIdZoneGeo(int idZoneGeo) {
		this.idZoneGeo = idZoneGeo;
	}

	public String getLibelleZoneGeo() {
		return libelleZoneGeo;
	}

	public void setLibelleZoneGeo(String libelleZoneGeo) {
		this.libelleZoneGeo = libelleZoneGeo;
	}

	public int getIdVille() {
		return idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getLibelleVille() {
		return libelleVille;
	}

	public void setLibelleVille(String libelleVille) {
		this.libelleVille = libelleVille;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
