/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author daddy
 */
public class CommandInvoker {
    private Deque<Command> stack;

    public CommandInvoker() {
        stack = new ArrayDeque<>();
    }
    
    public void execute(Command command){
        stack.addFirst(command);
        command.execute();
    }
    
    public void undoLast(){
        Command lastCommand = stack.removeFirst();
        lastCommand.undo();
    }
    
}
