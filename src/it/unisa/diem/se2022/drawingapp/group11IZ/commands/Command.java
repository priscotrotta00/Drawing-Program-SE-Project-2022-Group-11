package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

/**
 * Interface that represents a command to be executed by an Invoker, according 
 * to the Command Pattern
 * @author Felice Scala
 */
public interface Command {
    /**
     * Execute the action related to the command
     */
    public void execute();
    
    /**
     * Undo the already done action related to the command
     */
    public void undo();
}
