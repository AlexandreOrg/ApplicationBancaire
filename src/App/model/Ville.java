package App.model;

//import java.sql.Date;

public class Ville {

	int idVille;
	String libelleVille;
	int idZoneGeo;
	
	public Ville(int idVille, String libelleVille, int idZoneGeo) {
		super();
		this.idVille = idVille;
		this.libelleVille = libelleVille;
		this.idZoneGeo = idZoneGeo;
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

	public int getIdZoneGeo() {
		return idZoneGeo;
	}

	public void setIdZoneGeo(int idZoneGeo) {
		this.idZoneGeo = idZoneGeo;
	}
	
}
