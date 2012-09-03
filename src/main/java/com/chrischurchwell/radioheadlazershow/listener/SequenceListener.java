package com.chrischurchwell.radioheadlazershow.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.particle.Particle;

import com.chrischurchwell.radioheadlazershow.RadioheadLazerShow;
import com.chrischurchwell.radioheadlazershow.cloud.Point;
import com.chrischurchwell.radioheadlazershow.cloud.PointCloud;
import com.chrischurchwell.radioheadlazershow.event.SequenceEvent;
import com.chrischurchwell.radioheadlazershow.material.ParticleSetting;

public class SequenceListener implements Listener {
	
	public static Integer lastTaskId;
	
	@EventHandler
	public void onSequenceEvent(SequenceEvent event) {
		
		//cancel running.
		if (lastTaskId != null) {
			Bukkit.getScheduler().cancelTask(lastTaskId);
		}
				
		//first get the current time so we can calculate time passed
		long startTime = System.currentTimeMillis();
		RadioheadLazerShow.log("Starting Sequence at " + String.valueOf(startTime));
		
		RadioheadLazerShow.log("Starting Music.");
		SpoutManager.getSoundManager().playGlobalCustomMusic(
				RadioheadLazerShow.getInstance(), 
				RadioheadLazerShow.musicFilename, 
				true, 
				event.getBlock().getLocation(), 
				(int)Math.rint(event.getSettings().getRange())
				);
		
		//start the sequence task.
		lastTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(
				RadioheadLazerShow.instance,
				new SequenceRunnable(startTime, event.getBlock(), event.getSettings()) {
					public void run() {
						//get time passed.
						long passedTime = System.currentTimeMillis()-startTime;
						
						if (passedTime > 67000) {
							RadioheadLazerShow.log("End of Sequence."); 
							//try to cancel myself
							Bukkit.getScheduler().cancelTask(lastTaskId);
							return;
						}
						
						int frame = Math.round(2101 * (((float)passedTime)/70000));
						
						if (frame < 1 || frame > 2101) return;
						
						//ParticleTester.log("Time Passed " + String.valueOf(passedTime) + " -- Frame: " + String.valueOf(frame));
						
						//load fram
						PointCloud pointCloud = new PointCloud();
						pointCloud.loadCSV(new File(RadioheadLazerShow.getInstance().getDataFolder(), "data/"+String.valueOf(frame)+".csv"));
						//ParticleTester.log("Point Cloud Loaded: " + String.valueOf(pointCloud.getPointCount()) + " points total.");
						
						spawnPointCloud(pointCloud, block, settings);
						
					}
				}, 
				0L, event.getSettings().getUpdateInterval());
	}
	
	public static void spawnPointCloud(PointCloud cloud, SpoutBlock block, ParticleSetting settings) {
		
		//ParticleTester.log("Spawning Particles...");
		
		int count = 1;
		
		for (Point point : cloud.getPoints()) {
			
			if (count % settings.getQuality() == 0) {
				//prepare location
				Location pLocation = block.getLocation();
				
				//rotate on x axis
				float x = (float)point.getX();
				float y = (float)point.getY();
				float z = (float)point.getZ();
				float x0 = x;
				float y0 = (float)( ((z) * Math.sin(Math.toRadians(settings.getRotationX()))) + ((y) * Math.cos(Math.toRadians(settings.getRotationX()))) );
				float z0 = (float)( ((z) * Math.cos(Math.toRadians(settings.getRotationX()))) - ((y ) * Math.sin(Math.toRadians(settings.getRotationX()))) );
				
				pLocation.setX(pLocation.getX() + -10d + ((double)x0/(double)settings.getScaleDown()));
				pLocation.setY(pLocation.getY() + settings.getHeightAdjustment() + ((double)y0/(double)settings.getScaleDown()));
				pLocation.setZ(pLocation.getZ() + -10d + ((double)z0/(double)settings.getScaleDown()));
				
				//prepare vector.
				Vector v = new Vector(settings.getMotionX(), settings.getMotionY(), settings.getMotionZ());
				
				//create particle.
				Particle particle = new Particle(settings.getType(), pLocation, v);
				particle.setAmount(settings.getAmount());
				particle.setGravity(settings.getGravity());
				particle.setMaxAge(settings.getAge());
				particle.setParticleBlue(settings.getBlue());
				particle.setParticleGreen(settings.getGreen());
				particle.setParticleRed(settings.getRed());
				//particle.setRange(ps.getRange());
				particle.setRange(settings.getRange());
				particle.setScale(settings.getScale());
				
				particle.spawn();
			}
			count++;
		}
	}
}
