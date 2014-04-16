/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.queue;

import com.trinary.vnjy.se.Command;


/**
 *
 * @author mmain
 */
public class PystTaggedQueue extends PystQueue {
    public Command popTaggedCommand(String tag) {
        if (peekTaggedCommand(tag) == null) {
            return null;
        }
        
        return (Command)remove();
    }
    
    public Command peekTaggedCommand(String tag) {
        Command command = (Command)peek();
        
        if (command == null || !command.getTag().equals(tag)) {
            return null;
        }
        
        return command;
    }
    
    // Graphics command
    public Command peekGFXCommand() {
        return peekTaggedCommand("gfx");
    }
    
    // Sound FX command
    public Command peekSFXCommand() {
        return peekTaggedCommand("sfx");
    }
    
    // Music command
    public Command peekBGMCommand() {
        return peekTaggedCommand("bgm");
    }
    
    // Input/Output command
    public Command peekIOCommand() {
        return peekTaggedCommand("io");
    }
    
    // Graphics command
    public Command popGFXCommand() {
        return popTaggedCommand("gfx");
    }
    
    // Sound FX command
    public Command popSFXCommand() {
        return popTaggedCommand("sfx");
    }
    
    // Music command
    public Command popBGMCommand() {
        return popTaggedCommand("bgm");
    }
    
    // Input/Output command
    public Command popIOCommand() {
        return popTaggedCommand("io");
    }
}
