/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.se;

import java.util.ArrayList;

/**
 *
 * @author mmain
 */
public class Choice {
    private String text = "";
    private String next = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
    public Command toResponse() {
        ArrayList<String> args = new ArrayList<>();
        args.add(text);
        args.add(next);
        return new Command("se.choice.response", args);
    }
    
    @Override
    public String toString() {
        return text;
    }
    
    public Choice(String text, String next) {
        this.text = text;
        this.next = next;
    }
    
    public Choice(Command command) {
        this.text = command.getArg(0);
        this.next = command.getArg(1);
    }
}
