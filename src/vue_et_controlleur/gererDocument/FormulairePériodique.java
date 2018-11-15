package vue_et_controlleur.gererDocument;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import bibliotheque.BibliothequePreposer;
import classMediateque.Document;
import classMediateque.Periodique;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FormulairePériodique extends Stage {

	String strTitre;
	String strDatePublication;
	String strMotsCles;
	String strNoVolume;
	String strNoPeriodique;
	
	TextField txtNoPeriodique = new TextField();
	TextField txtNoVolume = new TextField();
	TextField txtMotsCles = new TextField();
	TextField txtDatePublication = new TextField();
	TextField txtTitre = new TextField();
	
	
	public FormulairePériodique() {
		try {
			VBox root = createVbox();
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Ajouter Nouveau Périodique");
			this.sizeToScene();
			
			this.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public VBox createVbox(){
		
		VBox  vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		
		Label lblInfo = new Label("Veuillez rentrer les informations du périodique");
		lblInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		lblInfo.setAlignment(Pos.CENTER);
		
		vBox.getChildren().addAll(lblInfo);

			vBox.getChildren().add(createPeriodiqueVbox());

		return vBox;
	}
	
	
	
	
	
	
	
	
	
	
	public VBox createPeriodiqueVbox(){
		VBox  vBox = new VBox();
		vBox.setSpacing(10);
		
		HBox hbox = new HBox();
		Button btnConfirmer = new Button("Confirmer");
		Button btnAnnuler = new Button("Annuler");
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(30));
		btnConfirmer.setFont(new Font(20));
		btnAnnuler.setFont(new Font(20));
		
		btnAnnuler.setOnAction(e-> {
			  Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.setTitle("Confirmation");
			  alert.setHeaderText("Confirmation");
			  alert.setContentText("Êtes vous sur de vouloir vous annuler l'ajout ?");
			  alert.showAndWait().ifPresent(response -> {
				     if (response == ButtonType.OK) {
				    	 this.close(); 
							new BibliothequePreposer().show();
				     }
				 });
			});
		
		
		btnConfirmer.setOnAction(e ->{
			if(txtDatePublication.getText().equals("") || txtNoPeriodique.getText().equals("") || txtMotsCles.getText().equals("") || txtTitre.getText().equals("") || txtNoVolume.getText().equals("") ){
				  Alert alert = new Alert(AlertType.ERROR);
				  alert.setTitle("Erreur");
				  alert.setHeaderText("Erreur");
				  alert.setContentText("Un des champs ci-dessus n'a pas été rempli");
				  alert.showAndWait();
			}
			
			else {
				strDatePublication = txtDatePublication.getText();
				strMotsCles = txtMotsCles.getText();
				strNoPeriodique = txtNoPeriodique.getText();
				strNoVolume = txtNoVolume.getText();
				strTitre = txtTitre.getText();
			ListePeriodique.ajouterPeriodique(new Periodique("Per"+(ListePeriodique.getLstPeriodiqueATrouver().size()+1), strTitre, strDatePublication, "Disponible", strMotsCles, strNoVolume, strNoPeriodique));
			ListDocument.ajouterDocument(new Document("Per"+(ListePeriodique.getLstPeriodiqueATrouver().size()), strTitre, strDatePublication, "Disponible", strMotsCles));
			 Alert alert = new Alert(AlertType.INFORMATION);
			  alert.setTitle("Ajout");
			  alert.setHeaderText("Ajout Terminé");
			  alert.setContentText("Le périodique " + strTitre + " a été ajouté avec succès");
			  alert.showAndWait();
			 new BibliothequePreposer().show();
			}
		});
		
		
		
		
		hbox.getChildren().addAll(btnConfirmer,btnAnnuler);
		
		vBox.getChildren().addAll(createTitreHBox(),createDatePublicationHBox(),createNoVolumeHBox(), createNoPeriodiqueHBox(), createMotsClesHBox(),hbox);
		
		return vBox;
	}
	
	
	
	public String getStrTitre() {
		return strTitre;
	}



	public String getStrDatePublication() {
		return strDatePublication;
	}



	public String getStrMotsCles() {
		return strMotsCles;
	}



	public String getStrNoVolume() {
		return strNoVolume;
	}



	public String getStrNoPeriodique() {
		return strNoPeriodique;
	}



	private HBox createTitreHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblTitre = new Label("Titre : ");
		lblTitre.setAlignment(Pos.CENTER_LEFT);
		
		txtTitre.setAlignment(Pos.CENTER_RIGHT);
		
		hBox.getChildren().addAll(lblTitre, txtTitre);
		
		return hBox;
	}
	
	private HBox createDatePublicationHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblDatePublication = new Label("Date de publication : ");
		
		
		hBox.getChildren().addAll(lblDatePublication, txtDatePublication);
		
		return hBox;
	}
	
	
	
	private HBox createMotsClesHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblMotsCles = new Label("Mots clés (séparés par espaces) : ");
		
		
		hBox.getChildren().addAll(lblMotsCles, txtMotsCles);
		
		return hBox;
	}
	
	private HBox createNoVolumeHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblNoVolume = new Label("Numero du volume : ");
		
		
		hBox.getChildren().addAll(lblNoVolume, txtNoVolume);
		
		return hBox;
	}
	
	private HBox createNoPeriodiqueHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblNoPeriodique = new Label("Numero du périodique : ");
		
		
		hBox.getChildren().addAll(lblNoPeriodique, txtNoPeriodique);
		
		return hBox;
	}
	
	
	
	
	public void lectureFichierPeriodique(String strNomFichier){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strNomFichier))) {
			bw.write(strMotsCles + "," + strTitre + "," + strDatePublication + "," );	
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	

}


