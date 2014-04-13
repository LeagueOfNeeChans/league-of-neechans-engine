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
public class Command {
    private String command = "";
    private PyTuple args;
    
    private String tag = "";

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
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public Command(String command, PyTuple args) {
        this.command = command;
        this.args = args;
    }
    
    @Override
    public String toString() {
        ArrayList<String> argList = new ArrayList<String>();
        for (PyObject object : args.list) {
            argList.add(((PyString)object).toString());
        }
        
        return command + ":" + argList;
    }
}
