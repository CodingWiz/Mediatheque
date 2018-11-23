package vue_et_controlleur;

import Objet.ListDocument;
import Objet.ListeDVD;
import Objet.ListeLivre;
import Objet.ListePeriodique;
import Objet.ListePret;
import Objet.Pret;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
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

public class GererLesPrets extends Stage {

	private TableView<Pret> tablePret = new TableView<Pret>();
	private ObservableList<Pret> pret = FXCollections.observableArrayList(ListePret.getLstPretATrouver());

	ListView<Pret> lstviewPret = new ListView<>(pret);

	public GererLesPrets() {
		this.setOnCloseRequest(e -> {
			retourABibliotheque(e);
		});

		try {
			HBox root = createHBox();
			Scene scene = new Scene(root, 960, 435);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Gérer prêt");
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
		// Button btnModifier = new Button("Modifier");
		Button btnFaireRetour = new Button("Faire retour");
		btnFaireRetour.setOnAction(e -> {
			Pret pretDoc = tablePret.getSelectionModel().getSelectedItem();

			if (pretDoc == null /* tablePret.getSelectionModel().getSelectedItem().equals(null) */) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText("Erreur");
				alert.setContentText("Veuillez sélectionner le prêt de la liste que vous voudriez retourner");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Êtes-vous sûr de vouloir vous retourner ce prêt ?");
				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {
						Pret Pret = tablePret.getSelectionModel().getSelectedItem();
						for (int i = 0; i < ListDocument.getLstAllDocument().size(); i++) {
							if (ListDocument.getLstAllDocument().get(i).getNoDoc().equals(Pret.getNoDoc().getNoDoc())) {
								ListDocument.getLstAllDocument().get(i).setEtat("Disponible");
							}
						}
						for (int i = 0; i < ListeDVD.getLstDVDATrouver().size(); i++) {
							if (ListeDVD.getLstDVDATrouver().get(i).getNoDoc().equals(Pret.getNoDoc().getNoDoc())) {
								ListeDVD.getLstDVDATrouver().get(i).setEtat("Disponible");
							}
						}
						for (int i = 0; i < ListeLivre.getLstLivreATrouver().size(); i++) {
							if (ListeLivre.getLstLivreATrouver().get(i).getNoDoc().equals(Pret.getNoDoc().getNoDoc())) {
								ListeLivre.getLstLivreATrouver().get(i).setEtat("Disponible");
							}
						}
						for (int i = 0; i < ListePeriodique.getLstPeriodiqueATrouver().size(); i++) {
							if (ListePeriodique.getLstPeriodiqueATrouver().get(i).getNoDoc()
									.equals(Pret.getNoDoc().getNoDoc())) {
								ListePeriodique.getLstPeriodiqueATrouver().get(i).setEtat("Disponible");
							}
						}
						int index = 0;
						for (int i = 0; i < ListePret.getLstPretATrouver().size(); i++) {
							if (ListePret.getLstPretATrouver().get(i) == Pret) {
								index = i;
							}
						}
						pret.remove(index);
						ListePret.supprimerPret(Pret);

					}
				});
			}
		});

		Button btnRetour = new Button("Retour à la bibliothèque");
		/*
		 * Button btnRetourner = new Button("Retour aux Actions");
		 * btnRetourner.setOnAction(e-> { this.close(); new ActionPrepose().show(); });
		 */

		btnRetour.setOnAction(e -> {
			retourABibliotheque(e);
		});

		vBox.getChildren().addAll(createVboxImage(), btnFaireRetour, btnRetour);

		return vBox;
	}

	private VBox createVboxImage() {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		Image bibliotheque = new Image("prêt.png", 144, 74, true, true);
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
		/*
		 * for(int i = 0; i<ListePret.getLstPretATrouver().size();i++){
		 * pret.add(ListePret.getLstPretATrouver().get(i));
		 * 
		 * }
		 */
		TableColumn<Pret, String> colonneDateDuJour = new TableColumn<Pret, String>("Date du prêt");
		TableColumn<Pret, String> colonneDateRetourPreveu = new TableColumn<Pret, String>("Date de retour prevu");
		TableColumn<Pret, String> colonneDateEffectiveRetour = new TableColumn<Pret, String>(
				"Date effective du retour");
		TableColumn<Pret, String> colonneNoAdherent = new TableColumn<Pret, String>("Nom et prénom de L'adhérent");
		TableColumn<Pret, String> colonneNoDoc = new TableColumn<Pret, String>("Numéro du document");
		tablePret.getColumns().addAll(colonneDateDuJour, colonneDateRetourPreveu, colonneDateEffectiveRetour,
				colonneNoAdherent, colonneNoDoc);

		colonneDateDuJour.setCellValueFactory(new PropertyValueFactory<>("dateDePret"));
		colonneDateRetourPreveu.setCellValueFactory(new PropertyValueFactory<>("dateRetourPreveu"));
		colonneDateEffectiveRetour.setCellValueFactory(new PropertyValueFactory<>("dateEffectiveRetour"));
		colonneNoAdherent.setCellValueFactory(new PropertyValueFactory<>("Adherent"));
		colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));

		tablePret.autosize();
		tablePret.setItems(pret);

		vBox.getChildren().addAll(tablePret);

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
