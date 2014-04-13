/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy;

import com.trinary.vnjy.se.Command;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mmain
 */
public class PystRouter {
    public static Queue<Command> pystQueue;
    private static final Object lock;
    
    static {
        pystQueue = new LinkedList<>();
        lock = new Object();
    }
    
    public static void routeCommand(Command command) {
        switch (command.getCommand()) {
            case "gfx.scene.change":
            case "gfx.actor.add":
            case "gfx.actor.change":
            case "gfx.actor.say":
            case "gfx.actor.emote":
            case "gfx.narrator.nsay":
            case "gfx.choice.render":
                command.setTag("gfx");
            case "io.choice.request":
                command.setTag("io");
        }
    }
    
    public static Command popTaggedCommand(String tag) {
        if (! pystQueue.peek().getTag().equals(tag)) {
            return null;
        }
        return popCommand();
    }
    
    // Pop command (thread safe)
    public static Command popCommand() {
        synchronized (lock) {
            return pystQueue.remove();
        }
    }
    
    // Push command (thread safe)
    public static void pushCommand(Command command) {
        synchronized (lock) {
            pystQueue.add(command);
        }
    }
    
    // Graphics command
    public static Command getNextGFXCommand() {
        return popTaggedCommand("gfx");
    }
    
    // Sound FX command
    public static Command getNextSFXCommand() {
        return popTaggedCommand("sfx");
    }
    
    // Music command
    public static Command getNextBGMCommand() {
        return popTaggedCommand("bgm");
    }
    
    // Input/Output command
    public static Command getNextIOCommand() {
        return popTaggedCommand("io");
    }
}
