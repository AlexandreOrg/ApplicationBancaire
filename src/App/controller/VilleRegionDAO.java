package App.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import App.model.Region;
import App.model.Ville;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





public class VilleRegionDAO {

	ObservableList<String> lstDesRegions = FXCollections.observableArrayList();
	
//-------------------- M�thode pour r�cup�rer la liste des villes --------------------
	public ObservableList<Ville> recupererLesVilles(){
		
		ObservableList<Ville> lstDesVilles = FXCollections.observableArrayList();
		
		try {
			Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        ResultSet result = state.executeQuery("SELECT * FROM ville" );
	        while(result.next()) {
	        	Ville lesVilles = new Ville(result.getInt("idVille"), result.getString("libelleVille"), result.getInt("idZoneGeo"));
	        	lstDesVilles.add(lesVilles);
	        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lstDesVilles;
	}
	
//--------------------- M�thode pour r�cup�rer la liste des r�gions ---------------------
	public ObservableList<String> afficherComboBoxRegion() {
		
		try {
			Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        ResultSet result = state.executeQuery("SELECT * FROM zonegeo" );
	        while(result.next()) {
	        	lstDesRegions.add(result.getString("libelleZoneGeo"));
	        }
	        
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lstDesRegions;
	}
	
//--------------------- M�thode pour r�cup�rer la liste des r�gions avec les Id's ---------------------
		public ObservableList<Region> listeDesRegions() {
			
			ObservableList<Region> listeRegionAvecId = FXCollections.observableArrayList();
			
			try {
				Connection connect = ConnectDB.initConnection();
		        Statement state = connect.createStatement();
		        ResultSet result = state.executeQuery("SELECT * FROM zonegeo" );
		        while(result.next()) {
		        	Region lesRegions = new Region(result.getInt("idZoneGeo"), result.getString("libelleZoneGeo"));
		        	listeRegionAvecId.add(lesRegions);
		        }
		        
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return listeRegionAvecId;
		}
		
//--------------------- M�thode d'ajout d'une ville dans la base de donn�es ---------------------
	public void ajoutDeLaVille(String ville, int idZoneGeo) {
		
		try {
			Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        String sql = "INSERT INTO VILLE (libelleVille, idZoneGeo) VALUES ('" + ville + "', '" + idZoneGeo + "')";
	        state.executeUpdate(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}	
		
	}
	
//--------------------- M�thode d'ajout d'une r�gion dans la base de donn�es ---------------------
	public void ajoutDeLaRegion(String zoneGeo) {
		
		try {
			Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        String sql = "INSERT INTO ZONEGEO (libelleZoneGeo) VALUES ('" + zoneGeo + "')";
	        state.executeUpdate(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}	
		
	}
		
	
}
