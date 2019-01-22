package App.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import App.model.Operation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class OperationDAO implements Initializable{
	
	@FXML private TableView<Operation> table;
	@FXML private TableColumn<Operation, Integer> nomOpe;
	@FXML private TableColumn<Operation, Integer> debitOpe;
	@FXML private TableColumn<Operation, Integer> creditOpe;
	@FXML private TableColumn<Operation, Double> montantOpe;
	@FXML private TableColumn<Operation, Date> dateOpe;
	public ObservableList<Operation> lstOperation = FXCollections.observableArrayList();
	public ObservableList<String> listeType = FXCollections.observableArrayList();
	public ObservableList<Operation> lstAffichageOperation = FXCollections.observableArrayList();
	
	public ObservableList<String> getListeType() {
		return listeType;
	}

	public void setListeType(ObservableList<String> listeType) {
		this.listeType = listeType;
	}

	

	Date dateOperation;
	double numeroOperation;
	int numeroCompte;
	double debitOperation;
	double montantOperation;
	int idTyp;
	int idMod;

//--------------------- Récupérer la liste des opérations pour les afficher dans la tableView ---------------------
	public ObservableList<Operation> afficherOperations(int zoneDeTexte) {
		try {
			Connection connect = ConnectDB.initConnection();
	        //String sql = "SELECT OPERATIONS.numeroCompte, OPERATIONS.numeroOperation, OPERATIONS.debitOperation, OPERATIONS.creditOperation, OPERATIONS.montantOperation, OPERATIONS.dateOperation, OPERATIONS.idType FROM OPERATIONS, COMPTES WHERE COMPTES.NumeroCompte = OPERATIONS.NumeroCompte ORDER BY dateOperation DESC";
	        String sql = "SELECT DISTINCT OPERATIONS.numeroCompte, OPERATIONS.motifOperation, OPERATIONS.debitOperation, OPERATIONS.creditOperation, OPERATIONS.dateOperation "
	        		+ "FROM OPERATIONS, COMPTES "
	        		+ "WHERE OPERATIONS.NumeroCompte='"+ zoneDeTexte + "' ORDER BY dateOperation DESC";
	        		//+ "WHERE COMPTES.NumeroCompte = OPERATIONS.NumeroCompte ORDER BY dateOperation DESC";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	
	        while(rs.next()) {
	    		Operation uneOpe = new Operation(rs.getInt("numeroCompte"), rs.getString("motifOperation"), rs.getDouble("debitOperation"), rs.getDouble("creditOperation"), rs.getDate("dateOperation"));
	    		lstAffichageOperation.add(uneOpe);
	        }
	        //connect.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lstAffichageOperation;
	}

	
	/*
//--------------------- Récupérer les infos dans la BDD ---------------------	
	public ObservableList<Operation> trouverOperation(){

		try {
	        Connection connect = ConnectDB.initConnection();
	        String sql = "SELECT OPERATIONS.numeroCompte, OPERATIONS.numeroOperation, OPERATIONS.montantOperation, OPERATIONS.dateOperation, OPERATIONS.idTyp "
	        		+ "FROM OPERATIONS, COMPTES "
	        		+ "WHERE COMPTES.NumeroCompte = OPERATIONS.NumeroCompte";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	        while(rs.next()) {
	        	lstOperation.add(new Operation(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getDate(4),rs.getInt(5)));
	        }
	        connect.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		for (int i=0; i<lstOperation.size(); i++)
		{
			if(lstOperation.get(i).getIdTyp()==1)
			{
				//nomOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Integer>("Num Opération"));
				debitOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Integer>("Débit"));
				//creditOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Integer>("Crédit"));
				montantOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Double>("Montant"));
				dateOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Date>("Date"));
				table.setItems(lstOperation);
			}
			else if (lstOperation.get(i).getIdTyp()==2)
			{
				//nomOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Integer>("Num Opération"));
				//debitOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Integer>("Débit"));
				creditOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Integer>("Crédit"));
				montantOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Double>("Montant"));
				dateOpe.setCellValueFactory(new PropertyValueFactory<OperationTV, Date>("Date"));
				table.setItems(lstOperation);
			}
		}
		return null;
	} // Fin ==> ObservableList
*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	
	public ObservableList<String> PourAffichageTypePaiementComboBox() {
		try {
	        Connection connect = ConnectDB.initConnection();
	        String sql = "SELECT * FROM TYPEOPERATION";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	        while(rs.next()) {
	        	listeType.add(rs.getInt(1),rs.getString(2));
	        }

	        return listeType;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
//---------------------- Méthode d'insertion de la nouvelle opération ----------------------
	public void insertionNewOpe(Operation newOp, String mode, String type, String aujourdhui, String motif) {

		Connection connect = ConnectDB.initConnection();
		
		//Récupérer l'IdType
		try {
			String sql = "SELECT idType FROM typeOperation WHERE type='" + type + "'";
			PreparedStatement stat = connect.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
	        	idTyp = (rs.getInt(1));
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Récupérer l'IdMode
		try {
			String sql = "SELECT idMode FROM modePaiement WHERE mode='" + mode + "'";
			PreparedStatement stat = connect.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
	        	idMod = (rs.getInt(1));
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			if (idTyp==1) {
				String sql = "INSERT INTO OPERATIONS(motifOperation, DebitOperation, MontantOperation, DateOperation, NumeroCompte, idType, idMode) "
	        		+ "VALUES (?,?,?,?,?,?,?)";
				
				PreparedStatement stat = connect.prepareStatement(sql);
					stat.setString(1, motif);
		        	stat.setDouble(2, newOp.getMontantOperation());
		        	stat.setDouble(3, newOp.getMontantOperation());
		        	stat.setString(4, aujourdhui);
		        	stat.setInt(5, newOp.getNumeroCompte());
		        	stat.setInt(6, idTyp);
		        	stat.setInt(7, idMod);
		        	stat.execute();
			}
			else
			{
				String sql = "INSERT INTO OPERATIONS(motifOperation, CreditOperation, MontantOperation, DateOperation, NumeroCompte, idType, idMode) "
		        		+ "VALUES (?,?,?,?,?,?,?)";
				
				PreparedStatement stat = connect.prepareStatement(sql);
					stat.setString(1, motif);
		        	stat.setDouble(2, newOp.getMontantOperation());
		        	stat.setDouble(3, newOp.getMontantOperation());
		        	stat.setString(4, aujourdhui);
		        	stat.setInt(5, newOp.getNumeroCompte());
		        	stat.setInt(6, idTyp);
		        	stat.setInt(7, idMod);
		        	stat.execute();
			}   
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

//---------------------- Méthode de mise à jour du solde après une nouvelle opération ----------------------
	public void majDuSolde(double soldePlusMoins, int numDuCompte, String type) {
		
		Connection connect = ConnectDB.initConnection();
		//Requête pour récupérer l'ID du type
		try {
			String sql = "SELECT idType FROM typeOperation WHERE type='" + type + "'";
			PreparedStatement stat = connect.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
	        	idTyp = (rs.getInt(1));
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}

		if (idTyp==1) //Débit
		{
			try {
				Statement state = connect.createStatement();
				String sql = "UPDATE COMPTES SET soldeCompte=SoldeCompte-" + soldePlusMoins + " WHERE numeroCompte='" + numDuCompte + "'";
		        state.executeUpdate(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (idTyp==2) //Crédit
		{
			try {
				String sql = "UPDATE COMPTES SET soldeCompte=SoldeCompte+" + soldePlusMoins + " WHERE numeroCompte='" + numDuCompte + "'";
				PreparedStatement stat = connect.prepareStatement(sql);
				stat.executeUpdate(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
