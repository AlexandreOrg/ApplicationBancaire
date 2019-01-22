package App.view;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import App.MainApp;
import App.controller.ClientDAO;
import App.controller.CompteDAO;
import App.controller.ConnectDB;
import App.controller.OperationDAO;
import App.controller.VilleRegionDAO;
import App.model.Client;
import App.model.Compte;
import App.model.Operation;
import App.model.Ville;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class OperationsController implements Initializable{
	
//*************************************************************************
//********** Déclaration des composants de l'interface graphique **********
//*************************************************************************
	@FXML private Button btRech;
	@FXML private Button btModif;
	@FXML private Button btDelete;
	@FXML private Button btDel;
	@FXML private Button btRechClient;
	@FXML private Button btClientNew;
	@FXML private Button btCloseOk;
	@FXML private Button btCloseValide;
	@FXML private Button btCloseAjout;
	@FXML private TextField ztZoneEdit;
	@FXML private TextField ztZoneTexteMotif;
	@FXML private TextField ztNomNew;
	@FXML private TextField ztPrenomNew;
	@FXML private TextField ztAdresseNew;
	@FXML private TextField ztVilleNew;
	@FXML private TextField ztMailNew;
	@FXML private TextField ztTelNew;
	@FXML private TextField ztRechCompte;
	@FXML private TextField ztNumCompte;
	@FXML private TextField ztProprioNom;
	@FXML private TextField ztProprioPrenom;
	@FXML private TextField ztDateCrea;
	@FXML private TextField ztSoldeRestant;
	@FXML private TextField ztLimRetrait;
	@FXML private Label lblNomPrenom;
	@FXML private Label lblDateCrea;
	@FXML private Label lblSolde;
	@FXML private Label lblLimRetrait;
	@FXML private Label ztNom;
	@FXML private Label ztDateCreation;
	@FXML private Label ztVilleClient;
	@FXML private Label ztPrenom;
	@FXML private Label ztSolde;
	@FXML public TextField ztNomClient;
	@FXML private TextField ztAdrClient;
	@FXML private TextField ztVilleDuClient;
	@FXML private TextField ztNomRecup;
	@FXML private TextField ztPrenomRecup;
	@FXML private TextField ztAdresseRecup;
	@FXML private TextField ztVilleRecup;
	@FXML private TextField ztMailRecup;
	@FXML private TextField ztTelRecup;
	@FXML private TabPane tabPaneCreationClient;
	@FXML private Tab creerClient;
	@FXML private Button EffectueOperation;
	@FXML private ComboBox<String> typePaiement;
	@FXML private ComboBox<String> modePaiement;
	@FXML private TextField ztMontantOperation;
	@FXML private Button btnValidOpe;
	
	@FXML private TableView<Operation> table;
	@FXML private TableColumn<Operation, Integer> motifOpe;
	@FXML private TableColumn<Operation, Double> debitOpe;
	@FXML private TableColumn<Operation, Double> creditOpe;
	//@FXML private TableColumn<Operation, Double> montantOpe;
	@FXML private TableColumn<Operation, Date> dateOpe;
	
	@FXML private TableView<Client> tableClient;
	@FXML private TableColumn<Client, String> nomClient;
	@FXML private TableColumn<Client, String> prenomClient;
	@FXML private TableColumn<Client, String> adrClient;
	@FXML private TableColumn<Client, String> villeClient;
	@FXML private TableColumn<Client, String> mailClient;
	@FXML private TableColumn<Client, String> telClient;
	
	
//*************************************************************************
//*********************** Déclaration des variables ***********************
//*************************************************************************	
	int numeroCodeClient;
	public int numCompteUser;
	String nomCl = null;
	String villeCl = null;
	String prenomCl = null;
	double soldeCl;
	
	Date dateOperation;
	int numeroOperation;
	int numeroCompte;
	double creditOperation;
	double debitOperation;
	double montantOperation;
	
	public String nomDuClient;
	String AdrDuClient;
	String VilleDuClient;
	int codeClientSelect;
	
	public int essaiCode;
	
	String prenomDuClient;
	Date dateCreation;
	double soldeDuCompte;
	int limiteRetrait;
	
	boolean villeExiste = false;
	int idVille;
	
	public ObservableList<Operation> lstOperation = FXCollections.observableArrayList();
	public ObservableList<Client> lstOngletClient = FXCollections.observableArrayList();
	ObservableList<String> listTypeOpe = FXCollections.observableArrayList();
	ObservableList<String> listModeOpe = FXCollections.observableArrayList();
	
	public ObservableList<Operation> lstAfficherLesOperations = FXCollections.observableArrayList();
	
	
	
	
//**************************************************************************
//******************* Déclaration des Getters et Setters *******************
//**************************************************************************
	public TextField getZtZoneEdit() {
		return ztZoneEdit;
	}

	public void setZtZoneEdit(TextField ztZoneEdit) {
		this.ztZoneEdit = ztZoneEdit;
	}

	public TextField getZtZoneTexteMotif() {
		return ztZoneTexteMotif;
	}

	public void setZtZoneTexteMotif(TextField ztZoneTexteMotif) {
		this.ztZoneTexteMotif = ztZoneTexteMotif;
	}

	public ComboBox<String> getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(ComboBox<String> typePaiement) {
		this.typePaiement = typePaiement;
	}

	public ComboBox<String> getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ComboBox<String> modePaiement) {
		this.modePaiement = modePaiement;
	}

	public TextField getZtMontantOperation() {
		return ztMontantOperation;
	}

	public void setZtMontantOperation(TextField ztMontantOperation) {
		this.ztMontantOperation = ztMontantOperation;
	}
	public boolean isVilleExiste() {
		return villeExiste;
	}

	public void setVilleExiste(boolean villeExiste) {
		this.villeExiste = villeExiste;
	}


