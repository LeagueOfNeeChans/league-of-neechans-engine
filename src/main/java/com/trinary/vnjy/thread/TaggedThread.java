/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.thread;

import com.trinary.vnjy.PystRouter;
import com.trinary.vnjy.se.Command;

/**
 *
 * @author mmain
 */
public abstract class TaggedThread extends Thread {
    protected String tag = "none";
    protected boolean running = false;
    
    protected Command popQueue() {
        return PystRouter.popTaggedCommand(tag);
    }
    
    protected void pushQueue(Command command) {
        PystRouter.pushCommand(command);
    }
    
    @Override 
    public void run() {
        while (running) {
            Command command = popQueue();
            
            // Process command.
            process(command);
        }
    }
    
    public void terminate() {
        running = false;
        stop();
    }
    
    public abstract void process(Command command);
}
