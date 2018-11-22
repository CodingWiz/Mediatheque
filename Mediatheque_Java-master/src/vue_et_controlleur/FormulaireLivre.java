package vue_et_controlleur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import Objet.Document;
import Objet.ListDocument;
import Objet.ListeLivre;
import Objet.Livre;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FormulaireLivre extends Stage {
	String strTitre;
	String strDatePublication;
	String strMotsCles;
	String strAuteur;

	TextField txtTitre = new TextField();
	DatePicker dpDatePublication = new DatePicker();
	TextField txtMotsCles = new TextField();
	TextField txtAuteur = new TextField();
	TextField txtNbDisque = new TextField();
	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

	public FormulaireLivre() {
		try {
			this.setOnCloseRequest(e->{annuler(e);});
			
			VBox root = createVbox();
			Scene scene = new Scene(root, 400, 400);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Ajouter Nouveau Livre");
			this.sizeToScene();

			this.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VBox createVbox() {

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);

		Label lblInfo = new Label("Veuillez rentrer les informations du livre");
		lblInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		lblInfo.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(lblInfo);

		vBox.getChildren().addAll(createLivreVbox());

		return vBox;
	}

	public String getStrTitre() {
		return strTitre;
	}

	public String getStrDatePublication() {
		return strDatePublication;
	}

	public String getStrMotsCles() {
		return strMotsCles;
	}

	public String getStrAuteur() {
		return strAuteur;
	}

	public VBox createLivreVbox() {
		VBox vBox = new VBox();
		vBox.setSpacing(10);

		HBox hbox = new HBox();
		Button btnConfirmer = new Button("Confirmer");
		Button btnAnnuler = new Button("Annuler");
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(30));
		btnConfirmer.setFont(new Font(20));
		btnAnnuler.setFont(new Font(20));

		btnAnnuler.setOnAction(e -> {annuler(e);});

		btnConfirmer.setOnAction(e -> {
			if (dpDatePublication.getValue() == null || txtMotsCles.getText().equals("")
					|| txtAuteur.getText().equals("") || txtTitre.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText("Erreur");
				alert.setContentText("Un des champs ci-dessus n'a pas été rempli");
				alert.showAndWait();
			}

			else {
				strDatePublication = dpDatePublication.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				strMotsCles = txtMotsCles.getText();
				strAuteur = txtAuteur.getText();
				strTitre = txtTitre.getText();
				ListeLivre.ajouterLivre(new Livre("Liv" + (ListeLivre.lstLivreATrouver.size() + 1), strTitre,
						strDatePublication, "Disponible", strMotsCles, strAuteur));
				ListDocument.ajouterDocument(new Document("Liv" + (ListeLivre.lstLivreATrouver.size()), strTitre,
						strDatePublication, "Disponible", strMotsCles));

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ajout");
				alert.setHeaderText("Ajout Terminé");
				alert.setContentText("Le périodique " + strTitre + " a été ajouté avec succès");
				alert.showAndWait();
				this.close();
				new BibliothequePrepose().show();
			}
		});

		hbox.getChildren().addAll(btnConfirmer, btnAnnuler);

		vBox.getChildren().addAll(createTitreHBox(), createDatePublicationHBox(), createAuteurHBox(),
				createMotsClesHBox(), hbox);

		return vBox;
	}

	private HBox createTitreHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));

		Label lblTitre = new Label("Titre : ");
		lblTitre.setAlignment(Pos.CENTER_LEFT);

		txtTitre.setAlignment(Pos.CENTER_RIGHT);

		hBox.getChildren().addAll(lblTitre, txtTitre);

		return hBox;
	}

	private HBox createDatePublicationHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));

		Label lblDatePublication = new Label("Date de publication : ");

		hBox.getChildren().addAll(lblDatePublication, dpDatePublication);

		return hBox;
	}

	private HBox createAuteurHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));

		Label lblAuteur = new Label("Auteur : ");

		hBox.getChildren().addAll(lblAuteur, txtAuteur);

		return hBox;
	}

	private HBox createMotsClesHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));

		Label lblMotsCles = new Label("Mots clés (séparés par espaces) : ");

		hBox.getChildren().addAll(lblMotsCles, txtMotsCles);

		return hBox;
	}

	public void lectureFichierLivre(String strNomFichier) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strNomFichier))) {
			bw.write(strMotsCles + "," + strTitre + "," + strDatePublication + "," + strAuteur);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private void annuler(Event event) {
		event.consume();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Confirmation");
		alert.setContentText("Êtes vous sur de vouloir vous annuler l'ajout ?");
		alert.showAndWait().ifPresent(response -> {
			if (response == ButtonType.OK) {
				this.close();
				//new BibliothequePrepose().show();
			}
		});
	}
}
