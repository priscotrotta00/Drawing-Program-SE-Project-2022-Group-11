/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
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
    
    public SelectionEllipseHelper(Canvas canvas, MyEllipse ellipse){
        this.setCanvas(canvas);
        this.setShape(ellipse);
    }
    
    @Override
    MyEllipse getShape(){
        return (MyEllipse) super.getShape();
    }
    
    @Override
    public MyEllipse getPreview(){
        return (MyEllipse) super.getPreview();
    }

    @Override
    ResizeShapeCommand createResizeShapeCommand() {
        return new ResizeShapeCommand(this.getShape());
    }

    @Override
    MyShape createBoundingBoxEdge() {
        MyEllipse ellipseBoundingBoxEdge = new MyEnhancedEllipse();
        
        // Bind the bounding box to the ellipse
        ellipseBoundingBoxEdge.myCenterXProperty().bindBidirectional(this.getPreview().myCenterXProperty());
        ellipseBoundingBoxEdge.myCenterYProperty().bindBidirectional(this.getPreview().myCenterYProperty());
        ellipseBoundingBoxEdge.myRadiusXProperty().bindBidirectional(this.getPreview().myRadiusXProperty());
        ellipseBoundingBoxEdge.myRadiusYProperty().bindBidirectional(this.getPreview().myRadiusYProperty());
        
        // Define the aspect of the bounding box
        ellipseBoundingBoxEdge.mySetFill(Color.TRANSPARENT);
        ellipseBoundingBoxEdge.mySetStroke(Color.BLACK);
        ellipseBoundingBoxEdge.mySetStrokeWidth(this.getPreview().myGetStrokeWidth() + STROKE_VERTEX_OFFSET);
        ellipseBoundingBoxEdge.myGetStrokeDashArray().addAll(STROKE_DASH_LIST);
        
        return ellipseBoundingBoxEdge;
    }

    @Override
    void updateVertices() {
        // Initialize first vertex at the top of the vertical diameter of the ellipse
        this.getVertex1().mySetWidth(WIDTH_VERTEX);
        this.getVertex1().mySetHeight(HEIGHT_VERTEX);
        this.getVertex1().myXProperty().bind(this.getPreview().myCenterXProperty().subtract(WIDTH_VERTEX/2));
        this.getVertex1().myYProperty().bind(this.getPreview().topLeftYProperty());
        
        // Initialize second vertex at the right of the horizontal diameter of the ellipse
        this.getVertex2().mySetWidth(WIDTH_VERTEX);
        this.getVertex2().mySetHeight(HEIGHT_VERTEX);
        this.getVertex2().myXProperty().bind(this.getPreview().bottomRightXProperty().subtract(WIDTH_VERTEX));
        this.getVertex2().myYProperty().bind(this.getPreview().myCenterYProperty().subtract(HEIGHT_VERTEX/2));
        
        // Initialize third vertex at the bottom of the vertical diameter of the ellipse
        this.getVertex3().mySetWidth(WIDTH_VERTEX);
        this.getVertex3().mySetHeight(HEIGHT_VERTEX);
        this.getVertex3().myXProperty().bind(this.getPreview().myCenterXProperty().subtract(WIDTH_VERTEX/2));
        this.getVertex3().myYProperty().bind(this.getPreview().bottomRightYProperty().subtract(HEIGHT_VERTEX));
        
        // Initialize fourth vertex at the left of the horizontal diameter of the ellipse
        this.getVertex4().mySetWidth(WIDTH_VERTEX);
        this.getVertex4().mySetHeight(HEIGHT_VERTEX);
        this.getVertex4().myXProperty().bind(this.getPreview().topLeftXProperty());
        this.getVertex4().myYProperty().bind(this.getPreview().myCenterYProperty().subtract(HEIGHT_VERTEX/2));
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
        return mouseY <= this.getPreview().getBottomRightY();
    }

    @Override
    void onMouseDragVertex1Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(this.getPreview().getTopLeftX(), mouseY, this.getPreview().getBottomRightX(), this.getPreview().getBottomRightY());
        this.getCommand().setNewCoordinates(this.getPreview().getTopLeftX(), mouseY, this.getPreview().getBottomRightX(), this.getPreview().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex2Condition(double mouseX, double mouseY) {
        return mouseX >= this.getPreview().getTopLeftX();
    }

    @Override
    void onMouseDragVertex2Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(this.getPreview().getTopLeftX(), this.getPreview().getTopLeftY(), mouseX, this.getPreview().getBottomRightY());
        this.getCommand().setNewCoordinates(this.getPreview().getTopLeftX(), this.getPreview().getTopLeftY(), mouseX, this.getPreview().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex3Condition(double mouseX, double mouseY) {
        return mouseY >= this.getPreview().getTopLeftY();
    }

    @Override
    void onMouseDragVertex3Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(this.getPreview().getTopLeftX(), this.getPreview().getTopLeftY(), this.getPreview().getBottomRightX(), mouseY);
        this.getCommand().setNewCoordinates(this.getPreview().getTopLeftX(), this.getPreview().getTopLeftY(), this.getPreview().getBottomRightX(), mouseY);
    }

    @Override
    boolean onMouseDragVertex4Condition(double mouseX, double mouseY) {
        return mouseX <= this.getPreview().getBottomRightX();
    }

    @Override
    void onMouseDragVertex4Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(mouseX, this.getPreview().getTopLeftY(), this.getPreview().getBottomRightX(), this.getPreview().getBottomRightY());
        this.getCommand().setNewCoordinates(mouseX, this.getPreview().getTopLeftY(), this.getPreview().getBottomRightX(), this.getPreview().getBottomRightY());
    }
    
}
