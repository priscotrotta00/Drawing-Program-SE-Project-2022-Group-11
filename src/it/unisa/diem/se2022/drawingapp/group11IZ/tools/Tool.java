/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author utente
 */
public interface Tool {
    
    /**
     * Method that handle the OnDragDetected event genereated on the drawPane
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnDragBegin(Controller c, MouseEvent event);
    
    /**
     * Method that handle the OnMouseDragged event genereated on the drawPane
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnMouseDrag(Controller c, MouseDragEvent event);
    
    /**
     * Method that handle the OnMouseReleased event generated on the drawPane
     * after a 
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnDragEnd(Controller c, MouseEvent event);
    
    /**
     * Method that handle the OnMouseClicked event generated on the drawPane
     * after a 
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event);
    
    /**
     * Method that handle the OnContextMenuRequested event generated on the drawPane
     * after a 
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnContextMenuRequested(Controller c, ContextMenuEvent event);
    
    public static Tool getInstance() {
        return null;
    }
}
