package gererPret;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class NouvModifPret extends Application{
	
	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		try {
			
		VBox root = createVBox();
		Scene scene = new Scene(root,400,200);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gérer prêt");
		primaryStage.sizeToScene();
		primaryStage.show();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	private HBox createHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setPadding(new Insets(10));
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    
	    hBox.getChildren().addAll(createInfoVBox(), createDateVBox());
	    
	    return hBox;
	}
	
	private VBox createVBox() {
		// TODO Auto-generated method stub
		VBox  vBox = new VBox();
		vBox.setPadding(new Insets(10));
	    vBox.setSpacing(10);
	    //vBox.setAlignment(Pos.CENTER);
	    
	    Label lblExample = new Label("Prêt");
	    lblExample.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
	    lblExample.setAlignment(Pos.CENTER);
	    
	    vBox.getChildren().addAll(lblExample, createHBox());
	    
	    return vBox;
	}
	
	private VBox createInfoVBox() {
		// TODO Auto-generated method stub
		VBox  hBox = new VBox();
		hBox.setPadding(new Insets(10));
	    hBox.setSpacing(20);
	   
	    TextField txtNoEmployer = new TextField();
	    txtNoEmployer.setPromptText("Numero d'employer");
	    TextField txtNoAdherent = new TextField();
	    txtNoAdherent.setPromptText("Numero d'adhérent");
	    TextField txtNoDoc = new TextField();
	    txtNoDoc.setPromptText("Numero de document");
	    
	    hBox.getChildren().addAll(txtNoEmployer, txtNoAdherent, txtNoDoc);
	    
	    return hBox;
	}
	
	private VBox createDateVBox() {
		// TODO Auto-generated method stub
		VBox  hBox = new VBox();
		hBox.setPadding(new Insets(10));
	    hBox.setSpacing(20);
	   
	    TextField txtDateJour = new TextField();
	    txtDateJour.setPromptText("Date du jour");
	    TextField txtDateRerour = new TextField();
	    txtDateRerour.setPromptText("Date du retour");
	    
	    hBox.getChildren().addAll(txtDateJour, txtDateRerour, createButtonHBox());
	    
	    return hBox;
	}
	
	private HBox createButtonHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setPadding(new Insets(10));
	    hBox.setSpacing(10);
	    
	    Button btnValider = new Button("Valider");
    	Button btnAnnuler = new Button("Anniler");
    	
    	hBox.getChildren().addAll(btnValider, btnAnnuler);
    	
		return hBox;
	}
	
}
