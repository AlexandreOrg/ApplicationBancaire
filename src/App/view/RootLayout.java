package App.view;



import App.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RootLayout {

	
//*************************************************************************
//********** Déclaration des composants de l'interface graphique **********
//*************************************************************************
	@FXML private Button Delete;
	@FXML private Button fermerFenetreAide;
	


	
//--------------------------------------------------------------------
//--------------------------------------------------------------------
//-------------------------- ONGLET FICHIER --------------------------
//--------------------------------------------------------------------
//--------------------------------------------------------------------
	
//----------------------- Création d'un nouveau client -----------------
	public void creerNewClient() {
		//Activer l'onglet "Nouveau client"
		OperationsController activeCreationClient = new OperationsController();
		activeCreationClient.ongCreerClient();
	}

//----------------------- Quitter l'application -----------------
	public void quitProgramme() {
		System.exit(0);
	}

//----------------------- Affiche les information de la personne à contacter -----------------
	public void afficherFenetreAide() {
		MainApp main = new MainApp();
		main.showFenetreAideInfos();
	}

	
	
	
//-----------------------------------------------------------------
//-----------------------------------------------------------------
//-------------------------- ONGLET AIDE --------------------------
//-----------------------------------------------------------------
//-----------------------------------------------------------------
	
//----------------------- Méthode de fermeture du message d'aide par le bouton OK -----------------------
	@FXML
	public void handleCloseOkAide(ActionEvent event) {
	    Stage stage = (Stage) fermerFenetreAide.getScene().getWindow();
	    stage.close();
	} //FIN ==> handleCloseOkErreur
	
	

	
} //FIN -> Classe RootLayout
