/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 *
 * @author utente
 */
public abstract class TwoVerticesBaseSelectionHelper implements SelectionHelper {
    private MyShape shape;
    
    private MyShape boundingBoxEdge;
    private MyRectangle vertex1;
    private MyRectangle vertex2;
    
    static final double widthVertex = 10;
    static final double heightVertex = 10;
    static final double strokeVertexOffset = 2;
    
    @Override
    public Group createBoundingBox(MyShape shape) {
        this.shape = shape;
        
        Group boundingBoxGroup = new Group();
        vertex1 = new MyEnhancedRectangle();
        vertex2 = new MyEnhancedRectangle();
        
        boundingBoxEdge = this.createBoundingBoxEdge();
        this.updateVertices();
        this.initializeVerticesHandlers();
        
        this.insertElementsInsideGroup(boundingBoxGroup);
        
        return boundingBoxGroup;
    }
    
    abstract MyShape createBoundingBoxEdge();
    
    abstract void updateVertices();
    
    private void initializeVerticesHandlers(){
        Shape vertex1Cast = (Shape) vertex1;
        vertex1Cast.setCursor(Cursor.NE_RESIZE);
        vertex1Cast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex1(event);
            vertex1Cast.setOnMouseReleased(event2 -> {});
        });
        
        Shape vertex2Cast = (Shape) vertex2;
        vertex2Cast.setCursor(Cursor.NE_RESIZE);
        vertex2Cast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex2(event);
            vertex2Cast.setOnMouseReleased(event2 -> {});
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
    
    MyRectangle getVertex1() {
        return vertex1;
    }

    MyRectangle getVertex2() {
        return vertex2;
    }
    
    MyShape getShape(){
        return shape;
    }
    
    MyShape getBoundingBoxEdge(){
        return boundingBoxEdge;
    }
    
}
