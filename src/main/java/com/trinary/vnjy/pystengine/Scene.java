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
public class Scene {
    public void move(String location) {
        ScriptEngine.addCommand("ui.scene.move", location, "");
    }

    public void add_actor(Actor actor, String side) {
        ScriptEngine.addCommand("ui.scene.add", actor.getName(), side);
    }
    
    public void remove_actor(Actor actor) {
        ScriptEngine.addCommand("ui.scene.remove", actor.getName(), "");
    }
    
    public void display_image(String resource) {
        ScriptEngine.addCommand("ui.scene.display", resource, "");
    }
}
