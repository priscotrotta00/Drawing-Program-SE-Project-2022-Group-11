/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import it.unisa.diem.se2022.drawingapp.group11IZ.Import.JSONImportVisitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.AddedDuplicateException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import it.unisa.diem.se2022.drawingapp.group11IZ.export.JSONExportVisitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ExtensionFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author saram
 */
/*extends (JSONExportVisitor) da inserire*/
public class Drawing implements Iterable<MyShape>{

    private List<MyShape> figures;

    public Drawing() {
        this.figures = new ArrayList<MyShape>(); //O(n) for insert, O(1) for search
    }

    /**
     * Change the position of Shape in figures, so change the layer of shape.
     *
     * @param myShape
     * @param i
     */
    public void moveToLayer(MyShape myShape, int i) {
        //add myShape in position i 
        figures.add(i, myShape);//Inserts the specified element at the specified position in this list. 
        //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
    }

    /**
     * Return the position of the Shape in figures.
     *
     * @param myShape
     * @return
     * @throws ShapeNotFoundException
     */
    public int getShapeLayer(MyShape myShape) throws ShapeNotFoundException {
        int i;
        i = figures.indexOf(myShape);
        if (i == -1) {
            throw new ShapeNotFoundException();
        } else {
            return i;
        }
    }

    /**
     * Add the Shape in figures. Throw RuntimeException if you try to add the
     * same figure twice
     *
     * @param myShape
     * @throws AddedDuplicateException
     */
    public void addShape(MyShape myShape) throws AddedDuplicateException {
        //check if the shape is already in the list
        boolean b;
        b = figures.contains(myShape);
        if (b) {
            throw new AddedDuplicateException();
        } else {
            //add in figures
            figures.add(myShape);
        }
    }

    /**
     * Remove the Shape form figures.Throw Exception if the removal fails.
     *
     * @param myShape
     */
    public void removeShape(MyShape myShape) {
        //search in figures the shape to delete
        //two shapes are equal if they have the same id
        int pos = getShapeLayer(myShape);
        boolean b = figures.remove(myShape);

        //shift
        for (int t = pos; t > figures.size(); t++) {
            //figures[i]=figures[i+1];
            MyShape s = figures.set(t, figures.get(t + 1));
        }

    }

    /**
     * Delete myShape from from its old position, move myShape in last position
     * in figures.
     *
     * @param myShape
     */
    public void moveToForeground(MyShape myShape) {
        try {
            //delete myshape 
            int i = getShapeLayer(myShape);
            figures.remove(i);
            moveToLayer(myShape, figures.size());
        } catch (ShapeNotFoundException ex) {
            Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Delete myShape from from its old position, move myShape in first position
     *
     * @param myShape
     */
    public void moveToBackground(MyShape myShape) {
        try {
            int i = getShapeLayer(myShape);
            figures.remove(i);
            
            moveToLayer(myShape, 0);
        } catch (ShapeNotFoundException ex) {
            Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void moveFigure(MyShape myShape, double x, double y) {

    }

    /**
     * Export the drawing in a JSON file
     * @param file is the path to the file where you want to save the drawing
     */
    
    public void exportDrawing(File file) {
        if(file == null) throw new NullPointerException();
        if(!file.getPath().endsWith(".json")) throw new ExtensionFileException();
        JSONArray jsonArray = new JSONArray();
        Visitor visitor = new JSONExportVisitor(jsonArray);
        for (MyShape shape : figures) {
            shape.accept(visitor);
        }
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.close();
        } catch (IOException ex) { 
            Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
     * Import the drawing from a JSON file
     * @param file is the path to the file from where you want to load the drawing
     * @return A Drawing class object
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws Exception 
     */
    
    public static Drawing importDrawing(File file) throws FileNotFoundException, IOException, ParseException, Exception {
        if(file == null) throw new NullPointerException();
        if(!file.getPath().endsWith(".json")) throw new ExtensionFileException();
        Drawing draw = new Drawing(); 
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(file)){
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while(iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                if (jsonObject.get("type").toString().equals("rectangle")){
                    MyRectangle myRectangle = new MyEnhancedRectangle();
                    Visitor visitor = new JSONImportVisitor(jsonObject, draw);
                    myRectangle.accept(visitor);
                }
                else if(jsonObject.get("type").toString().equals("ellipse")){
                    MyEllipse myEllipse = new MyEnhancedEllipse();
                    Visitor visitor = new JSONImportVisitor(jsonObject, draw);
                    myEllipse.accept(visitor);
                }
                else if(jsonObject.get("type").toString().equals("line")){
                    MyLine myLine = new MyEnhancedLine();
                    Visitor visitor = new JSONImportVisitor(jsonObject, draw);
                    myLine.accept(visitor);
                }
            }
        } 
        return draw;
    }

    @Override
    public Iterator<MyShape> iterator() {
        return this.figures.iterator();
    }
}
