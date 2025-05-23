/**
 * Test of the main methods of Selection class 
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author daddy
 */
public class SelectionTest {
    private Canvas canvas;
    private Selection selection;
    private Pane pane;
    private MyEnhancedLine myEnhancedLine;
    private MyEnhancedLine selectedBorderLine;
    private MyEnhancedRectangle selectedBorderRectangle;
    private MyEnhancedRectangle myEnhancedRectangle;
    private MyEnhancedEllipse myEnhancedEllipse;
    private MyEnhancedEllipse selectedBorderEllipse;
    private Group group;
    private BooleanProperty boolProp;
    private MyShape selectedShape;
    private Field selectionBorderField;
    private Field selectedField;
    private Field selectedItemField;
    
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
    public void setUp() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        canvas = new Canvas();
        pane = new Pane();
        
        Field drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawPaneField.setAccessible(true);
        drawPaneField.set(canvas, pane);
        canvas.initialize(null, null);
        
        selection = canvas.getSelection();
        
        myEnhancedLine = new MyEnhancedLine();
        myEnhancedRectangle = new MyEnhancedRectangle();
        myEnhancedEllipse = new MyEnhancedEllipse();
        
        myEnhancedLine.mySetStartX(10);
        myEnhancedLine.mySetStartY(10);
        myEnhancedLine.mySetEndX(50);
        myEnhancedLine.mySetEndY(10);
        
        myEnhancedRectangle.mySetX(10);
        myEnhancedRectangle.mySetY(10);
        myEnhancedRectangle.mySetWidth(20);
        myEnhancedRectangle.mySetHeight(10);
        
        myEnhancedEllipse.mySetCenterX(50);
        myEnhancedEllipse.mySetCenterY(50);
        myEnhancedEllipse.mySetRadiusX(50);
        myEnhancedEllipse.mySetRadiusY(25);
        
        selectionBorderField = Selection.class.getDeclaredField("selectionBorder");
        selectedField = Selection.class.getDeclaredField("selected");
        selectedItemField = Selection.class.getDeclaredField("selectedItem");
        
        selectionBorderField.setAccessible(true);
        selectedField.setAccessible(true);
        selectedItemField.setAccessible(true);
    }
    
    @Test
    public void selectLineTest() throws IllegalArgumentException, IllegalAccessException{
        
        canvas.addShape(myEnhancedLine);
        
        selection.select(myEnhancedLine);
        
        group = (Group) selectionBorderField.get(selection);
        boolProp = (BooleanProperty) selectedField.get(selection);
        
        selectedBorderLine = (MyEnhancedLine) group.getChildren().get(0);
        
        Assert.assertNotNull("If selectedBorder is not null", group.getChildren().get(0));        
        Assert.assertEquals("If selectedBorderLine is a myEnhancedLine", selectedBorderLine.getClass(), (new MyEnhancedLine()).getClass());
        Assert.assertEquals("If selectedBorderLine has black stroke", selectedBorderLine.myGetStroke(), Color.BLACK);
        Assert.assertEquals("If selectedBorderLine has transparent fill",selectedBorderLine.myGetFill(), Color.TRANSPARENT);
        Assert.assertTrue("If selectedBorderLine stroke > myEnhancedLine stroke", selectedBorderLine.getStrokeWidth() > myEnhancedLine.getStrokeWidth());
        Assert.assertTrue("If selected property is true", boolProp.get());
        
    }
    
    @Test
    public void selectRectangleTest() throws IllegalArgumentException, IllegalAccessException{
        
        canvas.addShape(myEnhancedRectangle);
        
        selection.select(myEnhancedRectangle);
        
        group = (Group) selectionBorderField.get(selection);        
        boolProp = (BooleanProperty) selectedField.get(selection);
        
        selectedBorderRectangle = (MyEnhancedRectangle) group.getChildren().get(0);

        Assert.assertNotNull("If selectedBorder is not null", group.getChildren().get(0));   
        Assert.assertEquals("If selectedBorderRectangle is a myEnhancedRectangle", selectedBorderRectangle.getClass(), (new MyEnhancedRectangle()).getClass());
        Assert.assertEquals("If selectedBorderRectangle has black stroke", selectedBorderRectangle.myGetStroke(), Color.BLACK);
        Assert.assertEquals("If selectedBorderRectangle has transparent fill",selectedBorderRectangle.myGetFill(), Color.TRANSPARENT);
        Assert.assertTrue("If selectedBorderRectangle stroke > myEnhancedRectangle stroke", selectedBorderRectangle.getStrokeWidth() > myEnhancedRectangle.getStrokeWidth());
        Assert.assertTrue("If selected property is true", boolProp.get());
        
    }
    
    @Test
    public void selectEllipseTest() throws IllegalArgumentException, IllegalAccessException{
   
        canvas.addShape(myEnhancedEllipse);
        
        selection.select(myEnhancedEllipse);
        
        group = (Group) selectionBorderField.get(selection);        
        boolProp = (BooleanProperty) selectedField.get(selection);
        
        selectedBorderEllipse = (MyEnhancedEllipse) group.getChildren().get(0);

        
        Assert.assertNotNull("If selectedBorder is not null", group.getChildren().get(0));
        Assert.assertEquals("If selectedBorderEllipse is a myEnhancedEllipse", selectedBorderEllipse.getClass(), (new MyEnhancedEllipse()).getClass());
        Assert.assertEquals("If selectedBorderEllipse has black stroke", selectedBorderEllipse.myGetStroke(), Color.BLACK);
        Assert.assertEquals("If selectedBorderEllipse has transparent fill",selectedBorderEllipse.myGetFill(), Color.TRANSPARENT);
        Assert.assertTrue("If selectedBorderEllipse stroke > myEnhancedEllipse stroke", selectedBorderEllipse.getStrokeWidth() > myEnhancedEllipse.getStrokeWidth());
        Assert.assertTrue("If selected property is true", boolProp.get());
        
    }
    
    @Test
    public void unSelectTest() throws IllegalArgumentException, IllegalAccessException{
        
        canvas.addShape(myEnhancedRectangle);
        
        selection.select(myEnhancedRectangle);
        
        selection.unSelect();
        
        group = (Group) selectionBorderField.get(selection);        
        boolProp = (BooleanProperty) selectedField.get(selection);
        selectedShape = (MyShape) selectedItemField.get(selection);
        
        Assert.assertNull("selectedItem is Null", selectedShape);
        Assert.assertFalse("selected is set to false", boolProp.get());
        Assert.assertTrue("If selectionBorder is a new Group object", group.getChildren().isEmpty());
        
    }    
    
}
