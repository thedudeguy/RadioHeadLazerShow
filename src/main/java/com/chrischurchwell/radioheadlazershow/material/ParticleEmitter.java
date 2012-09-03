package com.chrischurchwell.radioheadlazershow.material;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.chrischurchwell.meshit.Model;
import com.chrischurchwell.radioheadlazershow.RadioheadLazerShow;
import com.chrischurchwell.radioheadlazershow.event.SequenceEvent;
import com.chrischurchwell.radioheadlazershow.gui.ParticleGUI;
import com.chrischurchwell.radioheadlazershow.texture.TextureFile;

public class ParticleEmitter extends GenericCustomBlock {
	
	public static HashMap<Location, ParticleSetting> particleSettings = new HashMap<Location, ParticleSetting>();
	
	public ParticleEmitter() {
		super(RadioheadLazerShow.getInstance(), "Projector of Awesomeness", Material.CAULDRON.getId());
		
		//Model model = new Model(ParticleTester.getInstance().getResource("models/machineBlock.obj"));
		Model model = new Model(RadioheadLazerShow.getInstance().getResource("models/particleemitter.obj"));
		
		BlockDesign design = model.getDesign();
		design.setTexture(RadioheadLazerShow.getInstance(), TextureFile.BLOCK_PARTICLE_EMITTER.getTexture());
		setBlockDesign(design);
		setHardness(0.1F);
		
		//set the recipe.
		SpoutManager.getMaterialManager().registerSpoutRecipe(
				new SpoutShapedRecipe(new SpoutItemStack(this, 1))
				.shape(" o ", " i ", "iii")
				.setIngredient('i', MaterialData.ironIngot)
				.setIngredient('o', MaterialData.obsidian)
			);
	}
	
	public boolean onBlockInteract(org.bukkit.World world, int x, int y, int z, SpoutPlayer player) {
		
		SpoutBlock block = (SpoutBlock)world.getBlockAt(x,y,z);
		
		//create the default settings
		if (!particleSettings.containsKey(block.getLocation())) particleSettings.put(block.getLocation(), new ParticleSetting());
		
		player.getMainScreen().attachPopupScreen(new ParticleGUI(block));
		
		return true;
	}
	
	public void onBlockClicked(org.bukkit.World world, int x, int y, int z, SpoutPlayer player) {
		
		SpoutBlock block = (SpoutBlock)world.getBlockAt(x,y,z);
		
		//create the default settings
		if (!particleSettings.containsKey(block.getLocation())) particleSettings.put(block.getLocation(), new ParticleSetting());
		
		//get settings
		//ParticleSetting ps = particleSettings.get(block.getLocation());
		
		//ParticleTester.spawnParticle(block, ps);
		
		SequenceEvent event = new SequenceEvent(block);
		Bukkit.getServer().getPluginManager().callEvent(event);
	}
	
	/*
	 * For redstone Power Activation
	 * @see org.getspout.spoutapi.material.block.GenericCustomBlock#onNeighborBlockChange(org.bukkit.World, int, int, int, int)
	 */
	public void onNeighborBlockChange(org.bukkit.World world, int x, int y, int z, int changedId) {
		
		SpoutBlock block = (SpoutBlock)world.getBlockAt(x, y, z);
		if (
				(
						block.getData("emitter.powered") == null ||
						(Integer)block.getData("emitter.powered") == 0
				) &&
				block.isBlockPowered() == true
				) {
			block.setData("emitter.powered", 1);
			
			onBlockClicked(world, x, y, z, null);
			
		} else if (
				block.getData("emitter.powered") != null &&
				(Integer)block.getData("emitter.powered") == 1 &&
				block.isBlockPowered() == true
				) {
		
		} else if (
				block.getData("emitter.powered") != null &&
				(Integer)block.getData("emitter.powered") == 1 &&
				block.isBlockPowered() == false
				) {
			block.setData("emitter.powered", 0);
			
		} else {
			block.setData("emitter.powered", 0);
		}
		
	}
	
}