//***********************************************************
//******************* Toutes les méthodes *******************
//***********************************************************
	
//----------------------------------------- Déclaration du programme principal Main -----------------------------------------
	private MainApp mainApp;

	public MainApp getMainApp() {
		return mainApp;
	} // Fin ==> getMainApp()

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	} // Fin ==> setMainApp()
	
	
	
	
//-----------------------------------------------------------------------
//-----------------------------------------------------------------------
//-------------------------- ONGLET OPERATIONS --------------------------
//-----------------------------------------------------------------------
//-----------------------------------------------------------------------
	
// --------------------- Méthode suite à la recherche dans la zone de texte ---------------------
	public void afficherDetailsComptes() { 
		
		effacerDetailsComptes(); //Appelle la méthode qui efface le GridPane à droite
		this.zoneSaisie(); //Appelle la méthode zoneSaisie()
		
		//Récupérer les informations du compte saisi précédemment
		ClientDAO unClientDAO = new ClientDAO();
		ObservableList<Client> lesClients = unClientDAO.trouverClients();
		
		for (Client cl : lesClients)
		{
			if (cl.getNumeroCompte()==numCompteUser)
			{
				nomCl = cl.getNomClient();
				prenomCl = cl.getPrenomClient();
				villeCl = cl.getVilleClient();
				soldeCl = cl.getSoldeCompte();
			}
		}
		
		//-----------------------------------------
		//--- ECRITURE SUR LE GRIDPANE A DROITE ---
		//-----------------------------------------
    	ztNom.setText(nomCl);
    	ztVilleClient.setText(villeCl);
    	ztPrenom.setText(prenomCl);
    	//Transformation de variable double en string
    	String soldeCltString = String.valueOf(soldeCl); //Change type du solde pour l'écrire
    	ztSolde.setText(soldeCltString);

    	this.afficherOperations();
    	
		return; 
		
	} // Fin ==> afficherDetailsComptes()
	
//------------------------------------- Efface les informations du GridPane à droite -------------------------------------
	public void effacerDetailsComptes() {
		ztNom.setText("");
		ztPrenom.setText("");
		ztVilleClient.setText("");
		ztSolde.setText("");
	} // Fin ==> effacerDetailsComptes()

