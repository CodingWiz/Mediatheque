package vue_et_controlleur;

import java.util.ArrayList;

import Objet.Pret;
import Objet.Adherent;
import Objet.Document;
import Objet.ListePret;
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

public class CompteAdherent extends Stage {
	private final TableView<Pret> tablePret = new TableView<Pret>();

	TextField txtMotscles = new TextField();
	int intDetteTotal = 0;
	ArrayList<Pret> lstAllPret = ListePret.getLstPretATrouver();
	ArrayList<Pret> lstPret = new ArrayList<>();

	private ObservableList<Pret> pret = null;

	Image imaTous = new Image("tous.jpg", 25, 25, true, true);
	ImageView imTous = new ImageView(imaTous);
	Image imaPeriodique = new Image("periodique.jpg", 25, 25, true, true);
	ImageView imPeriodique = new ImageView(imaPeriodique);
	Image imalivres = new Image("livres.jpg", 25, 25, true, true);
	ImageView imlivres = new ImageView(imalivres);
	Image imaDVD = new Image("dvd.gif", 25, 25, true, true);
	ImageView imDVD = new ImageView(imaDVD);
	Adherent adherent = GererLesAdherents.adherentSelectionne;

	public CompteAdherent() {

		try {
			HBox root = createHBox();
			Scene scene = new Scene(root, 890, 435);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Compte Adhérent");
			this.sizeToScene();
			this.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HBox createHBox() {
		// TODO Auto-generated method stub

		VBox vbTest = new VBox();
		Label lblNomComplet = new Label(adherent.getStrNom() + ", " + adherent.getStrPrenom());
		HBox hBox = new HBox();
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

		vbTest.getChildren().addAll(lblNomComplet, tabPane);

		hBox.getChildren().addAll(vbTest, createVboxFiltres());

		return hBox;
	}

	private VBox createVboxFiltres() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(40);
		vBox.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vBox.setMaxWidth(300);
		vBox.setAlignment(Pos.CENTER);
		ObservableList<String> options = FXCollections.observableArrayList("Tous", "Prêt", "Disponible");
		final ComboBox<String> comboBox = new ComboBox<String>(options);
		comboBox.setValue("Tous");
		Button btnEffacerFiltres = new Button("Éffacer les filtres");

		btnEffacerFiltres.setOnAction(e -> {
			txtMotscles.clear();
			comboBox.setValue("Tous");
		});

		Button btnRetour = new Button("Retour à la gestion des adhérents");
		btnRetour.setOnAction(e -> {
			this.close();
		});

		vBox.getChildren().addAll(createVboxImage(), createHboxMotsCles(), comboBox, btnEffacerFiltres, btnRetour);

		return vBox;
	}

	private VBox createVboxImage() {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		Image bibliotheque = new Image("compte.jpg", 120, 100, true, true);
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

	@SuppressWarnings("unchecked")
	private VBox createTablePretVBox() {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);
		// System.out.println(adherent);
		for (int i = 0; i < ListePret.getLstPretATrouver().size(); i++) {
			// System.out.println("adhérent sélectionné :" + adherent.getStrNom() + " " +
			// "adherent de la liste : " +
			// ListePret.getLstPretATrouver().get(i).getAdherent().getStrNom() );
			if (ListePret.getLstPretATrouver().get(i).getAdherent().getStrTelephone()
					.equals(adherent.getStrTelephone())) {
				lstPret.add(ListePret.getLstPretATrouver().get(i));
				// System.out.println("Je rentre par la");
				intDetteTotal += Integer.parseInt(ListePret.getLstPretATrouver().get(i).getDbAmende());
			}
		}

		Label lblDetteTotal = new Label("Dette Total : " + intDetteTotal);

		lblDetteTotal.setFont(new Font(20));
		// TextField tbDetteTotal = new TextField();
		for (int i = 0; i < lstPret.size(); i++) {
			// System.out.println(lstPret.get(i).toString());
		}

		pret = FXCollections.observableArrayList(lstPret);

		// tbDetteTotal.setFont(new Font(15));
		TableColumn<Pret, String> colonneDateEmpruntPreveu = new TableColumn<Pret, String>("Date d'emprunt ");

		TableColumn<Pret, String> colonneDateRetourPreveu = new TableColumn<Pret, String>("Date du retour prevu ");
		TableColumn<Pret, String> colonneDateEffectiveRetour = new TableColumn<Pret, String>(
				"Date du retour effective");
		TableColumn<Pret, Document> colonneNoDoc = new TableColumn<Pret, Document>("Numéro du document");
		TableColumn<Pret, Double> colonneAmande = new TableColumn<Pret, Double>("Amende");
		tablePret.getColumns().addAll(colonneNoDoc, colonneDateEmpruntPreveu, colonneDateRetourPreveu, colonneDateEffectiveRetour, colonneAmande);

		HBox hboxDetteTotal = new HBox();
		hboxDetteTotal.setPadding(new Insets(15));
		hboxDetteTotal.setSpacing(15);
		hboxDetteTotal.getChildren().addAll(lblDetteTotal);

		colonneNoDoc.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
		colonneDateEmpruntPreveu.setCellValueFactory(new PropertyValueFactory<>("dateDePret"));
		colonneDateRetourPreveu.setCellValueFactory(new PropertyValueFactory<>("dateRetourPreveu"));
		colonneDateEffectiveRetour.setCellValueFactory(new PropertyValueFactory<>("dateEffectiveRetour"));
		colonneAmande.setCellValueFactory(new PropertyValueFactory<>("dbAmende"));

		tablePret.autosize();
		tablePret.setItems(pret);

		vBox.getChildren().addAll(tablePret, hboxDetteTotal);

		return vBox;
	}

}
