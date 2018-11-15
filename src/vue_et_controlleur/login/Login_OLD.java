package vue_et_controlleur.login;
	
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import serialisationEtdeserialisation.FirstSerializerDocument;
import serialisationEtdeserialisation.LectureDesFichiers;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Login_OLD extends Application {
	

	
	@Override
	public void start(Stage primaryStage) {
		try {
		LectureDesFichiers.LireFichierAdhérant("Adhérent.txt");
		LectureDesFichiers.LireFichierDVD("DVD.txt");
		LectureDesFichiers.LireFichierLivres("Livres.txt");
		LectureDesFichiers.LireFichierPeriodique("Periodiques.txt");
		LectureDesFichiers.LireFichierPrepose("Preposé.txt");
		
			File fichier = new File("DVD.ser");
			
			if(!fichier.exists()){
				FirstSerializerDocument.getInstance();
			}
				
			BorderPane root = createBorderPane(primaryStage);
			Scene scene = new Scene(root,500,270);
		
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.show(); 

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public VBox createVbox(Stage primaryStage){
		VBox vbox = new VBox();
		Text textDeBienvenue = new Text("Médiathèque");
		Font font =  Font.font("Harlow Solid Italic",FontWeight.EXTRA_BOLD,50);
		
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(10);
		
		Label lblNoCompte = new Label("No de Compte :");
		TextField tbNoCompte = new TextField();
		HBox hbox1 = new HBox();
		
		hbox1.setPadding(new Insets(10));
		hbox1.setSpacing(10);
		 
		hbox1.getChildren().addAll(lblNoCompte,tbNoCompte);
		Label lblPassword = new Label("Mot de passe :");
		lblNoCompte.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,15));
		lblPassword.setFont(Font.font("Lucida Calligraphy",FontWeight.BOLD,15));
		TextField tbPassword = new TextField();
		
		HBox hbox2 = new HBox();
		
		hbox2.setPadding(new Insets(10));
		hbox2.setSpacing(10);
		
		hbox2.getChildren().addAll(lblPassword,tbPassword);
		
		textDeBienvenue.setFont(font);
		
		HBox hbox3 = new HBox();
		Text txtMessage = new Text("Je suis un ");
		RadioButton rbPrepose = new RadioButton("Préposé");
		RadioButton rbAdherant = new RadioButton("Adhérant");
		
		Button btnQuitter = new Button("Quitter");
		
		btnQuitter.setOnAction(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.setTitle("Confirmation");
			  alert.setHeaderText("Confirmation");
			  alert.setContentText("Êtes vous sur de vouloir quitter l'application");
			  alert.showAndWait().ifPresent(response -> {
				     if (response == ButtonType.OK) {
				    System.exit(0);
							Login_OLD login = new Login_OLD();
							login.start(new Stage());
				     }
				 });
		});
	
		hbox3.setPadding(new Insets(10));
		hbox3.setSpacing(10);
		
		
		
		hbox3.getChildren().addAll(txtMessage,rbPrepose, rbAdherant,btnQuitter);
		
		Button btnConnexion = new Button("Connexion");
		btnConnexion.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		
		vbox.getChildren().addAll(textDeBienvenue,hbox1,hbox2,hbox3,btnConnexion, btnQuitter);
		vbox.setAlignment(Pos.TOP_CENTER);
		
	//	btnConnexion.setOnAction(e-> {primaryStage.close(); new ActionAdhérent().show();});
		return vbox;
		
	}
	
	
	
	
	

	private BorderPane createBorderPane(Stage primaryStage) {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,50,50,50));
		Text txtMessage = new Text("Je suis un ");
		RadioButton rbPrepose = new RadioButton("Préposé");
		RadioButton rbAdherant = new RadioButton("Adhérant");

		HBox hb = new HBox();
		hb.setPadding(new Insets(20,20,20,30));

		//Adding GridPane
		
        GridPane gridPane = new GridPane();			
        gridPane.setPadding(new Insets(20,20,20,20));			
        gridPane.setHgap(5);			
        gridPane.setVgap(5);	         

       //Implementing Nodes for GridPane		
        Label lblUserName = new Label("Nom d'utilisateur :");		
        final TextField txtUserName = new TextField();		
        Label lblPassword = new Label("Mot de passe :");		
        final PasswordField pf = new PasswordField();		
        Button btnLogin = new Button("Connexion");
Button btnQuitter = new Button("Quitter");
		
		btnQuitter.setOnAction(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.setTitle("Confirmation");
			  alert.setHeaderText("Confirmation");
			  alert.setContentText("Êtes vous sur de vouloir quitter l'application");
			  alert.showAndWait().ifPresent(response -> {
				     if (response == ButtonType.OK) {
				    System.exit(0);
							
				     }
				     				 });
		});
       // final Label lblMessage = new Label();
		ToggleGroup tg = new ToggleGroup();
		rbAdherant.setToggleGroup(tg);
		rbPrepose.setToggleGroup(tg);
		      
        gridPane.add(lblUserName, 0, 0);			        
        gridPane.add(txtUserName, 1, 0);			        
        gridPane.add(lblPassword, 0, 1);			        
        gridPane.add(pf, 1, 1);			        
        gridPane.add(btnLogin, 3, 1);
        gridPane.add(txtMessage, 0, 2);
      
        gridPane.add(rbAdherant, 1, 2);
        gridPane.add(rbPrepose, 1, 3);
        gridPane.add(btnQuitter, 3, 2);

        //Reflection for gridPane			        
        Reflection r = new Reflection();			        
        r.setFraction(0.7f);			        
        gridPane.setEffect(r);

        //DropShadow effect			        
        DropShadow dropShadow = new DropShadow();			        
        dropShadow.setOffsetX(5);			        
        dropShadow.setOffsetY(5);
        
        
      //Adding text and DropShadow effect to it	                
        Text text = new Text("Médiathèque");		                
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 50));		                
        text.setEffect(dropShadow);

      //Adding text to HBox
        hb.getChildren().add(text);
     
        //Add ID's to Nodes		                
              
   
        btnLogin.setOnAction(e-> {
        if(rbAdherant.isSelected() ){
        	primaryStage.close(); 
        	new ActionAdhérent().show();
        	}
	  else if(rbPrepose.isSelected()){
        		  primaryStage.close();
        		 new ActionPrepose().show();
	  }
	  else {
		  Alert alert = new Alert(AlertType.WARNING);
		  alert.setTitle("Attention");
		  alert.setHeaderText("Une Erreur s'est produite");
		  alert.setContentText("Veuillez choisir si vous êtes un adhérant ou un préposé");
		  alert.showAndWait();
	  }
        	});
      
        bp.setTop(hb);
        bp.setCenter(gridPane);
        
        
		return bp; 
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
