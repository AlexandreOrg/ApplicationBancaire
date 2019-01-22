package App.view;



import App.MainApp;
import App.controller.VilleRegionDAO;
import App.model.Region;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VilleRegionController {

	
//*************************************************************************
//********** Déclaration des composants de l'interface graphique **********
//*************************************************************************
	@FXML private TextField ztNomVille;
	@FXML private TextField ztNomRegion;
	@FXML private ComboBox<String> cbRegion;
	@FXML private Button btnNewRegion;
	@FXML private Button btnValideNewVille;
	@FXML private Button btnValideNewRegion;

	String nomNouvelleVille;
	
	
	
	public TextField getZtNomVille() {
		return ztNomVille;
	}

	public void setZtNomVille(TextField ztNomVille) {
		this.ztNomVille = ztNomVille;
	}

	public ComboBox<String> getCbRegion() {
		return cbRegion;
	}

	public void setCbRegion(ComboBox<String> cbRegion) {
		this.cbRegion = cbRegion;
	}

	public Button getBtnNewRegion() {
		return btnNewRegion;
	}

	public void setBtnNewRegion(Button btnNewRegion) {
		this.btnNewRegion = btnNewRegion;
	}

	public Button getBtnValideNewVille() {
		return btnValideNewVille;
	}

	public void setBtnValideNewVille(Button btnValideNewVille) {
		this.btnValideNewVille = btnValideNewVille;
	}

	public String getNomNouvelleVille() {
		return nomNouvelleVille;
	}

	public void setNomNouvelleVille(String nomNouvelleVille) {
		this.nomNouvelleVille = nomNouvelleVille;
	}



	public ObservableList<String> getLstDesRegions() {
		return lstDesRegions;
	}

	public void setLstDesRegions(ObservableList<String> lstDesRegions) {
		this.lstDesRegions = lstDesRegions;
	}



	ObservableList<String> lstDesRegions = FXCollections.observableArrayList();
	int idDeLaZoneGeo;
	
	public int getIdDeLaZoneGeo() {
		return idDeLaZoneGeo;
	}

	public void setIdDeLaZoneGeo(int idDeLaZoneGeo) {
		this.idDeLaZoneGeo = idDeLaZoneGeo;
	}
	
	

//----------------------- Méthode d'affichage des régions sur la comboBox -----------------------
	public void affichageDesRegionsSurComboBox() {
		VilleRegionDAO afficherLesRegions = new VilleRegionDAO();
		lstDesRegions = afficherLesRegions.afficherComboBoxRegion();

		cbRegion.setItems(lstDesRegions);
	}

//----------------------- Méthode de validation de création de la ville - Bouton "Valider" -----------------------
	public void boutonValidationCreationVille() {
		
		ObservableList<Region> laListeDesRegions = FXCollections.observableArrayList();
		
		VilleRegionDAO listeDesRegions = new VilleRegionDAO();
		laListeDesRegions = listeDesRegions.listeDesRegions();
		
		//Récupérer l'Id de la zone géo
		if(cbRegion.getValue()!=null)
		{
			
			for(int i=0; i<laListeDesRegions.size(); i++) {
				if (cbRegion.getValue().equals(laListeDesRegions.get(i).getLibelleZoneGeo())){
					setIdDeLaZoneGeo(laListeDesRegions.get(i).getIdZoneGeo());
					break;
				}
			}
			
			if (getIdDeLaZoneGeo()!=0) {
				VilleRegionDAO ajoutDuneVilleBDD = new VilleRegionDAO();
				ajoutDuneVilleBDD.ajoutDeLaVille(ztNomVille.getText(), getIdDeLaZoneGeo());
				
				//Fermer la fenetre d'opération
			    Stage stage = (Stage) btnValideNewVille.getScene().getWindow();
			    stage.close();
			}
			
			
		}else {
			//Interface erreur : il faut sélectionner une region
			MainApp afficheErreurAjoutVille = new MainApp();
			afficheErreurAjoutVille.showErreurAjoutVille();
		}
			
		
		

	}

//----------------------- Méthode d'ouverture de la page de création d'une zone géographique -----------------------
	public void boutonOuverturePageCreationZoneGeo() {
		MainApp afficheInterfaceNewZoneGeo = new MainApp();
		afficheInterfaceNewZoneGeo.showCreationNewRegion();
	}

//----------------------- Méthode de validation de création dela région - Bouton "Valider" -----------------------
	public void boutonValidationCreationZoneGeo() {
		//Insertion de la région dans la base de données
		VilleRegionDAO nouvelleRegion = new VilleRegionDAO();
		nouvelleRegion.ajoutDeLaRegion(ztNomRegion.getText());
		
		//Fermer la fenetre d'opération
	    Stage stage = (Stage) btnValideNewRegion.getScene().getWindow();
	    stage.close();
	}
	
	
	
	
} //FIN -> Classe RootLayout
