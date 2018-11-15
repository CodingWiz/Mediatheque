package gererAdherent;

import classMediateque.Adherent;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import login.ActionPrepose;

public class G�rerLesAdh�rents extends Stage {
	private final TableView<Adherent> tableAdherent = new TableView<Adherent>();
	private final ObservableList<Adherent> adherent = FXCollections.observableArrayList(new Adherent("Kouma","C�dric","4444 rue elgin","1256747567","1","111"));
		public G�rerLesAdh�rents() {
			try {
				HBox root = createHBox();
				Scene scene = new Scene(root,960,435);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				this.setScene(scene);
				this.setTitle("G�rer Les adh�rents");
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
			
			
			Button btnAjouterAdherent = new Button(" Ajouter Adh�rent");
			Button btnSupprimerAdherent = new Button("Supprimer Adh�rent");
			Button btnRetourner = new Button("Retour aux Actions");
			btnRetourner.setOnAction(e-> {
				this.close();
				new ActionPrepose().show();
				});		
			
			
			vBox.getChildren().addAll(createVboxImage(), btnAjouterAdherent, btnSupprimerAdherent, btnRetourner);	
			
			return vBox;
		}
		
		private VBox createVboxImage() {
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.CENTER);
	        Image bibliotheque = new Image("adh�rent.png");
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
		    
		    TableColumn<Adherent, String> colonneNoAdherent = new TableColumn<Adherent, String> ("Num�ro de l'Adh�rent");
		    TableColumn<Adherent, String> colonneNom = new TableColumn<Adherent, String>  ("Nom");
		    TableColumn<Adherent, String> colonnePrenom = new TableColumn<Adherent, String>  ("Prenom");
		    TableColumn<Adherent, String> colonneAdresse = new TableColumn<Adherent, String> ("Adresse");
		    TableColumn<Adherent, Integer> colonneNoT�lephone = new TableColumn<Adherent, Integer> ("Num�ro du t�lephone");
		    TableColumn<Adherent, String> colonnePassword = new TableColumn<Adherent, String> ("Password");
		    
		    
		    tableAdherent.getColumns().addAll(colonneNoAdherent, colonneNom, colonnePrenom, colonneAdresse, colonneNoT�lephone, colonnePassword); 
		    
		    colonneNoAdherent.setCellValueFactory(new PropertyValueFactory<>("strNoAdherent"));
		    colonneNom.setCellValueFactory(new PropertyValueFactory<>("strNom"));
		    colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("strPrenom"));
		    colonneAdresse.setCellValueFactory(new PropertyValueFactory<>("strAdresse"));
		    colonneNoT�lephone.setCellValueFactory(new PropertyValueFactory<>("intTelephone"));
		    colonnePassword.setCellValueFactory(new PropertyValueFactory<>("strPassword"));
		    
		    tableAdherent.autosize();
		    tableAdherent.setItems(adherent);
		     
		    vBox.getChildren().addAll(tableAdherent);
			
			return vBox;
		}
	}

