package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ResizeShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Class that define the behaviour a bounding box will have on a rectangle.
 * @author Felice Scala
 */
public class SelectionRectangleHelper extends FourVerticesBaseSelectionHelper{
    
    public SelectionRectangleHelper(Canvas canvas, MyRectangle rectangle){
        this.setCanvas(canvas);
        this.setShape(rectangle);
    }
    
    @Override
    MyRectangle getShape(){
        return (MyRectangle) super.getShape();
    }
    
    @Override
    public MyRectangle getPreview(){
        return (MyRectangle) super.getPreview();
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
    void updateVertices(){
        // Initialize first vertex on the top left point of the rectangle
        this.getVertex1().mySetWidth(WIDTH_VERTEX);
        this.getVertex1().mySetHeight(HEIGHT_VERTEX);
        this.getVertex1().getView().setCursor(Cursor.NW_RESIZE);
        this.getVertex1().myXProperty().bind(this.getPreview().topLeftXProperty());
        this.getVertex1().myYProperty().bind(this.getPreview().topLeftYProperty());
        
        // Initialize first vertex on the top right point of the rectangle
        this.getVertex2().mySetWidth(WIDTH_VERTEX);
        this.getVertex2().mySetHeight(HEIGHT_VERTEX);
        this.getVertex2().getView().setCursor(Cursor.NE_RESIZE);
        this.getVertex2().myXProperty().bind(this.getPreview().bottomRightXProperty().subtract(WIDTH_VERTEX));
        this.getVertex2().myYProperty().bind(this.getPreview().topLeftYProperty());
        
        // Initialize fourth vertex on the bottom left point of the rectangle
        this.getVertex4().mySetWidth(WIDTH_VERTEX);
        this.getVertex4().mySetHeight(HEIGHT_VERTEX);
        this.getVertex4().getView().setCursor(Cursor.SW_RESIZE);
        this.getVertex4().myXProperty().bind(this.getPreview().topLeftXProperty());
        this.getVertex4().myYProperty().bind(this.getPreview().bottomRightYProperty().subtract(HEIGHT_VERTEX));
        
        // Initialize third vertex on the bottom right point of the rectangle
        this.getVertex3().mySetWidth(WIDTH_VERTEX);
        this.getVertex3().mySetHeight(HEIGHT_VERTEX);
        this.getVertex3().getView().setCursor(Cursor.SE_RESIZE);
        this.getVertex3().myXProperty().bind(this.getPreview().bottomRightXProperty().subtract(WIDTH_VERTEX));
        this.getVertex3().myYProperty().bind(this.getPreview().bottomRightYProperty().subtract(HEIGHT_VERTEX));
    }

    @Override
    MyShape createBoundingBoxEdge() {
        MyRectangle rectangleBoundingBox = new MyEnhancedRectangle();
        
        // Bind the bounding box to the rectangle
        rectangleBoundingBox.myXProperty().bindBidirectional(this.getPreview().myXProperty());
        rectangleBoundingBox.myYProperty().bindBidirectional(this.getPreview().myYProperty());
        rectangleBoundingBox.myWidthProperty().bindBidirectional(this.getPreview().myWidthProperty());
        rectangleBoundingBox.myHeightProperty().bindBidirectional(this.getPreview().myHeightProperty());
        
        // Define the aspect of the bounding box
        rectangleBoundingBox.mySetStroke(Color.BLACK);
        rectangleBoundingBox.mySetFill(Color.TRANSPARENT);
        rectangleBoundingBox.mySetStrokeWidth(this.getPreview().myGetStrokeWidth() + STROKE_VERTEX_OFFSET);
        rectangleBoundingBox.myGetStrokeDashArray().addAll(STROKE_DASH_LIST);
        rectangleBoundingBox.getView().setCursor(Cursor.CLOSED_HAND);
        
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
        return mouseX <= this.getPreview().getBottomRightX() && mouseY <= this.getPreview().getBottomRightY();
    }

    @Override
    void onMouseDragVertex1Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(mouseX, mouseY, this.getPreview().getBottomRightX(), this.getPreview().getBottomRightY());
        this.getCommand().setNewCoordinates(mouseX, mouseY, this.getPreview().getBottomRightX(), this.getPreview().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex2Condition(double mouseX, double mouseY) {
        return mouseX >= this.getPreview().getTopLeftX() && mouseY <= this.getPreview().getBottomRightY();
    }

    @Override
    void onMouseDragVertex2Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(this.getPreview().getTopLeftX(), mouseY, mouseX, this.getPreview().getBottomRightY());
        this.getCommand().setNewCoordinates(this.getPreview().getTopLeftX(), mouseY, mouseX, this.getPreview().getBottomRightY());
    }

    @Override
    boolean onMouseDragVertex4Condition(double mouseX, double mouseY) {
        return mouseY >= this.getPreview().getTopLeftY() && mouseX <= this.getPreview().getBottomRightX();
    }

    @Override
    void onMouseDragVertex4Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(mouseX, this.getPreview().getTopLeftY(), this.getPreview().getBottomRightX(), mouseY);
        this.getCommand().setNewCoordinates(mouseX, this.getPreview().getTopLeftY(), this.getPreview().getBottomRightX(), mouseY);
    }

    @Override
    boolean onMouseDragVertex3Condition(double mouseX, double mouseY) {
        return mouseX >= this.getPreview().getTopLeftX() && mouseY >= this.getPreview().getTopLeftY();
    }

    @Override
    void onMouseDragVertex3Action(double mouseX, double mouseY) {
        this.getPreview().modifyShape(this.getPreview().getTopLeftX(), this.getPreview().getTopLeftY(), mouseX, mouseY);
        this.getCommand().setNewCoordinates(this.getPreview().getTopLeftX(), this.getPreview().getTopLeftY(), mouseX, mouseY);
    }
}
