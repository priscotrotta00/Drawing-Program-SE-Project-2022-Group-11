/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.export;

import it.unisa.diem.se2022.drawingapp.group11IZ.export.exceptions.ExportException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.paint.Color;
import org.json.simple.JSONArray;

/**
 *
 * @author prisc
 */
public class JSONExportVisitorTest {
    
    /**
     * Test of visitRectangle method, of class JSONExportVisitor.
     */
    
    @Test (expected=NullPointerException.class)
    public void testNullJSONArray() {
        JSONArray jsonArray = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
    }
    
    @Test (expected=ExportException.class)
    public void testVisitNullRectangle() {
        JSONArray jsonArray = new JSONArray();
        MyRectangle myRectangle = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitRectangle(myRectangle);
    }
    
    @Test
    public void testVisitStandardRectangle() {
        JSONArray jsonArray = new JSONArray();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitRectangle(myRectangle);
        String myString = "[{\"width\":0.0,\"x\":0.0,\"y\":0.0,\"stroke-width\":1.0,\"type\":\"rectangle\",\"fill\":\"0x000000ff\",\"stroke\":null,\"height\":0.0}]";
        assertEquals("Test failed when you want to visit an empty rectangle",myString, jsonArray.toString());
    }
    
    @Test
    public void testVisitRectangle() {
        JSONArray jsonArray = new JSONArray();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.AQUAMARINE);
        myRectangle.mySetStroke(Color.AQUAMARINE);
        myRectangle.mySetHeight(15.0);
        myRectangle.mySetWidth(30.0);
        myRectangle.mySetX(30.0);
        myRectangle.mySetY(30.0);
        myRectangle.mySetStrokeWidth(2.0);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitRectangle(myRectangle);
        String myString = "[{\"width\":30.0,\"x\":30.0,\"y\":30.0,\"stroke-width\":2.0,\"type\":\"rectangle\",\"fill\":\"0x7fffd4ff\",\"stroke\":\"0x7fffd4ff\",\"height\":15.0}]";
        assertEquals("Test failed when you want to visit a rectangle", myString, jsonArray.toString());
    }
    
    @Test
    public void testVisitNegativeRectangle() {
        JSONArray jsonArray = new JSONArray();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.AQUAMARINE);
        myRectangle.mySetStroke(Color.AQUAMARINE);
        myRectangle.mySetHeight(-15.0);
        myRectangle.mySetWidth(-30.0);
        myRectangle.mySetX(-30.0);
        myRectangle.mySetY(-30.0);
        myRectangle.mySetStrokeWidth(-2.0);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitRectangle(myRectangle);
        String myString = "[{\"width\":-30.0,\"x\":-30.0,\"y\":-30.0,\"stroke-width\":-2.0,\"type\":\"rectangle\",\"fill\":\"0x7fffd4ff\",\"stroke\":\"0x7fffd4ff\",\"height\":-15.0}]";
        assertEquals("Test failed when you want to visit a rectangle", myString, jsonArray.toString());
    }

    @Test (expected=ExportException.class)
    public void testVisitNullEllipse() {
        JSONArray jsonArray = new JSONArray();
        MyEllipse myEllipse = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitEllipse(myEllipse);
    }
        
    @Test
    public void testVisitStandardEllipse() {
        JSONArray jsonArray = new JSONArray();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitEllipse(myEllipse);
        String myString = "[{\"centerY\":0.0,\"centerX\":0.0,\"radiusY\":0.0,\"radiusX\":0.0,\"stroke-width\":1.0,\"type\":\"ellipse\",\"fill\":\"0x000000ff\",\"stroke\":null}]";
        assertEquals("Test failed when you want to visit an empty ellipse", myString, jsonArray.toString());
    }
    
    /**
     * Test of visitEllipse method, of class JSONExportVisitor.
     */
    @Test
    public void testVisitEllipse() {
        JSONArray jsonArray = new JSONArray();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetFill(Color.AQUAMARINE);
        myEllipse.mySetStroke(Color.AQUAMARINE);
        myEllipse.mySetCenterX(30.0);
        myEllipse.mySetCenterY(30.0);
        myEllipse.mySetRadiusX(60.0);
        myEllipse.mySetRadiusY(30.0);
        myEllipse.mySetStrokeWidth(2.0);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitEllipse(myEllipse);
        String myString = "[{\"centerY\":30.0,\"centerX\":30.0,\"radiusY\":30.0,\"radiusX\":60.0,\"stroke-width\":2.0,\"type\":\"ellipse\",\"fill\":\"0x7fffd4ff\",\"stroke\":\"0x7fffd4ff\"}]";
        assertEquals("Test failed when you want to visit an ellipse", myString, jsonArray.toString());
    }
    
    @Test
    public void testVisitNegativeEllipse() {
        JSONArray jsonArray = new JSONArray();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetFill(Color.AQUAMARINE);
        myEllipse.mySetStroke(Color.AQUAMARINE);
        myEllipse.mySetCenterX(-30.0);
        myEllipse.mySetCenterY(-30.0);
        myEllipse.mySetRadiusX(-60.0);
        myEllipse.mySetRadiusY(-30.0);
        myEllipse.mySetStrokeWidth(-2.0);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitEllipse(myEllipse);
        String myString = "[{\"centerY\":-30.0,\"centerX\":-30.0,\"radiusY\":-30.0,\"radiusX\":-60.0,\"stroke-width\":-2.0,\"type\":\"ellipse\",\"fill\":\"0x7fffd4ff\",\"stroke\":\"0x7fffd4ff\"}]";
        assertEquals("Test failed when you want to visit an ellipse", myString, jsonArray.toString());
    }
    
    @Test (expected=ExportException.class)
    public void testVisitNullLine() {
        JSONArray jsonArray = new JSONArray();
        MyLine myLine = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitLine(myLine);
    }

    @Test
    public void testVisitStandardLine() {
        JSONArray jsonArray = new JSONArray();
        MyLine myLine = new MyEnhancedLine();
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitLine(myLine);
        String myString = "[{\"endY\":0.0,\"endX\":0.0,\"startY\":0.0,\"startX\":0.0,\"stroke-width\":1.0,\"type\":\"line\",\"fill\":null,\"stroke\":\"0x000000ff\"}]";
        assertEquals("Test failed when you want to visit an empty line", myString, jsonArray.toString());
    }
    
    /**
     * Test of visitLine method, of class JSONExportVisitor.
     */
    @Test
    public void testVisitLine() {
        JSONArray jsonArray = new JSONArray();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetFill(Color.AQUAMARINE);
        myLine.mySetStroke(Color.AQUAMARINE);
        myLine.mySetEndX(15.0);
        myLine.mySetEndY(15.0);
        myLine.mySetStartX(30.0);
        myLine.mySetStartY(30.0);
        myLine.mySetStrokeWidth(2.0);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitLine(myLine);
        String myString = "[{\"endY\":15.0,\"endX\":15.0,\"startY\":30.0,\"startX\":30.0,\"stroke-width\":2.0,\"type\":\"line\",\"fill\":\"0x7fffd4ff\",\"stroke\":\"0x7fffd4ff\"}]";
        assertEquals("Test failed when you want to visit an line", myString, jsonArray.toString());
    }
    
    @Test
    public void testVisitNegativeLine() {
        JSONArray jsonArray = new JSONArray();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetFill(Color.AQUAMARINE);
        myLine.mySetStroke(Color.AQUAMARINE);
        myLine.mySetEndX(-15.0);
        myLine.mySetEndY(-15.0);
        myLine.mySetStartX(-30.0);
        myLine.mySetStartY(-30.0);
        myLine.mySetStrokeWidth(-2.0);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitLine(myLine);
        String myString = "[{\"endY\":-15.0,\"endX\":-15.0,\"startY\":-30.0,\"startX\":-30.0,\"stroke-width\":-2.0,\"type\":\"line\",\"fill\":\"0x7fffd4ff\",\"stroke\":\"0x7fffd4ff\"}]";
        assertEquals("Test failed when you want to visit an line", myString, jsonArray.toString());
    }
    
}
