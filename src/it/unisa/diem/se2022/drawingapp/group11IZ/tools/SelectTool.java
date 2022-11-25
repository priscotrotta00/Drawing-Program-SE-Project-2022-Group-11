/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.event.EventTarget;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author daddy
 */
public class SelectTool implements Tool{
    
    private static Selection selectedShape;
    private static Tool instance = null; 

    private SelectTool() {
        SelectTool.selectedShape = new Selection();
    }
    
    public static Tool getInstance(){
        if (instance == null) instance = new SelectTool();
        return instance;
    }

    public Selection getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(MyShape shape) {
        selectedShape.select(shape);
    }
    
    

    @Override
    public void handleOnDragBegin(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
    }

    @Override
    public void handleOnMouseDrag(Controller c, MouseDragEvent event) {
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
        
        //MyShape shape = (MyShape) event.getTarget();
        
        EventTarget eventTarget = event.getTarget();
        
        if(!(eventTarget instanceof MyShape)) return;
        
        MyShape shape = (MyShape) eventTarget;
        
        
        //System.out.println("Ho selezionato una figura");
        //if(c.getDrawPane().getChildren().contains(shape)){
        System.out.println("Ho selezionato una figura");
        setSelectedShape(shape);
        //}
        
    }

    @Override
    public void handleOnSecondaryMouseClick(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getSource();
        
        /*if(c.getDrawPane().getChildren().contains(shape)){
            setSelectedShape(shape);
            
        }*/
    }
    
}
