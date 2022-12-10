/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;

/**
 *
 * @author utente
 */
public class ControllerTest {
    private Controller controller;
    private Canvas canvas;
    
    private Pane drawPane;
    private Drawing draw;
    private Selection selection;
    
    private Field lineToggleButtonField;
    private Field rectangleToggleButtonField;
    private Field ellipseToggleButtonField;
    private Field selectionToggleButtonField;
    private Field toolToggleGroupField;
    private Field strokeColorPickerField;
    private Field fillColorPickerField;
    private Field copyButtonField;
    private Field cutButtonField;
    private Field pasteButtonField;
    private Field deleteButtonField;
    private Field changeStrokeColorButtonField;
    private Field changeFillColorButtonField;
    private Field loadButtonField;
    private Field saveButonField;
    private Field tabPaneField;
    private Field fileTabField;
    private Field editTabField;
    private Field viewTabField;
    private Field undoButtonField;
    private Field canvasField;
    
    private Field selectedToolField;
    private Field drawPaneField;
    private Field drawingField;
    
    private Button loadButton;
    private Button saveButton;
    private ToggleButton lineToggleButton;
    private ToggleButton rectangleToggleButton;
    private ToggleButton ellipseToggleButton;
    private ToggleButton selectionToggleButton;
    private Button changeStrokeColorButton;
    private Button changeFillColorButton;
    private Button copyButton;
    private Button deleteButton;
    private Button cutButton;
    private Button pasteButton;
    private ColorPicker strokeColorPicker;
    private ColorPicker fillColorPicker;
    private TabPane tabPane;
    private Tab fileTab;
    private Tab editTab;
    private Button undoButton;
    private Tab viewTab;
    
