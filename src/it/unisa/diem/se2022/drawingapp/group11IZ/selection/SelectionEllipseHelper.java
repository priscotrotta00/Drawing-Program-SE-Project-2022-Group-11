/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ResizeEllipseCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ResizeShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Class that define the behaviour a bounding box will have on an ellipse.
 * @author Felice Scala
 */
public class SelectionEllipseHelper extends FourVerticesBaseSelectionHelper{
    
    @Override
    MyEllipse getShape(){
        return (MyEllipse) super.getShape();
    }
    
    @Override
    ResizeEllipseCommand getCommand(){
        return (ResizeEllipseCommand) super.getCommand();
    }

    @Override
    ResizeShapeCommand createResizeShapeCommand() {
        return new ResizeEllipseCommand(this.getShape());
    }

    @Override
    MyShape createBoundingBoxEdge() {
        MyEllipse ellipseBoundingBoxEdge = new MyEnhancedEllipse();
        
        // Bind the bounding box to the ellipse
        ellipseBoundingBoxEdge.myCenterXProperty().bindBidirectional(this.getShape().myCenterXProperty());
        ellipseBoundingBoxEdge.myCenterYProperty().bindBidirectional(this.getShape().myCenterYProperty());
        ellipseBoundingBoxEdge.myRadiusXProperty().bindBidirectional(this.getShape().myRadiusXProperty());
        ellipseBoundingBoxEdge.myRadiusYProperty().bindBidirectional(this.getShape().myRadiusYProperty());
        
        // Define the aspect of the bounding box
        ellipseBoundingBoxEdge.mySetFill(Color.TRANSPARENT);
        ellipseBoundingBoxEdge.mySetStroke(Color.BLACK);
        ellipseBoundingBoxEdge.mySetStrokeWidth(this.getShape().myGetStrokeWidth() + strokeVertexOffset);
        ellipseBoundingBoxEdge.myGetStrokeDashArray().addAll(strokeDashList);
        
        return ellipseBoundingBoxEdge;
    }

    @Override
    void updateVertices() {
        // Initialize first vertex at the top of the vertical diameter of the ellipse
        this.getVertex1().mySetWidth(widthVertex);
        this.getVertex1().mySetHeight(heightVertex);
        this.getVertex1().myXProperty().bind(this.getShape().myCenterXProperty().subtract(widthVertex/2));
        this.getVertex1().myYProperty().bind(this.getShape().topLeftYProperty());
        
        // Initialize second vertex at the right of the horizontal diameter of the ellipse
        this.getVertex2().mySetWidth(widthVertex);
        this.getVertex2().mySetHeight(heightVertex);
        this.getVertex2().myXProperty().bind(this.getShape().bottomRightXProperty().subtract(widthVertex));
        this.getVertex2().myYProperty().bind(this.getShape().myCenterYProperty().subtract(heightVertex/2));
        
        // Initialize third vertex at the bottom of the vertical diameter of the ellipse
        this.getVertex3().mySetWidth(widthVertex);
        this.getVertex3().mySetHeight(heightVertex);
        this.getVertex3().myXProperty().bind(this.getShape().myCenterXProperty().subtract(widthVertex/2));
        this.getVertex3().myYProperty().bind(this.getShape().bottomRightYProperty().subtract(heightVertex));
        
        // Initialize fourth vertex at the left of the horizontal diameter of the ellipse
        this.getVertex4().mySetWidth(widthVertex);
        this.getVertex4().mySetHeight(heightVertex);
        this.getVertex4().myXProperty().bind(this.getShape().topLeftXProperty());
        this.getVertex4().myYProperty().bind(this.getShape().myCenterYProperty().subtract(heightVertex/2));
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
        return mouseY <= this.getShape().getBottomRightY();
    }

    @Override
    void onMouseDragVertex1Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(this.getShape().getTopLeftX(), mouseY, this.getShape().getBottomRightX(), this.getShape().getBottomRightY());
        this.getCommand().setNewCoordinates(this.getShape().getTopLeftX(), mouseY, this.getShape().getBottomRightX(), this.getShape().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex2Condition(double mouseX, double mouseY) {
        return mouseX >= this.getShape().getTopLeftX();
    }

    @Override
    void onMouseDragVertex2Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(this.getShape().getTopLeftX(), this.getShape().getTopLeftY(), mouseX, this.getShape().getBottomRightY());
        this.getCommand().setNewCoordinates(this.getShape().getTopLeftX(), this.getShape().getTopLeftY(), mouseX, this.getShape().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex3Condition(double mouseX, double mouseY) {
        return mouseY >= this.getShape().getTopLeftY();
    }

    @Override
    void onMouseDragVertex3Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(this.getShape().getTopLeftX(), this.getShape().getTopLeftY(), this.getShape().getBottomRightX(), mouseY);
        this.getCommand().setNewCoordinates(this.getShape().getTopLeftX(), this.getShape().getTopLeftY(), this.getShape().getBottomRightX(), mouseY);
    }

    @Override
    boolean onMouseDragVertex4Condition(double mouseX, double mouseY) {
        return mouseX <= this.getShape().getBottomRightX();
    }

    @Override
    void onMouseDragVertex4Action(double mouseX, double mouseY) {
        this.getShape().modifyShape(mouseX, this.getShape().getTopLeftY(), this.getShape().getBottomRightX(), this.getShape().getBottomRightY());
        this.getCommand().setNewCoordinates(mouseX, this.getShape().getTopLeftY(), this.getShape().getBottomRightX(), this.getShape().getBottomRightY());
    }
    
}