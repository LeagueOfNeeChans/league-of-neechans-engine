/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy;

import com.trinary.vnjy.se.Choice;
import com.trinary.vnjy.se.Command;
import com.trinary.vnjy.se.ScriptEngine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mmain
 */
public class Application {
    public static void main(String[] args) {
        ScriptEngine.init("lon.pyst");
        
        Scanner ob = new Scanner(System.in);
        Integer choice = 0;
      
        while (!ScriptEngine.isDone()) {
            ScriptEngine.run();
            
            Command command;
            ArrayList<Choice> choices = new ArrayList<Choice>();
            int i = 1;
            
            while ((command = ScriptEngine.popCommand()) != null) {
                switch (command.getCommand()) {
                    case "say":
                        System.out.println(command.getArg(0) + ": " + command.getArg(1));
                        break;
                    case "nsay":
                        System.out.println(command.getArg(0));
                        break;
                    case "choice":
                        System.out.println(i + "> " + command.getArg(0));
                        choices.add(new Choice(command));
                        i++;
                        break;
                    default:
                        System.out.println(command);
                }
            }
            
            if (ScriptEngine.isPaused()) {
                System.out.println("Enter choice: ");
                choice = Integer.parseInt(ob.nextLine());
                
                ScriptEngine.choose(choices.get(choice - 1));
            }
            
            System.out.println(ScriptEngine.getNext());
        }
    }
}
