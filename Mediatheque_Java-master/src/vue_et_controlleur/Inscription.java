package vue_et_controlleur;

import java.util.Random;

import Objet.Adherent;
import Objet.ListeAdherant;
import Objet.ListePrepose;
import Objet.Prepose;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

	// private String strModele = "modele/images/";

	private String strModele = "./modele/";

	private Stage thisStage;

	private boolean blnProfPasDeStyle, blnLogin;

	private Label lblNom, lblPrenom, lblAdresse, lblNoTel, lblTypeEmploye, lblPreposePwd, lblPreposePwdConfirmation;
	private Label[] arrLbl;

	private TextField textFieldNom, textFieldPrenom, textFieldAdresse, textFieldNoTel;
	private TextField[] arrTextField;
	private PasswordField pwdFieldPreposePwd, pwdFieldPreposePwdConfirmation;
	private PasswordField[] arrPwdField;

	private RadioButton rbPrepose, rbAdherent;

	private Label lblMsgErreur;

	private GridPane gridPane;

	private HBox hBoxRadioButton = new HBox(10), hBoxButton = new HBox(10);

	private Button btnInscription, btnAnnuler;

	public Inscription(boolean blnProfPasDeStyle, boolean blnLogin) {
		try {
			this.thisStage = this;
			this.blnProfPasDeStyle = blnProfPasDeStyle;
			this.blnLogin = blnLogin; // pour savoir si la fenetre envoyee est le login ou si c est la gestion des adherents

			this.setOnCloseRequest(e -> {
				//quitter(e);
				
				retour(e);
			});

			BorderPane root = new BorderPane();

			Scene scene = new Scene(root, 503, 384);

			gridPane = new GridPane();
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setHgap(5);
			gridPane.setVgap(10);

			// Implementing Nodes for GridPane
			lblNom = new Label("Nom :");
			lblPrenom = new Label("Prénom :");
			lblAdresse = new Label("Adresse :");
			lblNoTel = new Label("No. de téléphone :");
			lblTypeEmploye = new Label("Type d'employé :");
			lblPreposePwd = new Label("Mot de passe :");
			lblPreposePwdConfirmation = new Label("Confirmer mot de passe :");
			arrLbl = new Label[] { lblNom, lblPrenom, lblAdresse, lblNoTel, lblTypeEmploye, lblPreposePwd,
					lblPreposePwdConfirmation };

			textFieldNom = new TextField();
			textFieldPrenom = new TextField();
			textFieldAdresse = new TextField();
			textFieldNoTel = new TextField();
			arrTextField = new TextField[] { textFieldNom, textFieldPrenom, textFieldAdresse, textFieldNoTel };

			pwdFieldPreposePwd = new PasswordField();
			pwdFieldPreposePwdConfirmation = new PasswordField();
			arrPwdField = new PasswordField[] { pwdFieldPreposePwd, pwdFieldPreposePwdConfirmation };

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
					textField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
							CornerRadii.EMPTY, new BorderWidths(1))));

					textField.setOnKeyPressed(new GestionClavier());
				}
				for (PasswordField passwordField : arrPwdField) {
					passwordField
							.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-text-inner-color: white;");
					passwordField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
							CornerRadii.EMPTY, new BorderWidths(1))));

					passwordField.setOnKeyPressed(new GestionClavier());
				}
			}

			hBoxRadioButton = new HBox(10);
			hBoxButton = new HBox(10);

			ToggleGroup tGroup = new ToggleGroup();
			rbPrepose.setToggleGroup(tGroup);
			rbAdherent.setToggleGroup(tGroup);

			rbPrepose.setTextFill(Color.WHITE);
			rbAdherent.setTextFill(Color.WHITE);

			rbPrepose.setFont(font(20, FontWeight.BOLD));
			rbAdherent.setFont(font(20, FontWeight.BOLD));

			rbPrepose.setOnAction(new GestionInscription());
			rbAdherent.setOnAction(new GestionInscription());

			hBoxRadioButton.setAlignment(Pos.CENTER_LEFT);
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
			GridPane.setHalignment(hBoxRadioButton, HPos.LEFT);
			GridPane.setHalignment(hBoxButton, HPos.CENTER);
			GridPane.setHalignment(lblMsgErreur, HPos.CENTER);

			for (int i = 0; i < arrLbl.length; i++) {
				if (arrLbl[i] != lblPreposePwd && arrLbl[i] != lblPreposePwdConfirmation) {
					gridPane.add(arrLbl[i], 0, i);
				}
			}
			for (int j = 0; j < arrTextField.length; j++) {
				gridPane.add(arrTextField[j], 1, j);
			}
			gridPane.add(hBoxRadioButton, 1, arrTextField.length);
			/*
			 * for (int m = arrTextField.length; m < (arrTextField.length +
			 * arrPwdField.length); m++) { gridPane.add(arrPwdField[m-arrTextField.length],
			 * 1, m+1); }
			 */
			gridPane.add(hBoxButton, 1, (arrTextField.length /* + arrPwdField.length */) + 3);

			BorderPane.setAlignment(gridPane, Pos.CENTER);
			BorderPane.setAlignment(lblMsgErreur, Pos.CENTER);
			root.setCenter(gridPane);
			root.setBottom(lblMsgErreur);
			root.setBackground(new Background(new BackgroundImage(new Image(strModele
					+ "page-ipad-ipad-ipad-mini-library-wallpapers-hd-desktop-1024768-library-clipart-background-1024_768.jpg"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(scene.getWidth() + 10, scene.getHeight() + 10, false, false, false, false))));

			// inscriptionPrepose(false);

			textFieldNom.requestFocus();
			
			if (!blnLogin) {
				for (PasswordField passwordField : arrPwdField) {
					gridPane.getChildren().remove(passwordField);
				}
				
				rbPrepose.setSelected(false);
				rbAdherent.setSelected(true);
				
				hBoxRadioButton.getChildren().remove(rbPrepose);
			}

			this.setScene(scene);
			this.setTitle("Médiathèque - Inscription");
			this.setResizable(false);
			this.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void shake(String strErreur) {
		// lblMsgErreur.setText("No prepose ou mot de passe incorrecte");
		for (Label lbl : arrLbl) {
			lbl.setTextFill(Color.YELLOW);
		}

		if (blnProfPasDeStyle) {
			for (TextField textField : arrTextField) {
				textField.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID,
						CornerRadii.EMPTY, new BorderWidths(1))));
			}
			for (PasswordField passwordField : arrPwdField) {
				passwordField.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID,
						CornerRadii.EMPTY, new BorderWidths(1))));
			}
		}

		rbPrepose.setTextFill(Color.YELLOW);
		rbAdherent.setTextFill(Color.YELLOW);

		lblMsgErreur.setText(strErreur);
		lblMsgErreur.setTextFill(Color.YELLOW);

		// shake animation en cas d'erreur
		final int[] x = { 0 };
		final int[] y = { 0 };

		Timeline timelineX = new Timeline(new KeyFrame(Duration.seconds(0.1), t -> {
			if (x[0] == 0) {
				thisStage.setX(thisStage.getX() + 10);
				x[0] = 1;
			} else {
				thisStage.setX(thisStage.getX() - 10);
				x[0] = 0;
			}
		}));

		timelineX.setCycleCount(6);
		timelineX.setAutoReverse(false);
		timelineX.play();

		Timeline timelineY = new Timeline(new KeyFrame(Duration.seconds(0.1), t -> {
			if (y[0] == 0) {
				thisStage.setY(thisStage.getY() + 10);
				y[0] = 1;
			} else {
				thisStage.setY(thisStage.getY() - 10);
				y[0] = 0;
			}
		}));

		timelineY.setCycleCount(6);
		timelineY.setAutoReverse(false);
		timelineY.play();
	}

	private void inscriptionPrepose(boolean blnAffiche) {
		retourSansErreur();

		/*
		 * for (int i = 0; i < arrLbl.length; i++) { gridPane.add(arrLbl[i], 0, i); }
		 * for (int j = 0; j < arrTextField.length; j++) { gridPane.add(arrTextField[j],
		 * 1, j); } gridPane.add(hBoxRadioButton, 1, arrTextField.length); for (int m =
		 * arrTextField.length; m < (arrTextField.length + arrPwdField.length); m++) {
		 * gridPane.add(arrPwdField[m-arrTextField.length], 1, m+1); }
		 * gridPane.add(hBoxButton, 1, (arrTextField.length + arrPwdField.length)+3);
		 */

		if (blnAffiche) {
			for (int i = 0; i < arrLbl.length; i++) {
				gridPane.add(arrLbl[i], 0, i);
			}
			for (int j = 0; j < arrTextField.length; j++) {
				gridPane.add(arrTextField[j], 1, j);
			}
			gridPane.add(hBoxRadioButton, 1, arrTextField.length);
			for (int m = arrTextField.length; m < (arrTextField.length + arrPwdField.length); m++) {
				gridPane.add(arrPwdField[m - arrTextField.length], 1, m + 1);
			}
			gridPane.add(hBoxButton, 1, (arrTextField.length + arrPwdField.length) + 3);
		} else {
			for (int i = 0; i < arrLbl.length; i++) {
				gridPane.getChildren().remove(arrLbl[i]);
			}
			for (int j = 0; j < arrTextField.length; j++) {
				gridPane.getChildren().remove(arrTextField[j]);
			}
			gridPane.getChildren().remove(hBoxRadioButton);
			for (int m = arrTextField.length; m < (arrTextField.length + arrPwdField.length); m++) {
				gridPane.getChildren().remove(arrPwdField[m - arrTextField.length]);
			}
			gridPane.getChildren().remove(hBoxButton);
		}
	}

	private void inscriptionAdherent(boolean blnAffiche) {
		retourSansErreur();

		/*
		 * for (int i = 0; i < arrLbl.length; i++) { gridPane.add(arrLbl[i], 0, i); }
		 * for (int j = 0; j < arrTextField.length; j++) { gridPane.add(arrTextField[j],
		 * 1, j); } gridPane.add(hBoxRadioButton, 1, arrTextField.length); for (int m =
		 * arrTextField.length; m < (arrTextField.length + arrPwdField.length); m++) {
		 * gridPane.add(arrPwdField[m-arrTextField.length], 1, m+1); }
		 * gridPane.add(hBoxButton, 1, (arrTextField.length + arrPwdField.length)+3);
		 */

		if (blnAffiche) {
			for (int i = 0; i < arrLbl.length; i++) {
				if (arrLbl[i] != lblPreposePwd && arrLbl[i] != lblPreposePwdConfirmation) {
					gridPane.add(arrLbl[i], 0, i);
				}
			}
			for (int j = 0; j < arrTextField.length; j++) {
				gridPane.add(arrTextField[j], 1, j);
			}
			gridPane.add(hBoxRadioButton, 1, arrTextField.length);
			/*
			 * for (int m = arrTextField.length; m < (arrTextField.length +
			 * arrPwdField.length); m++) { gridPane.add(arrPwdField[m-arrTextField.length],
			 * 1, m+1); }
			 */
			gridPane.add(hBoxButton, 1, (arrTextField.length /* + arrPwdField.length */) + 3);
		} else {
			for (int i = 0; i < arrLbl.length; i++) {
				if (arrLbl[i] != lblPreposePwd && arrLbl[i] != lblPreposePwdConfirmation) {
					gridPane.getChildren().remove(arrLbl[i]);
				}
			}
			for (int j = 0; j < arrTextField.length; j++) {
				gridPane.getChildren().remove(arrTextField[j]);
			}
			gridPane.getChildren().remove(hBoxRadioButton);
			/*
			 * for (int m = arrTextField.length; m < (arrTextField.length +
			 * arrPwdField.length); m++) {
			 * gridPane.getChildren().remove(arrPwdField[m-arrTextField.length]); }
			 */
			gridPane.getChildren().remove(hBoxButton);
		}
	}

	private boolean inscription() {
		boolean blnReturn = true, blnDonneesNonVide = true;

		for (TextField textField : arrTextField) {
			if (textField.getText().isEmpty()) {
				blnDonneesNonVide = false;
				// shake("Une ou toutes les données sont vides");
				break;
			}
		}
		for (PasswordField passwordField : arrPwdField) {
			if (passwordField.getText().isEmpty()) {
				blnDonneesNonVide = false;
				break;
			}
		}

		if (!blnDonneesNonVide) {
			shake("Une ou toutes les données sont vides");
		}
		if (blnReturn && (!rbPrepose.isSelected() && !rbAdherent.isSelected())) {
			blnReturn = false;
			shake("Veillez choisir votre type de travail");
		}

		// textFieldNom, textFieldPrenom, textFieldAdresse, textFieldNoTel

		if (rbPrepose.isSelected()) {
			if (!textFieldNom.getText().isEmpty() && !textFieldPrenom.getText().isEmpty()
					&& !textFieldAdresse.getText().isEmpty() && !textFieldNoTel.getText().isEmpty()
					&& !pwdFieldPreposePwd.getText().isEmpty() && !pwdFieldPreposePwdConfirmation.getText().isEmpty()) {
				if (!(pwdFieldPreposePwd.getText().equals(pwdFieldPreposePwdConfirmation.getText()))) {
					blnReturn = false;
					shake("Confirmation de mot de passe n'est pas égale au mot de passe");
				}
				pwdFieldPreposePwdConfirmation.clear();
			} else {
				blnReturn = false;
				shake("Une ou toutes les données sont vides");
			}
		} else if (rbAdherent.isSelected()) {
			if (!textFieldNom.getText().isEmpty() && !textFieldPrenom.getText().isEmpty()
					&& !textFieldAdresse.getText().isEmpty() && !textFieldNoTel.getText().isEmpty()) {
			} else {
				blnReturn = false;
				shake("Une ou toutes les données sont vides");
			}
		}

		if (rbAdherent.isSelected() && ListePrepose.getLstPreposeATrouver().size() == 0) {
			blnReturn = false;
			shake("!!! AUCUN PRÉPOSÉ EXISTE !!!\nVeillez créer d'abord un préposé avant de créer un adhérent");
		}

		return blnReturn;
	}

	/*
	 * TODO ajout des employées dans les fichiers sérialisés
	 */
	private void ajoutEmploye() {
		if (rbAdherent.isSelected()) {
			ListeAdherant.ajouterAdherant(new Adherent(textFieldNom.getText(), textFieldPrenom.getText(),
					textFieldAdresse.getText(), textFieldNoTel.getText()));
		}

		else if (rbPrepose.isSelected()) {
			Random noEmploye = new Random();

			// entre 1000000 et 9999999 inclusif
			int bonNo = noEmploye.nextInt((9999999 - 1000000) + 1) + 1000000;
			for (int i = 0; i < ListePrepose.getLstPreposeATrouver().size(); i++) {
				if (ListePrepose.getLstPreposeATrouver().get(i).getStrNoPrepose().equals(Integer.toString(bonNo))) {
					bonNo = noEmploye.nextInt((9999999 - 1000000) + 1) + 1000000;
					i = 0;
				}
			}
			ListePrepose.ajouterPrepose(
					new Prepose(textFieldNom.getText(), textFieldPrenom.getText(), textFieldAdresse.getText(),
							textFieldNoTel.getText(), Integer.toString(bonNo), pwdFieldPreposePwd.getText()));

			// System.out.println("Votre numéro d'employé est : " +
			// Integer.toString(bonNo));

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText(
					"Veillez prendre en note que le numéro d'employé qui vous a été attribué est le suivant : "
							+ Integer.toString(bonNo));

			alert.showAndWait();
		}

	}

	private class GestionInscription implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == rbPrepose) {
				inscriptionAdherent(false);
				inscriptionPrepose(true);

				pwdFieldPreposePwd.clear();
				pwdFieldPreposePwdConfirmation.clear();

				pwdFieldPreposePwd.requestFocus();
			} else if (event.getSource() == rbAdherent) {
				inscriptionPrepose(false);
				inscriptionAdherent(true);

				pwdFieldPreposePwd.clear();
				pwdFieldPreposePwdConfirmation.clear();
			} else if (event.getSource() == btnInscription) {
				if (inscription()) {
					retourSansErreur();

					ajoutEmploye();

					thisStage.close();

					// si la fenetre est le login
					if (blnLogin) {
						System.out.println("La fenetre precedente est une fenetre login. booPremiereFois est mis a false");
						
						Login login = new Login();
						try {
							login.booPremiereFois = false;
							login.start(new Stage());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} 
					// si la fenetre est gerer les adherents
					else {
						System.out.println("La fenetre precedente est une fenetre de gestion des adherents");
						
						new GererLesAdherents().show();
					}
				}
			} else if (event.getSource() == btnAnnuler) {
				/*thisStage.close();

				retourApresBonneInscription();*/
				
				retour(event);
			}
		}

	}

	private class GestionClavier implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent event) {
			if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.ENTER) {
				if (inscription()) {
					retourSansErreur();
					
					ajoutEmploye();
					
					thisStage.close();

					// si la fenetre est le login
					if (blnLogin) {
						System.out.println("La fenetre est une fenetre login. booPremiereFois est mis a false");
						
						Login login = new Login();
						try {
							login.booPremiereFois = false;
							login.start(new Stage());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} 
					// si la fenetre est gerer les adherents
					else {
						System.out.println("La fenetre precedente est une fenetre de gestion des adherents");
						new GererLesAdherents().show();
					}
				}
			}
		}

	}

	/*private void quitter(Event event) {
		event.consume();

		ButtonType btnTypeSave = new ButtonType("Sauvegarder", ButtonBar.ButtonData.OK_DONE),
				btnTypeClose = new ButtonType("Quitter", ButtonBar.ButtonData.OK_DONE),
				btnTypeAnnuler = new ButtonType("Rester", ButtonBar.ButtonData.CANCEL_CLOSE);

		Alert alert = new Alert(AlertType.CONFIRMATION, "Êtes-vous sûr de vouloir quitter l'application ?", btnTypeSave,
				btnTypeClose, btnTypeAnnuler);

		alert.setTitle("Confirmation");
		alert.setHeaderText("Confirmation");

		alert.showAndWait().ifPresent(response -> {
			if (response == btnTypeSave) {
				Serialisation.getInstance();
				System.exit(0);

			} else if (response == btnTypeClose) {
				System.exit(0);
			}
		});
	}*/
	
	private void retour(Event e) {		
		e.consume();

		ButtonType btnTypeSave = new ButtonType("Retour " + (blnLogin ? "au login" : "à la bibliothèque"), ButtonBar.ButtonData.OK_DONE),
				btnTypeAnnuler = new ButtonType("Rester", ButtonBar.ButtonData.CANCEL_CLOSE);
             
		Alert alert = new Alert(AlertType.CONFIRMATION, "Êtes-vous sûr de vouloir retourner " + (blnLogin ? "au login" : "à la bibliothèque") + "  ?",
				btnTypeSave, btnTypeAnnuler);

		alert.setTitle("Confirmation");
		alert.setHeaderText("Confirmation");

		alert.showAndWait().ifPresent(response -> {
			if (response == btnTypeSave) {
				/*
				 * try {
						login.booPremiereFois = false;
						login.start(new Stage());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 */		
				thisStage.close();

				// si la fenetre est le login
				if (blnLogin) {
					System.out.println("La fenetre est une fenetre login. booPremiereFois est mis a false");
					
					Login login = new Login();
					try {
						login.booPremiereFois = false;
						login.start(new Stage());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				// si la fenetre est gerer les adherents
				else {
					System.out.println("La fenetre precedente est une fenetre de gestion des adherents");
					new GererLesAdherents().show();
				}
			}
		});
	}

	private void retourSansErreur() {
		rbPrepose.setTextFill(Color.WHITE);
		rbAdherent.setTextFill(Color.WHITE);

		for (Label lbl : arrLbl) {
			lbl.setTextFill(Color.WHITE);
		}
		if (blnProfPasDeStyle) {
			for (TextField textField : arrTextField) {
				textField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
						new BorderWidths(1))));
			}
			for (PasswordField passwordField : arrPwdField) {
				passwordField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
						CornerRadii.EMPTY, new BorderWidths(1))));
			}
		}
		lblMsgErreur.setText("");
	}

	private Font font(int intSize, FontWeight fontWeight) {
		return Font.font("Serif", fontWeight == null ? FontWeight.NORMAL : fontWeight, intSize);
	}
}