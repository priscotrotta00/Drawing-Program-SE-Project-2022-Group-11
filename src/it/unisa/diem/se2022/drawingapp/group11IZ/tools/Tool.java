package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * Interface that represents a tool that modify the behaviour of the drawing pane
 * in the main interface
 * @author Felice Scala
 */
public interface Tool {
    
    /**
     * Method that handle the OnDragDetected event genereated on the drawPane
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnDragBegin(Canvas c, MouseEvent event);
    
    /**
     * Method that handle the OnMouseDragged event genereated on the drawPane
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnMouseDrag(Canvas c, MouseEvent event);
    
    /**
     * Method that handle the OnMouseReleased event generated on the drawPane
     * after a 
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnDragEnd(Canvas c, MouseEvent event);
    
    /**
     * Method that handle the OnMouseClicked event generated on the drawPane
     * after a 
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnPrimaryMouseClick(Canvas c, MouseEvent event);
    
    /**
     * Method that handle the OnContextMenuRequested event generated on the drawPane
     * after a 
     * @param c Controller
     * @param event Generated Event
     */
    public void handleOnContextMenuRequested(Canvas c, ContextMenuEvent event);
    
    public static Tool getInstance() {
        return null;
    }
}