//------------------------------------- Affiche les détails dans le tableView -------------------------------------
	public void afficherOperations() {
		
		int ztZoneDeTexteNumeroCompte = Integer.parseInt(ztZoneEdit.getText());
		
		OperationDAO pourAfficherOperations = new OperationDAO();
		lstAfficherLesOperations = pourAfficherOperations.afficherOperations(ztZoneDeTexteNumeroCompte);
		
		motifOpe.setCellValueFactory(new PropertyValueFactory<>("motifOperation")); //Integer
		debitOpe.setCellValueFactory(new PropertyValueFactory<>("debitOperation")); //Double
		creditOpe.setCellValueFactory(new PropertyValueFactory<>("creditOperation")); //Double
		//montantOpe.setCellValueFactory(new PropertyValueFactory<>("montantOperation")); //Double
		dateOpe.setCellValueFactory(new PropertyValueFactory<>("Date")); //Date
		table.setItems(lstAfficherLesOperations);
	}

//--------------------- Récupérer le numéro de compte saisi et vérifie que ce soit un chiffre ---------------------	
	public int zoneSaisie() {
		
		//Pour vider la TableView à chaque clic sur le bouton
		for (int i = 0; i<table.getItems().size(); i++)
		{ 
			table.getItems().clear(); 
		}
	
		//Récupérer le compte saisi et le passer en entier
		numCompteUser = Integer.parseInt(ztZoneEdit.getText());

		try {
		    System.out.println("La variable est bien un chiffre !");
		} catch (NumberFormatException numCompteUser) {
			this.effacerDetailsComptes(); //Pour effacer les informations du GridPane à droite
		}
		
		return numCompteUser; //Retourne le numéro de compte saisi

	} // Fin ==> zoneSaisie()

//--------------------- Clic sur "Effectuer une opération" - Affichage d'une interface ---------------------	
	public void EffectuerOperation() {
		mainApp.showFenetrePourOperations();	
	}

//--------------------- Clic sur la comboBox FenetreOperation.fxml - Affichage des types de paiement ---------------------
	public void AfficheTypePaiement() {
		try {
			Connection connect = ConnectDB.initConnection();
			String sql = "SELECT * FROM TYPEOPERATION";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	        while (rs.next()) {
	        	listTypeOpe.add(rs.getString("type"));
	        }
	        typePaiement.setItems(listTypeOpe);
		}
		catch (SQLException e) {
			System.out.println("Erreur");
		}
	}
	
//--------------------- Clic sur la comboBox FenetreOperation.fxml - Affichage des modes de paiement ---------------------
	public void AfficheModePaiement() {
		try {
			Connection connect = ConnectDB.initConnection();
			String sql = "SELECT * FROM MODEPAIEMENT";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	        while (rs.next()) {
	        	listModeOpe.add(rs.getString("mode"));
	        }
	        modePaiement.setItems(listModeOpe);
		}
		catch (SQLException e) {
			System.out.println("Erreur");
		}
	}
	
//--------------------- Valider la saisie de la nouvelle opération (Suite EffectuerOperation()) ---------------------
	public void buttonValideNewOperation() throws ParseException {

		//Date aujourdhui = this.dateDuJour();
		Locale loc = new Locale("fr", "ca");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", loc);
		Calendar date = Calendar.getInstance();
		String dateF = df.format(date.getTime());

		Operation newOp = new Operation();
			newOp.setMontantOperation(Integer.parseInt(ztMontantOperation.getText()));
			newOp.setNumeroCompte(Integer.parseInt(ztZoneEdit.getText()));
		
		OperationDAO insertionNewOpe = new OperationDAO();
			insertionNewOpe.insertionNewOpe(newOp, modePaiement.getValue(), typePaiement.getValue(), dateF, ztZoneTexteMotif.getText());
			
		//Mettre maintenant à jour le solde du compte
		double soldePlusMoins = Double.parseDouble(ztMontantOperation.getText());
		int numDuCompte = Integer.parseInt(ztZoneEdit.getText());
		
		OperationDAO majSolde = new OperationDAO();
			majSolde.majDuSolde(soldePlusMoins, numDuCompte, typePaiement.getValue());

		//Fermer la fenetre d'opération
	    Stage stage = (Stage) btnValidOpe.getScene().getWindow();
	    stage.close();
	}

	
	

//--------------------------------------------------------------------
//--------------------------------------------------------------------
//-------------------------- ONGLET CLIENTS --------------------------
//--------------------------------------------------------------------
//--------------------------------------------------------------------

