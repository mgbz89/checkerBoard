/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author MatthewBarber
 */
public class boardFXMLController implements Initializable, Startable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuBar menuBar;
    
    ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        refresh();
    };
    
    private CheckerBoard checkerBoard;
    private int size = 8;
    boolean blue = false;
    private Stage stage;
    
    
    @FXML
    private void handle16(ActionEvent event){
        size = 16;
        refresh();
    }
    
    @FXML
    private void handle10(ActionEvent event){
        size = 10;
        refresh();
    }
    
    @FXML
    private void handle8(ActionEvent event){
        size = 8;
        refresh();
    }
    
    @FXML
    private void handle3(ActionEvent event){
        size = 3;
        refresh();
    }
    
    @FXML
    private void handleDefault(ActionEvent event){
        blue = false;
        refresh();
    }
    
    @FXML
    private void handleBlue(ActionEvent event){
        blue = true;
        refresh();
    }
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        checkerBoard = new CheckerBoard(size,size,stage.getWidth(), stage.getHeight() - menuBar.getHeight() * 1.9);
        anchorPane.getChildren().add(checkerBoard.build());
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }

    private void refresh() {
        clearAnchorPane();
        System.out.println(stage.getHeight() - menuBar.getHeight());
        System.out.println(stage.getWidth());
        if(blue)
            checkerBoard = new CheckerBoard(size,size, stage.getWidth(), stage.getHeight() - menuBar.getHeight() * 1.9, Color.SKYBLUE, Color.DARKBLUE);
        else
            checkerBoard = new CheckerBoard(size,size, stage.getWidth(), stage.getHeight() - menuBar.getHeight() * 1.9);
        
        anchorPane.getChildren().add(checkerBoard.build());
    }
    
    private void clearAnchorPane(){
        
        anchorPane.getChildren().clear();
    }
    
}
