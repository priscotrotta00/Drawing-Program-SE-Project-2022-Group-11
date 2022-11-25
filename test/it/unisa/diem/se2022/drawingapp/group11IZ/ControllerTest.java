/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawEllipseTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawLineTool;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.DrawRectangleTool;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
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
    private Field toolToggleGroup;
    private Field selectedToolField;
    
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
       toolToggleGroup = Controller.class.getDeclaredField("toolToggleGroup");
       selectedToolField = Controller.class.getDeclaredField("selectedTool");
       
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
}
