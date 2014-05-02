/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.pystengine;

import java.util.ArrayList;

import com.trinary.vnjy.se.ScriptEngine;
import com.trinary.vnjy.se.StringFormatter;
/**
 *
 * @author dstillz
 */
public class Actor {
    protected String name = "";
    protected ArrayList<String> switches = new ArrayList();
    protected ArrayList<String> inventory = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void set(String name) {
        if (!this.switches.contains(name)) {
            this.switches.add(name);
        }
    }
    
    public void give(Actor target, String item) {
        if (this.has(item)) {
            target.receive(item);
        }
    }
    
    public void receive(String name) {
        this.inventory.add(name);
    }
    
    public boolean is_set(String switch_name) {
        return (this.switches.contains(switch_name));
    }
        
    public boolean has(String item) {
        return (this.inventory.contains(item));
    }
    
    public void say(String dialogue) {
        ScriptEngine.addCommand("gfx.actor.say", name, StringFormatter.format(dialogue));
    }
    
    public void change(String mood) {
        ScriptEngine.addCommand("gfx.actor.change", name, mood);
    }
    
    public Actor(String name) {
        this.name = name;
    }
}        
