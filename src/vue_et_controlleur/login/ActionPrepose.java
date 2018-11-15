package vue_et_controlleur.login;



import bibliotheque.BibliothequePreposer;
import gererAdherent.GérerLesAdhérents;
import gererPret.GérerLesPrêtes;
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

public class ActionPrepose extends Stage{

	public ActionPrepose(){
		try {
			VBox root =  createVbox();
			Scene scene = new Scene(root,250,250);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("ActionPrepose");
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
			this.close(); 
			new BibliothequePreposer().show();
			});
		
		Button btnGererAdherent = new Button("Gérer les adhérents");
		btnGererAdherent.setOnAction(e-> {
			this.close(); new GérerLesAdhérents().show();
			});
		
		
		Button btnGererPret = new Button("Gérer les prêts");	
		btnGererPret.setOnAction(e-> {
			this.close(); new GérerLesPrêtes().show();
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
							Login_OLD login = new Login_OLD();
							login.start(new Stage());
				     }
				 });
			});
		
		
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().addAll(lblAction,btnBibliotheque,btnGererPret,btnGererAdherent,btnDeconnexion);
		return vbox;
	}
	
	

	
}

