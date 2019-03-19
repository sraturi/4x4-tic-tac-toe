package ca.cmpt213.asn4.tictactoe.game.ui;

import ca.cmpt213.asn4.tictactoe.game.model.Game;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * this is the Main Application class that setups the game and the UI.
 */
public class TicTacToe extends Application {
    private Button newGameButton;
    private GameController gameController;
    private Label gameInfoLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        newGameButton = new Button("NEW GAME");
        setupGame(primaryStage);
        newGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setupGame(primaryStage);
            }
        });

    }

    private void setupGame(Stage primaryStage) {
        gameInfoLabel = new Label();
        gameController = new GameController(gameInfoLabel);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(getInitialScene());
        primaryStage.show();
    }

    private Scene getInitialScene() {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        //setting up image view
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                CustomImageView imageView = null;

                Image image = new Image("file:images/blank.jpg");
                imageView = new CustomImageView(i, j, image);
                imageView.setFitHeight(150);
                imageView.setFitWidth(150);
                imageView.setOnMouseClicked(gameController);
                HBox h = new HBox(imageView);
                h.setPadding(new Insets(3));
                gridPane.add(h, i, j);
            }
        }
        borderPane.setPadding(new Insets(20));
        borderPane.setCenter(gridPane);

        gameInfoLabel.setTextAlignment(TextAlignment.CENTER);
        gameInfoLabel.setTextFill(Color.rgb(34, 155, 56));
        gameInfoLabel.setText("The Game is in progess");

        newGameButton.setMinWidth(100);
        newGameButton.setMinHeight(50);
        newGameButton.setCenterShape(true);
        HBox hBox = new HBox(newGameButton, gameInfoLabel);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(40);


        borderPane.setBottom(hBox);

        return new Scene(borderPane);
    }
}