//--------------------------- Recherche des clients pour les afficher dans la TableView ---------------------------
	public void zoneRechercheClient() {
		
		tableClient.getItems().clear();
		ztNomRecup.clear();
		ztPrenomRecup.clear();
		ztAdresseRecup.clear();
		ztVilleRecup.clear();
		ztMailRecup.clear();
		ztTelRecup.clear();

		ClientDAO desClientDAO = new ClientDAO();
		ObservableList<Client> lstOngletClient = desClientDAO.trouverDesClients();

    	//On vient parcourir notre liste client
		for (int i = 0; i < lstOngletClient.size();i++) {

			//Pour trois critères de recherche :
	    	//Si on a un nom d'écrit dans la zone de texte, une ville et une adresse et qu'ils existent dans la liste
			if ((ztNomClient.getText().length()!=0) && (ztVilleDuClient.getText().length()!=0) && (ztAdrClient.getText().length()!=0) && (lstOngletClient.get(i).getNomClient().length()!=0) && (lstOngletClient.get(i).getVilleClient().length()!=0) &&  (lstOngletClient.get(i).getAdresseClient().length()!=0) && (lstOngletClient.get(i).getNomClient().contains(ztNomClient.getText()) && lstOngletClient.get(i).getVilleClient().contains(ztVilleDuClient.getText()) && lstOngletClient.get(i).getAdresseClient().contains(ztAdrClient.getText()))) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));
    		}
        	
			//Pour deux critères de recherche :
        	//Si on a un nom d'écrit dans la zone de texte et une ville et qu'ils existent dans la liste
			if ((ztNomClient.getText().length()!=0) && (ztVilleDuClient.getText().length()!=0) && (ztAdrClient.getText().length()==0) && (lstOngletClient.get(i).getNomClient().length()!=0) && (lstOngletClient.get(i).getVilleClient().length()!=0) && (lstOngletClient.get(i).getNomClient().contains(ztNomClient.getText()) && lstOngletClient.get(i).getVilleClient().contains(ztVilleDuClient.getText()))) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));
    		}
        			
        	//Si on a un nom d'écrit dans la zone de texte et une adresse et qu'ils existent dans la liste
			if ((ztNomClient.getText().length()!=0) && (ztAdrClient.getText().length()!=0) && (ztVilleDuClient.getText().length()==0) && (lstOngletClient.get(i).getNomClient().length()!=0) && (lstOngletClient.get(i).getAdresseClient().length()!=0) && (lstOngletClient.get(i).getNomClient().contains(ztNomClient.getText()) && lstOngletClient.get(i).getAdresseClient().contains(ztAdrClient.getText()))) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));
    		}
        			
        	//Si on a une ville d'écrite dans la zone de texte et une adresse et qu'elles existent dans la liste
			if ((ztVilleDuClient.getText().length()!=0) && (ztAdrClient.getText().length()!=0) && (ztNomClient.getText().length()==0) && (lstOngletClient.get(i).getAdresseClient().length()!=0) && (lstOngletClient.get(i).getVilleClient().length()!=0) && (lstOngletClient.get(i).getAdresseClient().contains(ztAdrClient.getText()) && lstOngletClient.get(i).getVilleClient().contains(ztVilleDuClient.getText()))) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));
    		}
        		
			//Pour un seul critère de recherche :
        	//Si on a un nom d'écrit dans la zone de texte et qu'il existe dans la liste
			if ((ztNomClient.getText().length()!=0) && (ztVilleDuClient.getText().length()==0) && (ztAdrClient.getText().length()==0) && (lstOngletClient.get(i).getNomClient().length()!=0) && lstOngletClient.get(i).getNomClient().contains(ztNomClient.getText())) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));
    		}
        			
        	//Si on a une ville d'écrite dans la zone de texte et qu'elle existe dans la liste
			if ((ztVilleDuClient.getText().length()!=0) && (ztNomClient.getText().length()==0) && (ztAdrClient.getText().length()==0) && (lstOngletClient.get(i).getVilleClient().length()!=0) && lstOngletClient.get(i).getVilleClient().contains(ztVilleDuClient.getText())) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));
    		}
        			
        	//Si on a une adresse d'écrite dans la zone de texte et qu'elle existe dans la liste
			if ((ztAdrClient.getText().length()!=0) && (ztVilleDuClient.getText().length()==0) && (ztNomClient.getText().length()==0) && (lstOngletClient.get(i).getAdresseClient().length()!=0) && lstOngletClient.get(i).getAdresseClient().contains(ztAdrClient.getText())) {
    			nomClient.setCellValueFactory(new PropertyValueFactory<>("NomClient")); //OperationTV, Integer
    			prenomClient.setCellValueFactory(new PropertyValueFactory<>("PrenomClient")); //OperationTV, Double
    			adrClient.setCellValueFactory(new PropertyValueFactory<>("AdresseClient")); //OperationTV, Double
    			villeClient.setCellValueFactory(new PropertyValueFactory<>("VilleClient")); //OperationTV, Double
    			tableClient.getItems().add(lstOngletClient.get(i));

    		}
        } //Fin -> For
	        		

			

		//Permet d'afficher les informations clients en appuyant sur une ligne de la TableView
		tableClient.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Client person = tableClient.getSelectionModel().getSelectedItem();

				if (person != null)
				{
					ztNomRecup.setText(person.getNomClient());
					ztPrenomRecup.setText(person.getPrenomClient());
					ztAdresseRecup.setText(person.getAdresseClient());
					ztVilleRecup.setText(person.getVilleClient());
					ztMailRecup.setText(person.getMailClient());
					ztTelRecup.setText(person.getTelClient());
					codeClientSelect = person.getCodeClient();
				}
			}
		});//Fin ==> MousePressed
		
	} //Fin ==> zoneRechercheClient
		
