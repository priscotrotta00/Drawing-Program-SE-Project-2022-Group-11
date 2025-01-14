package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ChangeFillColorCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.ChangeStrokeColorCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.Command;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.CutShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.DeleteShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.MoveBackgroundShapeCommand;
import it.unisa.diem.se2022.drawingapp.group11IZ.commands.MoveForegroundShapeCommand;
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
import javafx.beans.value.ObservableValue;
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
    private Button foregroundButton;
    @FXML
    private Button backgroundButton;
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
        BooleanBinding selectedAndChosenSelectToolCondition;
        SingleSelectionModel<Tab> selectionModel;
        
        // Set Edit Tab as default one
        selectionModel = tabPane.getSelectionModel();
        selectionModel.select(editTab);
        
        // Create a file manager to manage files
        fileManager = new FileManager();
        
        // Define all buttons bindings
        selectedAndChosenSelectToolCondition = Bindings.or(
                not(this.selectionToggleButton.selectedProperty()), 
                not(this.canvasController.getSelection().getSelectedProperty())
        );
        this.initializeToolToggleGroup();
        this.initializeButtonDisablePropertyBinding(this.changeFillColorButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.changeStrokeColorButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.deleteButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.copyButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.cutButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.backgroundButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.foregroundButton, selectedAndChosenSelectToolCondition);
        this.initializeButtonDisablePropertyBinding(this.pasteButton, this.canvasController.getClipboard().copiedProperty().not());
        this.initializeButtonDisablePropertyBinding(this.undoButton, this.canvasController.getCommandInvoker().stackIsEmptyProperty());
        
        // Bindings with Canvas for selected colors
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

        // Set listener to activate when a new button is selected
        toolToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == null) {
                newToggle = oldToggle;
                newToggle.setSelected(true);
                return;
            }

            this.updateSelectedTool(newToggle);
        });

        // Set Rectangle Button as default one
        rectangleToggleButton.selectedProperty().setValue(true);

    }
    
    /**
     * Initialize the bind between the Disable property of a button and another Observable Boolean Value
     * @param button Button on which the binding should be performed
     * @param observable Other observable boolean value on which the binding should be performed
     */
    private void initializeButtonDisablePropertyBinding(Button button, ObservableValue<? extends Boolean> observable){
        button.disableProperty().bind(observable);
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
        
        // Update seletected tool inside Canvas according to the selected button
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
     * @param event
     */    
    @FXML
    private void onLoadAction(ActionEvent event){
        // Open a new File Chooser to select a new file
        FileChooser fc = new FileChooser();
        fc.setTitle("Open a drawing with .json extension");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
        File file = fc.showOpenDialog(null);
        
        // Load the saved drawing
        if(file == null) return;
        Drawing loadedDrawing = fileManager.loadFile(file);
        this.canvasController.initializeNewDrawing(loadedDrawing);
    }

    /**
     * Save the drawing in a JSON file
     * @param event
     */   
    @FXML
    private void onSaveAction(ActionEvent event) {
        // Open a File Chooser to select where the drawing should be saved
        FileChooser fc = new FileChooser();
        fc.setTitle("Save the drawing in a .json file extension");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));	
	File file = fc.showSaveDialog(null);
        
        // Save drawing to the file
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
        // Create and execute a new ChangeColorCommand
        Command ccc = new ChangeStrokeColorCommand(this.canvasController, this.canvasController.getSelection().getSelectedItem(), this.getSelectedStrokeColor());
        this.canvasController.getCommandInvoker().execute(ccc);
    }

    /**
     * Change the fill color of the selected shape with the color in the fillColorPicker
     * @param event 
     */   
    @FXML
    private void onChangeFillColorAction(ActionEvent event) {
        // Create and execute a new ChangeFillColorCommand
        Command ccc = new ChangeFillColorCommand(this.canvasController, this.canvasController.getSelection().getSelectedItem(), this.getSelectedFillColor());
        this.canvasController.getCommandInvoker().execute(ccc);
    }
    
    /**
     * Get selected shape and call copyShape
     * @param event 
     */
    @FXML
    private void onCopyAction(ActionEvent event) {
        // Create a new copy of the selected shape and give it to the clipboard
        MyShape s = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        MyShape shapeClone=s.clone();
        this.canvasController.copyShape(shapeClone);
    }

    /**
     * Delete the shape from Draw and Pane
     * @param event 
     */
    @FXML
    private void onDeleteAction(ActionEvent event) {
        // Get the selected shape and execute a new Delete Shape Command
        MyShape s = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        Command deleteCommand = new DeleteShapeCommand(this.canvasController, s);
        this.canvasController.getCommandInvoker().execute(deleteCommand);
    }
    
    /**
     * Execute the cut actions. Delete the shape and adds it in the clipboard
     * @param event 
     */
    @FXML
    private void onCutAction(ActionEvent event) {
        // Get the selected shape and execute a new Cut Shape Command
        MyShape selectedShape = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        
        Command cutCommand = new CutShapeCommand(selectedShape, this.canvasController);
        this.canvasController.getCommandInvoker().execute(cutCommand);
    }

    /**
     * Paste the shape contained in the Clipboard object on the drawing
     * The method checks that the Clipboard object contains a shape
     * @param event 
     */
    @FXML
    private void onPasteAction(ActionEvent event) {
        // Get a new copy of the shape inside the clipboard and execute the Paste Command
        if(not(this.canvasController.getClipboard().copiedProperty()).equals(true)) return;
        MyShape s = this.canvasController.getClipboard().getNewCopy();
        Command pasteShapeCommand = new PasteShapeCommand(this.canvasController, s);
        this.canvasController.getCommandInvoker().execute(pasteShapeCommand);
    }

    /**
     * Execute MoveForeground action
     * @param event 
     */
    @FXML
    private void onForegroundAction(ActionEvent event) {
        // Get the selected shape and execute a new Move to Foreground Command
        MyShape s = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        Command moveForegroundCommand=new MoveForegroundShapeCommand(this.canvasController,s);
        this.canvasController.getCommandInvoker().execute(moveForegroundCommand);
    }

    /**
     * Execute MoveBackground action
     * @param event 
     */
    @FXML
    private void onBackgroundAction(ActionEvent event) {
        // Get the selected shape and execute a new Move to Foreground Commnad
        MyShape s = this.canvasController.getSelection().getSelectedItem();
        this.canvasController.getSelection().unSelect();
        Command moveBackgroundCommand=new MoveBackgroundShapeCommand(this.canvasController, s);
        this.canvasController.getCommandInvoker().execute(moveBackgroundCommand);
    }
    
    /**
     * Execute the undo operation of the last command executed
     * @param event 
     */
    @FXML
    private void onUndoAction(ActionEvent event) {
        // Undo the last done operation
        if(this.canvasController.getSelection().getSelectedValue()) this.canvasController.getSelection().unSelect();
        this.canvasController.getCommandInvoker().undoLast();
    }
}
