/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trinary.vnjy.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.PriorityBlockingQueue;

import com.trinary.vnjy.se.Command;

/**
 *
 * @author mmain
 */
//public abstract class PystQueue extends PriorityBlockingQueue {
public abstract class PystQueue extends ConcurrentLinkedQueue<Command> {
	private static final long serialVersionUID = -5444475338041204264L;

}
