/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.se;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mmain
 */
public class ComplexCommand extends Command {
    Queue<Command> commands;
    
    @Override
    public String getTag() {
        Command command = commands.peek();
        if (command == null) {
            return "none";
        }
        
        return command.getTag();
    }
    
    @Override
    public String getNamespace() {
        Command command = commands.peek();
        if (command == null) {
            return "none";
        }
        
        return command.getNamespace();
    }
    
    @Override
    public String getFunction() {
        Command command = commands.peek();
        if (command == null) {
            return "nop";
        }
        
        return command.getFunction();
    }
    
    @Override
    public ArrayList<String> getArgs() {
        Command command = commands.peek();
        ArrayList<String> args;
        if (command == null) {
            args = new ArrayList<>();
        } else {
            args = command.getArgs();
        }
        
        return args;
    }
    
    @Override
    public String getArg(Integer index) {
        ArrayList<String> args = getArgs();
        
        if (index >= args.size()) {
            return "";
        }
        
        return args.get(index);
    }
    
    public Command remove() {
        return commands.remove();
    }
    
    public void add(Command command) {
        commands.add(command);
    }
    
    public ComplexCommand() {
        commands = new LinkedList<>();
    }
}
