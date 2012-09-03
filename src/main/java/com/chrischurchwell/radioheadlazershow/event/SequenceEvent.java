package com.chrischurchwell.radioheadlazershow.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.radioheadlazershow.material.ParticleEmitter;
import com.chrischurchwell.radioheadlazershow.material.ParticleSetting;

public class SequenceEvent extends Event {
	
	private SpoutBlock block;
	private ParticleSetting settings;
	
	public SequenceEvent(SpoutBlock block) {
		setBlock(block);
		if (!ParticleEmitter.particleSettings.containsKey(block.getLocation())) ParticleEmitter.particleSettings.put(block.getLocation(), new ParticleSetting());
		
		setSettings(ParticleEmitter.particleSettings.get(block.getLocation()));
	}
	
	public SpoutBlock getBlock() {
		return block;
	}
	public void setBlock(SpoutBlock block) {
		this.block = block;
	}
	
	public ParticleSetting getSettings() {
		return settings;
	}

	public void setSettings(ParticleSetting settings) {
		this.settings = settings;
	}
	
	/**
	 * Required by Bukkit
	 */
	private static final HandlerList handlers = new HandlerList();
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}
