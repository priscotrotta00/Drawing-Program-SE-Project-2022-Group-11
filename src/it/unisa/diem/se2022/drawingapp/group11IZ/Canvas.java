/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Tool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * FXML Controller class
 * 
 * @author scala
 */
public class Canvas implements Initializable {

    @FXML
    private Pane drawPane;
    private Drawing draw;
    private Rectangle clip;
    private Selection selection;
    private Clipboard clipboard;
    private Tool selectedTool;
    private final ObjectProperty<Color> selectedStrokeColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> selectedFillColor = new SimpleObjectProperty<>();

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
        
        clip = new Rectangle();
        clip.heightProperty().bind(drawPane.heightProperty());
        clip.widthProperty().bind(drawPane.widthProperty());
        drawPane.setClip(clip);
        
        this.setSelectedFillColor(Color.WHITE);
        this.setSelectedStrokeColor(Color.BLACK);
        
        this.initializeDrawPaneEventHandlers();
    }

    /**
     * Initialize the Draw Pane Event Handlers
     */
    private void initializeDrawPaneEventHandlers() {
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

        drawPane.setOnMouseClicked(event -> {
            selectedTool.handleOnPrimaryMouseClick(this, event);
        });

        drawPane.setOnContextMenuRequested(event -> {
            selectedTool.handleOnContextMenuRequested(this, event);
        });
    }
    
    public void updateDraw() {

    }

    public Pane getDrawPane() {
        return drawPane;
    }
    
    public Drawing getDraw() {
        return this.draw;
    }
    
    public void setDraw(Drawing draw) {
        this.draw = draw;
    }
    
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
        drawPane.getChildren().add((Shape) shape);

    }
    
    /**
     * Delete MyShape draw and into Pane.
     *
     * @param event
     */
    public void removeShape(MyShape myShape) {
        this.draw.removeShape(myShape);
        drawPane.getChildren().remove(myShape);

    }

    /**
     * Move the shape in foreground
     *
     * @param myShape
     */
    public void moveShapeToForeground(MyShape myShape) {
        this.draw.moveToForeground(myShape);
    }

    /**
     * Move the shape in background
     *
     * @param myShape
     */
    public void moveShapeToBackground(MyShape myShape) {
        this.draw.moveToBackground(myShape);
    }
    
    /**
     * Copy the shape in Clipboard for use it in future
     * @param shape 
     */
    public void copyShape(MyShape shape){
        this.clipboard.copy(shape);
    }
    
    protected Clipboard getClipboard(){
        return this.clipboard;
    }
    
    public Selection getSelection(){
        return this.selection;
    }
    
}
