/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ExtensionFileException;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.SelectTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Tool;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author prisc
 */
public class Controller implements Initializable {

    @FXML
    private Pane drawPane;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label shapeLabel;
    @FXML
    private ToggleButton lineToggleButton;
    @FXML
    private ToggleButton rectangleToggleButton;
    @FXML
    private ToggleButton ellipseToggleButton;
    @FXML
    private ToggleButton selectionToggleButton;
    @FXML
    private Label labelColors;
    @FXML
    private Button changeStrokeColorButton;
    @FXML
    private Button changeFillColorButton;
    @FXML
    private Label labelOptions;
    @FXML
    private Button copyButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button cutButton;
    @FXML
    private Button pasteButton;
    @FXML
    private Label strokeLabel;
    @FXML
    private ColorPicker strokeColorPicker;
    @FXML
    private Label fillLabel;
    @FXML
    private ColorPicker fillColorPicker;
    
    private Drawing draw;
    
    //ADDED
    private ToggleGroup toolToggleGroup;
    private ToggleGroup colorToggleGroup;
    private Rectangle clip;
    private Tool selectedTool;
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        System.out.println("Hello world");
        
        this.initializeToolToggleGroup();
        
        //
        clip = new Rectangle();
        clip.heightProperty().bind(drawPane.heightProperty());
        clip.widthProperty().bind(drawPane.widthProperty());
        drawPane.setClip(clip);
        
        this.initializeDrawPaneEventHandlers();
        
        //create draw
        this.draw=new Drawing();
        
        
        drawPane.setOnMouseClicked(value ->{
            selectedTool.handleOnPrimaryMouseClick(this, value);
        });
        
    }

    /**
     * Initialize the ToolToggleGroup, including the Tools Toggle Buttons inside
     * it
     */
    public void initializeToolToggleGroup(){
        //Initialize toolToggleGroup
        toolToggleGroup = new ToggleGroup();
        lineToggleButton.setToggleGroup(toolToggleGroup);
        rectangleToggleButton.setToggleGroup(toolToggleGroup);
        ellipseToggleButton.setToggleGroup(toolToggleGroup);
        selectionToggleButton.setToggleGroup(toolToggleGroup);
        
        toolToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == null){
                newToggle = oldToggle;
                newToggle.setSelected(true);
                return;
            }
            
            this.updateSelectedTool(newToggle);
        });
        
        rectangleToggleButton.selectedProperty().setValue(true);
    }
    
    /**
     * Initialize the Draw Pane Event Handlers
     */
    public void initializeDrawPaneEventHandlers(){
        drawPane.setOnDragDetected(value -> {
            selectedTool.handleOnDragBegin(this, value);
            drawPane.setOnMouseDragged(event -> {
                selectedTool.handleOnMouseDrag(this, event);
            });
            drawPane.setOnMouseReleased(event -> {
                selectedTool.handleOnDragEnd(this, event);
                drawPane.setOnMouseReleased(event2 -> {});
                drawPane.setOnMouseDragged(event2 -> {});
            });
        });
        
        drawPane.setOnMouseClicked(event -> {
            selectedTool.handleOnPrimaryMouseClick(this, event);
        });
        
        drawPane.setOnContextMenuRequested(event -> {
            selectedTool.handleOnContextMenuRequested(this, event);
        });
    }

    public void updateDraw(){
    
    }
    
    public Pane getDrawPane(){
        return drawPane;
    }
    
    /**
     * Change the selected tool according to the selected Toggle Button in the
     * Tool Toggle Group. This method will be called when there is a change in
     * the toggle group
     * @param selectedToggle The selcted toggle of the toolToggleGroup
     */
    public void updateSelectedTool(Toggle selectedToggle){
        ToggleButton toggle = (ToggleButton) selectedToggle;
        if (toggle.equals(ellipseToggleButton))
            this.selectedTool = DrawEllipseTool.getInstance();
        else if (toggle.equals(rectangleToggleButton))
            this.selectedTool = DrawRectangleTool.getInstance();
        else if (toggle.equals(lineToggleButton))
            this.selectedTool = DrawLineTool.getInstance();
        else if (toggle.equals(selectionToggleButton))
            this.selectedTool = SelectTool.getInstance();
    }
    
    public void updateSelectedColor(){
        
    }
    
    /**
     * Add MyShape into draw and into Pane. 
     * @param shape 
     */
    public void addShape(MyShape shape){
        drawPane.getChildren().add((Shape) shape);
        this.draw.addShape(shape);
    }
    
    /**
     * Delete MyShape draw and into Pane.
     * @param event 
     */
    public void removeShape(MyShape myShape) {
        drawPane.getChildren().remove(myShape);
        this.draw.removeShape(myShape); 
    }
    
    /**
     * Move the shape in foreground
     * @param myShape 
     */
    public void moveShapeToForeground(MyShape myShape){
        this.draw.moveToForeground(myShape);
    }
    
    /**
     * Move the shape in background
     * @param myShape 
     */
    public void moveShapeToBackground(MyShape myShape){
        this.draw.moveToBackground(myShape);
    }
    
    /**
     * Load the drawing from a JSON file
     * @param event 
     */
    
    @FXML
    private void onLoadAction(ActionEvent event) {
        //new Alert(Alert.AlertType.INFORMATION, "File must have a .json extension!").showAndWait();
        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Open a drawing with .json extension");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
            File file = fc.showOpenDialog(null);
            
            Drawing loadedDrawing = Drawing.importDrawing(file);
            for(MyShape myShape : this.draw){
                this.drawPane.getChildren().remove((Shape) myShape);
            }
            for(MyShape myShape : loadedDrawing){
                this.drawPane.getChildren().add((Shape) myShape);
            }
            this.draw = loadedDrawing;
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Save the drawing in a JSON file
     * @param event 
     */
    
    @FXML
    private void onSaveAction(ActionEvent event) {
        FileChooser fc = new FileChooser();     //IN SCRITTURA
        fc.setTitle("Save the drawing in a .json file extension");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));	
	File file = fc.showSaveDialog(null);
        try {
            this.draw.exportDrawing(file);
        }catch(ExtensionFileException ex){
            new Alert(Alert.AlertType.INFORMATION, "File must have a .json extension!").showAndWait();
        }
    }

    @FXML
    private void onChangeStrokeColorAction(ActionEvent event) {
    }

    @FXML
    private void onChangeFillColorAction(ActionEvent event) {
    }

    @FXML
    private void onCopyAction(ActionEvent event) {
    }

    @FXML
    private void onDeleteAction(ActionEvent event) {
    }

    @FXML
    private void onCutAction(ActionEvent event) {
    }

    @FXML
    private void onPasteAction(ActionEvent event) {
    }
    
}
