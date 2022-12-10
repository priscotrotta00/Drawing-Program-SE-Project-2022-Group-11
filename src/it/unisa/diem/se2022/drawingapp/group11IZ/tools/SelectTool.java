/**
 * The class SelectTool implements all the behaviour linked to the Selection
 * button in the Edit menu
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.MoveShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.event.EventTarget;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daddy
 */
public class SelectTool implements Tool{
    private Selection selectedShape;
    private static Tool instance = null; 
    private MoveShapeCommand msc;
    
    /**
     * Class costructor is private. In order to implement a 
     * single instance of SelectTool
     */
    private SelectTool() {
        //SelectTool.selectedShape = Selection.getInstance();
        this.msc = null;
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
     * @param shape 
     */
    public void setSelectedShape(MyShape shape) {
        shape.accept(selectedShape);
    }
    
    /**
     * Initialize MoveShapeCommand with the selected shape
     * @param c
     * @param event 
     */
    @Override
    public void handleOnDragBegin(Canvas c, MouseEvent event) {
        this.selectedShape = c.getSelection();
        if(!selectedShape.getSelectedValue() || !event.getTarget().equals(selectedShape.getSelectionBorder().getChildren().get(0))) return;
        
        msc = new MoveShapeCommand(selectedShape.getSelectedItem());
    }
    
    /**
     * During the drag action actually moves the selected shape
     * 
     * @param c
     * @param event 
     */
    @Override
    public void handleOnMouseDrag(Canvas c, MouseEvent event) {
        this.selectedShape = c.getSelection();
        if(!selectedShape.getSelectedValue() || !event.getTarget().equals(selectedShape.getSelectionBorder().getChildren().get(0))) return;
        
        selectedShape.getSelectedItemPreview().moveShape(event.getX(), event.getY());
        
    }
    
    /**
     * When released the mouse left-click the position of
     * the shape is changed
     * @param c
     * @param event 
     */
    @Override
    public void handleOnDragEnd(Canvas c, MouseEvent event) {
        this.selectedShape = c.getSelection();
        if(!selectedShape.getSelectedValue() || !event.getTarget().equals(selectedShape.getSelectionBorder().getChildren().get(0))) return;
        
        msc.setNewCoordinates(event.getX(), event.getY());
        
        c.getCommandInvoker().execute(msc);
    }
    
    /**
     * This method handle the primary mouse click on shapes and drawing area.
     * When clicking on a shape it calls a method that select the figure,
     * instead when not clicking on a shape it unselect the shape
     * @param c
     * @param event 
     */
    @Override
    public void handleOnPrimaryMouseClick(Canvas c, MouseEvent event) {
        this.selectedShape = c.getSelection();
        EventTarget eventTarget = event.getTarget();
        
        if (eventTarget.equals(selectedShape.getSelectionBorder()))
            return;
        
        if(!(eventTarget instanceof MyShape)) {
            selectedShape.unSelect();
            return;
        }
        
        MyShape shape = (MyShape) eventTarget;
        
        if (selectedShape.getSelectionBorder().getChildren().contains(shape))
            return;
        
        setSelectedShape(shape);
    }

    
    @Override
    public void handleOnContextMenuRequested(Canvas c, ContextMenuEvent event) {
        //NOP
    }
       
    
}
