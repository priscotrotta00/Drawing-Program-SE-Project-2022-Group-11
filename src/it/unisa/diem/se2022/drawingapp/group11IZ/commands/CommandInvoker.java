/**
 * Class that maintain the stack of executed commands
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import java.util.ArrayDeque;
import java.util.Deque;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Class that represents the Invoker that executes the Commands, according to 
 * the Command Pattern. It keeps a history of the commands that have been
 * executed inside a stack. It is possible to undo the commands according to a 
 * LIFO policy
 * @author daddy
 */
public class CommandInvoker {
    private final Deque<Command> stack;
    private final BooleanProperty emptyProperty;
    
    /**
     * Constructor
     */
    public CommandInvoker() {
        stack = new ArrayDeque<>();
        emptyProperty = new SimpleBooleanProperty(stack.isEmpty());
    }
    
    /**
     * Return the property if the stack of executed commands is empty
     * @return 
     */
    public BooleanProperty stackIsEmptyProperty() {
        return emptyProperty;
    }
    
    /**
     * Clears the commands stack
     */
    public void clearStack(){
        stack.clear();
        emptyProperty.set(stack.isEmpty());
    }
    
    /**
     * Add the command to execute in the stack, update the Empty Property
     * and execute the command
     * @param command 
     */
    public void execute(Command command){
        stack.addFirst(command);
        emptyProperty.set(stack.isEmpty());
        command.execute();
    }
    
    /**
     * remove the last command added in the stack, update the Empty Property
     * and execute the undo operation of the last executed command
     */
    public void undoLast(){
        Command lastCommand = stack.removeFirst();
        emptyProperty.set(stack.isEmpty());
        lastCommand.undo();
    }
    
}
