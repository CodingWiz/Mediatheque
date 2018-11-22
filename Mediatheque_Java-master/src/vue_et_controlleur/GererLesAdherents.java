package vue_et_controlleur;

import java.util.ArrayList;

import Objet.Adherent;
import Objet.ListeAdherant;
import Objet.ListePret;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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

public class GererLesAdherents extends Stage {
	public static Adherent adherentSelectionne = null;
	private final TableView<Adherent> tableAdherent = new TableView<Adherent>();
	private final ObservableList<Adherent> adherent = FXCollections
			.observableArrayList(ListeAdherant.getLstAdherantATrouver());
	// private final ObservableList<Adherent> adherent = null;

	public GererLesAdherents() {
		try {
			this.setOnCloseRequest(e -> {
				retourABibliotheque(e);
			});

			HBox root = createHBox();
			Scene scene = new Scene(root, 960, 435);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Gérer Les adhérents");
			this.sizeToScene();
			this.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HBox createHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.getChildren().addAll(createTablePretVBox(), createVboxFiltres());

		return hBox;
	}

	private VBox createVboxFiltres() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(20);
		vBox.setSpacing(40);
		vBox.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vBox.setMaxWidth(300);
		vBox.setAlignment(Pos.CENTER);

		// Button btnAjouterAdherent = new Button(" Ajouter Adhérent");
		Button btnSupprimerAdherent = new Button("Supprimer Adhérent");
		btnSupprimerAdherent.setOnAction(e -> {
			Adherent adherent = tableAdherent.getSelectionModel().getSelectedItem();
			if (tableAdherent.getSelectionModel().getSelectedItem() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText("");
				alert.setContentText("Veuillez séléctionner l'adhérent que vous aimeriez supprimer");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Êtes vous sur de vouloir supprimer " + adherent.getStrNom() + ", "
						+ adherent.getStrPrenom() + "?");
				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {
						ListeAdherant.supprimerAdherant(tableAdherent.getSelectionModel().getSelectedItem());
						Alert alertInfo = new Alert(AlertType.INFORMATION);
						alertInfo.setTitle("Succes");
						alertInfo.setHeaderText("");
						alertInfo.setContentText("L'adherent " + adherent.getStrNom() + ", " + adherent.getStrPrenom()
								+ " a été supprimé");
						alertInfo.showAndWait();
					}
				});

			}
		});
		Button btnRetourner = new Button("Retour à la bibliothèque");
		Button btnInfoDetaille = new Button("Information détaillées");
		btnInfoDetaille.setOnAction(e -> {
			if (tableAdherent.getSelectionModel().getSelectedItem() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText("");
				alert.setContentText(
						"Veuillez selectionner l'adhérent pour qui vous aimeriez voir les informations détaillées");
				alert.showAndWait();
			} else {
				adherentSelectionne = tableAdherent.getSelectionModel().getSelectedItem();
				new CompteAdherent().show();
			}
		});

		btnRetourner.setOnAction(e -> {			
			retourABibliotheque(e);
		});

		vBox.getChildren().addAll(createVboxImage(), btnSupprimerAdherent, btnInfoDetaille, btnRetourner);

		return vBox;
	}

	private VBox createVboxImage() {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		Image bibliotheque = new Image("adhérent.png");
		vBox.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vBox.getChildren().add(new ImageView(bibliotheque));

		return vBox;
	}

	@SuppressWarnings("unchecked")
	private VBox createTablePretVBox() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);
		vBox.setPrefSize(770, 420);
		TableColumn<Adherent, String> colonneNom = new TableColumn<Adherent, String>("Nom");
		TableColumn<Adherent, String> colonnePrenom = new TableColumn<Adherent, String>("Prenom");
		TableColumn<Adherent, String> colonneAdresse = new TableColumn<Adherent, String>("Adresse");
		TableColumn<Adherent, Integer> colonneNoTélephone = new TableColumn<Adherent, Integer>("Numéro du télephone");

		tableAdherent.getColumns().addAll(colonneNom, colonnePrenom, colonneAdresse, colonneNoTélephone);

		colonneNom.setCellValueFactory(new PropertyValueFactory<>("strNom"));
		colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("strPrenom"));
		colonneAdresse.setCellValueFactory(new PropertyValueFactory<>("strAdresse"));
		colonneNoTélephone.setCellValueFactory(new PropertyValueFactory<>("strTelephone"));
		tableAdherent.autosize();
		tableAdherent.setItems(adherent);

		vBox.getChildren().addAll(tableAdherent);

		return vBox;
	}
	
	private void retourABibliotheque(Event e) {
		e.consume();

		ButtonType btnTypeSave = new ButtonType("Retour à bibliothèque", ButtonBar.ButtonData.OK_DONE),
				btnTypeAnnuler = new ButtonType("Rester", ButtonBar.ButtonData.CANCEL_CLOSE);

		Alert alert = new Alert(AlertType.CONFIRMATION, "Êtes-vous sûr de vouloir retourner à la bibliothèque ?",
				btnTypeSave, btnTypeAnnuler);

		alert.setTitle("Confirmation");
		alert.setHeaderText("Confirmation");

		alert.showAndWait().ifPresent(response -> {
			if (response == btnTypeSave) {
				/*
				 * TODO check qui est connecte
				 */
				this.close();

				new BibliothequePrepose().show();
			}
		});
	}
}
