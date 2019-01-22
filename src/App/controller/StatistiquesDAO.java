/*package App.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import App.model.Operation;
import App.model.OperationTV;
import App.model.Statistiques;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StatistiquesDAO {

	@FXML private TableView<Operation> tableStat;
	@FXML private TableColumn<Operation, Integer> nomVille;
	@FXML private TableColumn<Operation, Integer> typeCompte;
	@FXML private TableColumn<Operation, Integer> nbrType;
	public ObservableList<String> lstZones = FXCollections.observableArrayList();
	
	@FXML ComboBox<String> barreDepartement;
	
	
	public void afficherLesDepartements() {
		try {
	        Connection connect = ConnectDB.initConnection();
	        String sql = "SELECT libelleZoneGeo FROM ZONEGEO";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	        while(rs.next()) {
	        	
	        	lstZones.add(rs.getString("libelleZoneGeo"));
	        	System.out.println(lstZones);
	        	
	        }
	        System.out.println("OKay");
	        connect.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(lstZones);
		System.out.println("Avant barre");
		for (int i=0; i<lstZones.size();i++) {
			barreDepartement.setItems(lstZones);
		}
		
		System.out.println("...");
		
	}

	public ObservableList<Statistiques> remplirTabStat(int idDep) {
		
			ObservableList<Statistiques> remplirLaTabStat = FXCollections.observableArrayList();
			
			try {
		        Connection connect = ConnectDB.initConnection();
		        String sql = "SELECT VILLE.libelleVille, TYPECOMPTE.libelleType, COUNT(*) as nbrType " + 
		        		"FROM COMPTES " + 
		        		"LEFT JOIN TYPECOMPTE ON COMPTES.idTypeCompte=TYPECOMPTE.idTypeCompte " + 
		        		"LEFT JOIN TYPEZONE ON TYPECOMPTE.idTypeCompte=TYPEZONE.idTypeCompte " + 
		        		"LEFT JOIN ZONEGEO ON TYPEZONE.idZoneGeo=ZONEGEO.idZoneGeo " + 
		        		"LEFT JOIN VILLE ON VILLE.idZoneGeo=ZONEGEO.idZoneGeo " + 
		        		"GROUP BY VILLE.libelleVille, TYPECOMPTE.libelleType;";
		        PreparedStatement stat = connect.prepareStateme
		        nt(sql);
		        ResultSet rs = stat.executeQuery(sql);

		        while(rs.next()) {
		        	remplirLaTabStat.add(new Statistiques(rs.getString(1),rs.getString(2),rs.getInt(3)));
		        }
		        connect.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			for (int i=0; i<remplirLaTabStat.size(); i++)
			{
				nomVille.setCellValueFactory(new PropertyValueFactory<Statistiques, String>("Ville"));
				typeCompte.setCellValueFactory(new PropertyValueFactory<Statistiques, String>("Type de compte"));
				nbrType.setCellValueFactory(new PropertyValueFactory<Statistiques, Integer>("Nombre"));
				tableStat.setItems(remplirLaTabStat);

			}
			return null;
	}


	
	
	
	
	
	
	
	
}*/
