/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daddy
 */
public class SelectTool implements Tool{
    
    private Selection selectedShape;

    public SelectTool(Selection selectedShape) {
        this.selectedShape = selectedShape;
    }

    public Selection getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Selection selectedShape) {
        this.selectedShape = selectedShape;
    }
    
    

    @Override
    public void handleOnDragBegin(Controller c, MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleOnMouseDrag(Controller c, MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleOnDragEnd(Controller c, MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleOnSecondaryMouseClick(Controller c, MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
