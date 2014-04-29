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
public class Command implements Comparable {
    private String command = "";
    private int priority = 0;
    private PyTuple args;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public PyTuple getArgs() {
        return args;
    }

    public void setArgs(PyTuple args) {
        this.args = args;
    }
    
    public String getArg(Integer index) {
        return ((PyString)args.list[index]).toString();
    }

    public String getTag() {
        return command.split("\\.")[0];
    }
    
    public String getNamespace() {
        return command.split("\\.")[1];
    }
    
    public String getFunction() {
        return command.split("\\.")[2];
    }
    
    public Command(String command, PyTuple args) {
        this.command = command;
        this.args = args;
    }
    
    public Integer getPriority() {
        return priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        ArrayList<String> argList = new ArrayList<String>();
        for (PyObject object : args.list) {
            argList.add(((PyString)object).toString());
        }
        
        return command + ":" + argList;
    }

    @Override
    public int compareTo(Object o) {
        Command c = (Command)o;
        if (this.priority > c.priority) {
            return 1;
        } else if (this.priority < c.priority) {
            return -1;
        } else {
            return 0;
        }
    }
}
