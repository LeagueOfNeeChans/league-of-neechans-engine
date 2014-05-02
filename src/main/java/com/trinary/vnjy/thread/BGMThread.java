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
public class BGMThread extends TaggedThread {
    protected String tag = "bgm";
    
    @Override
    protected String getTag() {
        return "bgm";
    }

    @Override
    public void processCommand(Command command) {
        System.out.println("BGM:  " + command);
    }

    @Override
    public void processIo(Command command) {
    }
}
