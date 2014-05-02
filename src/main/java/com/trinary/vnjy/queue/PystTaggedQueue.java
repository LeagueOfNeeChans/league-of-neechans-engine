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
        Command command = peekTaggedCommand(tag);
        
        if (command == null) {
            return null;
        }
        
        return command.remove();
    }
    
    public Command peekTaggedCommand(String tag) {
        Command command = (Command)peek();
        
        if (command == null || !command.getTag().equals(tag)) {
            return null;
        }
        
        // If command has been expended, then remove it.
        if (command.getTag().equals("none")) {
            remove();
            return null;
        }
        
        return command;
    }
}
