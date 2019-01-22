package App.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import App.model.Compte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompteDAO {

	public ObservableList<Compte> trouverBonCompte(){
		
		ObservableList<Compte> lstComptes = FXCollections.observableArrayList();
		
		try {
	        Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        ResultSet result = state.executeQuery( "SELECT COMPTES.NumeroCompte, CLIENTS.NomClient, CLIENTS.PrenomClient, "
	        		+ "COMPTES.DateCreation, COMPTES.SoldeCompte, COMPTES.LimiteRetrait FROM CLIENTS, COMPTES "
	        		+ "WHERE CLIENTS.CodeClient=COMPTES.CodeClient" );
	       
	        
	        while(result.next()) {
	        	
	        	Compte unCompte = new Compte(result.getInt("NumeroCompte"), result.getString("NomClient"), result.getString("PrenomClient"), result.getDate("DateCreation"), result.getDouble("SoldeCompte"), result.getInt("LimiteRetrait"));
	        	lstComptes.add(unCompte);

	        }

		} catch (SQLException e){
			
			e.printStackTrace();
			
		}

		return lstComptes;
	
	} // Fin ==> ObservableList
	
	
	public ObservableList<Compte> nouveauCompte(){
		
		ObservableList<Compte> lstComptes = FXCollections.observableArrayList();
		
		try {
	        Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        ResultSet result = state.executeQuery( "SELECT COMPTES.NumeroCompte, CLIENTS.NomClient, CLIENTS.PrenomClient, COMPTES.DateCreation, COMPTES.SoldeCompte, COMPTES.LimiteRetrait, COMPTES.CodeClient FROM COMPTES, CLIENTS WHERE CLIENTS.CodeClient=COMPTES.CodeClient" );
	       
	        
	        while(result.next()) {
	        	
	        	Compte unCompte = new Compte(result.getInt("NumeroCompte"), result.getString("NomClient"), result.getString("PrenomClient"), result.getDate("DateCreation"), result.getDouble("SoldeCompte"), result.getInt("LimiteRetrait"), result.getInt("CodeClient"));
	        	lstComptes.add(unCompte);

	        }

		} catch (SQLException e){
			
			e.printStackTrace();
			
		}

		return lstComptes;
	
	} // Fin ==> ObservableList

	
}
