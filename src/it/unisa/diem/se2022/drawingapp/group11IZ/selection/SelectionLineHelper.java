/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author utente
 */
public class SelectionLineHelper extends TwoVerticesBaseSelectionHelper{

    @Override
    MyLine getShape(){
        return (MyLine) super.getShape();
    }
    
    @Override
    MyShape createBoundingBoxEdge() {
        MyLine lineBoundingBoxEdge = new MyEnhancedLine();
        
        lineBoundingBoxEdge.myStartXProperty().bind(this.getShape().myStartXProperty());
        lineBoundingBoxEdge.myStartYProperty().bind(this.getShape().myStartYProperty());
        lineBoundingBoxEdge.myEndXProperty().bind(this.getShape().myEndXProperty());
        lineBoundingBoxEdge.myEndYProperty().bind(this.getShape().myEndYProperty());
        
        lineBoundingBoxEdge.mySetStrokeWidth(this.getShape().myGetStrokeWidth() + strokeVertexOffset);
        lineBoundingBoxEdge.mySetFill(Color.TRANSPARENT);
        
        return lineBoundingBoxEdge;
    }

    @Override
    void updateVertices() {
        this.getVertex1().mySetWidth(widthVertex);
        this.getVertex1().mySetHeight(heightVertex);
        this.getVertex1().myXProperty().bind(this.getShape().myStartXProperty().subtract(widthVertex/2));
        this.getVertex1().myYProperty().bind(this.getShape().myStartYProperty().subtract(widthVertex/2));
        
        this.getVertex2().mySetWidth(widthVertex);
        this.getVertex2().mySetHeight(heightVertex);
        this.getVertex2().myXProperty().bind(this.getShape().myEndXProperty().subtract(widthVertex/2));
        this.getVertex2().myYProperty().bind(this.getShape().myEndYProperty().subtract(widthVertex/2));
    }

    @Override
    void insertElementsInsideGroup(Group group) {
        group.getChildren().addAll(
                (Shape) this.getBoundingBoxEdge(),
                (Shape) this.getVertex1(),
                (Shape) this.getVertex2()
        );
    }

    @Override
    boolean onMouseDragVertex1Condition(double mouseX, double mouseY) {
        return true;
    }

    @Override
    void onMouseDragVertex1Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(mouseX, mouseY, this.getShape().myGetEndX(), this.getShape().myGetEndY());
    }

    @Override
    boolean onMouseDragVertex2Condition(double mouseX, double mouseY) {
        return true;
    }

    @Override
    void onMouseDragVertex2Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(this.getShape().myGetStartX(), this.getShape().myGetStartY(), mouseX, mouseY);
    }
    
}
