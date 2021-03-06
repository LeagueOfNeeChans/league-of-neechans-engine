/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy;

import com.trinary.vnjy.queue.PystTaggedQueue;
import com.trinary.vnjy.se.Command;

/**
 *
 * @author mmain
 */
public class PystRouter {
    public static PystTaggedQueue mainQueue;
    public static PystTaggedQueue ioQueue;
    
    static {
        mainQueue = new PystTaggedQueue();
        ioQueue = new PystTaggedQueue();
    }
    
    public static void routeCommand(Command command) {
        //System.out.println("ROUTING COMMAND " + command);
        mainQueue.add(command);
    }
    
    public static Command popCommand(String tag) {
        //System.out.println("POPPING COMMAND " + mainQueue.peekTaggedCommand(tag));
        return mainQueue.popTaggedCommand(tag);
    }
    
    public static Command peekCommand(String tag) {
        return mainQueue.peekTaggedCommand(tag);
    }
    
    public static void routeIoCommand(Command command) {
        //System.out.println("ROUTING IO COMMAND " + command);
        ioQueue.add(command);
    }
    
    public static Command popIoCommand(String tag) {
        //System.out.println("POPPING IO COMMAND " + mainQueue.peekTaggedCommand(tag));
        return ioQueue.popTaggedCommand(tag);
    }
    
    public static Command peekIoCommand(String tag) {
        return ioQueue.peekTaggedCommand(tag);
    }
}
