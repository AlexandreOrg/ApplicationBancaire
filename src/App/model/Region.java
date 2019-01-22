package App.model;

//import java.sql.Date;

public class Region {

	int idZoneGeo;
	String libelleZoneGeo;
	
	public Region(int idZoneGeo, String libelleZoneGeo) {
		super();
		this.idZoneGeo = idZoneGeo;
		this.libelleZoneGeo = libelleZoneGeo;
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
	
}
