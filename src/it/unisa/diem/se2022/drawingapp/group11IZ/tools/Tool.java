/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import javafx.scene.input.MouseEvent;

/**
 * Interface that represents a tool that modify the behaviour of the drawing pane
 * in the main interface
 * @author Felice Scala
 */
public interface Tool {
    
    public void handleOnDragBegin(Controller c, MouseEvent event);
    
    public void handleOnMouseDrag(Controller c, MouseEvent event);
    
    public void handleOnDragEnd(Controller c, MouseEvent event);
    
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event);
    
    public void handleOnSecondaryMouseClick(Controller c, MouseEvent event);
    
    public static Tool getInstance() {
        return null;
    }
}
