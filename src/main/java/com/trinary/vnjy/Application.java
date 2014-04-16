/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy;

import com.trinary.vnjy.se.Choice;
import com.trinary.vnjy.se.Command;
import com.trinary.vnjy.se.ScriptEngine;
import com.trinary.vnjy.thread.*;

/**
 *
 * @author mmain
 */
public class Application {
    public static void main(String[] args) {
        ScriptEngine.init("lon.pyst");
        GFXThread gfx = new GFXThread();
        SFXThread sfx = new SFXThread();
        BGMThread bgm = new BGMThread();
        IOThread  io  = new IOThread(); 
        
        // Start all threads
        gfx.start();
        sfx.start();
        bgm.start();
        io.start();
        
        // Run main loop
        while (!ScriptEngine.isDone()) {
            ScriptEngine.run();
            
            Command command = PystRouter.peekCommand("se");
            
            if (command != null) {
                
                System.out.println("SE: " + command);
                
                if (command.getCommand().equals("se.choice.response")) {
                    Choice choice = new Choice(command);
                    ScriptEngine.choose(choice);
                }
                
                PystRouter.popCommand("se");
            }
            
            while ((command = ScriptEngine.popCommand()) != null) {
                PystRouter.routeCommand(command);
            }
        }
        
        // Kill all threads
        gfx.terminate();
        sfx.terminate();
        bgm.terminate();
        io.terminate();
    }
}