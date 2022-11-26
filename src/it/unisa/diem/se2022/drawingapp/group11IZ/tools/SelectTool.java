/**
 * The class SelectTool implements all the behaviour linked to the Selection
 * button in the Edit menu
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Controller;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.event.EventTarget;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daddy
 */
public class SelectTool implements Tool{
    private static Selection selectedShape;
    private static Tool instance = null; 
    
    /**
     * Class costructor is private. In order to implement a 
     * single instance of SelectTool
     */
    private SelectTool() {
        SelectTool.selectedShape = new Selection();
    }
    
    /**
     * 
     * @return the instance of SelectTool.
     */
    public static Tool getInstance(){
        if (instance == null) instance = new SelectTool();
        return instance;
    }
    
    /**
     * 
     * @return the Selection attribute
     */
    public Selection getSelectedShape() {
        return selectedShape;
    }
    
    /**
     * 
     * @param shape 
     */
    public void setSelectedShape(MyShape shape) {
        shape.accept(selectedShape);
    }
    
    /**
     * 
     * @param c
     * @param event 
     */
    @Override
    public void handleOnDragBegin(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getTarget();
    }
    
    /**
     * 
     * @param c
     * @param event 
     */
    @Override
    public void handleOnDragEnd(Controller c, MouseEvent event) {
        MyShape shape = (MyShape) event.getTarget();
    }
    
    /**
     * This method handle the primary mouse click on shapes and drawing area.
     * When clicking on a shape it calls a method that select the figure,
     * instead when not clicking on a shape it unselect the shape
     * @param c
     * @param event 
     */
    @Override
    public void handleOnPrimaryMouseClick(Controller c, MouseEvent event) {
        EventTarget eventTarget = event.getTarget();
        
        if(!(eventTarget instanceof MyShape)) {
            selectedShape.unSelect();
            return;
        }
        
        MyShape shape = (MyShape) eventTarget;
        setSelectedShape(shape);
    }

    @Override
    public void handleOnMouseDrag(Controller c, MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleOnContextMenuRequested(Controller c, ContextMenuEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