    public static class AsNonApp extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            //NOOP
        }
        
    }
    
    @BeforeClass
    public static void initJFX() {
        Thread t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(AsNonApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
    }
    
    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException{
        this.setUpCanvas();
        this.setUpController();
    }
    
    private void setUpController() throws NoSuchFieldException, IllegalAccessException{
        controller = new Controller();
        
        lineToggleButton = new ToggleButton();
        ellipseToggleButton = new ToggleButton();
        rectangleToggleButton = new ToggleButton();
        selectionToggleButton = new ToggleButton();
        strokeColorPicker = new ColorPicker();
        fillColorPicker = new ColorPicker();
        changeStrokeColorButton = new Button();
        changeFillColorButton = new Button();
        copyButton = new Button();
        deleteButton = new Button();
        cutButton = new Button();
        pasteButton = new Button();
        tabPane = new TabPane();
        fileTab = new Tab();
        editTab = new Tab();
        undoButton = new Button();
        viewTab = new Tab();
        
        lineToggleButtonField = Controller.class.getDeclaredField("lineToggleButton");
        rectangleToggleButtonField = Controller.class.getDeclaredField("rectangleToggleButton");
        ellipseToggleButtonField = Controller.class.getDeclaredField("ellipseToggleButton");
        selectionToggleButtonField = Controller.class.getDeclaredField("selectionToggleButton");
        //toolToggleGroupField = Controller.class.getDeclaredField("toolToggleGroup");
        strokeColorPickerField = Controller.class.getDeclaredField("strokeColorPicker");
        fillColorPickerField = Controller.class.getDeclaredField("fillColorPicker");
        changeStrokeColorButtonField = Controller.class.getDeclaredField("changeStrokeColorButton");
        changeFillColorButtonField = Controller.class.getDeclaredField("changeFillColorButton");
        copyButtonField=Controller.class.getDeclaredField("copyButton");
        deleteButtonField=Controller.class.getDeclaredField("deleteButton");
        cutButtonField = Controller.class.getDeclaredField("cutButton");
        pasteButtonField = Controller.class.getDeclaredField("pasteButton");
        tabPaneField = Controller.class.getDeclaredField("tabPane");
        fileTabField = Controller.class.getDeclaredField("fileTab");
        editTabField = Controller.class.getDeclaredField("editTab");
        viewTabField = Controller.class.getDeclaredField("viewTab");
        undoButtonField = Controller.class.getDeclaredField("undoButton");
        canvasField = Controller.class.getDeclaredField("canvasController");
       
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.strokeColorPickerField.setAccessible(true);
        this.fillColorPickerField.setAccessible(true);
        this.changeFillColorButtonField.setAccessible(true);
        this.changeStrokeColorButtonField.setAccessible(true);
        this.copyButtonField.setAccessible(true);
        this.cutButtonField.setAccessible(true);
        this.pasteButtonField.setAccessible(true);
        this.deleteButtonField.setAccessible(true);
        this.tabPaneField.setAccessible(true);
        this.fileTabField.setAccessible(true);
        this.editTabField.setAccessible(true);
        this.viewTabField.setAccessible(true);
        this.undoButtonField.setAccessible(true);
        this.canvasField.setAccessible(true);
        
        this.ellipseToggleButtonField.set(controller, ellipseToggleButton);
        this.lineToggleButtonField.set(controller, lineToggleButton);
        this.rectangleToggleButtonField.set(controller, rectangleToggleButton);
        this.selectionToggleButtonField.set(controller, selectionToggleButton);
        this.strokeColorPickerField.set(controller, strokeColorPicker);
        this.fillColorPickerField.set(controller, fillColorPicker);
        this.changeFillColorButtonField.set(controller, changeFillColorButton);
        this.changeStrokeColorButtonField.set(controller, changeStrokeColorButton);
        this.copyButtonField.set(controller, copyButton);
        this.cutButtonField.set(controller, cutButton);
        this.pasteButtonField.set(controller, pasteButton);
        this.deleteButtonField.set(controller, deleteButton);
        this.tabPaneField.set(controller, tabPane);
        this.fileTabField.set(controller, fileTab);
        this.editTabField.set(controller, editTab);
        this.viewTabField.set(controller, viewTab);
        this.undoButtonField.set(controller, undoButton);
        this.canvasField.set(controller, canvas);
        
        controller.initialize(null, null);
    }
    
    private void setUpCanvas() throws NoSuchFieldException, IllegalAccessException{
        canvas = new Canvas();
        drawPane = new Pane();
        
        selectedToolField = Canvas.class.getDeclaredField("selectedTool");
        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawingField = Canvas.class.getDeclaredField("draw");
        
        selectedToolField.setAccessible(true);
        drawPaneField.setAccessible(true);
        drawingField.setAccessible(true);
        
        drawPaneField.set(canvas, drawPane);
        canvas.initialize(null ,null);
        
        draw = canvas.getDraw();
    }
   
    @Test
    public void testUpdateSelectedToolEllipse() throws IllegalAccessException{
        ellipseToggleButton.selectedProperty().set(true);
        Assert.assertEquals("Test Ellipse selected", DrawEllipseTool.getInstance(), this.selectedToolField.get(canvas));
       
    }
    
    @Test
    public void testUpdateSelectedToolRectangle() throws IllegalAccessException{
        rectangleToggleButton.selectedProperty().set(true);
        Assert.assertEquals("Test Rectangle selected", DrawRectangleTool.getInstance(), this.selectedToolField.get(canvas));  
    }
    
    @Test
    public void testUpdateSelectedToolLine() throws IllegalAccessException{
        lineToggleButton.selectedProperty().set(true);
        Assert.assertEquals("Test Rectangle selected", DrawLineTool.getInstance(), this.selectedToolField.get(canvas));  
    }
    
    @Test
    public void testUpdateSelectedToolUnselect() throws IllegalAccessException{
        ellipseToggleButton.setSelected(true);
        ellipseToggleButton.setSelected(false);

        Assert.assertTrue("Tool toggle button is not unselected", ellipseToggleButton.selectedProperty().get());
        Assert.assertEquals("Tool has not changed", DrawEllipseTool.getInstance(), this.selectedToolField.get(canvas));
    }
    
    @Test
    public void testGetSelectedStrokeColor() throws IllegalAccessException{
        ColorPicker colorPicker = strokeColorPicker;
        
        colorPicker.setValue(Color.BLUE);
        Assert.assertEquals("Test stroke color blue (static)", this.controller.getSelectedStrokeColor().toString(), Color.BLUE.toString());
        colorPicker.setValue(Color.web("#f68"));
        Assert.assertEquals("Test stroke color orange (web)", this.controller.getSelectedStrokeColor().toString(), Color.web("#f68").toString());
        colorPicker.setValue(Color.web("#00ff00"));
        Assert.assertEquals("Test stroke color green (web)", this.controller.getSelectedStrokeColor().toString(), Color.web("#00ff00").toString());
    }
    
    @Test
    public void testGetSelectedFillColor() throws IllegalAccessException{
        ColorPicker colorPicker = fillColorPicker;
        
        colorPicker.setValue(Color.BLUE);
        Assert.assertEquals("Test stroke color blue (static)", this.controller.getSelectedFillColor().toString(), Color.BLUE.toString());
        colorPicker.setValue(Color.web("#f68"));
        Assert.assertEquals("Test stroke color orange (web)", this.controller.getSelectedFillColor().toString(), Color.web("#f68").toString());
        colorPicker.setValue(Color.web("#00ff00"));
        Assert.assertEquals("Test stroke color green (web)", this.controller.getSelectedFillColor().toString(), Color.web("#00ff00").toString());
    }

    @Test   //I didn't click on selectionToggleButton
    public void testBindChangeStrokeColorButton1() throws IllegalArgumentException, IllegalAccessException {
        canvas.getSelection().unSelect();
        lineToggleButton.setSelected(true);
        
        //The changeStrokeColorButton must be disabled because I've not clicked on the Selection button
        assertTrue("Error in bind changeStrokeColorButton", changeStrokeColorButton.isDisabled());
    }
    
    @Test   //I clicked on selectionToggleButton, but did not select any figure
    public void testBindChangeStrokeColorButton2() throws IllegalArgumentException, IllegalAccessException {
        //I create a new shape and I add it to the drawing, but I don't select it
        MyShape myLine = new MyEnhancedLine();
        canvas.getSelection().unSelect();
        canvas.addShape(myLine);
        
        MyShape myShape = canvas.getSelection().getSelectedItem();
        
        //The shape selected must be null and the changeStrokeColorButton must be disabled
        assertEquals(myShape, null);
        assertTrue("Error in bind changeStrokeColorButton", changeStrokeColorButton.isDisable());
    }
    
    @Test   //I clicked on selectionToggleButton, selected a figure
    public void testBindChangeStrokeColorButton3() throws IllegalArgumentException, IllegalAccessException {
        canvas.getSelection().unSelect();
        //I create a new shape, I add it to the drawing and I select it
        MyShape myLine = new MyEnhancedLine();
        canvas.addShape(myLine);
        
        canvas.getSelection().select((MyLine) myLine);
        selectionToggleButton.setSelected(true);
        MyShape myShape = canvas.getSelection().getSelectedItem();
        //The shape selected must be myLine and the changeStrokeColorButton must be enabled
        assertEquals(myShape.toString(), myLine.toString());
        assertFalse("Error in bind changeStrokeColorButton", changeStrokeColorButton.isDisable());
    }   
    
    @Test   //I didn't click on selectionToggleButton
    public void testBindChangeFillColorButton1() throws IllegalArgumentException, IllegalAccessException {
        lineToggleButton.setSelected(true);
        
        //The changeFillColorButton must be disabled because I've not clicked on the Selection button
        assertTrue("Error in bind changeFillColorButton", changeFillColorButton.isDisabled());
    }
    
    @Test   //I clicked on selectionToggleButton, but did not select any figure
    public void testBindChangeFillColorButton2() throws IllegalArgumentException, IllegalAccessException {
        //I create a new shape and I add it to the drawing, but I don't select it
        MyShape myLine = new MyEnhancedLine();
        canvas.getSelection().unSelect();
        canvas.addShape(myLine);
        
        MyShape myShape = canvas.getSelection().getSelectedItem();
        
        //The shape selected must be null and the changeFillColorButton must be disabled
        assertEquals(myShape, null);
        assertTrue("Error in bind changeStrokeColorButton", changeFillColorButton.isDisable());
    }
    
    @Test   //I clicked on selectionToggleButton, selected a figure
    public void testBindChangeFillColorButton3() throws IllegalArgumentException, IllegalAccessException {
        canvas.getSelection().unSelect();
        //I create a new shape, I add it to the drawing and I select it
        MyShape myLine = new MyEnhancedLine();
        canvas.addShape(myLine);
        
        canvas.getSelection().select((MyLine) myLine);
        selectionToggleButton.setSelected(true);
        MyShape myShape = canvas.getSelection().getSelectedItem();
        //The shape selected must be myLine and the changeFillColorButton must be enabled
        assertEquals(myShape.toString(), myLine.toString());
        assertFalse("Error in bind changeStrokeColorButton", changeFillColorButton.isDisable());
    }
    
    @Test // ho premuto su seleziona e scelto figura.
    public void testBindDeleteButton3() throws IllegalArgumentException, IllegalAccessException{
        MyEnhancedLine lineShape=new MyEnhancedLine();
        canvas.addShape(lineShape);
        
        canvas.getSelection().select(lineShape);
        MyShape myShape = canvas.getSelection().getSelectedItem();
        assertEquals(myShape.toString(), lineShape.toString());
        selectionToggleButton.setSelected(true);
        
        assertFalse("error in bind2",selectionToggleButton.isDisable() );
        assertFalse("error in bind", deleteButton.isDisable());
        
    }
    
    
    @Test //non ho premuto su seleziona.
    public void testBindDeleteButton1() throws IllegalArgumentException, IllegalAccessException{
        assertTrue("error in bind", deleteButton.isDisable());
        
    }
    
    @Test // ho premuto su seleziona.
    public void testBindDeleteButton2() throws IllegalArgumentException, IllegalAccessException{
        selectionToggleButton.setSelected(true);
        assertTrue("error in bind", deleteButton.isDisable());
    }
    
    @Test
    public void testBindCutButton() throws IllegalArgumentException, IllegalAccessException{
        Assert.assertTrue("If cutButton is disabled", cutButton.isDisable());
        
        MyShape myRectangle = new MyEnhancedRectangle();
        canvas.addShape(myRectangle);
        this.canvas.getSelection().select((MyRectangle) myRectangle);
        this.selectionToggleButton.setSelected(true);
        Assert.assertFalse("If cutButton is not disabled", cutButton.isDisable());
    }
    
    
    @Test //non ho premuto su seleziona.
    public void testBindCopyButton1() throws IllegalArgumentException, IllegalAccessException{
        assertTrue("error in bind", copyButton.isDisable());
        
    }
    
    @Test // ho premuto su seleziona.
    public void testBindCopyButton2() throws IllegalArgumentException, IllegalAccessException{
        selectionToggleButton.setSelected(true);
        assertTrue("error in bind", copyButton.isDisable());
        
    }
    
    @Test // ho premuto su seleziona e scelto figura.
    public void testBindCopyButton3() throws IllegalArgumentException, IllegalAccessException{
        MyEnhancedLine lineShape=new MyEnhancedLine();
        canvas.addShape(lineShape);
        
        canvas.getSelection().select(lineShape);
        MyShape myShape = canvas.getSelection().getSelectedItem();
        assertEquals(myShape.toString(), lineShape.toString());
        selectionToggleButton.setSelected(true);
        
        assertFalse("error in bind2",selectionToggleButton.isDisable() );
        assertFalse("error in bind", copyButton.isDisable());
        
    }
    
    @Test
    public void testBindPasteButton() throws IllegalArgumentException, IllegalAccessException{       
        MyShape shape = new MyEnhancedRectangle();
        this.canvas.addShape(shape);
        this.canvas.copyShape(shape);
        
        assertFalse("Error in DeleteButton binding", pasteButton.isDisable());
              
    }
    
}
