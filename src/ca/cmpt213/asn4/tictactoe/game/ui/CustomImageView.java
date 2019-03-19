package ca.cmpt213.asn4.tictactoe.game.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * this is a custom imageview that uses ImageView class as a base class. it represents the cell player clicks on.
 */
public class CustomImageView extends ImageView {

    private boolean isClicked;
    private int row;
    private int col;

    public CustomImageView(int row, int col, Image image) {
        super(image);
        this.isClicked = false;
        this.col = col;
        this.row = row;

    }

    int getCol() {
        return col;
    }

    int getRow() {
        return row;
    }

    boolean isClicked() {
        return isClicked;
    }

    void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
