/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.pystengine;

import com.trinary.vnjy.se.ScriptEngine;

/**
 *
 * @author dstillz
 */
public class PystEngine {
    public void choice(String text, String next) {       
        ScriptEngine.addCommand("gfx.choice.prompt", text, "");
        ScriptEngine.addCommand("io.choice.prompt", text, next);        
    }
}
