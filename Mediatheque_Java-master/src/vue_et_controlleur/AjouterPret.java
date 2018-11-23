package vue_et_controlleur;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Objet.Adherent;
import Objet.DVD;
import Objet.Document;
import Objet.ListDocument;
import Objet.ListeAdherant;
import Objet.ListeDVD;
import Objet.ListeLivre;
import Objet.ListePeriodique;
import Objet.ListePret;
import Objet.Livre;
import Objet.Periodique;
import Objet.Pret;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AjouterPret extends Stage {
	String strDateEffectiveRetour;
	String strNoAdherent;
	String strNoDoc;
	String strAmende;
	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar = Calendar.getInstance();

	TextField txtNoDoc = new TextField();
	TextField txtAmende = new TextField();
	Date actuelle = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String dateDuJour = ft.format(calendar.getTime());
	String dateRetour = "";
	Document documentSelectionne = BibliothequePrepose.document;

	public AjouterPret() {
		try {

			VBox root = createVbox();
			Scene scene = new Scene(root, 400, 550);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.setScene(scene);
			this.setTitle("Ajouter Nouveau Prêt");
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

		Label lblInfo = new Label("À qui voulez-vous prêter le " + documentSelectionne.getNoDoc() + " ?");
		lblInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		lblInfo.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(lblInfo);

		vBox.getChildren().addAll(createLivreVbox());

		return vBox;
	}

	public VBox createLivreVbox() {
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		ListView<String> list = new ListView<String>();
		ArrayList<String> listNomPrenomAdherent = new ArrayList<>();
		for (int i = 0; i < ListeAdherant.lstAdherantATrouver.size(); i++) {
			listNomPrenomAdherent.add(ListeAdherant.lstAdherantATrouver.get(i).getStrNom() + ", "
					+ ListeAdherant.lstAdherantATrouver.get(i).getStrPrenom());
		}
		ObservableList<String> items = FXCollections.observableArrayList(listNomPrenomAdherent);
		list.setItems(items);
		// list.setPrefWidth(100);
		// list.setPrefHeight(70);

		HBox hbox = new HBox();
		Button btnConfirmer = new Button("Confirmer");
		btnConfirmer.setOnAction(e -> {
			boolean booEndette = false;
			String strAdherantSelectionne = list.getSelectionModel().getSelectedItem();
			if (strAdherantSelectionne == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText("");
				alert.setContentText("Veuillez selectionner l'adhérent qui prête ce document");
				alert.showAndWait();
			} else {
				for (int i = 0; i < ListePret.getLstPretATrouver().size(); i++) {
					if ((ListePret.getLstPretATrouver().get(i).getAdherent().getStrNom() + ", "
							+ ListePret.getLstPretATrouver().get(i).getAdherent().getStrPrenom())
									.equals(strAdherantSelectionne)) {
						if (ListePret.getLstPretATrouver().get(i).getDbAmende().equals("0")) {
							booEndette = true;
						}
					}
				}
				if (!booEndette) {
					int nbLivre = 0;
					int nbDVD = 0;
					int nbPeriodique = 0;
					for (int i = 0; i < ListePret.getLstPretATrouver().size(); i++) {
						if (strAdherantSelectionne
								.equals(ListePret.getLstPretATrouver().get(i).getAdherent().getStrNom() + ", "
										+ ListePret.getLstPretATrouver().get(i).getAdherent().getStrPrenom())) {
							if (ListePret.getLstPretATrouver().get(i).getNoDoc().getNoDoc().substring(0, 1)
									.equals("D")) {
								nbDVD++;
							} else if (ListePret.getLstPretATrouver().get(i).getNoDoc().getNoDoc().substring(0, 1)
									.equals("L")) {
								nbLivre++;
							} else if (ListePret.getLstPretATrouver().get(i).getNoDoc().getNoDoc().substring(0, 1)
									.equals("P")) {
								nbPeriodique++;
							}
						}
					}
					String strNoDoc = documentSelectionne.getNoDoc();
					String strPremiereLettreNoDoc = strNoDoc.substring(0, 1);
					// System.out.println("DVD " + nbDVD + " " + "\nLivre " + nbLivre + " " +
					// "\nPeriodique " + nbPeriodique );
					if (nbDVD < 2) {
						if (strPremiereLettreNoDoc.equals("D")) {
							calendar.add(Calendar.DATE, 7);
							dateRetour = ft.format(calendar.getTime());
							for (int i = 0; i < ListeDVD.getLstDVDATrouver().size(); i++) {
								if (ListeDVD.getLstDVDATrouver().get(i).getNoDoc()
										.equals(documentSelectionne.getNoDoc())) {
									ListeDVD.getLstDVDATrouver().get(i).setEtat("Emprunté");
								}
							}
							/*
							 * for (DVD d : DVD) { if (d.getNoDoc().equals(strNoDoc)) {
							 * ListeDVD.supprimerDVD(d); } }
							 */

						}
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erreur");
						alert.setHeaderText("");
						alert.setContentText(
								"Cet adhérent a déja emprunté 2 DVD sans les retourner. Il ne peut donc pas en emprunter un autre");
						alert.showAndWait();
					}
					if (nbLivre < 3) {
						if (strPremiereLettreNoDoc.equals("L")) {
							for (int i = 0; i < ListeLivre.getLstLivreATrouver().size(); i++) {
								if (ListeLivre.getLstLivreATrouver().get(i).getNoDoc()
										.equals(documentSelectionne.getNoDoc())) {
									ListeLivre.getLstLivreATrouver().get(i).setEtat("Emprunté");
								}
							}
							calendar.add(Calendar.DATE, 14);
							dateRetour = ft.format(calendar.getTime());
							/*
							 * for (Livre l : livre) { if (l.getNoDoc().equals(strNoDoc)) {
							 * ListeLivre.supprimerLivre(l); } }
							 */
						}
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erreur");
						alert.setHeaderText("");
						alert.setContentText(
								"Cet adhérent a déja emprunté 3 Livre sans les retourner. Il ne peut donc pas en emprunter un autre");
						alert.showAndWait();
					}
					if (nbPeriodique < 1) {
						if (strPremiereLettreNoDoc.equals("P")) {
							for (int i = 0; i < ListePeriodique.getLstPeriodiqueATrouver().size(); i++) {
								if (ListePeriodique.getLstPeriodiqueATrouver().get(i).getNoDoc()
										.equals(documentSelectionne.getNoDoc())) {
									ListePeriodique.getLstPeriodiqueATrouver().get(i).setEtat("Emprunté");
								}
							}

							calendar.add(Calendar.DATE, 3);
							dateRetour = ft.format(calendar.getTime());
							/*
							 * for (Periodique p : periodique) { if (p.getNoDoc().equals(strNoDoc)) {
							 * ListePeriodique.supprimerPeriodique(p); } }
							 */
						}
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erreur");
						alert.setHeaderText("");
						alert.setContentText(
								"Cet adhérent a déja emprunté 3 périodique sans les retourner. Il ne peut donc pas en emprunter un autre");
						alert.showAndWait();
					}
					Adherent adherent = null;
					for (int i = 0; i < ListeAdherant.getLstAdherantATrouver().size(); i++) {
						if (strAdherantSelectionne.equals(ListeAdherant.getLstAdherantATrouver().get(i).getStrNom()
								+ ", " + ListeAdherant.getLstAdherantATrouver().get(i).getStrPrenom())) {
							adherent = ListeAdherant.getLstAdherantATrouver().get(i);
						}
					}
					ListePret.ajouterPret(new Pret(dateDuJour, dateRetour, "", adherent, documentSelectionne, "0"));
					documentSelectionne.setEtat("Emprunté");

					for (int i = 0; i < ListDocument.getLstAllDocument().size(); i++) {
						if (ListDocument.getLstAllDocument().get(i).equals(documentSelectionne)) {
							ListDocument.getLstAllDocument().get(i).setEtat("Emprunté");
						}
					}

					this.close();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Erreur");
					alert.setHeaderText("");
					alert.setContentText(
							"Cet adhérent a une dette impayée. Il doit rembourser sa dette avant de pouvoir emprunter un document");
					alert.showAndWait();
				}
			}

		});
		Button btnAnnuler = new Button("Annuler");
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(30));
		btnConfirmer.setFont(new Font(20));
		btnAnnuler.setFont(new Font(20));

		btnAnnuler.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Confirmation");
			alert.setContentText("Êtes vous sur de vouloir vous annuler ?");
			alert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					this.close();

				}
			});
		});

		/*
		 * btnConfirmer.setOnAction(e ->{ if(txtNoDoc.getText().equals("") ){ Alert
		 * alert = new Alert(AlertType.ERROR); alert.setTitle("Erreur");
		 * alert.setHeaderText("Erreur");
		 * alert.setContentText("Un des champs ci-dessus n'a pas été rempli");
		 * alert.showAndWait(); }
		 * 
		 * else {
		 * 
		 * strAmende = txtAmende.getText(); strNoDoc = txtNoDoc.getText();
		 * //ListePret.ajouterPret(new
		 * Pret("Pret"+(ListePret.getLstPretATrouver().size()+1), strDateDuJour,
		 * strDateRetourPreveu, strDateEffectiveRetour, strNoAdherent, strNoDoc,
		 * strAmende)); Alert alert = new Alert(AlertType.INFORMATION);
		 * alert.setTitle("Ajout"); alert.setHeaderText("Ajout Terminé");
		 * alert.setContentText("Le Document " + " a été prêté avec succès");
		 * alert.showAndWait(); new GererLesPrets().show(); } });
		 */

		hbox.getChildren().addAll(btnConfirmer, btnAnnuler);

		// vBox.getChildren().addAll(createDateDuJourHBox(),createDateRetourPrevuHBox(),createDateEffectiveRetourHBox(),createNoAdherentHBox(),createNoDocHBox(),createAmendeHBox(),hbox);
		vBox.getChildren().addAll(list, hbox);
		return vBox;
	}

	/*
	 * private HBox createNoPretHBox() { // TODO Auto-generated method stub HBox
	 * hBox = new HBox(); hBox.setSpacing(10); hBox.setPadding(new Insets(10));
	 * 
	 * Label lblNoPret = new Label("No Prêt ");
	 * lblNoPret.setAlignment(Pos.CENTER_LEFT);
	 * 
	 * txtNoPret.setAlignment(Pos.CENTER_RIGHT);
	 * 
	 * hBox.getChildren().addAll(lblNoPret, txtNoPret);
	 * 
	 * return hBox; }
	 */

	/*
	 * private HBox createDateDuJourHBox() { // TODO Auto-generated method stub HBox
	 * hBox = new HBox(); hBox.setSpacing(10); hBox.setPadding(new Insets(10));
	 * 
	 * Label lblDateDuJour = new Label("Date du jour : "); LocalDate aujourdhui=
	 * LocalDate.now(); //txtDateDuJour.setText(aujourdhui.getDayOfMonth()+ "-"+
	 * aujourdhui.getMonthValue()+"-" + aujourdhui.getYear());
	 * //txtDateDuJour.setEditable(false);
	 * //System.out.println(aujourdhui.getDayOfMonth()+ "/"+
	 * aujourdhui.getMonthValue()+"/" + aujourdhui.getYear());
	 * 
	 * hBox.getChildren().addAll(lblDateDuJour, txtDateDuJour);
	 * 
	 * return hBox; }
	 */

	/*
	 * private HBox createDateRetourPrevuHBox() { // TODO Auto-generated method stub
	 * HBox hBox = new HBox(); hBox.setSpacing(10); hBox.setPadding(new Insets(10));
	 * 
	 * Label lblDateEffectiveRetour = new Label("Date de Retour Prévu : ");
	 * LocalDate aujourdhui= LocalDate.now(); LocalDate pretLivre =
	 * aujourdhui.plusMonths(2); // System.out.println(pretLivre.getDayOfMonth()+
	 * "/"+ pretLivre.getMonthValue()+"/" + pretLivre.getYear());
	 * 
	 * LocalDate pretPeriodique = aujourdhui.plusDays(3);
	 * //System.out.println(pretPeriodique.getDayOfMonth()+ "/"+
	 * pretPeriodique.getMonthValue()+"/" + pretPeriodique.getYear());
	 * 
	 * LocalDate pretDVD= aujourdhui.plusWeeks(1);
	 * System.out.println(pretDVD.getDayOfMonth()+ "/"+ pretDVD.getMonthValue()+"/"
	 * + pretDVD.getYear());
	 * 
	 * hBox.getChildren().addAll(lblDateEffectiveRetour, txtDateEffectiveRetour);
	 * 
	 * return hBox; }
	 */

	/*
	 * private HBox createDateEffectiveRetourHBox() { // TODO Auto-generated method
	 * stub HBox hBox = new HBox(); hBox.setSpacing(10); hBox.setPadding(new
	 * Insets(10));
	 * 
	 * Label lblDateRetourPreveu = new Label(" Date de Retour effective");
	 * 
	 * 
	 * hBox.getChildren().addAll(lblDateRetourPreveu, txtDateRetourPreveu);
	 * 
	 * return hBox; }
	 */

	/*
	 * private HBox createNoAdherentHBox() { // TODO Auto-generated method stub HBox
	 * hBox = new HBox(); hBox.setSpacing(10); hBox.setPadding(new Insets(10));
	 * 
	 * Label lblNoAdhérent = new Label("No Adhérent ");
	 * 
	 * 
	 * hBox.getChildren().addAll(lblNoAdhérent, txtNoAdherent);
	 * 
	 * return hBox; }
	 */

	/*
	 * private HBox createNoDocHBox() { // TODO Auto-generated method stub HBox hBox
	 * = new HBox(); hBox.setSpacing(10); hBox.setPadding(new Insets(10));
	 * 
	 * Label lblNoDoc = new Label("No Document");
	 * 
	 * 
	 * hBox.getChildren().addAll(lblNoDoc, txtNoDoc);
	 * 
	 * return hBox; }
	 */

	/*
	 * private HBox createAmendeHBox() { // TODO Auto-generated method stub HBox
	 * hBox = new HBox(); hBox.setSpacing(10); hBox.setPadding(new Insets(10));
	 * 
	 * Label lblAmende = new Label("Amende"); txtAmende.setText("0");
	 * txtAmende.setEditable(false);
	 * 
	 * hBox.getChildren().addAll(lblAmende, txtAmende);
	 * 
	 * return hBox; }
	 */

}
