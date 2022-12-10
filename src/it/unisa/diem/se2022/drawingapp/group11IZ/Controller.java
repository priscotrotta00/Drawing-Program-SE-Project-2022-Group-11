/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ChangeFillColorCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ChangeStrokeColorCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.Command;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.CutShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.DeleteShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.PasteShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.exceptions.ExtensionFileException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.SelectTool;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import static javafx.beans.binding.Bindings.not;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author prisc
 */
public class Controller implements Initializable {

    @FXML
    private Canvas canvasController;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;
    @FXML
    private ToggleButton lineToggleButton;
    @FXML
    private ToggleButton rectangleToggleButton;
    @FXML
    private ToggleButton ellipseToggleButton;
    @FXML
    private ToggleButton selectionToggleButton;
    @FXML
    private Button changeStrokeColorButton;
    @FXML
    private Button changeFillColorButton;
    @FXML
    private Button copyButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button cutButton;
    @FXML
    private Button pasteButton;
    @FXML
    private ColorPicker strokeColorPicker;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab fileTab;
    @FXML
    private Tab editTab;
    @FXML
    private Button undoButton;
    @FXML
    private Tab viewTab;
    //ADDED
    private ToggleGroup toolToggleGroup;
    private FileManager fileManager;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(editTab);
        
        fileManager = new FileManager();
        
        this.initializeToolToggleGroup();
        this.initializeChangeColorBindings();
        this.initializeDeleteBindings();

        this.initializeCopyShapeBindings();
        
        this.initializePasteBindings();
        
        
        this.initializeCutBindings();

