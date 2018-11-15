package vue_et_controlleur.login;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import serialisationEtdeserialisation.FirstSerializerDocument;
import serialisationEtdeserialisation.LectureDesFichiers;

public class Login extends Application {
	
	private String strModele = "./modele/", 
			strVueEtControlleur = "./vue_et_controlleur/";
	
	private Stage stage;
	
	private boolean blnProfPasDeStyle = true;
	
	private Label lblUser, lblPwd;
	
	private TextField textFieldUser;
	private PasswordField pwdFieldUser;
	
	private Label lblMsgErreur;
	
	private Button btnConnexion, btnEnregistrement;

	@Override
	public void start(Stage primaryStage) throws Exception {
		serialisation();
		
		this.stage = primaryStage;
		
		BorderPane root = new BorderPane();
		
		Scene scene = new Scene(root, 410, 307);
		
		//Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        //gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        
        /*Text text = new Text("Veillez vous identifier");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFill(Color.WHITE);
        text.setFont(font(40, FontWeight.BOLD));*/
        
        //Implementing Nodes for GridPane
        lblUser = new Label("No. de l'employé :");
        lblPwd = new Label("Mot de passe :");
        textFieldUser = new TextField();
        pwdFieldUser = new PasswordField();
        btnConnexion = new Button("Connexion");
        btnEnregistrement = new Button("Inscription");
        lblMsgErreur = new Label("");
        
        lblUser.setTextFill(Color.WHITE);
        lblPwd.setTextFill(Color.WHITE);
        
        lblMsgErreur.setTextFill(Color.YELLOW);
        
        lblUser.setTextAlignment(TextAlignment.RIGHT);
        lblPwd.setTextAlignment(TextAlignment.RIGHT);
        
        lblMsgErreur.setTextAlignment(TextAlignment.CENTER);
        
        lblUser.setAlignment(Pos.CENTER_RIGHT);
        lblPwd.setAlignment(Pos.CENTER_RIGHT);
        
        lblMsgErreur.setAlignment(Pos.CENTER);
        
        btnConnexion.setAlignment(Pos.CENTER_RIGHT);
        btnEnregistrement.setAlignment(Pos.CENTER_RIGHT);
        
        lblUser.setFont(font(20, null));
        lblPwd.setFont(font(20, null));
        
        lblMsgErreur.setFont(font(15, FontWeight.BOLD));
        
        textFieldUser.setFont(font(15, null));
        pwdFieldUser.setFont(font(15, null));
        
        btnConnexion.setFont(font(15, FontWeight.BOLD));
        btnEnregistrement.setFont(font(15, FontWeight.BOLD));
        
        btnConnexion.setGraphic(
        		new ImageView(new Image(strModele + "secure-icon-lock-secure-icon-27.png", 20, 20, false, false)));
        
        textFieldUser.setOnKeyPressed(new GestionClavier());
        pwdFieldUser.setOnKeyPressed(new GestionClavier());
        
        btnConnexion.setOnAction(new GestionConnexion());
        btnEnregistrement.setOnAction(new GestionConnexion());
        
        if (blnProfPasDeStyle) {
	        // https://stackoverflow.com/questions/12717487/how-to-implement-a-transparent-pane-with-non-transparent-children
	        //textFieldUser.setFill(Color.WHITE);        
	        textFieldUser.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); /*-fx-background-radius: 10;*/ -fx-text-inner-color: white;");
	        textFieldUser.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
	        /*textFieldUser.skinProperty().addListener(new ChangeListener<Skin<?>>() {
	
	            @Override
	            public void changed(
	              ObservableValue<? extends Skin<?>> ov, Skin<?> t, Skin<?> t1) {
	                if (t1 != null && t1.getNode() instanceof Region) {
	                    Region r = (Region) t1.getNode();
	                    r.setBackground(Background.EMPTY);
	
	                    r.getChildrenUnmodifiable().stream().
	                            filter(n -> n instanceof Region).
	                            map(n -> (Region) n).
	                            forEach(n -> n.setBackground(Background.EMPTY));
	
	                    r.getChildrenUnmodifiable().stream().
	                            filter(n -> n instanceof Control).
	                            map(n -> (Control) n).
	                            forEach(c -> c.skinProperty().addListener(this)); // *
	                }
	            }
	        });*/
	        
	        pwdFieldUser.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); /*-fx-background-radius: 10;*/ -fx-text-inner-color: white;");
	        pwdFieldUser.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
	        /*pwdFieldUser.skinProperty().addListener(new ChangeListener<Skin<?>>() {
	
	            @Override
	            public void changed(
	              ObservableValue<? extends Skin<?>> ov, Skin<?> t, Skin<?> t1) {
	                if (t1 != null && t1.getNode() instanceof Region) {
	                    Region r = (Region) t1.getNode();
	                    r.setBackground(Background.EMPTY);
	
	                    r.getChildrenUnmodifiable().stream().
	                            filter(n -> n instanceof Region).
	                            map(n -> (Region) n).
	                            forEach(n -> n.setBackground(Background.EMPTY));
	
	                    r.getChildrenUnmodifiable().stream().
	                            filter(n -> n instanceof Control).
	                            map(n -> (Control) n).
	                            forEach(c -> c.skinProperty().addListener(this)); // *
	                }
	            }
	        });*/
        }
        
        //Adding Nodes to GridPane layout
        GridPane.setHalignment(lblUser, HPos.RIGHT);
        GridPane.setHalignment(lblPwd, HPos.RIGHT);
        GridPane.setHalignment(btnConnexion, HPos.RIGHT);
        GridPane.setHalignment(btnEnregistrement, HPos.RIGHT);
        GridPane.setHalignment(lblMsgErreur, HPos.CENTER);
        gridPane.add(lblUser, 0, 0);
        gridPane.add(textFieldUser, 1, 0);
        gridPane.add(lblPwd, 0, 1);
        gridPane.add(pwdFieldUser, 1, 1);
        gridPane.add(btnConnexion, 1, 5);
        gridPane.add(btnEnregistrement, 1, 7);
        //gridPane.add(lblMsgErreur, 1, 15);
        
        //Add HBox and GridPane layout to BorderPane Layout
        
        //root.setAlignment(gridPane, Pos.CENTER);
        /*root.setMargin(text, new Insets(80, 0, 0, 0));
        root.setMargin(gridPane, new Insets(80, 0, 0, 0));*/
        BorderPane.setAlignment(gridPane, Pos.CENTER);
        BorderPane.setAlignment(lblMsgErreur, Pos.CENTER);
        root.setCenter(gridPane);
        root.setBottom(lblMsgErreur);
        root.setBackground(new Background(
				new BackgroundImage(new Image(strModele + "page-ipad-ipad-ipad-mini-library-wallpapers-hd-desktop-1024768-library-clipart-background-1024_768.jpg"), 
												BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
												new BackgroundSize(scene.getWidth()+10, scene.getHeight()+10, false, false, false, false))));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bienvenue à la médiathèque - Connexion");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private void serialisation() {
		/*LectureDesFichiers.LireFichierAdhérant(strModele + "Adhérent.txt");
		LectureDesFichiers.LireFichierDVD(strModele + "DVD.txt");
		LectureDesFichiers.LireFichierLivres(strModele + "Livres.txt");
		LectureDesFichiers.LireFichierPeriodique(strModele + "Periodiques.txt");
		LectureDesFichiers.LireFichierPrepose(strModele + "Preposé.txt");
		
		File fichier = new File(strModele + "DVD.ser");
		
		if(!fichier.exists()){
			FirstSerializerDocument.getInstance();
		}*/
	}
	
	private void shake(String strErreur) {
		//lblMsgErreur.setText("No prepose ou mot de passe incorrecte");
		lblUser.setTextFill(Color.YELLOW);
		lblPwd.setTextFill(Color.YELLOW);
		
		if (blnProfPasDeStyle) {
			textFieldUser.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
			pwdFieldUser.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
		}
		
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
        
        textFieldUser.requestFocus();
	}
	
	/*
	 * TODO afficher menu principal
	 */
	private void afficheMenuPrincipal() {
		
	}
	
	/*
	 * TODO check si les données entrées sont valides et sont dans les fichiers sérialisés
	 */
	private boolean connexion() {
		boolean blnConnexion = true;
		if (!textFieldUser.getText().isEmpty() && !pwdFieldUser.getText().isEmpty()) {
			if (textFieldUser.getText().equals("MHG") && pwdFieldUser.getText().equals("123")) {
				
			}
			else {
				blnConnexion = false;
				shake("No. de l'employé et/ou mot de passe erroné");
			}
			
			pwdFieldUser.clear();
		}
		else {
			blnConnexion = false;
			shake("No. de l'employé et/ou mot de passe vide");
		}
		
		return blnConnexion;
	}
	
	private class GestionConnexion implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btnConnexion) {
				if (connexion()) {
					afficheMenuPrincipal();
					
					retourSansErreur();
					
					stage.close();
					
					
				}
			}
			else if (event.getSource() == btnEnregistrement) {
				retourSansErreur();
				
				stage.close();
				
				new Inscription(blnProfPasDeStyle, stage).show();
			}
		}
		
	}
	private class GestionClavier implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent event) {
			if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.ENTER) {
				if (connexion()) {
					afficheMenuPrincipal();
					
					retourSansErreur();
					
					stage.close();
				}
			}
		}
		
	}
	
	private void retourSansErreur() {
		lblUser.setTextFill(Color.WHITE);
		lblPwd.setTextFill(Color.WHITE);
		
		if (blnProfPasDeStyle) {
			textFieldUser.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
			pwdFieldUser.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
		}
		
		lblMsgErreur.setText("");
	}
	
	private Font font(int intSize, FontWeight fontWeight) {
		return Font.font("Serif", fontWeight == null ? FontWeight.NORMAL : fontWeight, intSize);
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
