/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.thread;

import com.trinary.vnjy.se.Command;

/**
 *
 * @author mmain
 */
public class SFXThread extends TaggedThread {
    protected String tag = "sfx";
    
    @Override
    protected String getTag() {
        return "sfx";
    }

    @Override
    public void processCommand(Command command) {
        System.out.println("SFX:  " + command);
    }

    @Override
    public void processIo(Command command) {
    }
}
