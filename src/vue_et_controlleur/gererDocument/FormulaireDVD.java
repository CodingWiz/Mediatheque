package vue_et_controlleur.gererDocument;



import bibliotheque.BibliothequePreposer;
import classMediateque.DVD;
import classMediateque.Document;
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

public class FormulaireDVD extends Stage{
	TextField txtTitre = new TextField();
	TextField txtDatePublication = new TextField();
	TextField txtMotsCles = new TextField();
	TextField txtRealisateur = new TextField();
	TextField txtNbDisque = new TextField();
	
	
	
	
	String strTitre;
	String strDatePublication;
	String strMotsCles;
	String strRealisateur;
	String strNbDisque;
	public FormulaireDVD() {
		try {
			VBox root = createVbox();
			Scene scene = new Scene(root,400,450);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Ajouter Nouveau DVD");
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
		
		Label lblInfo = new Label("Veuillez rentrer les informations du DVD");
		lblInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		lblInfo.setAlignment(Pos.CENTER);
		
		vBox.getChildren().addAll(lblInfo);

			vBox.getChildren().add(createDVDVbox());

		return vBox;
	}
	
	
	
	
	
	
	
	
	
	public VBox createDVDVbox(){
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
			if(txtDatePublication.getText().equals("") || txtMotsCles.getText().equals("") || txtNbDisque.getText().equals("") || txtRealisateur.getText().equals("") || txtTitre.getText().equals("") ){
				  Alert alert = new Alert(AlertType.ERROR);
				  alert.setTitle("Erreur");
				  alert.setHeaderText("Erreur");
				  alert.setContentText("Un des champs ci-dessus n'a pas été rempli");
				  alert.showAndWait();
			}
			
			else {
				strDatePublication = txtDatePublication.getText();
				strMotsCles = txtMotsCles.getText();
				strRealisateur = txtRealisateur.getText();
				strTitre = txtTitre.getText();
				strNbDisque = txtNbDisque.getText();
				
				ListeDVD.ajouterDVD(new DVD("DVD"+(ListeDVD.lstDVDATrouver.size()+1), strTitre, strDatePublication, "Disponible", strMotsCles, strNbDisque, strRealisateur));
				ListDocument.ajouterDocument(new Document("DVD"+(ListeDVD.lstDVDATrouver.size()), strTitre, strDatePublication, "Disponible", strMotsCles));
				 Alert alert = new Alert(AlertType.INFORMATION);
				  alert.setTitle("Ajout");
				  alert.setHeaderText("Ajout Terminé");
				  alert.setContentText("Le DVD " + strTitre + " a été ajouté avec succès");
				  alert.showAndWait();
				 new BibliothequePreposer().show();
				  /*for (int i=0; i<ListeDVD.getLstDVDATrouver().size();i++)
				  {
				 System.out.println(ListeDVD.getLstDVDATrouver() + "\n");
				  }*/
				 
			}
		});
		hbox.getChildren().addAll(btnConfirmer,btnAnnuler);
		vBox.getChildren().addAll(createTitreHBox(),createDatePublicationHBox(),createNbDisqueHBox(), createRealisateurHBox(), createMotsClesHBox(),hbox);
		
		return vBox;
	}
	
	public String getStrTitre() {
		return strTitre;
	}



	public void setStrTitre(String strTitre) {
		this.strTitre = strTitre;
	}



	public String getStrDatePublication() {
		return strDatePublication;
	}



	public void setStrDatePublication(String strDatePublication) {
		this.strDatePublication = strDatePublication;
	}



	public String getStrMotsCles() {
		return strMotsCles;
	}



	public void setStrMotsCles(String strMotsCles) {
		this.strMotsCles = strMotsCles;
	}



	public String getStrRealisateur() {
		return strRealisateur;
	}



	public void setStrRealisateur(String strRealisateur) {
		this.strRealisateur = strRealisateur;
	}



	public String getStrNbDisque() {
		return strNbDisque;
	}



	public void setStrNbDisque(String strNbDisque) {
		this.strNbDisque = strNbDisque;
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
	
	
	
	private HBox createNbDisqueHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblNbDisque = new Label("Nombres des disques : ");
		
		
		hBox.getChildren().addAll(lblNbDisque, txtNbDisque);
		
		return hBox;
	}
	
	private HBox createRealisateurHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
		Label lblRealisateur = new Label("Réalisateur : ");
		
		
		hBox.getChildren().addAll(lblRealisateur, txtRealisateur);
		
		return hBox;
	}
	
	
	
	
	
	
	
	
	
	

}

