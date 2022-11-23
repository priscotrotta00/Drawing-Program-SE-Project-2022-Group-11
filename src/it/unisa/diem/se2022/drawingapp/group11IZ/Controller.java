/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

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
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        System.out.println("Hello world");  
        
        //Initialize toolToggleGroup
        toolToggleGroup = new ToggleGroup();
        lineToggleButton.setToggleGroup(toolToggleGroup);
        rectangleToggleButton.setToggleGroup(toolToggleGroup);
        ellipseToggleButton.setToggleGroup(toolToggleGroup);
        selectionToggleButton.setToggleGroup(toolToggleGroup);
        
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
    }    

    public void updateDraw(){
    
    }
    
    public void updateSelectedTool(){
        
    }
    
    public void updateSelectedColor(){
        
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
