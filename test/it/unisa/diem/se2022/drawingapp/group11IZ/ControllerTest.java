/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

//import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Selection;
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
    
    private Field deleteButtonField;
    private Field selectionField;
    
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
       deleteButtonField=Controller.class.getDeclaredField("deleteButton");
       selectionField=Controller.class.getDeclaredField("selection");
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
 
    @Test // ho premuto su seleziona e scelto figura.
    public void testBindDeleteButton3() throws IllegalArgumentException, IllegalAccessException{
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
        toolToggleGroup.selectToggle(selection);
        Selection.getInstance().setSelected(true);
        c.initializeDeleteBindings();
        assertFalse("error in bind", deleteButton.isDisabled());
        
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
        assertTrue("error in bind", deleteButton.isDisabled());
        
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
        this.selectionField.set(c, Selection.getInstance());
 
        c.initializeToolToggleGroup();
        ToggleGroup toolToggleGroup = (ToggleGroup) toolToggleGroupField.get(c);
        toolToggleGroup.selectToggle(selection);
        
        c.initializeDeleteBindings();
        assertTrue("error in bind", deleteButton.isDisabled());
        
    }
    
    /*@Test // ho premuto su seleziona e scelto figura.
    public void testBindDeleteButton3() throws IllegalArgumentException, IllegalAccessException{
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
        toolToggleGroup.selectToggle(selection);
        Selection.getInstance().setSelected(true);
        c.initializeDeleteBindings();
        assertFalse("error in bind", deleteButton.isDisabled());
        
    }*/
    
    @Test
    public void testGetDraw() throws IllegalArgumentException, IllegalAccessException{
        this.drawingField.setAccessible(true);
        Drawing drawing = new Drawing();
        this.drawingField.set(c, drawing);
        
        Drawing d=c.getDraw();
        assertTrue("Error in getDraw",d==drawing);
    }
}
