/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

//import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.clipboard.Clipboard;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
    private Controller c;
    private Field lineToggleButtonField;
    private Field rectangleToggleButtonField;
    private Field ellipseToggleButtonField;
    private Field selectionToggleButtonField;
    private Field toolToggleGroupField;
    private Field selectedToolField;
    private Field drawPaneField;
    private Field drawingField;
    private Field strokeColorPickerField;
    private Field fillColorPickerField;
    private Field copyButtonField;
    private Field deleteButtonField;
    private Field changeStrokeColorField;
    private Field changeFillColorField;
    private Field selectionField;
    private Field cutButtonField;
    private Field clipboardField;
    private Field pasteButtonField;
    
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
    public void setUp() throws NoSuchFieldException{
       for (int i = 0; i < Controller.class.getDeclaredFields().length; i++){
           Controller.class.getDeclaredFields()[i].setAccessible(true);
       }
       
       lineToggleButtonField = Controller.class.getDeclaredField("lineToggleButton");
       rectangleToggleButtonField = Controller.class.getDeclaredField("rectangleToggleButton");
       ellipseToggleButtonField = Controller.class.getDeclaredField("ellipseToggleButton");
       selectionToggleButtonField = Controller.class.getDeclaredField("selectionToggleButton");
       toolToggleGroupField = Controller.class.getDeclaredField("toolToggleGroup");
       selectedToolField = Controller.class.getDeclaredField("selectedTool");
       drawPaneField = Controller.class.getDeclaredField("drawPane");
       drawingField = Controller.class.getDeclaredField("draw");
       strokeColorPickerField = Controller.class.getDeclaredField("strokeColorPicker");
       fillColorPickerField = Controller.class.getDeclaredField("fillColorPicker");
       changeStrokeColorField = Controller.class.getDeclaredField("changeStrokeColorButton");
       changeFillColorField = Controller.class.getDeclaredField("changeFillColorButton");
       selectionField = Controller.class.getDeclaredField("selection");
       copyButtonField=Controller.class.getDeclaredField("copyButton");
       deleteButtonField=Controller.class.getDeclaredField("deleteButton");
       selectionField=Controller.class.getDeclaredField("selection");
       clipboardField=Controller.class.getDeclaredField("clipboard");
       pasteButtonField=Controller.class.getDeclaredField("pasteButton");
       
       cutButtonField=Controller.class.getDeclaredField("cutButton");
       c = new Controller();
   }
   
    @Test
    public void testUpdateSelectedToolEllipse() throws IllegalAccessException{
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
       
        c.initializeToolToggleGroup();

        ellipse.selectedProperty().set(true);
        Assert.assertEquals("Test Ellipse selected", this.selectedToolField.get(c), DrawEllipseTool.getInstance());
       
    }
    
    @Test
    public void testUpdateSelectedToolRectangle() throws IllegalAccessException{
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        
       ToggleButton line = new ToggleButton();
       ToggleButton rectangle = new ToggleButton();
       ToggleButton ellipse = new ToggleButton();
       ToggleButton selection = new ToggleButton();
       
       this.ellipseToggleButtonField.set(c, ellipse);
       this.lineToggleButtonField.set(c, line);
       this.rectangleToggleButtonField.set(c, rectangle);
       this.selectionToggleButtonField.set(c, selection);
       
       c.initializeToolToggleGroup();
       
       rectangle.selectedProperty().set(true);
       Assert.assertEquals("Test Rectangle selected", DrawRectangleTool.getInstance(), this.selectedToolField.get(c));  
    }
    
    @Test
    public void testUpdateSelectedToolLine() throws IllegalAccessException{
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        
       ToggleButton line = new ToggleButton();
       ToggleButton rectangle = new ToggleButton();
       ToggleButton ellipse = new ToggleButton();
       ToggleButton selection = new ToggleButton();
       
       this.ellipseToggleButtonField.set(c, ellipse);
       this.lineToggleButtonField.set(c, line);
       this.rectangleToggleButtonField.set(c, rectangle);
       this.selectionToggleButtonField.set(c, selection);
       
       c.initializeToolToggleGroup();
       
       line.selectedProperty().set(true);
       Assert.assertEquals("Test Rectangle selected", DrawLineTool.getInstance(), this.selectedToolField.get(c));  
    }
    
    @Test
    public void testUpdateSelectedToolUnselect() throws IllegalAccessException{
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        
       ToggleButton line = new ToggleButton();
       ToggleButton rectangle = new ToggleButton();
       ToggleButton ellipse = new ToggleButton();
       ToggleButton selection = new ToggleButton();
       
       this.ellipseToggleButtonField.set(c, ellipse);
       this.lineToggleButtonField.set(c, line);
       this.rectangleToggleButtonField.set(c, rectangle);
       this.selectionToggleButtonField.set(c, selection);
       
       c.initializeToolToggleGroup();
       ellipse.setSelected(true);
       ellipse.setSelected(false);
       
       Assert.assertTrue("Tool toggle button is not unselected", ellipse.selectedProperty().get());
       Assert.assertEquals("Tool has not changed", DrawEllipseTool.getInstance(), this.selectedToolField.get(c));
    }
    @Test
    public void testAddShape() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        System.out.println("add");
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //check if in DrawPane i have the shape
        MyEnhancedEllipse ellipse= new MyEnhancedEllipse();
        c.addShape(ellipse);
        //check if in DrawPane i have the ellipse
        assertTrue("Error in addShape",pane.getChildren().contains(ellipse));
    
        MyEnhancedRectangle rectangle= new MyEnhancedRectangle();
        c.addShape(rectangle);
        //check if in DrawPane i have the ellipse
        assertTrue("Error in addShape",pane.getChildren().contains(rectangle));
    
        MyEnhancedLine line= new MyEnhancedLine();
        c.addShape(line);
        //check if in DrawPane i have the ellipse
        assertTrue("Error in addShape",pane.getChildren().contains(line));
    }
    
    @Test (expected=Exception.class)
    public void testRemove3() throws NoSuchFieldException, IllegalAccessException{
        System.out.println("remove");
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //try to delete an ellipse that is not in the list
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        c.removeShape(ellipse);        
    }
    
    
    @Test
    public void testRemoveShape() throws IllegalArgumentException, IllegalAccessException, Exception{
        System.out.println("remove");
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //add
        MyEnhancedEllipse ellipse= new MyEnhancedEllipse();
        c.addShape(ellipse);
        MyEnhancedRectangle rectangle= new MyEnhancedRectangle();
        c.addShape(rectangle);
        MyEnhancedLine line= new MyEnhancedLine();
        c.addShape(line);
        
        //remove
        c.removeShape(ellipse);
        assertFalse("Error in removeShape",pane.getChildren().contains(ellipse));
        c.removeShape(line);
        assertFalse("Error in removeShape",pane.getChildren().contains(line));
        c.removeShape(rectangle);
        assertFalse("Error in removeShape",pane.getChildren().contains(rectangle));
    }
    
    @Test
    public void testGetSelectedStrokeColor() throws IllegalAccessException{
        ColorPicker colorPicker = new ColorPicker();
        
        this.strokeColorPickerField.setAccessible(true);
        this.strokeColorPickerField.set(c, colorPicker);
        
        colorPicker.setValue(Color.BLUE);
        Assert.assertEquals("Test stroke color blue (static)", this.c.getSelectedStrokeColor().toString(), Color.BLUE.toString());
        colorPicker.setValue(Color.web("#f68"));
        Assert.assertEquals("Test stroke color orange (web)", this.c.getSelectedStrokeColor().toString(), Color.web("#f68").toString());
        colorPicker.setValue(Color.web("#00ff00"));
        Assert.assertEquals("Test stroke color green (web)", this.c.getSelectedStrokeColor().toString(), Color.web("#00ff00").toString());
    }
    
    @Test
    public void testGetSelectedFillColor() throws IllegalAccessException{
        ColorPicker colorPicker = new ColorPicker();
        
        this.fillColorPickerField.setAccessible(true);
        this.fillColorPickerField.set(c, colorPicker);
        
        colorPicker.setValue(Color.BLUE);
        Assert.assertEquals("Test stroke color blue (static)", this.c.getSelectedFillColor().toString(), Color.BLUE.toString());
        colorPicker.setValue(Color.web("#f68"));
        Assert.assertEquals("Test stroke color orange (web)", this.c.getSelectedFillColor().toString(), Color.web("#f68").toString());
        colorPicker.setValue(Color.web("#00ff00"));
        Assert.assertEquals("Test stroke color green (web)", this.c.getSelectedFillColor().toString(), Color.web("#00ff00").toString());
    }

    @Test   //I didn't click on selectionToggleButton
    public void testBindChangeStrokeColorButton1() throws IllegalArgumentException, IllegalAccessException {
        this.changeStrokeColorField.setAccessible(true);
        this.changeFillColorField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);
        
        this.selectionField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());

        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(line);
        
        Button changeStrokeColor = new Button();
        Button changeFillColor = new Button();
        this.changeStrokeColorField.set(c, changeStrokeColor);
        this.changeFillColorField.set(c, changeFillColor);

        c.initializeChangeColorBindings();
        
        //The changeStrokeColorButton must be disabled because I've not clicked on the Selection button
        assertTrue("Error in bind changeStrokeColorButton", changeStrokeColor.isDisabled());
    }
    
    @Test   //I clicked on selectionToggleButton, but did not select any figure
    public void testBindChangeStrokeColorButton2() throws IllegalArgumentException, IllegalAccessException {
        this.changeStrokeColorField.setAccessible(true);
        this.changeFillColorField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);
        
        this.selectionField.setAccessible(true);
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());

        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        
        Button changeStrokeColor = new Button();
        Button changeFillColor = new Button();
        this.changeStrokeColorField.set(c, changeStrokeColor);
        this.changeFillColorField.set(c, changeFillColor);

        c.initializeChangeColorBindings();
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //I create a new shape and I add it to the drawing, but I don't select it
        MyShape myLine = new MyEnhancedLine();
        c.addShape(myLine);
        
        MyShape myShape = Selection.getInstance().getSelectedItem();
        toolToggleGroup.selectToggle(selection);
        
        //The shape selected must be null and the changeStrokeColorButton must be disabled
        assertEquals(myShape, null);
        assertTrue("Error in bind changeStrokeColorButton", changeStrokeColor.isDisable());
    }
    
    @Test   //I clicked on selectionToggleButton, selected a figure
    public void testBindChangeStrokeColorButton3() throws IllegalArgumentException, IllegalAccessException {
        this.changeStrokeColorField.setAccessible(true);
        this.changeFillColorField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);
        
        this.selectionField.setAccessible(true);
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());

        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        
        Button changeStrokeColor = new Button();
        Button changeFillColor = new Button();
        this.changeStrokeColorField.set(c, changeStrokeColor);
        this.changeFillColorField.set(c, changeFillColor);

        c.initializeChangeColorBindings();
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //I create a new shape, I add it to the drawing and I select it
        MyShape myLine = new MyEnhancedLine();
        c.addShape(myLine);
        
        Selection.getInstance().select((MyLine) myLine);
        toolToggleGroup.selectToggle(selection);
        MyShape myShape = Selection.getInstance().getSelectedItem();
        //The shape selected must be myLine and the changeStrokeColorButton must be enabled
        assertEquals(myShape.toString(), myLine.toString());
        assertFalse("Error in bind changeStrokeColorButton", changeStrokeColor.isDisable());
    }   
    
    @Test   //I didn't click on selectionToggleButton
    public void testBindChangeFillColorButton1() throws IllegalArgumentException, IllegalAccessException {
        this.changeStrokeColorField.setAccessible(true);
        this.changeFillColorField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);
        
        this.selectionField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());

        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(line);
        
        Button changeStrokeColor = new Button();
        Button changeFillColor = new Button();
        this.changeStrokeColorField.set(c, changeStrokeColor);
        this.changeFillColorField.set(c, changeFillColor);

        c.initializeChangeColorBindings();
        
        //The changeFillColorButton must be disabled because I've not clicked on the Selection button
        assertTrue("Error in bind changeFillColorButton", changeFillColor.isDisabled());
    }
    
    @Test   //I clicked on selectionToggleButton, but did not select any figure
    public void testBindChangeFillColorButton2() throws IllegalArgumentException, IllegalAccessException {
        this.changeStrokeColorField.setAccessible(true);
        this.changeFillColorField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);
        
        this.selectionField.setAccessible(true);
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());

        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        
        Button changeStrokeColor = new Button();
        Button changeFillColor = new Button();
        this.changeStrokeColorField.set(c, changeStrokeColor);
        this.changeFillColorField.set(c, changeFillColor);

        c.initializeChangeColorBindings();
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //I create a new shape and I add it to the drawing, but I don't select it
        MyShape myLine = new MyEnhancedLine();
        c.addShape(myLine);
        
        MyShape myShape = Selection.getInstance().getSelectedItem();
        toolToggleGroup.selectToggle(selection);
        //The shape selected must be null and the changeFillColorButton must be disabled
        assertEquals(myShape, null);
        assertTrue("Error in bind changeFillColorButton", changeFillColor.isDisable());
    }
    
    @Test   //I clicked on selectionToggleButton, selected a figure
    public void testBindChangeFillColorButton3() throws IllegalArgumentException, IllegalAccessException {
        this.changeStrokeColorField.setAccessible(true);
        this.changeFillColorField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);
        
        this.selectionField.setAccessible(true);
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();

        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());

        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        
        Button changeStrokeColor = new Button();
        Button changeFillColor = new Button();
        this.changeStrokeColorField.set(c, changeStrokeColor);
        this.changeFillColorField.set(c, changeFillColor);

        c.initializeChangeColorBindings();
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        //I create a new shape, I add it to the drawing and I select it
        MyShape myLine = new MyEnhancedLine();
        c.addShape(myLine);
        
        toolToggleGroup.selectToggle(selection);
        Selection.getInstance().select((MyLine) myLine);
        
        MyShape myShape = Selection.getInstance().getSelectedItem();
        //The shape selected must be myLine and the changeFillColorButton must be enabled
        assertEquals(myShape.toString(), myLine.toString());
        assertFalse("Error in bind changeFillColorButton", changeFillColor.isDisable());
    }
    
    @Test // ho premuto su seleziona e scelto figura.
    public void testBindDeleteButton3() throws IllegalArgumentException, IllegalAccessException{
        this.deleteButtonField.setAccessible(true);
        Button deleteButton=new Button();
        this.deleteButtonField.set(c, deleteButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        //this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);      
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        c.initializeDeleteBindings();
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(selection);
        
        MyEnhancedLine lineShape=new MyEnhancedLine();
        c.addShape(lineShape);
        
        Selection.getInstance().select(lineShape);
        MyShape myShape = Selection.getInstance().getSelectedItem();
        assertEquals(myShape.toString(), lineShape.toString());
        
        
        assertFalse("error in bind2",selection.isDisable() );
        assertFalse("error in bind", deleteButton.isDisable());
        
    }
    
    
    @Test //non ho premuto su seleziona.
    public void testBindDeleteButton1() throws IllegalArgumentException, IllegalAccessException{
        this.deleteButtonField.setAccessible(true);
        Button deleteButton=new Button();
        this.deleteButtonField.set(c, deleteButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);      
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(line);
        c.initializeDeleteBindings();
        assertTrue("error in bind", deleteButton.isDisable());
        
    }
    
    @Test // ho premuto su seleziona.
    public void testBindDeleteButton2() throws IllegalArgumentException, IllegalAccessException{
        
        this.deleteButtonField.setAccessible(true);
        Button deleteButton=new Button();
        this.deleteButtonField.set(c, deleteButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(selection);
        
        
        c.initializeDeleteBindings();
        assertTrue("error in bind", deleteButton.isDisable());
        
    }
    
    @Test
    public void testBindCutButton() throws IllegalArgumentException, IllegalAccessException{
        this.cutButtonField.setAccessible(true);
        
        Button cutButton = new Button();
        this.cutButtonField.set(c, cutButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);     
        
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(selection);
        
        
        c.initializeCutBindings();
        Assert.assertTrue("If cutButton is disabled", cutButton.isDisable());
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        MyShape myRectangle = new MyEnhancedRectangle();
        c.addShape(myRectangle);
        Selection.getInstance().select((MyRectangle) myRectangle);
        
        Assert.assertFalse("If cutButton is not disabled", cutButton.isDisable());
        
    }
    
    
    @Test
    public void testGetDraw() throws IllegalArgumentException, IllegalAccessException{
        this.drawingField.setAccessible(true);
        Drawing drawing = new Drawing();
        this.drawingField.set(c, drawing);
        
        Drawing d=c.getDraw();
        assertTrue("Error in getDraw",d==drawing);
    }
    
    @Test //non ho premuto su seleziona.
    public void testBindCopyButton1() throws IllegalArgumentException, IllegalAccessException{
        this.copyButtonField.setAccessible(true);
        Button copyButton=new Button();
        this.copyButtonField.set(c, copyButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);      
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(line);
        c.initializeCopyShapeBindings();
        assertTrue("error in bind", copyButton.isDisable());
        
    }
    
    @Test // ho premuto su seleziona.
    public void testBindCopyButton2() throws IllegalArgumentException, IllegalAccessException{
        
        this.copyButtonField.setAccessible(true);
        Button copyButton=new Button();
        this.copyButtonField.set(c, copyButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);
        Selection.getInstance().unSelect();
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(selection);
        
        
        c.initializeCopyShapeBindings();
        assertTrue("error in bind", copyButton.isDisable());
        
    }
    
    @Test // ho premuto su seleziona e scelto figura.
    public void testBindCopyButton3() throws IllegalArgumentException, IllegalAccessException{
        this.copyButtonField.setAccessible(true);
        Button copyButton=new Button();
        this.copyButtonField.set(c, copyButton);
        this.selectionToggleButtonField.setAccessible(true); 
        this.ellipseToggleButtonField.setAccessible(true);
        this.lineToggleButtonField.setAccessible(true);
        this.rectangleToggleButtonField.setAccessible(true);
        //this.selectionToggleButtonField.setAccessible(true);
        this.selectedToolField.setAccessible(true);
        this.toolToggleGroupField.setAccessible(true);        
        this.selectionField.setAccessible(true);        
        ToggleButton line = new ToggleButton();
        ToggleButton rectangle = new ToggleButton();
        ToggleButton ellipse = new ToggleButton();
        ToggleButton selection = new ToggleButton();
        this.ellipseToggleButtonField.set(c, ellipse);
        this.lineToggleButtonField.set(c, line);
        this.rectangleToggleButtonField.set(c, rectangle);
        this.selectionToggleButtonField.set(c, selection);      
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        c.initializeCopyShapeBindings();
        
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        
        
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(selection);
        
        MyEnhancedLine lineShape=new MyEnhancedLine();
        c.addShape(lineShape);
        
        Selection.getInstance().select(lineShape);
        MyShape myShape = Selection.getInstance().getSelectedItem();
        assertEquals(myShape.toString(), lineShape.toString());
        
        
        assertFalse("error in bind2",selection.isDisable() );
        assertFalse("error in bind", copyButton.isDisable());
        
    }
    
    @Test
    public void copyShapeTest() throws IllegalArgumentException, IllegalAccessException{
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        this.clipboardField.setAccessible(true);
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        Clipboard clipboard=new Clipboard();
        this.clipboardField.set(this.c, clipboard);
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        MyEnhancedLine lineShape=new MyEnhancedLine();
        c.addShape(lineShape);
        Selection.getInstance().select(lineShape); //selection the shape
        assertTrue("Error in selection", Selection.getInstance().getSelectedValue());
        //copyShape
        c.copyShape(Selection.getInstance().getSelectedItem());
        //check if lineShape is in clipboard 
        
        assertTrue("Error insert in clipboard", clipboard.hasCopiedShape());
        //check if the selected shape is equal to lineShape
        assertTrue("Error insert in clipboard 0", Selection.getInstance().getSelectedItem().myGetId()==lineShape.myGetId());
        
        //check if the shape in clipboard is equal to lineshape
        
        MyEnhancedLine shapeClipboard=(MyEnhancedLine) clipboard.getNewCopy();
        
        assertTrue("error insert in clipboard 1", shapeClipboard.myGetFill()==lineShape.myGetFill());
        assertTrue("error insert in clipboard 2", shapeClipboard.myGetStroke()==lineShape.myGetStroke());
        assertTrue("error insert in clipboard 3", shapeClipboard.myGetEndX()==lineShape.myGetEndX());
        assertTrue("error insert in clipboard 4", shapeClipboard.myGetEndY()==lineShape.myGetEndY());
        assertTrue("error insert in clipboard 5", shapeClipboard.myGetStartX()==lineShape.myGetStartX());
        assertTrue("error insert in clipboard 6", shapeClipboard.myGetStartY()==lineShape.myGetStartY());
        assertTrue("Error insert in clipboard 7", shapeClipboard.myGetStrokeWidth()==lineShape.myGetStrokeWidth());   
        
    }
    
    @Test
    public void copyShapeTest2() throws IllegalArgumentException, IllegalAccessException{
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        this.clipboardField.setAccessible(true);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        Clipboard clipboard=new Clipboard();
        this.clipboardField.set(this.c, clipboard);
        
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        MyEnhancedRectangle rectangleShape =new MyEnhancedRectangle();
        c.addShape(rectangleShape);
        Selection.getInstance().select(rectangleShape); //selection the shape
        //copyShape
        c.copyShape(Selection.getInstance().getSelectedItem());
        //check if rectangleShape is in clipboard 
        assertTrue("Error insert in clipboard", clipboard.hasCopiedShape());
        //check if the selected shape is equal to rectangleShape
        assertTrue("Error insert in clipboard 0", Selection.getInstance().getSelectedItem().myGetId()==rectangleShape.myGetId());
        //check if the shape in clipboard is equal to rectangleshape
        MyEnhancedRectangle shapeClipboard=(MyEnhancedRectangle) clipboard.getNewCopy();
        
        assertTrue("error insert in clipboard 1", shapeClipboard.myGetFill()==rectangleShape.myGetFill());
        assertTrue("error insert in clipboard 2", shapeClipboard.myGetStroke()==rectangleShape.myGetStroke());
        assertTrue("error insert in clipboard 3", shapeClipboard.myGetWidth()==rectangleShape.myGetWidth());
        assertTrue("error insert in clipboard 4", shapeClipboard.myGetHeight()==rectangleShape.myGetHeight());
        assertTrue("error insert in clipboard 5", shapeClipboard.myGetX()==rectangleShape.myGetX());
        assertTrue("error insert in clipboard 6", shapeClipboard.myGetY()==rectangleShape.myGetY());
        assertTrue("Error insert in clipboard 7", shapeClipboard.myGetStrokeWidth()==rectangleShape.myGetStrokeWidth());   
        
    }
    
    @Test
    public void copyShapeTest3() throws IllegalArgumentException, IllegalAccessException{
        this.drawPaneField.setAccessible(true);
        this.drawingField.setAccessible(true);
        this.clipboardField.setAccessible(true);
        
        Clipboard clipboard=new Clipboard();
        this.clipboardField.set(this.c, clipboard);
        
        Pane pane = new Pane();
        Drawing drawing = new Drawing();
        this.drawPaneField.set(this.c, pane);
        this.drawingField.set(c, drawing);
        MyEnhancedEllipse ellipseShape =new MyEnhancedEllipse();
        c.addShape(ellipseShape);
        Selection.getInstance().select(ellipseShape); //selection the shape
        //copyShape
        c.copyShape(Selection.getInstance().getSelectedItem());
        //check if ellipseShape is in clipboard 
        
        assertTrue("Error insert in clipboard", clipboard.hasCopiedShape());
        //check if the selected shape is equal to ellipseShape
        assertTrue("Error insert in clipboard 0", Selection.getInstance().getSelectedItem().myGetId()==ellipseShape.myGetId());
        //check if the shape in clipboard is equal to ellipseshape
        MyEnhancedEllipse shapeClipboard=(MyEnhancedEllipse) clipboard.getNewCopy();
        
        assertTrue("error insert in clipboard 1", shapeClipboard.myGetFill()==ellipseShape.myGetFill());
        assertTrue("error insert in clipboard 2", shapeClipboard.myGetStroke()==ellipseShape.myGetStroke());
        assertTrue("error insert in clipboard 3", shapeClipboard.myGetRadiusX()==ellipseShape.myGetRadiusX());
        assertTrue("error insert in clipboard 4", shapeClipboard.myGetRadiusY()==ellipseShape.myGetRadiusY());
        assertTrue("error insert in clipboard 5", shapeClipboard.myGetCenterX()==ellipseShape.myGetCenterX());
        assertTrue("error insert in clipboard 6", shapeClipboard.myGetCenterY()==ellipseShape.myGetCenterY());
        assertTrue("Error insert in clipboard 7", shapeClipboard.myGetStrokeWidth()==ellipseShape.myGetStrokeWidth());   
        
    }
    @Test
    public void testBindPasteButton() throws IllegalArgumentException, IllegalAccessException{
        this.clipboardField.setAccessible(true);
        this.pasteButtonField.setAccessible(true);
        
        Clipboard clipboard = new Clipboard();
        MyShape shape = new MyEnhancedRectangle();
        clipboard.copy(shape);
        this.clipboardField.set(c, clipboard);
        Button pasteButton = new Button();
        this.pasteButtonField.set(c, pasteButton);
        
        c.initializePasteBindings();
        
        assertFalse("Error in DeleteButton binding", pasteButton.isDisable());
              
    }
    
}
