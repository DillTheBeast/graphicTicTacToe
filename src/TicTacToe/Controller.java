package TicTacToe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import javax.swing.plaf.basic.BasicPasswordFieldUI;

import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private GridPane gridPane;

    //True = X, False = O
    boolean xTurn = false;
    boolean Winner = false;
    String[][] board = new String[3][3];
    String turnPrint = "X";
    Alert Won;
    Alert Tie;
    Alert spaceFull;
    int boardFill = 0;

    public void initialize() {
        Won = new Alert(AlertType.CONFIRMATION);
        Won.setHeaderText("We Have a Winner");

        Tie = new Alert(AlertType.CONFIRMATION);
        Tie.setHeaderText("There is a Tie");
        Tie.setContentText("Both players have tied.");

        spaceFull = new Alert(AlertType.ERROR);
        spaceFull.setHeaderText("This spot has already been taken");
        spaceFull.setContentText("Please choose a different spot");

        resetGame();
    }
    
    @FXML
    void onButtonClick(ActionEvent event) {
        
        Node currentNode = (Node)(event.getSource());
        Integer column = GridPane.getColumnIndex(currentNode);
        Integer row = GridPane.getRowIndex(currentNode);
        if(column == null) {
            column = 0;
        }
        if(row == null) {
            row = 0;
        }
        if(!(board[row][column].equals(""))) {
            spaceFull.showAndWait();
            return;
        }
        boardFill++;
        ((Button)currentNode).setText(turnPrint);
        xTurn = !(xTurn);
        board[row][column] = turnPrint;
        if(winOrLose()) {
            Won.setContentText(turnPrint + " has won");
            Won.showAndWait();
            resetGame();
        }
    
        else if(tie()) {
            Tie.showAndWait();
            resetGame();
        }

        if(xTurn == true) 
            turnPrint = "O";

        else if(xTurn == false)
            turnPrint = "X";
        
    }

    @FXML
    void onResetClick(ActionEvent event) {
        resetGame();
    }

    public boolean winOrLose() {
        return
        (board[0][2].equals(turnPrint) && board[1][2].equals(turnPrint) && board[2][2].equals(turnPrint)) ||

        (board[0][1].equals(turnPrint) && board[1][1].equals(turnPrint) && board[2][1].equals(turnPrint)) ||

        (board[0][0].equals(turnPrint) && board[1][0].equals(turnPrint) && board[2][0].equals(turnPrint)) ||

        (board[0][0].equals(turnPrint) && board[0][1].equals(turnPrint) && board[0][2].equals(turnPrint)) ||

        (board[1][0].equals(turnPrint) && board[1][1].equals(turnPrint) && board[1][2].equals(turnPrint)) ||

        (board[2][0].equals(turnPrint) && board[2][1].equals(turnPrint) && board[2][2].equals(turnPrint)) ||

        (board[0][0].equals(turnPrint) && board[1][1].equals(turnPrint) && board[2][2].equals(turnPrint)) ||

        (board[0][2].equals(turnPrint) && board[1][1].equals(turnPrint) && board[2][0].equals(turnPrint)); 

    }

    public boolean tie() {
        return
        (boardFill == 9);
    }

    public void resetGame() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = "";
            }
        }
        for (Node currentNode : gridPane.getChildren()) {
            try {
                ((Button)currentNode).setText("");
            } catch (Exception e) {

            }

        }
        boardFill = 0;
        xTurn = false;
        turnPrint = "X";
    }
    
}