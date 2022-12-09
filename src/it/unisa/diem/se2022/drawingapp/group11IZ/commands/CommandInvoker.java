/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import java.util.ArrayDeque;
import java.util.Deque;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author daddy
 */
public class CommandInvoker {
    private Deque<Command> stack;
    private BooleanProperty emptyProperty;

    public CommandInvoker() {
        stack = new ArrayDeque<>();
        emptyProperty = new SimpleBooleanProperty(stack.isEmpty());
    }

    public BooleanProperty stackIsEmptyProperty() {
        return emptyProperty;
    }
    
    public void clearStack(){
        stack.clear();
        emptyProperty.set(stack.isEmpty());
    }
    
    public void execute(Command command){
        stack.addFirst(command);
        emptyProperty.set(stack.isEmpty());
        command.execute();
    }
    
    public void undoLast(){
        Command lastCommand = stack.removeFirst();
        emptyProperty.set(stack.isEmpty());
        lastCommand.undo();
    }
    
}
