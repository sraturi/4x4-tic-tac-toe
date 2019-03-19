package ca.cmpt213.asn4.tictactoe.game.ui;

import ca.cmpt213.asn4.tictactoe.game.model.Game;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * this is the game controller class that handles the win and loose logic of the game and updates the UI.
 */
public class GameController implements EventHandler<MouseEvent> {
    private Game game;
    private Label infoLabel;
    private int totalBoxClicked;

    public GameController( Label label) {
        this.game = new Game();
        this.infoLabel = label;
        this.totalBoxClicked = 0;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        CustomImageView imageview = (CustomImageView) mouseEvent.getSource();

        if (!game.isGameWon() && !imageview.isClicked()) {
            if (game.getPlayer() == (Game.PLAYER_O)) {
                imageview.setImage(new Image("file:images/o.png"));
            } else {
                imageview.setImage(new Image("file:images/x.png"));
            }
            game.setPlayerPosition(imageview.getRow(), imageview.getCol(), game.getPlayer());
            imageview.setClicked(true);
            game.checkGameStatus(game.getPlayer());
            game.changeTurn();
            totalBoxClicked++;
            if (game.isGameWon()) {
                gameOver(imageview);
            } else if (isDraw()) {
                gameDraw();
            }
        }

    }

    private void gameOver(CustomImageView imageView) {
        infoLabel.setTextFill(Color.rgb(229, 138, 11));
        infoLabel.setText("HAS WON THE GAME !!");
        ImageView winnerImageview = new ImageView(imageView.getImage());
        winnerImageview.setFitHeight(50);
        winnerImageview.setFitWidth(50);
        infoLabel.setGraphic(winnerImageview);
    }

    private void gameDraw() {
        infoLabel.setTextFill(Color.rgb(229, 138, 11));
        infoLabel.setText("THE GAME WAS A DRAW :(");
        infoLabel.setGraphic(null);
    }

    private boolean isDraw() {
        return game.getTotalNumCells() == totalBoxClicked;
    }


}
