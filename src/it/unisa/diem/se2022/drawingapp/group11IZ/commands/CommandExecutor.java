/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import java.util.Stack;

/**
 *
 * @author utente
 */
public class CommandExecutor {
    private static CommandExecutor instance;
    private Stack<Command> commandStack;
    
    private CommandExecutor(){
        this.commandStack = new Stack();
    }
    
    public static CommandExecutor getInstance(){
        if (instance == null) instance = new CommandExecutor();
        return instance;
    }
    
    public void execute(Command command){
        command.execute();
        commandStack.add(command);
    }
    
    public void undoLastCommand(){
        commandStack.pop().undo();
    }
}
