package vue_et_controlleur.Compte;

import java.util.ArrayList;


import classMediateque.Pret;
import gererPret.ListePret;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import login.ActionAdhérent;

public class CompteAdherent extends Stage {
	private final TableView<Pret> tablePret = new TableView<Pret>();
   
    TextField txtMotscles = new TextField();
    
    ArrayList<Pret> lstAllPret = ListePret.getLstPretATrouver();
    
    private  ObservableList<Pret> pret = FXCollections.observableArrayList(lstAllPret);
    
	Image imaTous = new Image("tous.jpg",25,25,true,true);
	ImageView imTous = new ImageView(imaTous); 
	Image imaPeriodique = new Image("periodique.jpg",25,25,true,true);
	ImageView imPeriodique = new ImageView(imaPeriodique);
	Image imalivres = new Image("livres.jpg",25,25,true,true);
	ImageView imlivres = new ImageView(imalivres);
	Image imaDVD = new Image("dvd.gif",25,25,true,true);
	ImageView imDVD = new ImageView(imaDVD);
	
	
	public CompteAdherent (){
 	
			try {
				HBox root = createHBox();
				Scene scene = new Scene(root,890,435);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				this.setScene(scene);
				this.setTitle("Compte Adhérent");
				this.sizeToScene();
				this.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		private HBox createHBox() {
			// TODO Auto-generated method stub
			
		
			
			
			VBox vbTest = new VBox();
			Label lblNomComplet = new Label("Alexander Porras");
			HBox  hBox = new HBox();
			hBox.setPadding(new Insets(10));
			hBox.setSpacing(10);
			TabPane tabPane = new TabPane();
			Tab tabPret = new Tab();
			tabPret.setGraphic(imTous);
			tabPret.setClosable(false);
			tabPret.setContent(createTablePretVBox());

			
			lblNomComplet.setFont(new Font(50));
		
			
			tabPane.getTabs().addAll(tabPret);
		    tabPane.setPrefWidth(673);
		    
		    vbTest.getChildren().addAll(lblNomComplet,tabPane);
			
			hBox.getChildren().addAll( vbTest, createVboxFiltres());
		
			return hBox;
		}
		
		

		
		
		
		
		
		private VBox createVboxFiltres() {
			VBox vBox = new VBox();
			vBox.setPadding(new Insets(10));	
			vBox.setSpacing(40);
			vBox.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			vBox.setMaxWidth(300);
			vBox.setAlignment(Pos.CENTER);
			ObservableList<String> options = 
				    FXCollections.observableArrayList(
				        "Tous",
				        "Prêt",
				        "Disponible"
				    );
			final ComboBox<String> comboBox = new ComboBox<String>(options);
			comboBox.setValue("Tous");
			Button btnEffacerFiltres = new Button("Éffacer les filtres");
			
			btnEffacerFiltres.setOnAction(e-> {
				txtMotscles.clear();
				comboBox.setValue("Tous");
				});
			
			Button btnRetour = new Button("Retour aux Actions");
			btnRetour.setOnAction(e-> {
				this.close();
				new ActionAdhérent().show();
				});
			
				
			vBox.getChildren().addAll(createVboxImage(), createHboxMotsCles(), comboBox, btnEffacerFiltres, btnRetour);	
			
			return vBox;
		}
		
		
		
		
		
		
		
		
		
		
		
		private VBox createVboxImage() {
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.CENTER);
	        Image bibliotheque = new Image("compte.jpg",120,100,true,true);
	        ImageView bibliotheque1 = new ImageView(bibliotheque);
	        vBox.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	        vBox.getChildren().add(bibliotheque1);
	        
			return vBox;
		}
		
		

		
		
		
		private HBox createHboxMotsCles(){
			HBox  hBox = new HBox();
			hBox.setPadding(new Insets(10));
			hBox.setSpacing(10);
			Label lblMotscles = new Label("Mots clés :");
		
			txtMotscles.setPrefSize(70, 20);
			
			hBox.getChildren().addAll(lblMotscles, txtMotscles);
			
			return hBox;
		}
		
		
	
		
		
		
		
		
		
		
		@SuppressWarnings("unchecked")
		private VBox createTablePretVBox() {
			VBox  vBox = new VBox();
			vBox.setPadding(new Insets(10));
		    vBox.setSpacing(10);	    
		   

			
			Label lblDetteTotal = new Label("Dette Total :");
			
			lblDetteTotal.setFont(new Font(20));
			TextField tbDetteTotal = new TextField();
			
			pret = FXCollections.observableArrayList(lstAllPret);
			
			tbDetteTotal.setFont(new Font(15));
		    TableColumn<Pret, String> colonneNoPret = new TableColumn<Pret, String> ("Numéro du Prêt");
		    TableColumn<Pret, String> colonneDateDuJour = new TableColumn<Pret, String> ("Date du jour");
		    TableColumn<Pret, String> colonneDateRetourPreveu = new TableColumn<Pret, String>  ("Date du retour preveu ");
		    TableColumn<Pret, String> colonneDateEffectiveRetour = new TableColumn<Pret, String> ("Date du retour effective");
		    TableColumn<Pret, String> colonneNoAdherent = new TableColumn<Pret, String> ("Numéro de l'adhérent");
		    TableColumn<Pret, String> colonneNoDoc = new TableColumn<Pret, String> ("Numéro du document");
		    TableColumn<Pret, Double> colonneAmande = new TableColumn<Pret, Double> ("Amende");
		    tablePret.getColumns().addAll(colonneNoPret, colonneDateDuJour, colonneDateRetourPreveu, colonneDateEffectiveRetour, colonneNoAdherent, colonneNoDoc, colonneAmande); 
		    
		    
		    
		    HBox hboxDetteTotal = new HBox();
		    hboxDetteTotal.setPadding(new Insets(15));
		    hboxDetteTotal.setSpacing(15);
		    hboxDetteTotal.getChildren().addAll(lblDetteTotal, tbDetteTotal);
		    colonneNoPret.setCellValueFactory(new PropertyValueFactory<>("noPret"));
		    colonneDateDuJour.setCellValueFactory(new PropertyValueFactory<>("dateDuJour"));
		    colonneDateRetourPreveu.setCellValueFactory(new PropertyValueFactory<>("dateRetourPreveu"));
		    colonneDateEffectiveRetour.setCellValueFactory(new PropertyValueFactory<>("dateEffectiveRetour"));
		    colonneNoAdherent.setCellValueFactory(new PropertyValueFactory<>("noAdherent"));
		    colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
		    colonneAmande.setCellValueFactory(new PropertyValueFactory<>("dbAmende"));
		    
		    tablePret.autosize();
		    tablePret.setItems(pret);
		     
		    vBox.getChildren().addAll(tablePret, hboxDetteTotal);
			
			return vBox;
		}
		
		
	}
