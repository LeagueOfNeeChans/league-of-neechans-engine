/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.se;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import org.python.core.PyFunction;
import org.python.core.PyString;
import org.python.core.PyStringMap;
import org.python.core.PyTuple;
import org.python.util.PythonInterpreter;


/**
 *
 * @author mmain
 */
public class ScriptEngine {
    private static PyStringMap namespace;
    private static final Queue<Command> commands;
    private static String next;
    private static ScriptState state;
    private static final PythonInterpreter pi;
    
    static {
        pi = new PythonInterpreter();
        next = "start";
        commands = new LinkedList<>();
        state = ScriptState.STOPPED;
    }
    
    public static void init(String filename) {
        // Load actors
        String player = "Guy";
        ArrayList<String> actors = new ArrayList<>();
        actors.add("yumi");
        actors.add("miku");
        
        // Inject includes
        pi.exec("from com.trinary.vnjy.pystengine import *");
        pi.exec("from com.trinary.vnjy.se import ScriptEngine");
        
        // Inject player
        pi.exec("player = Player('" + player + "')");
        
        // Inject actors
        for (String actor : actors) {
            pi.exec(actor + " = Actor('" + actor + "')" );
        }
        
        // Inject scene
        pi.exec("scene = Scene()");

        // Inject narrator
        pi.exec("narrator = Narrator()" );
        
        // Inject pystengine
        pi.exec("engine = PystEngine()");

        // Load pyst script
        pi.execfile("lon.pyst");
        
        // Run inject
        pi.exec("ScriptEngine.inject(globals())");
    }
    
    public static void inject(PyStringMap functionTable) {
        ScriptEngine.namespace = functionTable;
    }
    
    public static void addCommand(String command, PyTuple args) {
        addCommand(new Command(command, args));
    }
    
    public static void addCommand(String command, ArrayList<String> args) {
        addCommand(new Command(command, args));
    }
    
    public static void addCommand(String command, String name, String args) {
        ArrayList<String> actual_args = new ArrayList();
        actual_args.add(name);
        actual_args.add(args);
        addCommand(new Command(command, actual_args));
    }
    
    public static void addCommand(Command c) {
        commands.add(c);
    }
    
    public static Command popCommand() {
        if (!commands.isEmpty()) {
            return commands.remove();
        } else {
            return null;
        }
    }
    
    public static void choose(Choice choice) {
        next = choice.getNext();
        state = ScriptState.STARTED;
    }
    
    public static boolean start() {
        state = ScriptState.STARTED;
        return nextScene("start");
    }
    
    public static boolean nextScene() {
        return nextScene(next);
    }
    
    public static boolean nextScene(String function) {
        PyString s = new PyString(function);
        if (namespace.has_key(s)) {
            PyFunction f = (PyFunction)namespace.get(s);
            next = ((PyString)f.__call__()).toString();
        } else {
            return false;
        }
        
        switch (next) {
            case "_wait":
                addCommand("ui.choice.request", new PyTuple());
                state = ScriptState.PAUSED;
                break;
            case "_end":
                addCommand("ui.core.shutdown", new PyTuple());
                addCommand("sfx.core.shutdown", new PyTuple());
                addCommand("bgm.core.shutdown", new PyTuple());
                addCommand("se.core.shutdown", new PyTuple());
                next = "_done";
                break;
            case "_done":
            default:
                return false;
        }
        
        return true;
    }
    
    public static String getNext() {
        return next;
    }
    
    public static PyStringMap getNamespace() {
        return namespace;
    }
    
    public static boolean isPaused() {
        return state == ScriptState.PAUSED;
    }
    
    public static boolean isRunning() {
        return state == ScriptState.STARTED;
    }
    
    public static boolean isDone() {
        return state == ScriptState.DONE;
    }
    
    public static void kill() {
        state = ScriptState.DONE;
    }
}