package it.unisa.diem.se2022.drawingapp.group11IZ;

import it.unisa.diem.se2022.drawingapp.group11IZ.Import.JSONImportVisitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.export.JSONExportVisitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.exceptions.ExtensionFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class that represents the File Manager of the application
 * @author prisc
 */
public class FileManager {
    /**
     * Create a new FileManager
     */
    
    public FileManager() {
    }
    
    /**
     * Load the drawing from the file passed as parameter
     * @param file File from which you need to import the drawing
     * @return Drawing object representing the loaded drawing
     */
    public Drawing loadFile(File file) {
        if(file == null) throw new NullPointerException();
        if(!file.getPath().endsWith(".json")) throw new ExtensionFileException();
        Drawing draw = new Drawing(); 
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(file)){
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while(iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                switch (jsonObject.get("type").toString()) {
                    case "rectangle":
                        {
                            MyRectangle myRectangle = new MyEnhancedRectangle();
                            Visitor visitor = new JSONImportVisitor(jsonObject, draw);
                            myRectangle.accept(visitor);
                            break;
                        }
                    case "ellipse":
                        {
                            MyEllipse myEllipse = new MyEnhancedEllipse();
                            Visitor visitor = new JSONImportVisitor(jsonObject, draw);
                            myEllipse.accept(visitor);
                            break;
                        }
                    case "line":
                        {
                            MyLine myLine = new MyEnhancedLine();
                            Visitor visitor = new JSONImportVisitor(jsonObject, draw);
                            myLine.accept(visitor);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return draw;
    }
    
    /**
     * Save the drawing in the file passed as first parameter
     * @param file File in which you need to save the drawing
     * @param draw Drawing that you want to save
     */
    public void saveFile(File file, Drawing draw){
        if (file == null || draw == null) throw new NullPointerException();
        if(!file.getName().endsWith(".json")) throw new ExtensionFileException();
        JSONArray jsonArray = new JSONArray();
        Visitor visitor = new JSONExportVisitor(jsonArray);
        Iterator<MyShape> itr;
        itr = draw.iterator();
        while(itr.hasNext())
            itr.next().accept(visitor);
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.close(); 
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
