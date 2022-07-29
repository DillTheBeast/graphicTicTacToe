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
    String[][] board = new String[3][3];

    public void initialize() {
        
    }
    
    @FXML
    void onButtonClick(ActionEvent event) {
        if(xTurn == true) {
            Node currentNode = (Node)(event.getSource());
            GridPane.getColumnIndex(currentNode);
            GridPane.getRowIndex(currentNode);
            ((Button)currentNode).setText("X");
            xTurn = false;
        }

        else if(xTurn == false) {
            Node currentNode = (Node)(event.getSource());
            GridPane.getColumnIndex(currentNode);
            GridPane.getRowIndex(currentNode);
            ((Button)currentNode).setText("0");
            xTurn = true;
        }
    }
    
}