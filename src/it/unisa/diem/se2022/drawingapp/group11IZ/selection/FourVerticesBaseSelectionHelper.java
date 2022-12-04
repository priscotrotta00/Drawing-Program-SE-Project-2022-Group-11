/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

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
 *
 * @author utente
 */
public abstract class FourVerticesBaseSelectionHelper implements SelectionHelper{
    private MyShape shape;
    private ResizeShapeCommand command;
    
    private MyShape boundingBoxEdge;
    private MyRectangle vertex1;
    private MyRectangle vertex2;
    private MyRectangle vertex3;
    private MyRectangle vertex4;
    
    static final double widthVertex = 10;
    static final double heightVertex = 10;
    static final double strokeVertexOffset = 2;
    static final List<Double> strokeDashList = Arrays.asList(5.0, 10.0, 5.0, 10.0);
    
    @Override
    public Group createBoundingBox(MyShape shape) {
        this.shape = shape;
        this.command = createResizeShapeCommand();
        
        Group boundingBoxGroup = new Group();
        vertex1 = new MyEnhancedRectangle();
        vertex2 = new MyEnhancedRectangle();
        vertex3 = new MyEnhancedRectangle();
        vertex4 = new MyEnhancedRectangle();
        
        boundingBoxEdge = this.createBoundingBoxEdge();
        this.updateVertices();
        this.initializeVerticesHandlers();
        
        this.insertElementsInsideGroup(boundingBoxGroup);
        
        return boundingBoxGroup;
    }
    
    abstract MyShape createBoundingBoxEdge();
    
    abstract ResizeShapeCommand createResizeShapeCommand();
    
    abstract void updateVertices();
    
    private void initializeVerticesHandlers(){
        Shape vertex1Cast = (Shape) vertex1;
        vertex1Cast.setCursor(Cursor.NE_RESIZE);
        vertex1Cast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex1(event);
            vertex1Cast.setOnMouseReleased(event2 -> {
                this.getCommand().execute();
                vertex1Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        Shape vertex2Cast = (Shape) vertex2;
        vertex2Cast.setCursor(Cursor.NE_RESIZE);
        vertex2Cast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex2(event);
            vertex2Cast.setOnMouseReleased(event2 -> {
                this.getCommand().execute();
                vertex2Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        Shape vertex3Cast = (Shape) vertex3;
        vertex3Cast.setCursor(Cursor.NE_RESIZE);
        vertex3Cast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex3(event);
            vertex3Cast.setOnMouseReleased(event2 -> {
                this.getCommand().execute();
                vertex3Cast.setOnMouseReleased(event3 -> {});
            });
        });
        
        Shape vertex4Cast = (Shape) vertex4;
        vertex4Cast.setCursor(Cursor.NE_RESIZE);
        vertex4Cast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex4(event);
            vertex4Cast.setOnMouseReleased(event2 -> {
                this.getCommand().execute();
                vertex4Cast.setOnMouseReleased(event3 -> {});
            });
        });
    }
    
    abstract void insertElementsInsideGroup(Group group);
    
    private void handleOnMouseDragVertex1(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex1Condition(mouseX, mouseY)){
            onMouseDragVertex1Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    abstract boolean onMouseDragVertex1Condition(double mouseX, double mouseY);
    
    abstract void onMouseDragVertex1Action(double mouseX, double mouseY);
    
    private void handleOnMouseDragVertex2(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex2Condition(mouseX, mouseY)){
            onMouseDragVertex2Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    abstract boolean onMouseDragVertex2Condition(double mouseX, double mouseY);
    
    abstract void onMouseDragVertex2Action(double mouseX, double mouseY);
    
    private void handleOnMouseDragVertex3(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex3Condition(mouseX, mouseY)){
            onMouseDragVertex3Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    abstract boolean onMouseDragVertex3Condition(double mouseX, double mouseY);
    
    abstract void onMouseDragVertex3Action(double mouseX, double mouseY);
    
    private void handleOnMouseDragVertex4(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(onMouseDragVertex4Condition(mouseX, mouseY)){
            onMouseDragVertex4Action(mouseX, mouseY);
            //this.updateVertices();
        }
        
        event.consume();
    }
    
    abstract boolean onMouseDragVertex4Condition(double mouseX, double mouseY);
    
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
    
    MyShape getShape(){
        return shape;
    }
    
    MyShape getBoundingBoxEdge(){
        return boundingBoxEdge;
    }
    
    ResizeShapeCommand getCommand(){
        return command;
    }
    
}