        this.strokeColorPicker.valueProperty().bindBidirectional(this.canvasController.selectedStrokeColorProperty());
        this.fillColorPicker.valueProperty().bindBidirectional(this.canvasController.selectedFillColorProperty());
    }

    /**
     * Initialize the ToolToggleGroup, including the Tools Toggle Buttons inside
     * it
     */
    public void initializeToolToggleGroup() {
        //Initialize toolToggleGroup
        toolToggleGroup = new ToggleGroup();
        lineToggleButton.setToggleGroup(toolToggleGroup);
        rectangleToggleButton.setToggleGroup(toolToggleGroup);
        ellipseToggleButton.setToggleGroup(toolToggleGroup);
        selectionToggleButton.setToggleGroup(toolToggleGroup);

        toolToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == null) {
                newToggle = oldToggle;
                newToggle.setSelected(true);
                return;
            }

            this.updateSelectedTool(newToggle);
        });

        rectangleToggleButton.selectedProperty().setValue(true);

    }
    
    /**
     * Initialize the changeStrokeColorButton and changeFillColorButton bindings
     */
    
    public void initializeChangeColorBindings(){
        BooleanBinding ex = Bindings.or(not(this.selectionToggleButton.selectedProperty()), not(this.canvasController.getSelection().getSelectedProperty()));
        changeStrokeColorButton.disableProperty().bind(ex);
        changeFillColorButton.disableProperty().bind(ex);
    }

    /**
     * Initialize DeleteButton bind
     */
    public void initializeDeleteBindings() {
        BooleanBinding del = Bindings.or(not(this.canvasController.getSelection().getSelectedProperty()), not(this.selectionToggleButton.selectedProperty()));
        deleteButton.disableProperty().bind(del);
    }
    
    /**
     * Initialize the PasteShapeButton bind
     */
    
    public void initializePasteBindings() {
        pasteButton.disableProperty().bind(not(this.canvasController.getClipboard().copiedProperty()));
    }
    /**
     * Initialize the CopyShapeButton bind
     */
    public void initializeCopyShapeBindings(){
        BooleanBinding del = Bindings.or(not(this.canvasController.getSelection().getSelectedProperty()), not(this.selectionToggleButton.selectedProperty()));
        copyButton.disableProperty().bind(del);
    }
    
    /**
     * Initialize the CutShapeButton bind
     */
    public void initializeCutBindings(){
        BooleanBinding cut = Bindings.or(not(this.canvasController.getSelection().getSelectedProperty()),not(this.selectionToggleButton.selectedProperty()));
        cutButton.disableProperty().bind(cut);
    }

    /**
     * Change the selected tool according to the selected Toggle Button in the
     * Tool Toggle Group. This method will be called when there is a change in
     * the toggle group
     *
     * @param selectedToggle The selcted toggle of the toolToggleGroup
     */
    public void updateSelectedTool(Toggle selectedToggle) {
        ToggleButton toggle = (ToggleButton) selectedToggle;
        if (toggle.equals(ellipseToggleButton)) {
            this.canvasController.setTool(DrawEllipseTool.getInstance());
        } else if (toggle.equals(rectangleToggleButton)) {
            this.canvasController.setTool(DrawRectangleTool.getInstance());
        } else if (toggle.equals(lineToggleButton)) {
            this.canvasController.setTool(DrawLineTool.getInstance());
        } else if (toggle.equals(selectionToggleButton)) {
            this.canvasController.setTool(SelectTool.getInstance());
        }
    }
    
    /**
     * Get the Stroke Color picked by user from the Stroke Color Picker
     *
     * @return the Stroke Color picked by user
     */
    public Color getSelectedStrokeColor() {
        return this.strokeColorPicker.getValue();
    }

    /**
     * Get the Fill Color picked by user from the Fill Color Picker
     *
     * @return the Fill Color picked by user
     */
    public Color getSelectedFillColor() {
        return this.fillColorPicker.getValue();
    }

    /**
     * Load the drawing from a JSON file
     *
     * @param event
     */
    @FXML
    private void onLoadAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Open a drawing with .json extension");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
        File file = fc.showOpenDialog(null);
        if(file == null) return;
        Drawing loadedDrawing = fileManager.loadFile(file);
        this.canvasController.initializeNewDrawing(loadedDrawing);
    }

    /**
     * Save the drawing in a JSON file
     *
     * @param event
     */
    @FXML
    private void onSaveAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save the drawing in a .json file extension");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));	
	File file = fc.showSaveDialog(null);
        if(file == null) return;
        try {
            fileManager.saveFile(file, this.canvasController.getDraw());
        } catch(ExtensionFileException ex){
            new Alert(Alert.AlertType.ERROR, "File must have a .json extension!").showAndWait(); 
        }
    }

    /**
     * Change the stroke color of the selected shape with the color in the StrokeColorPicker
     * @param event 
     */
    
    @FXML
    private void onChangeStrokeColorAction(ActionEvent event) {
        Command ccc = new ChangeStrokeColorCommand(this.canvasController.getSelection().getSelectedItem(), this.getSelectedStrokeColor());
        ccc.execute();
    }

    /**
     * Change the fill color of the selected shape with the color in the fillColorPicker
     * @param event 
     */
    
    @FXML
    private void onChangeFillColorAction(ActionEvent event) {
        Command ccc = new ChangeFillColorCommand(this.canvasController.getSelection().getSelectedItem(), this.getSelectedFillColor());
        ccc.execute();
    }

    
    /**
     * get selected shape and call copyShape
     * @param event 
     */
    @FXML
    private void onCopyAction(ActionEvent event) {
        MyShape s = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        MyShape shapeClone=s.clone();
        this.canvasController.copyShape(shapeClone);
        //prendo la figura selezionata e la passo alla copyShape
    }

    /**
     * Delete the shape from Draw and Pane
     * @param event 
     */
    @FXML
    private void onDeleteAction(ActionEvent event) {
        MyShape s = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        Command deleteCommand = new DeleteShapeCommand(this.canvasController, s);
        deleteCommand.execute();
    }
    
    /**
     * Execute the cut actions. Delete the shape and adds it in the clipboard
     * @param event 
     */
    @FXML
    private void onCutAction(ActionEvent event) {
        // aggiungere qua la gestion di quando viene premuta la cut
        MyShape selectedShape = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        
        Command cutCommand = new CutShapeCommand(selectedShape, this.canvasController);
        cutCommand.execute();
    }

    /**
     * Paste the shape contained in the Clipboard object on the drawing
     * The method checks that the Clipboard object contains a shape
     * @param event 
     */
    
    @FXML
    private void onPasteAction(ActionEvent event) {
        if(not(this.canvasController.getClipboard().copiedProperty()).equals(true)) return;
        MyShape s = this.canvasController.getClipboard().getNewCopy();
        Command pasteShapeCommand = new PasteShapeCommand(this.canvasController, s);
        pasteShapeCommand.execute();
    }

    @FXML
    private void onUndoAction(ActionEvent event) {
    }
}
