/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.pystengine;

import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;

import com.trinary.vnjy.se.ScriptEngine;
import com.trinary.vnjy.se.StringFormatter;
/**
 *
 * @author dstillz
 */
public class Actor {
    private String name = "";
    private PyList switches = new PyList();
    private PyList inventory = new PyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void set(String name) {
        if (!this.switches.contains(name)) {
            this.switches.append(name);
        }
    }
    
    public String give(Actor target, String item) {
        if (this.has(item)) {
            target.receive(item);
        }
    }
    
    public void receive(String name) {
        this.inventory.append(name);
    }
    
    public boolean is_set(String switch) {
        return (this.switches.contains(switch));
    }
        
    public boolean has(String item) {
        return (this.inventory.contains(item));
    }
    
    public void say(String dialogue) {
        ScriptEngine.addCommand("gfx.actor.say", new PyTuple(this.name, StringFormatter.format(dialogue)));
    }
    
    public void change(String mood) {
        ScriptEngine.addCommand("gfx.actor.change", new PyTuple(this.name, mood));
    }
    
    public Actor(String name) {
        this.name = name;
    }
}        