//--------------------------- Méthode de modification des informations client ---------------------------
	public void modificationInformations() {
		
		if(ztNomRecup.getText().isEmpty() || ztPrenomRecup.getText().isEmpty() || ztAdresseRecup.getText().isEmpty() || ztVilleRecup.getText().isEmpty() || ztMailRecup.getText().isEmpty() || ztTelRecup.getText().isEmpty())
		{
			mainApp.showErreurAjout();
		}
		else {
			ClientDAO miseAJourClient = new ClientDAO();
			miseAJourClient.miseAJourClient(ztNomRecup.getText(), ztPrenomRecup.getText(), ztAdresseRecup.getText(), ztVilleRecup.getText(), ztMailRecup.getText(), ztTelRecup.getText(), codeClientSelect);
			
	        tableClient.getItems().clear();
	        this.zoneRechercheClient();
	        
	        //Appel de la GUI modification
        	mainApp.showModifSucces();

		}
	} //Fin ==> modificationInformations

//--------------------------- Méthode d'ajout d'un nouveau client ---------------------------
	public void nouveauClient() {

		if(ztNomNew.getText().isEmpty() || ztPrenomNew.getText().isEmpty() || ztAdresseNew.getText().isEmpty() || ztVilleNew.getText().isEmpty() || ztMailNew.getText().isEmpty() || ztTelNew.getText().isEmpty())
		{
			mainApp.showErreurAjout();
		}
		else
		{
			ObservableList<Ville> lesVilles = FXCollections.observableArrayList();
			
			VilleRegionDAO toutesLesVilles = new VilleRegionDAO();
			lesVilles = toutesLesVilles.recupererLesVilles();
			
			setVilleExiste(false);
			
			for (int i=0; i<lesVilles.size(); i++)
			{
				if(ztVilleNew.getText().equals(lesVilles.get(i).getLibelleVille()))
				{
					idVille = lesVilles.get(i).getIdZoneGeo();
					setVilleExiste(true);
					break;
				}
			}
			
			if (isVilleExiste()==false) {
				mainApp.showCreationNewVille(); //Interface graphique de création d'une nouvelle ville
				//Créer la ville
				
				//Insérer le nouvel Id dans idVille
			}
			else if (isVilleExiste()) {
				ClientDAO insertionNouveauClient = new ClientDAO();
				insertionNouveauClient.insertionNouveauClient(ztNomNew.getText(), ztPrenomNew.getText(), ztAdresseNew.getText(), ztVilleNew.getText(), ztMailNew.getText(), ztTelNew.getText(), idVille);
				        
				mainApp.showValidationAjoutClient();

				ztNomNew.clear();
				ztPrenomNew.clear();
				ztAdresseNew.clear();
				ztVilleNew.clear();
				ztMailNew.clear();
				ztTelNew.clear();
			}
		}
	} //Fin ==> nouveauClient
	
