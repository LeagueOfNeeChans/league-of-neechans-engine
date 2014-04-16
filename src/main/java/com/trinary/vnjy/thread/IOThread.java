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
public class IOThread extends TaggedThread {
    protected String tag = "io";
    
    @Override
    protected String getTag() {
        return "io";
    }

    @Override
    public void process(Command command) {
        System.out.println("IO:  " + command);
    }
}
