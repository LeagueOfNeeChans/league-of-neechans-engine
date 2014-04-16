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
    public static PystTaggedQueue pystQueue;
    
    static {
        pystQueue = new PystTaggedQueue();
    }
    
    public static void routeCommand(Command command) {
        pystQueue.add(command);
    }
    
    public static Command popCommand(String tag) {
        return pystQueue.popTaggedCommand(tag);
    }
    
    public static Command peekCommand(String tag) {
        return pystQueue.peekTaggedCommand(tag);
    }
}
