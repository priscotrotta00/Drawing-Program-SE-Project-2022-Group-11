package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ResizeShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Class that define the behaviour a bounding box will have on a line.
 * @author Felice Scala
 */
public class SelectionLineHelper extends TwoVerticesBaseSelectionHelper{

    public SelectionLineHelper(Canvas canvas, MyLine line) {
        this.setCanvas(canvas);
        this.setShape(line);
    }
    
    @Override
    MyLine getShape(){
        return (MyLine) super.getShape();
    }
    
    @Override
    public MyLine getPreview(){
        return (MyLine) super.getPreview();
    }
    
    @Override
    ResizeShapeCommand getCommand(){
        return (ResizeShapeCommand) super.getCommand();
    }

    @Override
    ResizeShapeCommand createResizeShapeCommand() {
        return new ResizeShapeCommand(this.getShape());
    }
    
    @Override
    MyShape createBoundingBoxEdge() {
        MyLine lineBoundingBoxEdge = new MyEnhancedLine();
        
        // Bind the bounding box to the line
        lineBoundingBoxEdge.myStartXProperty().bind(this.getPreview().myStartXProperty());
        lineBoundingBoxEdge.myStartYProperty().bind(this.getPreview().myStartYProperty());
        lineBoundingBoxEdge.myEndXProperty().bind(this.getPreview().myEndXProperty());
        lineBoundingBoxEdge.myEndYProperty().bind(this.getPreview().myEndYProperty());
        lineBoundingBoxEdge.myGetStrokeDashArray().addAll(STROKE_DASH_LIST);
        
        // Define the aspect of the bounding box
        lineBoundingBoxEdge.mySetStrokeWidth(this.getPreview().myGetStrokeWidth() + STROKE_VERTEX_OFFSET);
        lineBoundingBoxEdge.mySetFill(Color.TRANSPARENT);
        
        return lineBoundingBoxEdge;
    }

    @Override
    void updateVertices() {
        // Initialize first vertex on the start point of the line
        this.getVertex1().mySetWidth(WIDTH_VERTEX);
        this.getVertex1().mySetHeight(HEIGHT_VERTEX);
        this.getVertex1().myXProperty().bind(this.getPreview().myStartXProperty().subtract(WIDTH_VERTEX/2));
        this.getVertex1().myYProperty().bind(this.getPreview().myStartYProperty().subtract(WIDTH_VERTEX/2));
        
        // Initialize first vertex on the end point of the line
        this.getVertex2().mySetWidth(WIDTH_VERTEX);
        this.getVertex2().mySetHeight(HEIGHT_VERTEX);
        this.getVertex2().myXProperty().bind(this.getPreview().myEndXProperty().subtract(WIDTH_VERTEX/2));
        this.getVertex2().myYProperty().bind(this.getPreview().myEndYProperty().subtract(WIDTH_VERTEX/2));
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
        this.getPreview().modifyShape(mouseX, mouseY, this.getShape().myGetEndX(), this.getShape().myGetEndY());
        this.getCommand().setNewCoordinates(mouseX, mouseY, this.getShape().myGetEndX(), this.getShape().myGetEndY());
    }

    @Override
    boolean onMouseDragVertex2Condition(double mouseX, double mouseY) {
        return true;
    }

    @Override
    void onMouseDragVertex2Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(this.getShape().myGetStartX(), this.getShape().myGetStartY(), mouseX, mouseY);
        this.getCommand().setNewCoordinates(this.getShape().myGetStartX(), this.getShape().myGetStartY(), mouseX, mouseY);
    }
    
}
