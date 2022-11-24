/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daddy
 */
public class SelectTool implements Tool{
    
    private static Selection selectedShape;

    public SelectTool() {
        SelectTool.selectedShape = new Selection();
    }

    public Selection getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(MyShape shape) {
        selectedShape.setSelectedItem(shape);
    }
    
    

    @Override
    public void handleOnDragBegin(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
    }

    @Override
    public void handleOnMouseDrag(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
    }

    @Override
    public void handleOnDragEnd(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
    }

    @Override
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
        
    }

    @Override
    public void handleOnSecondaryMouseClick(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
    }
    
}
