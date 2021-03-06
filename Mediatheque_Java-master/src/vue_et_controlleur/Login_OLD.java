package vue_et_controlleur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @web http://zoranpavlovic.blogspot.com/
 */
public class Login_OLD extends Application {

	String user = "JavaFX2", pw = "password";
	String checkUser, checkPw;

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 50, 50, 50));

		Scene scene = new Scene(root, 410, 307);

		// Adding HBox
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("No. de l'employ� : "), lblPassword = new Label("Mot de passe : ");
		;
		TextField txtUserName = new TextField();
		PasswordField pwdField = new PasswordField();
		Button btnLogin = new Button("Login");
		Label lblMessage = new Label();

		lblUserName.setTextFill(Color.WHITE);
		lblPassword.setTextFill(Color.WHITE);

		// Adding Nodes to GridPane layout
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pwdField, 1, 1);
		gridPane.add(btnLogin, 2, 1);
		gridPane.add(lblMessage, 1, 2);

		// Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		/*
		 * Text text = new Text("JavaFX 2 Login"); text.setFont(Font.font("Courier New",
		 * FontWeight.BOLD, 28)); text.setEffect(dropShadow);
		 */

		// Adding text to HBox
		// hBox.getChildren().add(text);

		// Add ID's to Nodes
		root.setId("root");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		// text.setId("text");

		// Action for btnLogin
		btnLogin.setOnAction(e -> {
			checkUser = txtUserName.getText().toString();
			checkPw = pwdField.getText().toString();
			if (checkUser.equals(user) && checkPw.equals(pw)) {
				lblMessage.setText("Congratulations!");
				lblMessage.setTextFill(Color.GREEN);
			} else {
				lblMessage.setText("Incorrect user or pw.");
				lblMessage.setTextFill(Color.RED);
			}
			txtUserName.setText("");
			pwdField.setText("");
		});

		// Add HBox and GridPane layout to BorderPane Layout
		root.setTop(hBox);
		root.setCenter(gridPane);
		root.setBackground(new Background(new BackgroundImage(new Image(
				"./modele/page-ipad-ipad-ipad-mini-library-wallpapers-hd-desktop-1024768-library-clipart-background-1024_768.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(410, 307, false, false, false, false))));

		// Adding BorderPane to the scene and loading CSS
		// scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
		primaryStage.setScene(scene);
		/*
		 * primaryStage.titleProperty().bind( scene.widthProperty().asString().
		 * concat(" : "). concat(scene.heightProperty().asString()));
		 */
		// primaryStage.setResizable(false);
		primaryStage.setTitle("Bienvenue � la m�diath�que");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}