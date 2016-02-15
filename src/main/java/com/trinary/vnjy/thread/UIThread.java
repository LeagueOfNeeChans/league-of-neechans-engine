/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.thread;

import com.trinary.util.EventCallback;
import com.trinary.vn.screen.UICore;
import com.trinary.vnjy.PystRouter;
import com.trinary.vnjy.se.Choice;
import com.trinary.vnjy.se.Command;

/**
 *
 * @author mmain
 */
public class UIThread extends TaggedThread {
	protected UICore core = new UICore();
	
	public UIThread() {
		core.scaleUI(0.8);
		core.setCallback(new EventCallback() {
			@Override
			public void run(String id) {
				
				Command c = new Choice("", id).toResponse();
                PystRouter.routeIoCommand(c);
			}
		});
	}
	
    @Override
    protected String getTag() {
        return "ui";
    }

    @Override
    public void processCommand(Command command) {
        System.out.println("UI: " + command);
        
        // IO Functions
        if (command.getNamespace().equals("choice")) {
	        switch (command.getFunction()) {
	        case "prompt":
	        	core.addChoice(command.getArg(1), command.getArg(0));
	            break;
	        case "request":
	        	core.showChoices();
	            break;
	        };
        } else if (command.getNamespace().equals("narrator")) {
        	switch (command.getFunction()) {
	        case "say":
	        	core.setText(command.getArg(0), String.format("<i>%s</i>", command.getArg(1)));
	            break;
	        }
        } else if (command.getNamespace().equals("actor")) {
	        switch (command.getFunction()) {
	        case "say":
	        	core.setText(command.getArg(0), command.getArg(1));
	            break;
	        case "change":
	        	core.changeActorMood(command.getArg(0), command.getArg(1));
	            break;
	        }
        } else if (command.getNamespace().equals("scene")) {
	        switch (command.getFunction()) {
	        case "move":
	        	core.changeScene(command.getArg(0));
	        	break;
	        case "add":
	        	core.addActor(command.getArg(0), command.getArg(1));
	        	break;
	        case "remove":
	        	core.removeActor(command.getArg(0));
	        }
        }
        
        // Block while last call is drawing
    	while (core.isDrawing()) {
    		try { sleep(0); } catch (InterruptedException e) {}
    	}
    	System.out.println("COMMAND COMPLETE");
    }       

    @Override
    public void processIo(Command command) {
    }

	@Override
	public void terminate() throws InterruptedException {
		core.stop();
		super.terminate();
	}
}