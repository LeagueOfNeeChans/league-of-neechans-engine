/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.se;

import java.util.ArrayList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;

/**
 *
 * @author mmain
 */
public class Command implements Tagged {
    protected String from = "";
    protected Boolean blocking = true;
    private String command = "";
    private ArrayList<String> args = new ArrayList<>();
    private Boolean removed = false;
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Boolean isBlocking() {
        return blocking;
    }

    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<String> args) {
        this.args = args;
    }
    
    public String getArg(Integer index) {
        if (index >= args.size()) {
            return "";
        }
        
        return args.get(index);
    }

    @Override
    public String getTag() {
        if (removed) {
            return "none";
        }
        
        return command.split("\\.")[0];
    }
    
    public String getNamespace() {
        if (removed) {
            return "none";
        }
        
        return command.split("\\.")[1];
    }
    
    public String getFunction() {
        if (removed) {
            return "nop";
        }
        
        return command.split("\\.")[2];
    }
    
    public Command remove() {        
        System.out.println("MARKING COMMAND " + this + " COMPLETED.");
        
        removed = true;
        return this;
    }
    
    public Command() {
    }
    
    public Command(String command, PyTuple args) {
        this.command = command;
        for (PyObject object : args.list) {
            this.args.add(((PyString)object).toString());
        }
    }
    
    public Command(String command, ArrayList<String> args) {
        this.command = command;
        this.args = args;
    }
    
    @Override
    public String toString() {    
        return command + ":" + args;
    }
}
