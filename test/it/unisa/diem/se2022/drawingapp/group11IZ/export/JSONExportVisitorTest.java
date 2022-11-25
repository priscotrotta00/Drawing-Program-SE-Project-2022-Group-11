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
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Exception;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.json.simple.JSONArray;

/**
 *
 * @author prisc
 */
public class JSONExportVisitorTest {
    
    public JSONExportVisitorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of visitRectangle method, of class JSONExportVisitor.
     */
    
    @Test (expected=ExportException.class)
    public void testVisitVoidRectangle() {
        System.out.println("visitVoidRectangle");
        JSONArray jsonArray = new JSONArray();
        MyRectangle myRectangle = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitRectangle(myRectangle);
    }
    
    @Test
    public void testVisitRectangle() {
        System.out.println("visitRectangle");
        JSONArray jsonArray = new JSONArray();
        MyRectangle myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.AQUAMARINE);
        myRectangle.mySetStroke(Color.AQUAMARINE);
        myRectangle.mySetHeight(15);
        myRectangle.mySetWidth(30);
        myRectangle.mySetX(30);
        myRectangle.mySetY(30);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitRectangle(myRectangle);
        String myString = "[{\"width\":30.0,\"x\":30.0,\"y\":30.0,\"type\":\"rectangle\",\"fill\":"+Color.AQUAMARINE+",\"stroke\":"+Color.AQUAMARINE+",\"height\":15.0}]";
        assertEquals(myString, jsonArray.toString());
    }

    @Test (expected=ExportException.class)
    public void testVisitVoidEllipse() {
        System.out.println("visitVoidEllipse");
        JSONArray jsonArray = new JSONArray();
        MyEllipse myEllipse = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitEllipse(myEllipse);
    }
        
    /**
     * Test of visitEllipse method, of class JSONExportVisitor.
     */
    @Test
    public void testVisitEllipse() {
        System.out.println("visitEllipse");
        JSONArray jsonArray = new JSONArray();
        MyEllipse myEllipse = new MyEnhancedEllipse();
        myEllipse.mySetFill(Color.AQUAMARINE);
        myEllipse.mySetStroke(Color.AQUAMARINE);
        myEllipse.mySetCenterX(30);
        myEllipse.mySetCenterY(30);
        myEllipse.mySetRadiusX(60);
        myEllipse.mySetRadiusY(30);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitEllipse(myEllipse);
        String myString = "[{\"centerY\":30.0,\"centerX\":30.0,\"radiusY\":30.0,\"radiusX\":60.0,\"type\":\"ellipse\",\"fill\":\""+Color.AQUAMARINE+"\",\"stroke\":"+Color.AQUAMARINE+"}]";
        assertEquals(myString, jsonArray.toString());
    }
    
    @Test (expected=ExportException.class)
    public void testVisitVoidLine() {
        System.out.println("visitVoidLine");
        JSONArray jsonArray = new JSONArray();
        MyLine myLine = null;
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitLine(myLine);
    }

    /**
     * Test of visitLine method, of class JSONExportVisitor.
     */
    @Test
    public void testVisitLine() {
        System.out.println("visitLine");
        JSONArray jsonArray = new JSONArray();
        MyLine myLine = new MyEnhancedLine();
        myLine.mySetFill(Color.AQUAMARINE);
        myLine.mySetStroke(Color.AQUAMARINE);
        myLine.mySetEndX(15);
        myLine.mySetEndY(15);
        myLine.mySetStartX(30);
        myLine.mySetStartY(30);
        JSONExportVisitor visitor = new JSONExportVisitor(jsonArray);
        visitor.visitLine(myLine);
        String myString = "[{\"endY\":15.0,\"endX\":15.0,\"startY\":30.0,\"startX\":30.0,\"type\":\"line\",\"fill\":"+Color.AQUAMARINE+",\"stroke\":"+Color.AQUAMARINE+"}]";
        assertEquals(myString, jsonArray.toString());
    }
    
}
