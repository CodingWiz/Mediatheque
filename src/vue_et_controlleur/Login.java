package vue_et_controlleur;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Skin;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Login extends Application {
	
	boolean blnProfPasDeStyle = true;

	TextField txtUserName;
	PasswordField pwdField;
	
	Button btnConnexion;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		
		Scene scene = new Scene(root, 410, 307);
		
		//Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        //gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        /*Text text = new Text("Veillez vous identifier");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFill(Color.WHITE);
        text.setFont(font(40, FontWeight.BOLD));*/
        
        //Implementing Nodes for GridPane
        Label lblUserName = new Label("No. de l'employé :"), lblPassword = new Label("Mot de passe :");
        txtUserName = new TextField();
        pwdField = new PasswordField();
        btnConnexion = new Button("Connexion");
        //Label lblMessage = new Label();
        
        lblUserName.setTextFill(Color.WHITE);
        lblPassword.setTextFill(Color.WHITE);
        
        lblUserName.setTextAlignment(TextAlignment.RIGHT);
        lblPassword.setTextAlignment(TextAlignment.RIGHT);
        
        lblUserName.setAlignment(Pos.CENTER_RIGHT);
        lblPassword.setAlignment(Pos.CENTER_RIGHT);
        
        btnConnexion.setAlignment(Pos.CENTER_RIGHT);
        
        lblUserName.setFont(font(20, null));
        lblPassword.setFont(font(20, null));
        
        txtUserName.setFont(font(15, null));
        pwdField.setFont(font(15, null));
        
        btnConnexion.setFont(font(15, FontWeight.BOLD));
        btnConnexion.setGraphic(new ImageView(new Image("./modele/secure-icon-lock-secure-icon-27.png", 25, 25, false, false)));
        
        btnConnexion.setOnAction(new GestionConnexion());
        
        if (blnProfPasDeStyle) {
	        // https://stackoverflow.com/questions/12717487/how-to-implement-a-transparent-pane-with-non-transparent-children
	        //txtUserName.setFill(Color.WHITE);        
	        txtUserName.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10; -fx-text-inner-color: white;");
	        txtUserName.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
	        /*txtUserName.skinProperty().addListener(new ChangeListener<Skin<?>>() {
	
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
	        
	        pwdField.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10; -fx-text-inner-color: white;");
	        pwdField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(1))));
	        /*pwdField.skinProperty().addListener(new ChangeListener<Skin<?>>() {
	
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
        GridPane.setHalignment(lblUserName, HPos.RIGHT);
        GridPane.setHalignment(lblPassword, HPos.RIGHT);
        GridPane.setHalignment(btnConnexion, HPos.RIGHT);
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pwdField, 1, 1);
        gridPane.add(btnConnexion, 1, 7);
        
        //Add HBox and GridPane layout to BorderPane Layout
        
        //root.setAlignment(gridPane, Pos.CENTER);
        /*root.setMargin(text, new Insets(80, 0, 0, 0));
        root.setMargin(gridPane, new Insets(80, 0, 0, 0));*/
        BorderPane.setAlignment(gridPane, Pos.CENTER);
        root.setCenter(gridPane);
        root.setBackground(new Background(
				new BackgroundImage(new Image("./modele/page-ipad-ipad-ipad-mini-library-wallpapers-hd-desktop-1024768-library-clipart-background-1024_768.jpg"), 
												BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
												new BackgroundSize(scene.getWidth()+10, scene.getHeight()+10, false, false, false, false))));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bienvenue à la médiathèque");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private class GestionConnexion implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if (txtUserName.getText().equals("MHG") && pwdField.getText().equals("123")) {
				System.out.println("OK");
			}
			else {
				System.out.println("Pas OK");
			}
		}
		
	}
	
	private Font font(int intSize, FontWeight fontWeight) {
		return Font.font("Serif", fontWeight == null ? FontWeight.NORMAL : fontWeight, intSize);
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
