package App.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import App.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





public class ClientDAO {
	

	public ObservableList<Client> trouverClients(){
		
		ObservableList<Client> lstClients = FXCollections.observableArrayList();
		
		try {
	        Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();

	        ResultSet result = state.executeQuery( "SELECT * FROM CLIENTS, COMPTES, OPERATIONS "
	        		+ "WHERE CLIENTS.CodeClient=COMPTES.CodeClient AND COMPTES.NumeroCompte = OPERATIONS.NumeroCompte" );
	        while(result.next()) {
	        	
	        	Client unClient = new Client(result.getInt("NumeroCompte"), result.getString("NomClient"), result.getString("PrenomClient"), result.getString("VilleClient"), result.getDouble("SoldeCompte"));
	        	lstClients.add(unClient);
	        	
	        }

		} catch (SQLException e){
			
			e.printStackTrace();
			
		}

		return lstClients;
	
	} // Fin ==> ObservableList
		
		
		
		
//--------------------- Récupérer les infos des clients dans la BDD - Onglets "Clients" ---------------------
		public ObservableList<Client> trouverDesClients(){
			
			ObservableList<Client> lstOngletClient = FXCollections.observableArrayList();
			
			try {
		        Connection connect = ConnectDB.initConnection();
		        Statement state = connect.createStatement();
		        ResultSet result = state.executeQuery("SELECT NomClient, PrenomClient, AdresseClient, VilleClient, MailClient, TelClient, CodeClient FROM CLIENTS" );
		        while(result.next()) {
		        	Client desClient = new Client(result.getString("NomClient"), result.getString("PrenomClient"), result.getString("AdresseClient"), result.getString("VilleClient"), result.getString("MailClient"), result.getString("TelClient"), result.getInt("CodeClient"));
		        	lstOngletClient.add(desClient);

		        }

			} catch (SQLException e){
				
				e.printStackTrace();
				
			}

			return lstOngletClient;
		
		} // Fin ==> ObservableList

//--------------------- Mettre à jour les informations des clients - Onglets "Clients" ---------------------
		public void miseAJourClient(String nom, String prenom, String adresse, String ville, String mail, String tel, int codeClient) {
			try {
				Connection connect = ConnectDB.initConnection();
		        Statement state = connect.createStatement();
		        String sql = "UPDATE CLIENTS SET NomClient='" + nom + "', PrenomClient='" + prenom + "', AdresseClient='" + adresse + "', VilleClient='" + ville + "', MailClient='" + mail + "', TelClient='" + tel + "' WHERE CodeClient=" + codeClient;
		        state.executeUpdate(sql);

			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
//--------------------- Méthode d'insertion d'un nouveau client - Onglets "Clients" ---------------------
		public void insertionNouveauClient(String nom, String prenom, String adresse, String ville, String mail, String tel, int idVille){

			try {
				Connection connect = ConnectDB.initConnection();
		        Statement state = connect.createStatement();
		        String sql = "INSERT INTO CLIENTS (NomClient, PrenomClient, AdresseClient, VilleClient, MailClient, TelClient, idVille) VALUES ('" + nom + "', '" + prenom + "', '" + adresse + "', '" + ville + "', '" + mail + "', '" + tel + "', '" + idVille + "')";
		        state.executeUpdate(sql);
			} catch (SQLException e){
				e.printStackTrace();
			}
		} // Fin ==> ObservableList
}
