package vue_et_controlleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Inscription extends Stage {
	
	private String strModele = "./modele/";
	
	private Stage stage, LoginStage;
	
	private boolean blnProf;
	
	private Label lblNom, lblPrenom, lblAdresse, lblNoTel, lblTypeEmploye;
	private Label[] arrLbl;
	
	private TextField textFieldNom, textFieldPrenom, textFieldAdresse, textFieldNoTel;
	private TextField[] arrTextField;
	
	private RadioButton rbPrepose, rbAdherent;
	
	private Label lblMsgErreur;
	
	private Button btnInscription, btnAnnuler;
	
	public Inscription(boolean blnProfPasDeStyle, Stage LoginStage) {
		try {
			this.stage = this;
			this.LoginStage = LoginStage;
			this.blnProf = blnProfPasDeStyle;
			
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root, 503, 384);
			
			GridPane gridPane = new GridPane();
	        gridPane.setAlignment(Pos.CENTER);
	        gridPane.setHgap(5);
	        gridPane.setVgap(10);
	        
	        //Implementing Nodes for GridPane
	        lblNom = new Label("Nom :");
	        lblPrenom = new Label("Prénom :");
	        lblAdresse = new Label("Adresse :");
	        lblNoTel = new Label("No. de téléphone :");
	        lblTypeEmploye = new Label("Type d'employé :");
	        arrLbl = new Label[] {lblNom, lblPrenom, lblAdresse, lblNoTel, lblTypeEmploye};
	        
	        textFieldNom = new TextField();
	        textFieldPrenom = new TextField();
	        textFieldAdresse = new TextField();
	        textFieldNoTel = new TextField();
	        arrTextField = new TextField[] {textFieldNom, textFieldPrenom, textFieldAdresse, textFieldNoTel};
	        
	        rbPrepose = new RadioButton("Préposé");
	        rbAdherent = new RadioButton("Adhérent");
	        
	        btnInscription = new Button("S'inscrire");
	        btnAnnuler = new Button("Annuler");
	        
	        lblMsgErreur = new Label("");
	        
	        for (Label lbl : arrLbl) {
	        	lbl.setTextFill(Color.WHITE);
	        	lbl.setTextAlignment(TextAlignment.RIGHT);
	        	lbl.setAlignment(Pos.CENTER_RIGHT);
	        	lbl.setAlignment(Pos.CENTER_RIGHT);
	        	lbl.setFont(font(20, null));
	        }
	        lblMsgErreur.setTextFill(Color.YELLOW);
	        lblMsgErreur.setTextAlignment(TextAlignment.CENTER);
	        lblMsgErreur.setFont(font(15, FontWeight.BOLD));
	        
	        if (blnProfPasDeStyle) {
	        	for (TextField textField : arrTextField) {
		        	textField.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-text-inner-color: white;");
		        	textField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
		        	
		        	textField.setOnKeyPressed(new GestionClavier());
		        }
	        }
	        
	        HBox hBoxRadioButton = new HBox(10), hBoxButton = new HBox(10);
	        
	        ToggleGroup tGroup = new ToggleGroup();
	        rbPrepose.setToggleGroup(tGroup);
	        rbAdherent.setToggleGroup(tGroup);
	        
	        rbPrepose.setTextFill(Color.WHITE);
	        rbAdherent.setTextFill(Color.WHITE);
	        
	        rbPrepose.setFont(font(20, FontWeight.BOLD));
	        rbAdherent.setFont(font(20, FontWeight.BOLD));
	        
	        hBoxRadioButton.setAlignment(Pos.CENTER);
	        hBoxRadioButton.getChildren().addAll(rbPrepose, rbAdherent);
	        
	        btnInscription.setFont(font(15, FontWeight.BOLD));
	        btnAnnuler.setFont(font(15, FontWeight.BOLD));
	        
	        btnInscription.setOnAction(new GestionInscription());
	        btnAnnuler.setOnAction(new GestionInscription());
	        
	        hBoxButton.setAlignment(Pos.CENTER);
	        hBoxButton.getChildren().addAll(btnInscription, btnAnnuler);
	        
	        for (Label lbl : arrLbl) {
	        	GridPane.setHalignment(lbl, HPos.RIGHT);
	        }
	        GridPane.setHalignment(hBoxRadioButton, HPos.CENTER);
	        GridPane.setHalignment(hBoxButton, HPos.CENTER);
	        GridPane.setHalignment(lblMsgErreur, HPos.CENTER);
	        
	        for (int i = 0; i < arrLbl.length; i++) {
	        	gridPane.add(arrLbl[i], 0, i);
	        }
	        for (int j = 0; j < arrTextField.length; j++) {
	        	gridPane.add(arrTextField[j], 1, j);
	        }
	        gridPane.add(hBoxRadioButton, 1, arrTextField.length);
	        gridPane.add(hBoxButton, 1, arrTextField.length+3);
			
	        BorderPane.setAlignment(gridPane, Pos.CENTER);
	        BorderPane.setAlignment(lblMsgErreur, Pos.CENTER);
			root.setCenter(gridPane);
	        root.setBottom(lblMsgErreur);
	        root.setBackground(new Background(
					new BackgroundImage(new Image(strModele + "page-ipad-ipad-ipad-mini-library-wallpapers-hd-desktop-1024768-library-clipart-background-1024_768.jpg"), 
													BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
													new BackgroundSize(scene.getWidth()+10, scene.getHeight()+10, false, false, false, false))));
						
	        this.setScene(scene);
	        this.setTitle("Bienvenue à la médiathèque - Inscription");
	        this.setResizable(false);
	        this.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void shake(String strErreur) {
		//lblMsgErreur.setText("No prepose ou mot de passe incorrecte");
		for (Label lbl : arrLbl) {
			lbl.setTextFill(Color.YELLOW);
		}
		
		if (blnProf) {
			for (TextField textField : arrTextField) {
				textField.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));	
			}
		}
		
		rbPrepose.setTextFill(Color.YELLOW);
		rbAdherent.setTextFill(Color.YELLOW);
		
		lblMsgErreur.setText(strErreur);
		lblMsgErreur.setTextFill(Color.YELLOW);

        // shake animation en cas d'erreur
        final int[] x = {0};
        final int[] y = {0};

        Timeline timelineX = new Timeline(new KeyFrame(Duration.seconds(0.1), t -> {
            if (x[0] == 0) {
            	stage.setX(stage.getX() + 10);
                x[0] = 1;
            } else {
            	stage.setX(stage.getX() - 10);
                x[0] = 0;
            }
        }));

        timelineX.setCycleCount(6);
        timelineX.setAutoReverse(false);
        timelineX.play();


        Timeline timelineY = new Timeline(new KeyFrame(Duration.seconds(0.1), t -> {
            if (y[0] == 0) {
            	stage.setY(stage.getY() + 10);
                y[0] = 1;
            } else {
            	stage.setY(stage.getY() - 10);
                y[0] = 0;
            }
        }));

        timelineY.setCycleCount(6);
        timelineY.setAutoReverse(false);
        timelineY.play();
	}
	
	private boolean inscription() {
		boolean blnReturn = true;
		for (TextField textField : arrTextField) {
			if (textField.getText().isEmpty()) {
				blnReturn = false;
				shake("Une ou toutes les données sont vides");
				break;
			}
		}
		
		if (blnReturn && (!rbPrepose.isSelected() && !rbAdherent.isSelected())) {
			blnReturn = false;
			shake("Veillez choisir votre type de travail");
		}
		
		return blnReturn;
	}
	
	/*
	 * TODO ajout des employées dans les fichiers sérialisés
	 */
	private void ajoutEmploye() {
		
	}
	
	private class GestionInscription implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btnInscription) {
				if (inscription()) {
					ajoutEmploye();
					
					stage.close();
					
					try {
						new Login().start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else if (event.getSource() == btnAnnuler) {
				stage.close();
				
				try {
					new Login().start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	private class GestionClavier implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent event) {
			if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.ENTER) {
				if (inscription()) {
					ajoutEmploye();
					
					stage.close();
					
					LoginStage.show();
				}
			}
		}
		
	}
	
	private Font font(int intSize, FontWeight fontWeight) {
		return Font.font("Serif", fontWeight == null ? FontWeight.NORMAL : fontWeight, intSize);
	}
}
