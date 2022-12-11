package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 * Base class that define the behaviour a bounding box with four vertices will have.
 * It defines a common logic and some method a subclass have to implement in order
 * to adapt the bounding box's aspect and behaviour to a particular type of Shape.
 * Subclass will define what will happen when the user move one of the four vertices.
 * It follows the Template method and Factory method templates
 * @author Felice Scala
 */
public abstract class FourVerticesBaseSelectionHelper extends TwoVerticesBaseSelectionHelper{
    private MyRectangle vertex3;
    private MyRectangle vertex4;
    
    @Override
    public Group createBoundingBox() {
        vertex3 = new MyEnhancedRectangle();
        vertex4 = new MyEnhancedRectangle();
        
        return super.createBoundingBox();
    }
    
    /**
     * Initialize all the defined event handlers that will define the resize
     * functionality
     */
    void initializeVerticesHandlers(){
        super.initializeVerticesHandlers();
        
        // Initialize third vertex's event handlers
        Shape vertex3Cast = (Shape) vertex3;
        vertex3Cast.setOnMouseDragged(event -> {
            this.setCommand(createResizeShapeCommand());
            this.handleOnMouseDragVertex3(event);
            vertex3Cast.setOnMouseReleased(event2 -> {
                this.getCanvas().getCommandInvoker().execute(this.getCommand());
                vertex3Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        // Initialize fourth vertex's event handlers
        Shape vertex4Cast = (Shape) vertex4;
        vertex4Cast.setOnMouseDragged(event -> {
            this.setCommand(createResizeShapeCommand());
            this.handleOnMouseDragVertex4(event);
            vertex4Cast.setOnMouseReleased(event2 -> {
                this.getCanvas().getCommandInvoker().execute(this.getCommand());
                vertex4Cast.setOnMouseReleased(event3 -> {});
            });
        });
    }
    
    /**
     * Defines the skeleton logic to execute when a drag operation happens on 
     * the third vertex. The specific logic will be defined by the subclasses 
     * thanks to the Template Method pattern
     * @param event 
     */
    private void handleOnMouseDragVertex3(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex3Condition(mouseX, mouseY)){
            onMouseDragVertex3Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    /**
     * Defines the condition when the related action has to be performed after
     * moving the third vertx
     * @param mouseX
     * @param mouseY
     * @return True to perform the action, False otherwise
     */
    abstract boolean onMouseDragVertex3Condition(double mouseX, double mouseY);
    
    /**
     * Defines the action to perform when the third vertex is moved and the
     * related condition is verified. A resize operation on the Shape the 
     * bounding box surronds should be performed
     * @param mouseX
     * @param mouseY 
     */
    abstract void onMouseDragVertex3Action(double mouseX, double mouseY);
    
    /**
     * Defines the skeleton logic to execute when a drag operation happens on 
     * the fourth vertex. The specific logic will be defined by the subclasses 
     * thanks to the Template Method pattern
     * @param event 
     */
    private void handleOnMouseDragVertex4(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex4Condition(mouseX, mouseY)){
            onMouseDragVertex4Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    /**
     * Defines the condition when the related action has to be performed after
     * moving the fourth vertx
     * @param mouseX
     * @param mouseY
     * @return True to perform the action, False otherwise
     */
    abstract boolean onMouseDragVertex4Condition(double mouseX, double mouseY);
    
    /**
     * Defines the action to perform when the fourth vertex is moved and the
     * related condition is verified. A resize operation on the Shape the 
     * bounding box surronds should be performed
     * @param mouseX
     * @param mouseY 
     */
    abstract void onMouseDragVertex4Action(double mouseX, double mouseY);

    MyRectangle getVertex3() {
        return vertex3;
    }

    MyRectangle getVertex4() {
        return vertex4;
    }
    
}
