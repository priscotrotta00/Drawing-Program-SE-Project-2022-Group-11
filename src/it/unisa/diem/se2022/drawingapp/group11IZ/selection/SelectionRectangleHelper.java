/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.util.Arrays;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author utente
 */
public class SelectionRectangleHelper extends FourVerticesBaseSelectionHelper{
    
    @Override
    MyRectangle getShape(){
        return (MyRectangle) super.getShape();
    }
    
    
    @Override
    void updateVertices(){
        this.getVertex1().mySetWidth(widthVertex);
        this.getVertex1().mySetHeight(heightVertex);
        this.getVertex1().myXProperty().bind(this.getShape().topLeftXProperty());
        this.getVertex1().myYProperty().bind(this.getShape().topLeftYProperty());
        
        this.getVertex2().mySetWidth(widthVertex);
        this.getVertex2().mySetHeight(heightVertex);
        this.getVertex2().myXProperty().bind(this.getShape().bottomRightXProperty().subtract(widthVertex));
        this.getVertex2().myYProperty().bind(this.getShape().topLeftYProperty());
        
        this.getVertex4().mySetWidth(widthVertex);
        this.getVertex4().mySetHeight(heightVertex);
        this.getVertex4().myXProperty().bind(this.getShape().topLeftXProperty());
        this.getVertex4().myYProperty().bind(this.getShape().bottomRightYProperty().subtract(heightVertex));
        
        this.getVertex3().mySetWidth(widthVertex);
        this.getVertex3().mySetHeight(heightVertex);
        this.getVertex3().myXProperty().bind(this.getShape().bottomRightXProperty().subtract(widthVertex));
        this.getVertex3().myYProperty().bind(this.getShape().bottomRightYProperty().subtract(heightVertex));
    }

    @Override
    MyShape createBoundingBoxEdge() {
        MyRectangle rectangleBoundingBox = new MyEnhancedRectangle();
        
        rectangleBoundingBox.myXProperty().bindBidirectional(this.getShape().myXProperty());
        rectangleBoundingBox.myYProperty().bindBidirectional(this.getShape().myYProperty());
        rectangleBoundingBox.myWidthProperty().bindBidirectional(this.getShape().myWidthProperty());
        rectangleBoundingBox.myHeightProperty().bindBidirectional(this.getShape().myHeightProperty());
        
        rectangleBoundingBox.mySetStroke(Color.BLACK);
        rectangleBoundingBox.mySetFill(Color.TRANSPARENT);
        rectangleBoundingBox.mySetStrokeWidth(this.getShape().myGetStrokeWidth() + strokeVertexOffset);
        rectangleBoundingBox.myGetStrokeDashArray().addAll(strokeDashList);
        
        return rectangleBoundingBox;
    }

    @Override
    void insertElementsInsideGroup(Group group) {
        group.getChildren().addAll(
                (Shape) this.getBoundingBoxEdge(),
                (Shape) this.getVertex1(),
                (Shape) this.getVertex2(),
                (Shape) this.getVertex3(),
                (Shape) this.getVertex4()
        );
    }

    @Override
    boolean onMouseDragVertex1Condition(double mouseX, double mouseY) {
        return mouseX <= this.getShape().getBottomRightX() && mouseY <= this.getShape().getBottomRightY();
    }

    @Override
    void onMouseDragVertex1Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(mouseX, mouseY, this.getShape().getBottomRightX(), this.getShape().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex2Condition(double mouseX, double mouseY) {
        return mouseX >= this.getShape().getTopLeftX() && mouseY <= this.getShape().getBottomRightY();
    }

    @Override
    void onMouseDragVertex2Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(this.getShape().getTopLeftX(), mouseY, mouseX, this.getShape().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex4Condition(double mouseX, double mouseY) {
        return mouseY >= this.getShape().getTopLeftY() && mouseX <= this.getShape().getBottomRightX();
    }

    @Override
    void onMouseDragVertex4Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(mouseX, this.getShape().getTopLeftY(), this.getShape().getBottomRightX(), mouseY);
    }

    @Override
    boolean onMouseDragVertex3Condition(double mouseX, double mouseY) {
        return mouseX >= this.getShape().getTopLeftX() && mouseY >= this.getShape().getTopLeftY();
    }

    @Override
    void onMouseDragVertex3Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(this.getShape().getTopLeftX(), this.getShape().getTopLeftY(), mouseX, mouseY);
    }
}
