package App;


//import java.io.File;
import java.io.IOException;
//import App.controller.ConnectDB;
//import App.model.Person;
import App.view.OperationsController;
import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    
//---------- Méthode de lancement de l'application principale ----------
    @Override
    public void start(Stage primaryStage) 
	    {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Application Bancaire"); //Titre de l'application
	
	        // Code pour le logo :
	        this.primaryStage.getIcons().add(new Image("file:resources/images/banque.png"));
	   
	        //Connection connect = ConnectDB.initConnection();
	        initRootLayout();
	
	        showAppGui(); //showOperation
	    }

//---------- Initialise le fichier RootLayout - Barre des tâches en haut de l'application ----------
    public void initRootLayout() 
	    {
	        try 
		        {
		            // Charge le fichier FXML RootLayout
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
		            rootLayout = (BorderPane) loader.load();
		
		            // Met ce même fichier sur scene
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		        } 
	        catch (IOException e) 
	        	{
		            e.printStackTrace();
		        }
	    }

//---------- Affiche l'interface RootLayout avec AppGui (Principal) ----------
    public void showAppGui()
    {
    	try 
    		{
	            // Charge l'aperçu du fichier AppGui.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/AppGui.fxml"));
	            AnchorPane AppGui = (AnchorPane) loader.load();
	
	            // Mettre le fichier AppGui sur RootLayout.
	            rootLayout.setCenter(AppGui);
	            
	            // Appelle le contrôleur :
	            OperationsController controller = loader.getController();
	            controller.setMainApp(this);
        	} 
    	catch (IOException e) 
	    	{
	            e.printStackTrace();
	        }
    }
    
//---------- Affiche l'interface d'aide ----------
    public void showFenetreAideInfos()
    {
    	try {
    		
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/Aide.fxml"));
    		AnchorPane afficheAide =(AnchorPane) objetFxml.load();
    		
   			Stage newAfficheAide = new Stage();
			newAfficheAide.setTitle("Contact et information");
			Scene scene = new Scene(afficheAide);
			newAfficheAide.setScene(scene);
			newAfficheAide.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

//---------- Affiche la fenêtre pour effectuer une nouvelle opération ----------
    public void showFenetrePourOperations() {
    	try {
    		
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/FenetreOperations.fxml"));
    		AnchorPane faireOperations =(AnchorPane) objetFxml.load();
    		
   			Stage newOperation = new Stage();
   			newOperation.setTitle("Nouvelle opération");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
//---------- Interface graphique d'erreur d'ajout ou de modification d'un client ----------
    public void showErreurAjout() {
    	try {
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/ErreurAjout.fxml"));
    		AnchorPane faireOperations =(AnchorPane) objetFxml.load();
    		
   			Stage newOperation = new Stage();
   			newOperation.setTitle("Erreur d'ajout/modification");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();
			
			//ReservationController control = objetFxml.getController();
			//control.setReservation(vehicRow);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

//---------- Interface graphique d'erreur d'ajout ou de modification d'un client ----------
    public void showModifSucces() {
    	try {
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/ModifSucces.fxml"));
    		AnchorPane faireOperations =(AnchorPane) objetFxml.load();
    		
   			Stage newOperation = new Stage();
   			newOperation.setTitle("Modifications réussies");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

//---------- Interface graphique de réussite d'ajout d'un nouveau client ----------
    public void showValidationAjoutClient() {
    	try {
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/ValideAjout.fxml"));
    		AnchorPane faireOperations =(AnchorPane) objetFxml.load();
    		
   			Stage newOperation = new Stage();
   			newOperation.setTitle("Ajout effectué");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
//---------- Interface graphique de réussite d'ajout d'un nouveau client ----------
    public void showCreationNewVille() {
    	try {
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/CreerVille.fxml"));
    		AnchorPane faireOperations =(AnchorPane) objetFxml.load();
    		
   			Stage newOperation = new Stage();
   			newOperation.setTitle("Créer une nouvelle ville");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
//---------- Interface graphique d'impossibilité d'ajout d'une ville ----------
    public void showErreurAjoutVille() {
    	try {
    		FXMLLoader objetFxml = new FXMLLoader();
    		objetFxml.setLocation(MainApp.class.getResource("View/ErreurAjoutVille.fxml"));
    		AnchorPane faireOperations =(AnchorPane) objetFxml.load();
    		
   			Stage newOperation = new Stage();
   			newOperation.setTitle("Sélectionnez une région");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
//---------- Interface graphique de réussite d'ajout d'un nouveau client ----------
	public void showCreationNewRegion() {
		try {
			FXMLLoader objetFxml = new FXMLLoader();
			objetFxml.setLocation(MainApp.class.getResource("View/CreerZoneGeo.fxml"));
			AnchorPane faireOperations =(AnchorPane) objetFxml.load();
			
			Stage newOperation = new Stage();
			newOperation.setTitle("Créer une nouvelle région");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
     
//---------- Interface d'erreur lors de la création d'un nouveau compte ----------
	public void showErreurCreationCompteChampsVides() {
		try {
			FXMLLoader objetFxml = new FXMLLoader();
			objetFxml.setLocation(MainApp.class.getResource("View/champsVides.fxml"));
			AnchorPane faireOperations =(AnchorPane) objetFxml.load();
			
			Stage newOperation = new Stage();
			newOperation.setTitle("Champs Vides");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
     
//---------- Interface d'affichage de validation de l'ajout d'un compte ----------
	public void showAjoutCompteValide() {
		try {
			FXMLLoader objetFxml = new FXMLLoader();
			objetFxml.setLocation(MainApp.class.getResource("View/AjoutCompte.fxml"));
			AnchorPane faireOperations =(AnchorPane) objetFxml.load();
			
			Stage newOperation = new Stage();
			newOperation.setTitle("Compte ajouté");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
//---------- Interface d'affichage de validation de l'ajout d'un compte ----------
	public void showErreurDateAjoutCompte() {
		try {
			FXMLLoader objetFxml = new FXMLLoader();
			objetFxml.setLocation(MainApp.class.getResource("View/ErrorFormatDate.fxml"));
			AnchorPane faireOperations =(AnchorPane) objetFxml.load();
			
			Stage newOperation = new Stage();
			newOperation.setTitle("Erreur date");
			Scene scene = new Scene(faireOperations);
			newOperation.setScene(scene);
			newOperation.show();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
    
    
//Retour au primary stage
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    


}