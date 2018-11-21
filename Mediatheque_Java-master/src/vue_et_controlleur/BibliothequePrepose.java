package vue_et_controlleur;

import java.util.ArrayList;

import Objet.DVD;
import Objet.Document;
import Objet.Livre;
import Objet.Periodique;
import Objet.ListeDVD;
import Objet.ListeLivre;
import Objet.ListePeriodique;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import Objet.LectureDesFichiers;
import Objet.ListDocument;

public class BibliothequePrepose extends Stage {

	private TableView<Document> tableDocument = new TableView<Document>();
	ArrayList<Document> lstAllDocument = new ArrayList<Document>(ListDocument.getLstAllDocument().size());
	ComboBox<String> comboBox = null;

	// ArrayList<Livre> lstAllLivre =
	// LectureDesFichiers.LireFichierLivres("Livres.txt");
	private ObservableList<Document> documents = FXCollections.observableArrayList(ListDocument.getLstAllDocument());
	ListView<Document> listView = new ListView<>(documents);
	private TableView<Periodique> tablePeriodique = new TableView<Periodique>();
	private ObservableList<Periodique> periodique = FXCollections
			.observableArrayList(ListePeriodique.getLstPeriodiqueATrouver());
	private TableView<Livre> tableLivre = new TableView<Livre>();
	private ObservableList<Livre> livre = FXCollections.observableArrayList(ListeLivre.getLstLivreATrouver());
	private TableView<DVD> tableDVD = new TableView<DVD>();
	private ObservableList<DVD> DVD = FXCollections.observableArrayList(ListeDVD.getLstDVDATrouver());

	TextField txtMotscles = new TextField();