//--------------------------- Méthode d'ouverture de la page d'ajout client si on passe par le RootLayout ---------------------------
	public void ongCreerClient() {
		//tabPaneCreationClient.getSelectionModel().isSelected(2);
		tabPaneCreationClient.getSelectionModel().select(creerClient);
	}
	
	
	
//--------------------------------------------------------------------
//--------------------------------------------------------------------
//-------------------------- ONGLET COMPTES --------------------------
//--------------------------------------------------------------------
//--------------------------------------------------------------------
	
//--------------------------- Méthode de recherche par numéro de compte ---------------------------
	public void rechParCompte() {
		
		CompteDAO desComptesDAO = new CompteDAO();
		ObservableList<Compte> lstComptes = desComptesDAO.trouverBonCompte();

		for (int i=0; i < lstComptes.size(); i++) {
			
			if (ztRechCompte.getText().isEmpty() || Integer.parseInt(ztRechCompte.getText())<0 || lstComptes.get(i).getNumeroCompte()!=(Integer.parseInt(ztRechCompte.getText()))) 
			{
				ztNumCompte.setText("");
				ztProprioNom.setText("");
				ztProprioPrenom.setText("");
				ztDateCrea.setText("");
				ztSoldeRestant.setText("");
				ztLimRetrait.setText("");
			}
			else if ((ztRechCompte.getText().length()!=0) && (lstComptes.get(i).getNumeroCompte()==(Integer.parseInt(ztRechCompte.getText()))))
			{
				ztNumCompte.setText(String.valueOf(lstComptes.get(i).getNumeroCompte()));
				ztProprioNom.setText(lstComptes.get(i).getNomClient());
				ztProprioPrenom.setText(lstComptes.get(i).getPrenomClient());
				ztDateCrea.setText(String.valueOf(lstComptes.get(i).getDateCreation()));
				ztSoldeRestant.setText(String.valueOf(lstComptes.get(i).getSoldeCompte()));
				ztLimRetrait.setText(String.valueOf(lstComptes.get(i).getLimiteRetrait()));
				break;
			}	
		} // Fin for
	}// Fin ==> rechParCompte
	
