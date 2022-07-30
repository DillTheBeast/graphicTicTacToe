package TicTacToe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

public class Controller {


    //True = X, False = O
    boolean xTurn = true;
    boolean Winner = false;
    String[][] board = new String[3][3];
    String turnPrint = "X";

    public void initialize() {
        
    }
    
    @FXML
    void onButtonClick(ActionEvent event) {
        while(Winner == false) {
            if(xTurn == true) {
                Node currentNode = (Node)(event.getSource());
                GridPane.getColumnIndex(currentNode);
                GridPane.getRowIndex(currentNode);
                ((Button)currentNode).setText(turnPrint);
                xTurn = false;
                turnPrint = "O";
            }

            else if(xTurn == false) {
                Node currentNode = (Node)(event.getSource());
                GridPane.getColumnIndex(currentNode);
                GridPane.getRowIndex(currentNode);
                ((Button)currentNode).setText(turnPrint);
                xTurn = true;
                turnPrint = "X";
            }
            winOrLose();
        }
    }
    public void winOrLose() {
        if(board[0][2] == turnPrint && board[1][2] == turnPrint && board[2][2] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
        if(board[0][1] == turnPrint && board[1][1] == turnPrint && board[2][1] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
        if(board[0][0] == turnPrint && board[1][0] == turnPrint && board[2][0] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
        if(board[0][0] == turnPrint && board[0][1] == turnPrint && board[0][2] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
        if(board[1][0] == turnPrint && board[1][1] == turnPrint && board[1][2] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
        if(board[2][0] == turnPrint && board[2][1] == turnPrint && board[2][2] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
        if(board[0][0] == turnPrint && board[1][1] == turnPrint && board[2][2] == turnPrint) {
            Winner = true;
        }
        if(board[0][2] == turnPrint && board[1][1] == turnPrint && board[2][0] == turnPrint) {
            System.out.println(turnPrint + "wins");
            Winner = true;
        }
    }
    
}