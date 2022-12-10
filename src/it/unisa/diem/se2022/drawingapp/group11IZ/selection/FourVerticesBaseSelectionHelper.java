/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ResizeShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.util.Arrays;
import java.util.List;
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
public abstract class FourVerticesBaseSelectionHelper implements SelectionHelper{
    private MyShape shape;
    private MyShape preview;
    private Canvas canvas;
    private ResizeShapeCommand command;
    
    private MyShape boundingBoxEdge;
    private MyRectangle vertex1;
    private MyRectangle vertex2;
    private MyRectangle vertex3;
    private MyRectangle vertex4;
    
    static final double WIDTH_VERTEX = 10;
    static final double HEIGHT_VERTEX = 10;
    static final double STROKE_VERTEX_OFFSET = 2;
    static final List<Double> STROKE_DASH_LIST = Arrays.asList(5.0, 10.0, 5.0, 10.0);
    
    @Override
    public Group createBoundingBox() {
        Group boundingBoxGroup;
        
        this.preview = this.canvas.substituteShapeWithPreview(shape);
        
        // Create the bounding box's components
        boundingBoxGroup = new Group();
        vertex1 = new MyEnhancedRectangle();
        vertex2 = new MyEnhancedRectangle();
        vertex3 = new MyEnhancedRectangle();
        vertex4 = new MyEnhancedRectangle();
        
        // Initialize edge and vertices
        this.boundingBoxEdge = this.createBoundingBoxEdge();
        this.updateVertices();
        this.initializeVerticesHandlers();
        
        // Group all the components
        this.insertElementsInsideGroup(boundingBoxGroup);
        
        return boundingBoxGroup;
    }

    @Override
    public void destroyBoundingBox() {
        this.canvas.substitutePreviewWithOriginalShape(shape);
        this.preview = null;
    }
    
    /**
     * Create the bounding box's edge according to the type of Shape. It defines
     * all the bindings between shape and edge properties, in order to resize/
     * move the second one when the shape is resized/moved
     * @return A bounding box's edge
     */
    abstract MyShape createBoundingBoxEdge();
    
    /**
     * Create the correct Resize Shape Command according to the type of Shape 
     * the subclass manage.
     * @return 
     */
    abstract ResizeShapeCommand createResizeShapeCommand();
    
    /**
     * Define the position of each vertex to the shape and all the necessary
     * bindings in order to move the vertices according to the shape
     */
    abstract void updateVertices();
    
    /**
     * Initialize all the defined event handlers that will define the resize
     * functionality
     */
    private void initializeVerticesHandlers(){
        // Initialize first vertex's event handlers
        Shape vertex1Cast = (Shape) vertex1;
        vertex1Cast.setCursor(Cursor.NE_RESIZE);
        vertex1Cast.setOnMouseDragged(event -> {
            this.command = createResizeShapeCommand();
            this.handleOnMouseDragVertex1(event);
            vertex1Cast.setOnMouseReleased(event2 -> {
                this.canvas.getCommandInvoker().execute(this.getCommand());
                vertex1Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        // Initialize second vertex's event handlers
        Shape vertex2Cast = (Shape) vertex2;
        vertex2Cast.setCursor(Cursor.NE_RESIZE);
        vertex2Cast.setOnMouseDragged(event -> {
            this.command = createResizeShapeCommand();
            this.handleOnMouseDragVertex2(event);
            vertex2Cast.setOnMouseReleased(event2 -> {
                this.canvas.getCommandInvoker().execute(this.getCommand());
                vertex2Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        // Initialize third vertex's event handlers
        Shape vertex3Cast = (Shape) vertex3;
        vertex3Cast.setCursor(Cursor.NE_RESIZE);
        vertex3Cast.setOnMouseDragged(event -> {
            this.command = createResizeShapeCommand();
            this.handleOnMouseDragVertex3(event);
            vertex3Cast.setOnMouseReleased(event2 -> {
                this.canvas.getCommandInvoker().execute(this.getCommand());
                vertex3Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        // Initialize fourth vertex's event handlers
        Shape vertex4Cast = (Shape) vertex4;
        vertex4Cast.setCursor(Cursor.NE_RESIZE);
        vertex4Cast.setOnMouseDragged(event -> {
            this.command = createResizeShapeCommand();
            this.handleOnMouseDragVertex4(event);
            vertex4Cast.setOnMouseReleased(event2 -> {
                this.canvas.getCommandInvoker().execute(this.getCommand());
                vertex4Cast.setOnMouseReleased(event3 -> {});
            });
        });
    }
    
    /**
     * Insert all the bounding box's components inside the given Group
     */ 
    abstract void insertElementsInsideGroup(Group group);
    
    /**
     * Defines the skeleton logic to execute when a drag operation happens on 
     * the first vertex. The specific logic will be defined by the subclasses 
     * thanks to the Template Method pattern
     * @param event 
     */
    private void handleOnMouseDragVertex1(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex1Condition(mouseX, mouseY)){
            onMouseDragVertex1Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    /**
     * Defines the condition when the related action has to be performed after
     * moving the first vertx
     * @param mouseX
     * @param mouseY
     * @return True to perform the action, False otherwise
     */
    abstract boolean onMouseDragVertex1Condition(double mouseX, double mouseY);
    
    /**
     * Defines the action to perform when the first vertex is moved and the
     * related condition is verified. A resize operation on the Shape the 
     * bounding box surronds should be performed
     * @param mouseX
     * @param mouseY 
     */
    abstract void onMouseDragVertex1Action(double mouseX, double mouseY);
    
    /**
     * Defines the skeleton logic to execute when a drag operation happens on 
     * the second vertex. The specific logic will be defined by the subclasses 
     * thanks to the Template Method pattern
     * @param event 
     */
    private void handleOnMouseDragVertex2(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex2Condition(mouseX, mouseY)){
            onMouseDragVertex2Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    /**
     * Defines the condition when the related action has to be performed after
     * moving the second vertx
     * @param mouseX
     * @param mouseY
     * @return True to perform the action, False otherwise
     */
    abstract boolean onMouseDragVertex2Condition(double mouseX, double mouseY);
    
    /**
     * Defines the action to perform when the second vertex is moved and the
     * related condition is verified. A resize operation on the Shape the 
     * bounding box surronds should be performed
     * @param mouseX
     * @param mouseY 
     */
    abstract void onMouseDragVertex2Action(double mouseX, double mouseY);
    
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

    MyRectangle getVertex1() {
        return vertex1;
    }

    MyRectangle getVertex2() {
        return vertex2;
    }

    MyRectangle getVertex3() {
        return vertex3;
    }

    MyRectangle getVertex4() {
        return vertex4;
    }
    
    void setShape(MyShape shape) {
        this.shape = shape;
    }
    
    MyShape getShape(){
        return shape;
    }
    
    public MyShape getPreview(){
        return preview;
    }
    
    MyShape getBoundingBoxEdge(){
        return boundingBoxEdge;
    }
    
    ResizeShapeCommand getCommand(){
        return command;
    }
    
    void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    
    Canvas getCanvas(){
        return canvas;
    }
    
}