//--------------------------- Méthode de modification des informations d'un compte ---------------------------
	public void boutonModif() {
		ObservableList<Compte> lstModifCompte = FXCollections.observableArrayList();
		try {
	        Connection connect = ConnectDB.initConnection();
	        Statement state = connect.createStatement();
	        ResultSet result = state.executeQuery( "SELECT COMPTES.NumeroCompte, CLIENTS.NomClient, CLIENTS.PrenomClient, COMPTES.DateCreation, COMPTES.SoldeCompte, COMPTES.LimiteRetrait FROM COMPTES, CLIENTS WHERE COMPTES.CodeClient=CLIENTS.CodeClient AND COMPTES.NumeroCompte="+Integer.parseInt(ztRechCompte.getText()));
	       
	        
	        while(result.next()) {
	        	
	        	Compte modifCompte = new Compte(result.getInt("NumeroCompte"), result.getString("NomClient"), result.getString("PrenomClient"), result.getDate("DateCreation"), result.getDouble("SoldeCompte"), result.getInt("LimiteRetrait"));
	        	lstModifCompte.add(modifCompte);

	        }

		} catch (SQLException e){
			
			e.printStackTrace();
			
		}
		System.out.println("1");
		for (int i=0; i< lstModifCompte.size(); i++) {

			if ((ztRechCompte.getText().length()!=0))// && (lstModifCompte.get(i).getNumeroCompte()==(Integer.parseInt(ztRechCompte.getText()))))
			{

				if ((Integer.parseInt(ztRechCompte.getText())==(Integer.parseInt(ztNumCompte.getText()))))
				{
					//MISE A JOUR DE LA BASE DE DONNEES
					
			        try {
			        	Connection connect = ConnectDB.initConnection();
						Statement stat = connect.createStatement();
						String sql = "UPDATE COMPTES, CLIENTS SET CLIENTS.NomClient='" + ztProprioNom.getText() + "', CLIENTS.PrenomClient='" + ztProprioPrenom.getText() + "', COMPTES.DateCreation='" + ztDateCrea.getText() + "', COMPTES.SoldeCompte='" + ztSoldeRestant.getText() + "', COMPTES.LimiteRetrait='" + ztLimRetrait.getText() + "' WHERE COMPTES.CodeClient=CLIENTS.CodeClient AND COMPTES.NumeroCompte="+Integer.parseInt(ztRechCompte.getText());
				        stat.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//System.out.println(ztLimRetrait.getText());
				}
				else
				{
					//LE COMPTE EST DIFFERENT DE CELUI QUI EST RECHERCHE
					try {
						AnchorPane errorModifCompte = (AnchorPane) FXMLLoader.load(getClass().getResource("ErrorModifCompte.fxml"));
						Stage modifCompteErr = new Stage();
						modifCompteErr.setTitle("Erreur de modification");
						Scene scene = new Scene(errorModifCompte);
						modifCompteErr.setScene(scene);
						modifCompteErr.show();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
			
	}// Fin ==> boutonModif
	
//--------------------------- Méthode de création d'un nouveau compte ---------------------------
	public void boutonNouveau() {
		
		//Si un des champs est vide
		if (ztProprioNom.getText().isEmpty() || ztProprioPrenom.getText().isEmpty() || ztDateCrea.getText().isEmpty() || ztSoldeRestant.getText().isEmpty() || ztLimRetrait.getText().isEmpty()) {
			mainApp.showErreurCreationCompteChampsVides();
		}
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
			java.util.Date date = null;
			try {
				//Conversion en java.util.Date
				date = sdf.parse(ztDateCrea.getText());
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			if (ztDateCrea.getText().equals((String.valueOf(sqlDate)))) {
				//Toutes les conditions réunies, on vient créer un nouveau compte :
				
				nomDuClient = ztProprioNom.getText();
				prenomDuClient = ztProprioPrenom.getText();
				//dateCreation = date.getTime(ztDateCrea.getText());
				soldeDuCompte = Double.parseDouble(ztSoldeRestant.getText());
				limiteRetrait = Integer.parseInt(ztLimRetrait.getText());

				
				CompteDAO trouveUnClient = new CompteDAO();
				ObservableList<Compte> unSeulClient = trouveUnClient.nouveauCompte();
				for (Compte unCpt : unSeulClient)
				{
					if ((unCpt.getNomClient().contains(nomDuClient)) && (unCpt.getPrenomClient().contains(prenomDuClient)))
					{
						numeroCodeClient = unCpt.getCodeClient();
					}
				}
				

				
				try {
			        Connection connect = ConnectDB.initConnection();
			        Statement state = connect.createStatement();
			        state.execute( "INSERT INTO COMPTES(DateCreation,SoldeCompte,LimiteRetrait,CodeClient,idTypeCompte) VALUES ('" + sqlDate +"', "+ soldeDuCompte +", "+ limiteRetrait +", "+ numeroCodeClient +", " + 1 + ")");
			        
			        mainApp.showAjoutCompteValide();
			
				} catch (SQLException e){
					e.printStackTrace();
				}
			
			}
			else {
				mainApp.showErreurDateAjoutCompte();
			}
		}
	} //Fin -> boutonNouveau()
	

	
	
//---------------------------------------------------------------------
//---------------------------------------------------------------------
//-------------------------- MESSAGES ALERTE --------------------------
//---------------------------------------------------------------------
//---------------------------------------------------------------------
	
//--------------------------- Méthode de fermeture du message d'erreur par le bouton OK ---------------------------
	@FXML
	public void handleCloseOkErreur(ActionEvent event) {
	    Stage stage = (Stage) btCloseOk.getScene().getWindow();
	    stage.close();
	} //FIN ==> handleCloseOkErreur
	
	
//--------------------------- Méthode de fermeture du message de validation par le bouton OK ---------------------------
	@FXML
	public void handleCloseOkValide(ActionEvent event) {
	    Stage stage = (Stage) btCloseValide.getScene().getWindow();
	    stage.close();
	} //FIN ==> handleCloseOkValide
	
	
	
	
	
	
	
	
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
//-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
//-------------------------- CETTE PARTIE CONCERNERA LES STATISTIQUES --------------------------
//-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
	
	
	/*
	@FXML private TableView<Operation> tableStat;
	@FXML private TableColumn<Operation, Integer> nomVille;
	@FXML private TableColumn<Operation, Integer> typeCompte;
	@FXML private TableColumn<Operation, Integer> nbrType;
	public ObservableList<Operation> lstStat = FXCollections.observableArrayList();
	@FXML private ComboBox<String> barreDepartement;
	public ComboBox<String> getBarreDepartement() {
		return barreDepartement;
	}

	public void setBarreDepartement(ComboBox<String> barreDepartement) {
		this.barreDepartement = barreDepartement;
	}

	
	public ObservableList<String> lstZones = FXCollections.observableArrayList();
	public void afficherZones(){

		try {
	        Connection connect = ConnectDB.initConnection();
	        String sql = "SELECT libelleZoneGeo FROM ZONEGEO";
	        PreparedStatement stat = connect.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery(sql);
	        while(rs.next()) {
	        	
	        	lstZones.add(rs.getString("libelleZoneGeo"));
	        	
	        }

	        connect.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		for (int i=0; i<lstZones.size();i++) {
			barreDepartement.setItems(lstZones);
		}
		
	}
	
	
	int idDep;
	
	public void afficherTabStat() {
		//Récupérer la valeur de la barre de recherche
		if(barreDepartement.getValue()=="Haute-Garonne") {
			idDep = 1;
		}
		else if (barreDepartement.getValue()=="Loire") {
			idDep = 1;
		}
		else if (barreDepartement.getValue()=="Rhône") {
			idDep = 3;
		}
		
		//Appel de la fonction de remplissage du tableau
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
	        PreparedStatement stat = connect.prepareStatement(sql);
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
	
	
	
	
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
} // Fin ==> OperationsController





/* SAVE REQUETE STATISTIQUES
SELECT VILLE.libelleVille, TYPECOMPTE.libelleType, COUNT(*) as nbrType
FROM TYPECOMPTE 
LEFT JOIN TYPEZONE ON TYPECOMPTE.idTypeCompte=TYPEZONE.idTypeCompte
LEFT JOIN ZONEGEO ON TYPEZONE.idZoneGeo=ZONEGEO.idZoneGeo
LEFT JOIN VILLE ON VILLE.idZoneGeo=ZONEGEO.idZoneGeo
WHERE TYPECOMPTE.libelleType="Associatif"
GROUP BY ZONEGEO.libelleZoneGeo;


///////////////////////////////////////////////////////////////////////////
SELECT VILLE.libelleVille, TYPECOMPTE.libelleType, COUNT(*) as nbrType
FROM TYPECOMPTE 
LEFT JOIN TYPEZONE ON TYPECOMPTE.idTypeCompte=TYPEZONE.idTypeCompte
LEFT JOIN ZONEGEO ON TYPEZONE.idZoneGeo=ZONEGEO.idZoneGeo
LEFT JOIN VILLE ON VILLE.idZoneGeo=ZONEGEO.idZoneGeo
GROUP BY ZONEGEO.libelleZoneGeo, TYPECOMPTE.libelleType;




SELECT VILLE.libelleVille, TYPECOMPTE.libelleType, COUNT(*) as nbrType
FROM COMPTES 
LEFT JOIN TYPECOMPTE ON COMPTES.idTypeCompte=TYPECOMPTE.idTypeCompte
LEFT JOIN TYPEZONE ON TYPECOMPTE.idTypeCompte=TYPEZONE.idTypeCompte
LEFT JOIN ZONEGEO ON TYPEZONE.idZoneGeo=ZONEGEO.idZoneGeo
LEFT JOIN VILLE ON VILLE.idZoneGeo=ZONEGEO.idZoneGeo
WHERE VILLE.libelleVille="Toulouse"
GROUP BY VILLE.libelleVille, TYPECOMPTE.libelleType;


 */




