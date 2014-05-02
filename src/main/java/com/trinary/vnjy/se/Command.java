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
<<<<<<< HEAD
    private ArrayList<String> args = new ArrayList();
=======
    private int priority = 0;
    private PyTuple args;
>>>>>>> priority

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
        return args.get(index);
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
    
    public Command(String command, ArrayList<String> args) {
        this.command = command;
        this.args = args;
    }
    
<<<<<<< HEAD
    public Command(String command, PyTuple args) {
        this.command = command;
=======
    public Integer getPriority() {
        return priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        ArrayList<String> argList = new ArrayList<String>();
>>>>>>> priority
        for (PyObject object : args.list) {
            this.args.add(((PyString)object).toString());
        }
    }
    
    @Override
    public String toString() {    
        return command + ":" + args;
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
