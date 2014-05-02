/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.queue;

import com.trinary.vnjy.se.Command;
import com.trinary.vnjy.se.ComplexCommand;


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
        
        //System.out.println("POPPING COMMAND " + command);
        
        // This doesn't work yet...
        //return command.remove();
        
        if (command instanceof ComplexCommand) {
            return command.remove();
        } else {
            return (Command)remove();
        }
    }
    
    public Command peekTaggedCommand(String tag) {
        Command command = (Command)peek();
        
        // If command has been expended, then remove it.
        if (command != null && command.getTag().equals("none")) {
            //System.out.println("REMOVING COMMAND " + command);
            
            remove();
            return null;
        } else if (command == null || !command.getTag().equals(tag)) {
            return null;
        }
        
        return command;
    }
}
