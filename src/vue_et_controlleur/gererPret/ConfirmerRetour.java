package vue_et_controlleur.gererPret;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ConfirmerRetour extends Stage{

	
	public ConfirmerRetour ( ) throws Exception {
		// TODO Auto-generated method stub
		try {
		VBox root = createVBox();
		Scene scene = new Scene(root,250,150);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.setScene(scene);
		this.setTitle("Confirmation");
		this.sizeToScene();
		this.show();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	private VBox createVBox() {
		// TODO Auto-generated method stub
		VBox  vBox = new VBox();
		vBox.setPadding(new Insets(10));
	    vBox.setSpacing(10);
	    
	    Label lblExample = new Label("Est-vous sure de faire le "
	    		+ "\nretour pour ce prêt?");
	    lblExample.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
	    lblExample.setAlignment(Pos.CENTER);
	    
	    vBox.getChildren().addAll(lblExample, createButtonHBox());
	    
		return vBox;
	}
	
	private HBox createButtonHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setPadding(new Insets(10));
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    
	    Button btnValider = new Button("Oui");
	    btnValider.setPrefSize(70, 40);
	    btnValider.setOnAction(e->{
	    	
	    });
	    
    	Button btnAnnuler = new Button("Non");
    	btnAnnuler.setPrefSize(70, 40);
    	btnAnnuler.setOnAction(e->{
	    	this.close();
	    });
    	
    	hBox.getChildren().addAll(btnValider, btnAnnuler);
    	
		return hBox;
	}

}

