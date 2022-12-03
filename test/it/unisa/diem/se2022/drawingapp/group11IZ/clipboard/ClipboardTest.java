/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.clipboard;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.lang.reflect.Field;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class ClipboardTest {
    
    @Test 
    public void testCopy(){
        MyEnhancedLine line=new MyEnhancedLine();
        Clipboard clipboard= new Clipboard();
        
        clipboard.copy(line);
        assertTrue("error in hasCopiedShape", clipboard.hasCopiedShape());
        assertTrue("Error in copy", clipboard.getNewCopy()==line);
        
    }
    
    @Test 
    public void testGetNewCopy() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Clipboard clipboard= new Clipboard();
        MyEnhancedLine line=new MyEnhancedLine();
        clipboard.copy(line);
        assertTrue("error in getNewCopy", clipboard.getNewCopy()==line);
        
    }
    
    @Test 
    public void testClear(){
        MyEnhancedLine line=new MyEnhancedLine();
        Clipboard clipboard= new Clipboard();
        
        clipboard.copy(line);
        clipboard.clear();
        assertTrue("Error in clear",clipboard.getNewCopy()==null);
        assertFalse("Error in clear2", clipboard.hasCopiedShape());
    }
    
    @Test 
    public void testCopiedProperty(){
        Clipboard clipboard= new Clipboard();
        assertFalse("error in hascopiedShape", clipboard.copiedProperty().get());
        
    }
    
     @Test 
    public void testCopiedProperty2(){
        MyEnhancedLine line=new MyEnhancedLine();
        Clipboard clipboard= new Clipboard();
        clipboard.copy(line);
        assertTrue("error in hascopiedShape", clipboard.copiedProperty().get());
        
    }
   
    @Test
    public void testHasCopiedShape(){
        //MyEnhancedLine line=new MyEnhancedLine();
        Clipboard clipboard= new Clipboard();
        assertFalse("error in hascopiedShape", clipboard.hasCopiedShape());
        
    }
    
    @Test
    public void testHasCopiedShape2(){
        MyEnhancedLine line=new MyEnhancedLine();
        Clipboard clipboard= new Clipboard();
        clipboard.copy(line);
        assertTrue("error in hascopiedShape", clipboard.hasCopiedShape());
        
    }
    
    
    
}
