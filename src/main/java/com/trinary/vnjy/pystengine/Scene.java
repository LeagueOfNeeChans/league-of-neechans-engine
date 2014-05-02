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
        ScriptEngine.addCommand("gfx.scene.move", location, "");
    }

    public void add_actor(Actor actor, String side) {
        ScriptEngine.addCommand("gfx.scene.add", actor.getName(), side);
    }
    
    public void display_image(String resource) {
        ScriptEngine.addCommand("gfx.scene.display", resource, "");
    }
}
