/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Tool;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
    private ToggleButton whiteColorToggleButton;
    @FXML
    private ToggleButton redColorToggleButton;
    @FXML
    private ToggleButton greenColorToggleButton;
    @FXML
    private ToggleButton blueColorToggleButton;
    @FXML
    private ToggleButton blackColorToggleButton;
    @FXML
    private ToggleButton yellowColorToggleButton;
    @FXML
    private ToggleButton greyColorToggleButton;
    @FXML
    private ToggleButton pinkColorToggleButton;
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
        
        //Initialize colorToggleGroup
        colorToggleGroup = new ToggleGroup();
        whiteColorToggleButton.setToggleGroup(colorToggleGroup);
        redColorToggleButton.setToggleGroup(colorToggleGroup);
        greenColorToggleButton.setToggleGroup(colorToggleGroup);
        blueColorToggleButton.setToggleGroup(colorToggleGroup);
        blackColorToggleButton.setToggleGroup(colorToggleGroup);
        yellowColorToggleButton.setToggleGroup(colorToggleGroup);
        greyColorToggleButton.setToggleGroup(colorToggleGroup);
        pinkColorToggleButton.setToggleGroup(colorToggleGroup);
        
        //
        clip = new Rectangle();
        clip.heightProperty().bind(drawPane.heightProperty());
        clip.widthProperty().bind(drawPane.widthProperty());
        drawPane.setClip(clip);
        
        drawPane.setOnDragDetected(value -> {
            selectedTool.handleOnDragBegin(this, value);
            drawPane.setOnMouseReleased(event -> {
                selectedTool.handleOnDragEnd(this, event);
                drawPane.setOnMouseReleased(event2 -> {});
            });
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
        
        toolToggleGroup.selectedToggleProperty().addListener(toggle -> {
            this.updateSelectedTool(toolToggleGroup.getSelectedToggle());
        });
        rectangleToggleButton.selectedProperty().setValue(true);
    }

    public void updateDraw(){
    
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
        else if (toggle.equals(selectionToggleButton));
    }
    
    public void updateSelectedColor(){
        
    }
    
    public void addShape(Shape shape){
        drawPane.getChildren().add(shape);
    }
    
    @FXML
    private void onLoadAction(ActionEvent event) {
    }

    @FXML
    private void onSaveAction(ActionEvent event) {
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
