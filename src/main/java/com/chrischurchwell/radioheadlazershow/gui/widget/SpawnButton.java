package com.chrischurchwell.radioheadlazershow.gui.widget;

import org.bukkit.Bukkit;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;

import com.chrischurchwell.radioheadlazershow.event.SequenceEvent;

public class SpawnButton extends GenericButton {

	private SpoutBlock block;
	
	public SpawnButton(SpoutBlock block) {
		super("Start Show");
		this.block = block;
	}
	
	public void onButtonClick(ButtonClickEvent event) {
		SequenceEvent sEvent = new SequenceEvent(block);
		Bukkit.getServer().getPluginManager().callEvent(sEvent);
		event.getPlayer().getMainScreen().getActivePopup().close();
	}
}
