package vue_et_controlleur.gererDocument;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ajouter extends Stage{
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "Livre",
		        "Périodique",
		        "DVD"
		    );
	final ComboBox<String> comboBox = new ComboBox<String>(options);

	
	public Ajouter() {
		try {
			VBox root = createVbox();
			Scene scene = new Scene(root,400,300);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Ajouter Nouveau Document");
			this.sizeToScene();
			/*comboBox.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});*/
			
			
			/*comboBox.setOnAction(e ->{
				this.close();
				new Ajouter().show();
			});*/
			this.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public VBox createVbox(){
		
		VBox  vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		
		Label lblInfo = new Label("Quels types de document désirez-vous ajouter ?");
		lblInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		lblInfo.setAlignment(Pos.CENTER);
		//System.out.println(comboBox.getValue());
		
		//comboBox.setValue(comboBox.getValue());
		vBox.getChildren().addAll(lblInfo);
		
		Button btnDVD = new Button("DVD");
		Button btnPériodique = new Button("Périodique");
		Button btnLivre = new Button("Livre");
		btnDVD.setOnAction(e ->{
			new FormulaireDVD().show();
		});
		
		btnLivre.setOnAction(e->{
			new FormulaireLivre().show();
		});
		
		
		btnPériodique.setOnAction(e -> {
			new FormulairePériodique();
		});
		
		
		vBox.getChildren().addAll(btnDVD,btnPériodique,btnLivre);
		
		return vBox;
	}
	
	
	
	
	
	
	
	
	

}
