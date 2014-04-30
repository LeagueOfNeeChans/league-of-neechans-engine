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
public class Narrator extends Actor {
    public void say(String dialogue) {
        ScriptEngine.addCommand("gfx.narrator.say", new PyTuple(this.name, StringFormatter.format(dialogue)));
    }    
}