	public BibliothequePrepose() {
		try {
			HBox root = createHBox();
			Scene scene = new Scene(root, 890, 435);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Bibliotheque");
			this.sizeToScene();
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			this.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HBox createHBox() {
		// TODO Auto-generated method stub

		Image imaTous = new Image("tous.jpg", 25, 25, true, true);
		ImageView imTous = new ImageView(imaTous);
		Image imaPeriodique = new Image("periodique.jpg", 25, 25, true, true);
		ImageView imPeriodique = new ImageView(imaPeriodique);
		Image imalivres = new Image("livres.jpg", 25, 25, true, true);
		ImageView imlivres = new ImageView(imalivres);
		Image imaDVD = new Image("dvd.gif", 25, 25, true, true);
		ImageView imDVD = new ImageView(imaDVD);
		tableDVD.setSelectionModel(null);
		tablePeriodique.setSelectionModel(null);
		tableLivre.setSelectionModel(null);
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(5));
		hBox.setSpacing(5);
		TabPane tabPane = new TabPane();
		Tab tabDocument = new Tab();
		tabDocument.setGraphic(imTous);
		tabDocument.setClosable(false);
		tabDocument.setContent(createTableDocumentVBox());
		Tab tabPeriodique = new Tab();
		tabPeriodique.setGraphic(imPeriodique);
		tabPeriodique.setClosable(false);
		tabPeriodique.setContent(createTablePeriodiqueVBox());
		Tab tabLivre = new Tab();
		tabLivre.setGraphic(imlivres);
		tabLivre.setClosable(false);
		tabLivre.setContent(createTableLivreVBox());
		Tab tabDVD = new Tab();
		tabDVD.setGraphic(imDVD);
		tabDVD.setClosable(false);
		tabDVD.setContent(createTableDVDVBox());

		tabPane.getTabs().addAll(tabDocument, tabPeriodique, tabLivre, tabDVD);
		tabPane.setPrefWidth(673);

		hBox.getChildren().addAll(tabPane, createVboxFiltres());

		return hBox;
	}

	private VBox createVboxFiltres() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(20);
		vBox.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vBox.setMaxWidth(300);
		vBox.setAlignment(Pos.CENTER);
		ObservableList<String> options = FXCollections.observableArrayList("Tous", "Prêt", "Disponible");
		comboBox = new ComboBox<String>(options);
		comboBox.setValue("Tous");

		Button btnEffacerFiltres = new Button("Éffacer les filtres");

		btnEffacerFiltres.setOnAction(e -> {
			txtMotscles.clear();
			comboBox.setValue("Tous");
		});

		Button btnNouveauDocument = new Button("Ajouter un document");
		btnNouveauDocument.setOnAction(e -> {
			this.close();
			new Ajouter().show();
		});

		Button btnSupprimerDocument = new Button("Supprimer un document");
		btnSupprimerDocument.setOnAction(e -> {
			// System.out.println("Allo");
			Document documentSelectionne = tableDocument.getSelectionModel().getSelectedItem();
			/*DVD dvdSelectionne = tableDVD.getSelectionModel().getSelectedItem();
			Livre livreSelectionne = tableLivre.getSelectionModel().getSelectedItem();
			Periodique periodiqueSelectionne = tablePeriodique.getSelectionModel().getSelectedItem();*/

			if (documentSelectionne != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Êtes vous sur de vouloir vous supprimer ce document ?");
				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {
						// System.out.println(ListeDVD.getLstDVDATrouver());
						String strNoDoc = documentSelectionne.getNoDoc();
						String strPremiereLettreNoDoc = strNoDoc.substring(0, 1);
						ListDocument.supprimerDocument(documentSelectionne);
						if (strPremiereLettreNoDoc.equals("D")) {
							for (DVD d : DVD) {
								if (d.getNoDoc().equals(strNoDoc)) {
									ListeDVD.supprimerDVD(d);
								}
							}

						} else if (strPremiereLettreNoDoc.equals("L")) {
							for (Livre l : livre) {
								if (l.getNoDoc().equals(strNoDoc)) {
									ListeLivre.supprimerLivre(l);
								}
							}
						} else if (strPremiereLettreNoDoc.equals("P")) {
							for (Periodique p : periodique) {
								if (p.getNoDoc().equals(strNoDoc)) {
									ListePeriodique.supprimerPeriodique(p);
								}
							}
						}						
					}
				});

			} /*else if (dvdSelectionne != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Êtes vous sur de vouloir vous supprimer ce DVD ?");
				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {
						String strNoDVD = dvdSelectionne.getNoDoc();
						ListeDVD.supprimerDVD(dvdSelectionne);
						for (Document d : documents) {
							if (d.getNoDoc().equals(strNoDVD)) {
								ListDocument.supprimerDocument(d);
							}
						}
					}
				});
			} else if (livreSelectionne != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Êtes vous sur de vouloir vous supprimer ce Livre ?");
				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {
						String strNoLivre = livreSelectionne.getNoDoc();
						ListeLivre.supprimerLivre(livreSelectionne);
						for (Document d : documents) {
							if (d.getNoDoc().equals(strNoLivre)) {
								ListDocument.supprimerDocument(d);
							}
						}
					}
				});
			}

			else if (periodiqueSelectionne != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Êtes vous sur de vouloir vous supprimer ce Periodique ?");
				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {
						String strNoPeriodique = periodiqueSelectionne.getNoDoc();
						ListePeriodique.supprimerPeriodique(periodiqueSelectionne);
						for (Document d : documents) {
							if (d.getNoDoc().equals(strNoPeriodique)) {
								ListDocument.supprimerDocument(d);
							}
						}
					}
				});
			}*/

			else {

				Alert alertAttention = new Alert(AlertType.WARNING);
				alertAttention.setTitle("Attention");
				alertAttention.setHeaderText("Attention");
				alertAttention.setContentText("Vous devez sélectionner le document que vous aimeriez supprimer");
				alertAttention.showAndWait();
			}
			this.close();
			new BibliothequePrepose().show();

		});

		Button btnGererAdherant = new Button("Gerer les adhérants");

		Button btnDeconnexion = new Button("Deconnexion");
		btnDeconnexion.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Confirmation");
			alert.setContentText("Êtes vous sur de vouloir vous déconnecter ?");
			alert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					this.close();
					Login login = new Login();
					try {
						login.booPremiereFois = false;
						login.start(new Stage());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		});

		vBox.getChildren().addAll(createVboxImage(), createHboxMotsCles(), comboBox, btnEffacerFiltres,
				btnNouveauDocument, btnSupprimerDocument, btnGererAdherant, btnDeconnexion);

		return vBox;
	}

	private VBox createVboxImage() {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		Image bibliotheque = new Image("biblio.png");
		ImageView bibliotheque1 = new ImageView(bibliotheque);
		vBox.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vBox.getChildren().add(bibliotheque1);

		return vBox;
	}

	private HBox createHboxMotsCles() {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(10);
		Label lblMotscles = new Label("Mots clés :");

		txtMotscles.setPrefSize(70, 20);

		hBox.getChildren().addAll(lblMotscles, txtMotscles);

		return hBox;
	}

	/*
	 * private VBox createVboxMotsCles() { VBox vBox = new VBox();
	 * vBox.setPadding(new Insets(10)); vBox.setAlignment(Pos.CENTER); Button
	 * btnRechercher = new Button("Rechercher");
	 * 
	 * vBox.getChildren().addAll(createHboxMotsCles(), btnRechercher);
	 * 
	 * return vBox;
	 * 
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	private VBox createTableDocumentVBox() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);

		/*
		 * for (int i = 0; i < ListeDVD.getLstDVDATrouver().size(); i++){
		 * lstAllDocument.add(new
		 * Document(ListeDVD.getLstDVDATrouver().get(i).getNoDoc(),ListeDVD.
		 * getLstDVDATrouver().get(i).getTitre(),ListeDVD.getLstDVDATrouver().get(i).
		 * getDateParution(),ListeDVD.getLstDVDATrouver().get(i).getEtat(),ListeDVD.
		 * getLstDVDATrouver().get(i).getMotsclés())); } for (int i = 0; i <
		 * ListeLivre.getLstLivreATrouver().size(); i++){ lstAllDocument.add(new
		 * Document(ListeLivre.getLstLivreATrouver().get(i).getNoDoc(),ListeLivre.
		 * getLstLivreATrouver().get(i).getTitre(),ListeLivre.getLstLivreATrouver().get(
		 * i).getDateParution(),ListeLivre.getLstLivreATrouver().get(i).getEtat(),
		 * ListeLivre.getLstLivreATrouver().get(i).getMotsclés())); } for (int i = 0; i
		 * < ListePeriodique.getLstPeriodiqueATrouver().size(); i++){
		 * lstAllDocument.add(new
		 * Document(ListePeriodique.getLstPeriodiqueATrouver().get(i).getNoDoc(),
		 * ListePeriodique.getLstPeriodiqueATrouver().get(i).getTitre(),ListePeriodique.
		 * getLstPeriodiqueATrouver().get(i).getDateParution(),ListePeriodique.
		 * getLstPeriodiqueATrouver().get(i).getEtat(),ListePeriodique.
		 * getLstPeriodiqueATrouver().get(i).getMotsclés())); }
		 */

		// documents = FXCollections.observableArrayList(lstAllDocument);

		TableColumn<Document, String> colonneNoDoc = new TableColumn<Document, String>("Numéro du document");
		TableColumn<Document, String> colonneTitre = new TableColumn<Document, String>("Titre");
		TableColumn<Document, String> colonneDateParution = new TableColumn<Document, String>("Date de publication");
		TableColumn<Document, String> colonneEtat = new TableColumn<Document, String>("Disponible");
		tableDocument.getColumns().addAll(colonneNoDoc, colonneTitre, colonneDateParution, colonneEtat);

		colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
		colonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		colonneDateParution.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
		colonneEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));

		tableDocument.autosize();
		tableDocument.setEditable(false);
		tableDocument.setItems(documents);

		vBox.getChildren().addAll(tableDocument);

		return vBox;
	}

	@SuppressWarnings("unchecked")
	private VBox createTablePeriodiqueVBox() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);

		TableColumn<Periodique, Integer> colonneNoDoc = new TableColumn<Periodique, Integer>("Numéro du document");
		TableColumn<Periodique, String> colonneTitre = new TableColumn<Periodique, String>("Titre");
		TableColumn<Periodique, String> colonneDateParution = new TableColumn<Periodique, String>(
				"Date de publication");
		TableColumn<Periodique, String> colonneEtat = new TableColumn<Periodique, String>("Disponible");
		TableColumn<Periodique, Integer> colonneNoVolume = new TableColumn<Periodique, Integer>("Numéro du volume");
		TableColumn<Periodique, Integer> colonneNoPeriodique = new TableColumn<Periodique, Integer>(
				"Numéro du periodique");
		tablePeriodique.getColumns().addAll(colonneNoDoc, colonneTitre, colonneDateParution, colonneEtat,
				colonneNoVolume, colonneNoPeriodique);

		colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
		colonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		colonneDateParution.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
		colonneEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
		colonneNoVolume.setCellValueFactory(new PropertyValueFactory<>("noVolume"));
		colonneNoPeriodique.setCellValueFactory(new PropertyValueFactory<>("noPeriodique"));

		tablePeriodique.autosize();
		tablePeriodique.setItems(periodique);

		vBox.getChildren().addAll(tablePeriodique);

		return vBox;
	}

	@SuppressWarnings("unchecked")
	private VBox createTableLivreVBox() {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);

		TableColumn<Livre, Integer> colonneNoDoc = new TableColumn<Livre, Integer>("Numéro du document");
		TableColumn<Livre, String> colonneTitre = new TableColumn<Livre, String>("Titre");
		TableColumn<Livre, String> colonneDateParution = new TableColumn<Livre, String>("Date de publication");
		TableColumn<Livre, String> colonneEtat = new TableColumn<Livre, String>("Disponible");
		TableColumn<Livre, String> colonneAuteur = new TableColumn<Livre, String>("Auteur");
		tableLivre.getColumns().addAll(colonneNoDoc, colonneTitre, colonneDateParution, colonneEtat, colonneAuteur);

		colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
		colonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		colonneDateParution.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
		colonneEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
		colonneAuteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));

		tableLivre.autosize();
		tableLivre.setItems(livre);

		vBox.getChildren().addAll(tableLivre);

		return vBox;
	}

	@SuppressWarnings("unchecked")
	private VBox createTableDVDVBox() {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);

		TableColumn<DVD, Integer> colonneNoDoc = new TableColumn<DVD, Integer>("Numéro du document");
		TableColumn<DVD, String> colonneTitre = new TableColumn<DVD, String>("Titre");
		TableColumn<DVD, String> colonneDateParution = new TableColumn<DVD, String>("Date de publication");
		TableColumn<DVD, String> colonneEtat = new TableColumn<DVD, String>("Disponible");
		TableColumn<DVD, Integer> colonneNbDisque = new TableColumn<DVD, Integer>("Nombres des disques");
		TableColumn<DVD, String> colonneRealisateur = new TableColumn<DVD, String>("Réalisateur");
		tableDVD.getColumns().addAll(colonneNoDoc, colonneTitre, colonneDateParution, colonneEtat, colonneNbDisque,
				colonneRealisateur);

		colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
		colonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		colonneDateParution.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
		colonneEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
		colonneNbDisque.setCellValueFactory(new PropertyValueFactory<>("nbDisque"));
		colonneRealisateur.setCellValueFactory(new PropertyValueFactory<>("realisateur"));

		tableDVD.autosize();
		tableDVD.setItems(DVD);

		vBox.getChildren().addAll(tableDVD);

		return vBox;
	}

}
