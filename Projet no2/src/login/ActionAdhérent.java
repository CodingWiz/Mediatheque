package login;


import Compte.CompteAdherent;
import bibliotheque.BibliothequeAdherant;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ActionAdhérent extends Stage{

	public ActionAdhérent(){
		try {
			VBox root =  createVbox();
			Scene scene = new Scene(root,200,200);
			this.setScene(scene);
			this.setTitle("ActionPrepose");
			this.sizeToScene();
			this.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	public VBox createVbox(){
		Font font =  Font.font("Harlow Solid Italic",FontWeight.EXTRA_BOLD,50);
		VBox  vbox = new VBox();
		Label lblAction = new Label("Action");
		lblAction.setFont(font);
		Button btnBibliotheque = new Button("Bibliothèque");
		
		btnBibliotheque.setOnAction(e-> {
			this.close(); new BibliothequeAdherant().show();
			});
		
		Button btnCompte = new Button("Compte");
		btnCompte.setOnAction(e-> {
			this.close(); 
			new CompteAdherent().show();
			});
		Button btnDeconnexion = new Button("Déconnexion");
		btnDeconnexion.setOnAction(e-> {
			  Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.setTitle("Confirmation");
			  alert.setHeaderText("Confirmation");
			  alert.setContentText("Êtes vous sur de vouloir vous déconnecter");
			  alert.showAndWait().ifPresent(response -> {
				     if (response == ButtonType.OK) {
				    	 this.close(); 
							LoginIn login = new LoginIn();
							login.start(new Stage());
				     }
				 });
			});
		
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(10);
		
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().addAll(lblAction,btnBibliotheque,btnCompte,btnDeconnexion);
		return vbox;
	}
	
	

	
}

