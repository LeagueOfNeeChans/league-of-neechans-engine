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
        UIThread  ui = new UIThread();
        SFXThread sfx = new SFXThread();
        BGMThread bgm = new BGMThread();
        
        // Start all threads
        ui.start();
        sfx.start();
        bgm.start();
        
        // Run main loop
        while (!ScriptEngine.isDone()) {
            // Run next scene
            ScriptEngine.nextScene();
            
            // Check for io command
            Command ioCommand = PystRouter.peekIoCommand("se");
            if (ioCommand != null) {
                if (ioCommand.getCommand().equals("se.choice.response")) {
                    Choice choice = new Choice(ioCommand);
                    ScriptEngine.choose(choice);
                }
                PystRouter.popIoCommand("se");
            }
            
            // Check for non-io command
            Command command = PystRouter.peekCommand("se");
            if (command != null) {               
                System.out.println("SE: " + command);
                PystRouter.popCommand("se");
                
                if (command.getFunction().equals("shutdown")) {
                    ScriptEngine.kill();
                }
            }
            
            // If SE has a command from the script waiting, route it
            while ((command = ScriptEngine.popCommand()) != null) {
                PystRouter.routeCommand(command);
            }
        }
        
        // Kill all threads
        ui.terminate();
        sfx.terminate();
        bgm.terminate();
    }
}