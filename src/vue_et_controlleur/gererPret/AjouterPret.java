package vue_et_controlleur.gererPret;



import java.time.LocalDate;

import classMediateque.Pret;
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

public class AjouterPret extends Stage {
	String strNoPret;
	String strDateDuJour;
	String strDateRetourPreveu;
	String strDateEffectiveRetour;
	String strNoAdherent;
	String strNoDoc;
	String strAmende;
	
	
	
	TextField txtNoPret = new TextField();
	TextField txtDateDuJour = new TextField();
	TextField txtDateRetourPreveu = new TextField();
	TextField txtDateEffectiveRetour = new TextField();
	TextField txtNoAdherent = new TextField();
	TextField txtNoDoc = new TextField();
	TextField txtAmende = new TextField();
	
	public AjouterPret() {
		try {
			VBox root = createVbox();
			Scene scene = new Scene(root,400,550);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Ajouter Nouveau Prêt");
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
		
		Label lblInfo = new Label("Veuillez rentrer les informations du prêt");
		lblInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		lblInfo.setAlignment(Pos.CENTER);
		
		
		
		vBox.getChildren().addAll(lblInfo);

			vBox.getChildren().addAll(createLivreVbox());

		return vBox;
	}
	
	
	
	
	
	
	
	
	
	
	
	






	public VBox createLivreVbox(){
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
			  alert.setContentText("Êtes vous sur de vouloir vous annuler ?");
			  alert.showAndWait().ifPresent(response -> {
				     if (response == ButtonType.OK) {
				    	 this.close(); 
							
				     }
				 });
			});
		
		

		btnConfirmer.setOnAction(e ->{
			if(txtDateDuJour.getText().equals("") || txtDateRetourPreveu.getText().equals("") || txtDateEffectiveRetour.getText().equals("") ||  txtNoAdherent.getText().equals("") || txtNoDoc.getText().equals("") ){
				  Alert alert = new Alert(AlertType.ERROR);
				  alert.setTitle("Erreur");
				  alert.setHeaderText("Erreur");
				  alert.setContentText("Un des champs ci-dessus n'a pas été rempli");
				  alert.showAndWait();
			}
			
			else {
				strDateDuJour = txtDateDuJour.getText();
				strDateRetourPreveu = txtDateRetourPreveu.getText();
				strDateEffectiveRetour = txtDateEffectiveRetour.getText();
				strNoPret = txtNoPret.getText();
				strAmende = txtAmende.getText();
				strNoDoc = txtNoDoc.getText();
				 ListePret.ajouterPret(new Pret("Pret"+(ListePret.getLstPretATrouver().size()+1), strDateDuJour, strDateRetourPreveu, strDateEffectiveRetour, strNoAdherent, strNoDoc, strAmende));
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ajout");
				alert.setHeaderText("Ajout Terminé");
				alert.setContentText("Le Document " + " a été prêté avec succès");
				alert.showAndWait();
				new GérerLesPrêtes().show();
			}
		});
		
		
		hbox.getChildren().addAll(btnConfirmer,btnAnnuler);
		
		vBox.getChildren().addAll(createDateDuJourHBox(),createDateRetourPrevuHBox(),createDateEffectiveRetourHBox(),createNoAdherentHBox(),createNoDocHBox(),createAmendeHBox(),hbox);
		
		return vBox;
	}
	
	
	
	/*private HBox createNoPretHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblNoPret = new Label("No Prêt ");
		lblNoPret.setAlignment(Pos.CENTER_LEFT);
		
		txtNoPret.setAlignment(Pos.CENTER_RIGHT);
		
		hBox.getChildren().addAll(lblNoPret, txtNoPret);
		
		return hBox;
	}*/
	
	private HBox createDateDuJourHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblDateDuJour = new Label("Date du jour : ");
		LocalDate aujourdhui= LocalDate.now();
		txtDateDuJour.setText(aujourdhui.getDayOfMonth()+ "-"+ aujourdhui.getMonthValue()+"-" + aujourdhui.getYear());
		txtDateDuJour.setEditable(false);
		//System.out.println(aujourdhui.getDayOfMonth()+ "/"+ aujourdhui.getMonthValue()+"/" + aujourdhui.getYear());
		
		hBox.getChildren().addAll(lblDateDuJour, txtDateDuJour);
		
		return hBox;
	}
	
	private HBox createDateRetourPrevuHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblDateEffectiveRetour = new Label("Date de Retour Prévu : ");
		LocalDate aujourdhui= LocalDate.now();
		LocalDate pretLivre = aujourdhui.plusMonths(2);
	//	System.out.println(pretLivre.getDayOfMonth()+ "/"+ pretLivre.getMonthValue()+"/" + pretLivre.getYear());
		
		LocalDate pretPeriodique = aujourdhui.plusDays(3);
		//System.out.println(pretPeriodique.getDayOfMonth()+ "/"+ pretPeriodique.getMonthValue()+"/" + pretPeriodique.getYear());
		
		LocalDate pretDVD= aujourdhui.plusWeeks(1);
		System.out.println(pretDVD.getDayOfMonth()+ "/"+ pretDVD.getMonthValue()+"/" + pretDVD.getYear());
		
		hBox.getChildren().addAll(lblDateEffectiveRetour, txtDateEffectiveRetour);
		
		return hBox;
	}
	
	private HBox createDateEffectiveRetourHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblDateRetourPreveu = new Label(" Date de Retour effective");
		
		
		hBox.getChildren().addAll(lblDateRetourPreveu, txtDateRetourPreveu);
		
		return hBox;
	}
	
	
	private HBox createNoAdherentHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblNoAdhérent = new Label("No Adhérent ");
		
		
		hBox.getChildren().addAll(lblNoAdhérent, txtNoAdherent);
		
		return hBox;
	}
	
	
	private HBox createNoDocHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblNoDoc = new Label("No Document");
		
		
		hBox.getChildren().addAll(lblNoDoc, txtNoDoc);
		
		return hBox;
	}
	
	
	private HBox createAmendeHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblAmende = new Label("Amende");
		txtAmende.setText("0");
		txtAmende.setEditable(false);
		
		hBox.getChildren().addAll(lblAmende, txtAmende);
		
		return hBox;
	}
	
	
	
	
	
	
	
	

}



