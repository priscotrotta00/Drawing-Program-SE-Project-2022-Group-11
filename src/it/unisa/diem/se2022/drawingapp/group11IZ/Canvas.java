package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.CommandInvoker;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Tool;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Class that represents the Drawing area inside the User Interface. It has some
 * methods to update the View and the Models together
 * 
 * @author scala
 */
public class Canvas implements Initializable {

    @FXML
    private Pane drawPane;
    private Drawing draw;
    private Rectangle clip;
    private Selection selection;
    private CommandInvoker commandInvoker;
    private Clipboard clipboard;
    private Tool selectedTool;
    private final ObjectProperty<Color> selectedStrokeColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> selectedFillColor = new SimpleObjectProperty<>();
    private final Map<MyShape, MyShape> previewShapesMap = new HashMap<>();

    public Color getSelectedFillColor() {
        return selectedFillColor.get();
    }

    public void setSelectedFillColor(Color value) {
        selectedFillColor.set(value);
    }

    public ObjectProperty selectedFillColorProperty() {
        return selectedFillColor;
    }

    public Color getSelectedStrokeColor() {
        return selectedStrokeColor.get();
    }

    public void setSelectedStrokeColor(Color value) {
        selectedStrokeColor.set(value);
    }

    public ObjectProperty selectedStrokeColorProperty() {
        return selectedStrokeColor;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.draw = new Drawing();
        this.clipboard = new Clipboard();
        this.selection = new Selection(this);
        this.commandInvoker = new CommandInvoker();
        
        // Clip the drawPane in order to not show a figure outside of the sha
        clip = new Rectangle();
        clip.heightProperty().bind(drawPane.heightProperty());
        clip.widthProperty().bind(drawPane.widthProperty());
        drawPane.setClip(clip);
        
        // Set default colors
        this.setSelectedFillColor(Color.WHITE);
        this.setSelectedStrokeColor(Color.BLACK);
        
        // Initialize some event handlers for the drawPane
        this.initializeDrawPaneEventHandlers();
    }

    /**
     * Initialize the Draw Pane Event Handlers
     */
    private void initializeDrawPaneEventHandlers() {
        // Initialize the Drag Detected action
        drawPane.setOnDragDetected(value -> {
            selectedTool.handleOnDragBegin(this, value);
            drawPane.setOnMouseDragged(event -> {
                selectedTool.handleOnMouseDrag(this, event);
            });
            drawPane.setOnMouseReleased(event -> {
                selectedTool.handleOnDragEnd(this, event);
                drawPane.setOnMouseReleased(event2 -> {
                });
                drawPane.setOnMouseDragged(event2 -> {
                });
            });
        });

        // Initialize the Mouse Clicked action
        drawPane.setOnMouseClicked(event -> {
            selectedTool.handleOnPrimaryMouseClick(this, event);
        });

        // Initialize the Context Menu Requested action
        drawPane.setOnContextMenuRequested(event -> {
            selectedTool.handleOnContextMenuRequested(this, event);
        });
    }

    /**
     * Get the drawPane inside the Canvas
     * @return a Pane
     */
    public Pane getDrawPane() {
        return drawPane;
    }
    
    /**
     * Get the actual drawing 
     * @return a Drawing
     */
    public Drawing getDraw() {
        return this.draw;
    }
    
    /**
     * Set a new tool
     * @param tool 
     */
    public void setTool(Tool tool){
        this.selectedTool = tool;
    }
    
    /**
     * Add MyShape into draw and into Pane.
     *
     * @param shape
     */
    public void addShape(MyShape shape){
        this.draw.addShape(shape);
        drawPane.getChildren().add(shape.getView());
    }
    
    /**
     * Delete MyShape from draw and Pane.
     * @param myShape
     */
    public void removeShape(MyShape myShape) {
        drawPane.getChildren().remove(this.draw.getShapeLayer(myShape));
    
        this.draw.removeShape(myShape);
        //drawPane.getChildren().remove(myShape.getView());
       // drawPane.getChildren().remove(this.drawPane.getChildren().re);
    }

    /**
     * Move the shape in foreground
     *
     * @param myShape
     */
    public void moveShapeToForeground(MyShape myShape) {
        int layer=this.drawPane.getChildren().indexOf(myShape);
        this.draw.moveToForeground(myShape);
        drawPane.getChildren().remove(layer);
        drawPane.getChildren().add(myShape.getView());
    }

