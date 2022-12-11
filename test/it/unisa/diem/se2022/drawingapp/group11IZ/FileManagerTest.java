/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.exceptions.ExtensionFileException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.DrawingTest;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author prisc
 */
public class FileManagerTest {
    
    @Test (expected = NullPointerException.class)
    public void testSaveNullFile(){
        File file = null;
        Drawing draw = new Drawing();
        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
    }
    
    @Test (expected = NullPointerException.class)
    public void testSaveNullDrawing(){
        File file = new File("testFileManager1.json");
        Drawing draw = null;
        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
        file.delete();
    }
    
    @Test
    public void testSaveEmptyDrawing(){
        Drawing draw = new Drawing();
        File file = new File("testFileManager2.json");
        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
        String JSONFileString = new String();
               
        try(Scanner in = new Scanner(file)){
            JSONFileString = in.nextLine();
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(FileManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String myString = "[]";
        assertEquals("Failed with an empty drawing",myString, JSONFileString);
        file.delete();
    }
    
    @Test 
    public void testSaveDrawing() throws Exception{
        File file = new File("testFileManager3.json");
        Drawing draw = new Drawing();
        
        MyShape line = new MyEnhancedLine();
        draw.addShape(line);

        MyShape rectangle = new MyEnhancedRectangle();
        draw.addShape(rectangle);

        MyShape ellipse = new MyEnhancedEllipse();
        draw.addShape(ellipse);

        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
        
        String JSONFileString = new String();
               
        try(Scanner in = new Scanner(file)){
            JSONFileString = in.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String myString = "[{\"endY\":0.0,\"endX\":0.0,\"startY\":0.0,\"startX\":0.0,\"stroke-width\":1.0,\"type\":\"line\",\"fill\":null,\"stroke\":\"0x000000ff\"},"
                + "{\"width\":0.0,\"x\":0.0,\"y\":0.0,\"stroke-width\":1.0,\"type\":\"rectangle\",\"fill\":\"0x000000ff\",\"stroke\":null,\"height\":0.0},"
                + "{\"centerY\":0.0,\"centerX\":0.0,\"radiusY\":0.0,\"radiusX\":0.0,\"stroke-width\":1.0,\"type\":\"ellipse\",\"fill\":\"0x000000ff\",\"stroke\":null}]";
        assertEquals("Failed export drawing",myString, JSONFileString);
        file.delete();
    }
    
    @Test (expected = ExtensionFileException.class)
    public void testSaveDrawingToNotJSONFile(){
        Drawing draw = new Drawing();
        File file = new File("testFileManager4");
        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
    }
    
    @Test (expected = NullPointerException.class)
    public void testLoadNullFile(){
        File file = null;
        FileManager fileManager = new FileManager();
        Drawing draw = fileManager.loadFile(file);
    }
    
    @Test 
    public void testLoadEmptyDrawing() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, Exception{
        Drawing draw = new Drawing();
        File file = new File("testFileManager5.json");
        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
        Drawing loadedDrawing = fileManager.loadFile(file);
        Iterator<MyShape> itr = draw.iterator();
        assertFalse("An empty drawing contains elements",itr.hasNext());
        file.delete();
    }
    
    @Test 
    public void testLoadDrawing() throws Exception{
        File file = new File("testFileManager6.json");
        Drawing draw = new Drawing();
        
        MyShape line = new MyEnhancedLine();
        draw.addShape(line);

        MyShape rectangle = new MyEnhancedRectangle();
        draw.addShape(rectangle);

        MyShape ellipse = new MyEnhancedEllipse();
        draw.addShape(ellipse);

        FileManager fileManager = new FileManager();
        fileManager.saveFile(file, draw);
        Drawing loadedDrawing = fileManager.loadFile(file);
        Iterator<MyShape> itr = draw.iterator();
       
        assertEquals("The Drawing doesn't contain all the figures stored in the file", line.toString(), itr.next().toString());
        assertEquals("The Drawing doesn't contain all the figures stored in the file", rectangle.toString(), itr.next().toString());
        assertEquals("The Drawing doesn't contain all the figures stored in the file", ellipse.toString(), itr.next().toString());
        assertFalse(itr.hasNext());
        file.delete();
    }
    
    @Test (expected = ExtensionFileException.class)
    public void testLoadDrawingFromNotJSONFile(){
        File file = new File("testFileManager7");
        FileManager fileManager = new FileManager();
        Drawing loadedDrawing = fileManager.loadFile(file);
    }    
    
}
