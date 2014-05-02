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
        
        // If command has been expended, then remove it.
        if (command != null && command.getTag().equals("none")) {
            //System.out.println("COMMAND IS EXPENDED.");
            remove();
            return null;
        } else if (command == null || !command.getTag().equals(tag)) {
            return null;
        }
        
        return command;
    }
}
