package com.chrischurchwell.radioheadlazershow.listener;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.radioheadlazershow.material.ParticleSetting;

public abstract class SequenceRunnable implements Runnable {

	long startTime;
	SpoutBlock block;
	ParticleSetting settings;
	
	public SequenceRunnable(long startTime, SpoutBlock block, ParticleSetting settings) {
		this.startTime = startTime;
		this.block = block;
		this.settings = settings;
	}
}
