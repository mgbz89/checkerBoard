/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author MatthewBarber
 */
public class CheckerBoard {
    
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color light;
    private Color dark;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.light = Color.RED;
        this.dark = Color.BLACK;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color light, Color dark){
        this(numRows, numCols, boardWidth, boardHeight);
        this.light = light;
        this.dark = dark;
    }
    
    
    public AnchorPane build(){
        
        AnchorPane anchorPane = new AnchorPane();
        double rectWidth = Math.ceil(boardWidth / numCols);
        double rectHeight = Math.ceil(boardHeight / numRows);
        
        for(int rows = 0; rows < numCols; rows++){
            for(int cols = 0; cols < numRows; cols++){
                Rectangle rect = new Rectangle(cols * rectWidth, rows * rectHeight, rectWidth, rectHeight);
                if((rows + cols) % 2 == 0)
                    rect.setFill(dark);
                else
                    rect.setFill(light);
                
                anchorPane.getChildren().add(rect);
            }
        }
        
        return anchorPane;
    }
}
