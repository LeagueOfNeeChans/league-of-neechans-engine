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
    
    static {
        pystQueue = new LinkedList<Command>();
    }
    
    private static boolean peekTag(String tag) {
        return pystQueue.peek().getTag() == tag;
    }
    
    // Graphics command
    public static Command getNextGFXCommand() {
        if (!peekTag("gfx")) {
            return null;
        }
        return pystQueue.remove();
    }
    
    // Sound FX command
    public static Command getNextSFXCommand() {
        if (!peekTag("sfx")) {
            return null;
        }
        return pystQueue.remove();
    }
    
    // Music command
    public static Command getNextBGMCommand() {
        if (!peekTag("bgm")) {
            return null;
        }
        return pystQueue.remove();
    }
    
    // Input/Output command
    public static Command getNextIOCommand() {
        if (!peekTag("io")) {
            return null;
        }
        return pystQueue.remove();
    }
}