    /**
     * Move the shape in background
     *
     * @param myShape
     */
    public void moveShapeToBackground(MyShape myShape) {
        int layer=this.drawPane.getChildren().indexOf(myShape);
        
        this.draw.moveToBackground(myShape);
        //remove shape from drawPane, add in first pos and add the another element ad the end of list
        drawPane.getChildren().remove(layer);
        drawPane.getChildren().add(0, myShape.getView());
    }
    
    /**
     * Copy the shape in Clipboard for use it in future
     * @param shape 
     */
    public void copyShape(MyShape shape){
        this.clipboard.copy(shape);
    }
    
    /**
     * Return clipboard
     * @return 
     */
    protected Clipboard getClipboard(){
        return this.clipboard;
    }
    
    /**
     * Return the Command Invoker that keeps the history of the commands that
     * have been executed
     * @return 
     */
    public CommandInvoker getCommandInvoker(){
        return this.commandInvoker;
    }
    
    /**
     * Return the Selection object that represent 
     * @return 
     */
    public Selection getSelection(){
        return this.selection;
    }
    
    /**
     * Add a bounding box into the pane
     * @param boundingBox 
     */
    public void addBoundingBox(Group boundingBox){
        this.drawPane.getChildren().add(boundingBox);
    }
    
    /**
     * Remove the given bounding box from the pane
     * @param boundingBox 
     */
    public void removeBoundingBox(Group boundingBox){
        this.drawPane.getChildren().remove(boundingBox);
    }
    
    /**
     * Add the preview of a new shape into the pane
     * @param preview 
     */
    public void addPreviewNewShape(MyShape preview){
        this.drawPane.getChildren().add(preview.getView());
    }
    
    /**
     * Remove the preview of the new shape
     * @param preview 
     */
    public void removePreviewNewShape(MyShape preview){
        if (!this.drawPane.getChildren().contains(preview.getView())) throw new RuntimeException();
        this.drawPane.getChildren().remove(preview.getView());
    }
    
    /**
     * Substitute a shape with its preview on the pane. The original shape is 
     * not deleted from the drawing but it is not visible on the pane
     * @param shape
     * @return 
     */
    public MyShape substituteShapeWithPreview(MyShape shape){
        int layer;
        MyShape preview;
        
        layer = this.draw.getShapeLayer(shape);
        preview = shape.clone();
        
        drawPane.getChildren().remove(shape.getView());
        this.previewShapesMap.put(shape, preview);
        drawPane.getChildren().add(layer, preview.getView());
        
        return preview;
    }
    
    /**
     * Delete the preview and substitute it with the original associated shape
     * @param shape 
     */
    public void substitutePreviewWithOriginalShape(MyShape shape){
        int layer = this.draw.getShapeLayer(shape);
        MyShape preview = this.previewShapesMap.get(shape);
        
        this.drawPane.getChildren().remove(preview.getView());
        this.drawPane.getChildren().add(layer, shape.getView());
    }
    
    /**
     * Substitute the current drawing with the new given one. The pane will be
     * updated too
     * @param draw 
     */
    public void initializeNewDrawing(Drawing draw){
        if(draw == null) throw new NullPointerException();
        this.getSelection().unSelect();

        for(MyShape myShape : this.getDraw()){
            this.getDrawPane().getChildren().remove((Shape) myShape);
        }

        for(MyShape myShape : draw){
            this.getDrawPane().getChildren().add((Shape) myShape);
        }
        this.draw = draw;
    }
    /**
     * Move the shape at different Layer
     * @param s 
     */
    public void moveToLayer(MyShape s, int layer){
        this.removeShape(s);
        //for draw
        this.getDraw().addShape(s);
        this.getDraw().moveToLayer(s, layer);
        //for drawpane
        this.getDrawPane().getChildren().add(layer, s.getView());

    }
    
    public void moveToLayer2(MyShape s, int layer){
        
        //for draw
        this.getDraw().addShape(s);
        this.getDraw().moveToLayer(s, layer);
        //for drawpane
        this.getDrawPane().getChildren().add(layer, s.getView());

    }
    
    /**
     * Change stroke color of the given shape and its preview (if any)
     * @param myShape
     * @param color 
     */
    public void changeShapeStrokeColor(MyShape myShape, Color color) {
        myShape.mySetStroke(color);
        if (this.previewShapesMap.containsKey(myShape)) this.previewShapesMap.get(myShape).mySetStroke(color);
    }
    
    /**
     * Change fill color of the given shape and its preview (if any)
     * @param myShape
     * @param color 
     */
    public void changeShapeFillColor(MyShape myShape, Color color) {
        myShape.mySetFill(color);
        if (this.previewShapesMap.containsKey(myShape)) this.previewShapesMap.get(myShape).mySetFill(color);
    }
    
}
