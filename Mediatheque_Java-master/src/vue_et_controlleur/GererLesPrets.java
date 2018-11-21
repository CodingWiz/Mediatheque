package vue_et_controlleur;

import Objet.ListePret;
import Objet.Pret;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GererLesPrets extends Stage {
	
	private  TableView<Pret> tablePret = new TableView<Pret>();
    private  ObservableList<Pret> pret = FXCollections.observableArrayList(ListePret.getLstPretATrouver());
	
    
     ListView<Pret> lstviewPret = new ListView<>(pret);
    
	public GererLesPrets() {
		try {
			HBox root = createHBox();
			Scene scene = new Scene(root,960,435);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Gérer prêt");
			this.sizeToScene();
			this.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private HBox createHBox() {
		// TODO Auto-generated method stub
		HBox  hBox = new HBox();
		hBox.setSpacing(10);
		hBox.getChildren().addAll(createTablePretVBox(), createVboxFiltres());
		
		return hBox;
	}
	
	private VBox createVboxFiltres() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));	
		vBox.setSpacing(20);
		vBox.setSpacing(40);
		vBox.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vBox.setMaxWidth(300);
		vBox.setAlignment(Pos.CENTER);
		Button btnModifier = new Button("Modifier");
		Button btnFaireRetour = new Button("Faire retour");
		btnFaireRetour.setOnAction(e-> {
			
			
			 if(lstviewPret.getSelectionModel().getSelectedItem().equals(null)){
				 Alert alert = new Alert(AlertType.ERROR);
				  alert.setTitle("Erreur");
				  alert.setHeaderText("Erreur");
				  alert.setContentText("Veuillez selectionner le prêt de la liste que vous voudriez retourner ?");
				  alert.showAndWait();
			 }
			 Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.setTitle("Confirmation");
			  alert.setHeaderText("Confirmation");
			  alert.setContentText("Êtes vous sur de vouloir vous annuler ce prêt ?");
			  alert.showAndWait().ifPresent(response -> {
				     if (response == ButtonType.OK) {
				    	 Pret Pret = lstviewPret.getSelectionModel().getSelectedItem();
				    	 lstviewPret.getSelectionModel().clearSelection();
				    	ListePret.supprimerPret(Pret);
				    	new GererLesPrets().show();
							
				     }
				 });
			
			
			});	
		
		Button btnNouveauRetour = new Button("Nouveau prêt");
		/*Button btnRetourner = new Button("Retour aux Actions");
		btnRetourner.setOnAction(e-> {
			this.close();
			new ActionPrepose().show();
			});	*/
		
		
		btnNouveauRetour.setOnAction(e-> {
			this.close();
			new AjouterPret().show();
			});	
		
		
		vBox.getChildren().addAll(createVboxImage(), btnModifier, btnFaireRetour, btnNouveauRetour);	
		
		return vBox;
	}
	
	private VBox createVboxImage() {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
        Image bibliotheque = new Image("prêt.png",144,74,true,true);
        vBox.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        vBox.getChildren().add(new ImageView(bibliotheque));
        
		return vBox;
	}
	
	@SuppressWarnings("unchecked")
	private VBox createTablePretVBox() {
		VBox  vBox = new VBox();
		vBox.setPadding(new Insets(10));
	    vBox.setSpacing(10);	
	    vBox.setPrefSize(770, 420);
	   /*for(int i = 0; i<ListePret.getLstPretATrouver().size();i++){
		   pret.add(ListePret.getLstPretATrouver().get(i));
		 
	   }*/
	    TableColumn<Pret, String> colonneNoPret = new TableColumn<Pret, String> ("Numéro du prêt");
	    TableColumn<Pret, String> colonneDateDuJour = new TableColumn<Pret, String> ("Date du prêt");
	    TableColumn<Pret, String> colonneDateRetourPreveu = new TableColumn<Pret, String>  ("Date de retour prevu");
	    TableColumn<Pret, String> colonneDateEffectiveRetour = new TableColumn<Pret, String> ("Date effective du retour");
	    TableColumn<Pret, String> colonneNoAdherent = new TableColumn<Pret, String> ("Numéro de l'Adhérent");
	    TableColumn<Pret, String> colonneNoDoc = new TableColumn<Pret, String> ("Numéro du document");
	    tablePret.getColumns().addAll(colonneNoPret, colonneDateDuJour, colonneDateRetourPreveu, colonneDateEffectiveRetour, colonneNoAdherent, colonneNoDoc); 
	    
	    colonneNoPret.setCellValueFactory(new PropertyValueFactory<>("noPret"));
	    colonneDateDuJour.setCellValueFactory(new PropertyValueFactory<>("dateDuJour"));
	    colonneDateRetourPreveu.setCellValueFactory(new PropertyValueFactory<>("dateRetourPreveu"));
	    colonneDateEffectiveRetour.setCellValueFactory(new PropertyValueFactory<>("dateEffectiveRetour"));
	    colonneNoAdherent.setCellValueFactory(new PropertyValueFactory<>("noAdherent"));
	    colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
	    
	    tablePret.autosize();
	    tablePret.setItems(pret);
	     
	    vBox.getChildren().addAll(tablePret);
		
		return vBox;
	}
}
