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
	
//-------------------- Méthode pour récupérer la liste des villes --------------------
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
	
//--------------------- Méthode pour récupérer la liste des régions ---------------------
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
	
//--------------------- Méthode pour récupérer la liste des régions avec les Id's ---------------------
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
		
//--------------------- Méthode d'ajout d'une ville dans la base de données ---------------------
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
	
//--------------------- Méthode d'ajout d'une région dans la base de données ---------------------
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
