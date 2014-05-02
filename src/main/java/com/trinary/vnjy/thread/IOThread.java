/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.thread;

import com.trinary.vnjy.PystRouter;
import com.trinary.vnjy.se.Choice;
import com.trinary.vnjy.se.Command;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mmain
 */
public class IOThread extends TaggedThread {
    protected Scanner sc = new Scanner(System.in);
    protected ArrayList<Choice> choices = new ArrayList<>();
    
    @Override
    protected String getTag() {
        return "io";
    }

    @Override
    public void processCommand(Command command) {
        System.out.println("IO:  " + command);
        
        switch (command.getFunction()) {
            case "prompt":
                choices.add(new Choice(command));
                break;
            case "request":
                System.out.println("Make a choice:");
                Integer choice = Integer.parseInt(sc.nextLine());
                System.out.println("YOU CHOSE: " + choices.get(choice));
                Command c = choices.get(choice).toResponse();
                PystRouter.routeIoCommand(c);
                choices = new ArrayList<>();
                break;
        }
    }

    @Override
    public void processIo(Command command) {
    }
}
