/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.beans.property.Property;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author utente
 */
public class SelectionRectangleHelperOriginal implements SelectionHelper{
    private MyRectangle rectangle;
    private MyRectangle vertexTopLeft;
    private MyRectangle vertexTopRight;
    private MyRectangle vertexBottomLeft;
    private MyRectangle vertexBottomRight;
    
    private static final double widthVertex = 20;
    private static final double heightVertex = 20;
    
    @Override
    public Group createBoundingBox(MyShape shape) {
        rectangle = (MyRectangle) shape;
        
        Group boundingBoxGroup = new Group();
        MyRectangle rectangleBoundingBox = new MyEnhancedRectangle();
        vertexTopLeft = new MyEnhancedRectangle();
        vertexTopRight = new MyEnhancedRectangle();
        vertexBottomLeft = new MyEnhancedRectangle();
        vertexBottomRight = new MyEnhancedRectangle();
        
        rectangleBoundingBox.myXProperty().bindBidirectional(rectangle.myXProperty());
        rectangleBoundingBox.myYProperty().bindBidirectional(rectangle.myYProperty());
        rectangleBoundingBox.myWidthProperty().bindBidirectional(rectangle.myWidthProperty());
        rectangleBoundingBox.myHeightProperty().bindBidirectional(rectangle.myHeightProperty());
        
        rectangleBoundingBox.mySetStroke(Color.BLACK);
        rectangleBoundingBox.mySetFill(Color.TRANSPARENT);
        rectangleBoundingBox.mySetStrokeWidth(rectangle.myGetStrokeWidth() + 2);
        
        this.updateVertices();
        
        Shape vertexTopLeftCast = (Shape) vertexTopLeft;
        vertexTopLeftCast.setCursor(Cursor.NE_RESIZE);
        vertexTopLeftCast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex1(event);
            vertexTopLeftCast.setOnMouseReleased(event2 -> {});
        });
        
        Shape vertexTopRightCast = (Shape) vertexTopRight;
        vertexTopRightCast.setCursor(Cursor.NE_RESIZE);
        vertexTopRightCast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex2(event);
            vertexTopRightCast.setOnMouseReleased(event2 -> {});
        });
        
        Shape vertexBottomLeftCast = (Shape) vertexBottomLeft;
        vertexBottomLeftCast.setCursor(Cursor.NE_RESIZE);
        vertexBottomLeftCast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex3(event);
            vertexBottomLeftCast.setOnMouseReleased(event2 -> {});
        });
        
        Shape vertexBottomRightCast = (Shape) vertexBottomRight;
        vertexBottomRightCast.setCursor(Cursor.NE_RESIZE);
        vertexBottomRightCast.setOnMouseDragged(event -> {
            this.handleOnMouseDragVertex4(event);
            vertexBottomRightCast.setOnMouseReleased(event2 -> {});
        });
        
        boundingBoxGroup.getChildren().addAll((Shape) rectangleBoundingBox, 
                (Shape) vertexTopLeft, 
                (Shape) vertexTopRight, 
                (Shape) vertexBottomLeft, 
                (Shape) vertexBottomRight
        );
        
        return boundingBoxGroup;
    }
    
    private void updateVertices(){
        vertexTopLeft.mySetWidth(widthVertex);
        vertexTopLeft.mySetHeight(heightVertex);
        vertexTopLeft.mySetX(rectangle.myGetX());
        vertexTopLeft.mySetY(rectangle.myGetY());
        
        vertexTopRight.mySetWidth(widthVertex);
        vertexTopRight.mySetHeight(heightVertex);
        vertexTopRight.mySetX(rectangle.getBottomRightX() - widthVertex);
        vertexTopRight.mySetY(rectangle.getTopLeftY());
        
        vertexBottomLeft.mySetWidth(widthVertex);
        vertexBottomLeft.mySetHeight(heightVertex);
        vertexBottomLeft.mySetX(rectangle.getTopLeftX());
        vertexBottomLeft.mySetY(rectangle.getBottomRightY() - heightVertex);
        
        vertexBottomRight.mySetWidth(widthVertex);
        vertexBottomRight.mySetHeight(heightVertex);
        vertexBottomRight.mySetX(rectangle.getBottomRightX() - widthVertex);
        vertexBottomRight.mySetY(rectangle.getBottomRightY() - heightVertex);
    }
    
    private void handleOnMouseDragVertex1(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if(mouseX <= rectangle.getBottomRightX() && mouseY <= rectangle.getBottomRightY()){
            rectangle.modifyShape(mouseX, mouseY, rectangle.getBottomRightX(), rectangle.getBottomRightY());
            this.updateVertices();
        }
        
        event.consume();
    }
    
    private void handleOnMouseDragVertex2(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if (mouseX >= rectangle.getTopLeftX() && mouseY <= rectangle.getBottomRightY()){
            rectangle.modifyShape(rectangle.getTopLeftX(), mouseY, mouseX, rectangle.getBottomRightY());
            this.updateVertices();
        }
        
        event.consume();
    }
    
    private void handleOnMouseDragVertex3(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if (mouseY >= rectangle.getTopLeftY() && mouseX <= rectangle.getBottomRightX()){
            rectangle.modifyShape(mouseX, rectangle.getTopLeftY(), rectangle.getBottomRightX(), mouseY);
            this.updateVertices();
        }
        
        event.consume();
    }
    
    private void handleOnMouseDragVertex4(MouseEvent event){
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        if (mouseX >= rectangle.getTopLeftX() && mouseY >= rectangle.getTopLeftY()){
            rectangle.modifyShape(rectangle.getTopLeftX(), rectangle.getTopLeftY(), mouseX, mouseY);
            this.updateVertices();
        }
    }
}
