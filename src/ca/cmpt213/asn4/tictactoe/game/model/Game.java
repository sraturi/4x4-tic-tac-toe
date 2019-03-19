package ca.cmpt213.asn4.tictactoe.game.model;


/**
 * This class represents a tic tac toe Game with the specified amount of rows and cols.
 */
public class Game {
    public static int EMPTY_CELL = 0;
    public static int PLAYER_X = 1;
    public static int PLAYER_O = 2;
    private final int ROWS = 4;
    private final int COLS = 4;
    private int player;
    private int[][] cells = new int[ROWS][COLS];
    private boolean isGameWon;

    public Game() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = EMPTY_CELL;
            }
        }
        player = PLAYER_X;
        isGameWon = false;
    }

    public void changeTurn() {
        if (player == (PLAYER_X)) {
            player = PLAYER_O;
        } else {
            player = PLAYER_X;
        }
    }

    public void checkGameStatus(int player) {

        //checking cross
        if (cells[0][0] == (player) &&
                cells[1][1] == (player) &&
                cells[2][2] == (player) && cells[3][3] == (player)) {
            isGameWon = true;
        }

        //checking cross
        if (cells[0][3] == (player) && cells[1][2] == (player) &&
                cells[2][1] == (player) && cells[3][0] == (player)) {
            isGameWon = true;
        }

        // checking all the rows
        for (int i = 0; i < ROWS; i++) {
            if (cells[i][0] == (player) && cells[i][1] == (player) &&
                    cells[i][2] == (player) && cells[i][3] == (player)) {
                isGameWon = true;
            }
        }

        //checking all the columns
        for (int i = 0; i < COLS; i++) {
            if (cells[0][i] == (player) && cells[1][i] == (player) &&
                    cells[2][i] == (player) && cells[3][i] == (player)) {
                isGameWon = true;
            }
        }

    }

    public void setPlayerPosition(int row, int col, int player) {
        cells[row][col] = (player);
    }

    public int getPlayer() {
        return player;
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public int getTotalNumCells() {
        return ROWS * COLS;
    }
}
