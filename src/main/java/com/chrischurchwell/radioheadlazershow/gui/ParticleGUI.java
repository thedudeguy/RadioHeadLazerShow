package com.chrischurchwell.radioheadlazershow.gui;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.gui.GenericPopup;

import com.chrischurchwell.radioheadlazershow.RadioheadLazerShow;
import com.chrischurchwell.radioheadlazershow.gui.widget.AgeSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.BlueSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.CloseButton;
import com.chrischurchwell.radioheadlazershow.gui.widget.GravitySlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.GreenSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.MotionXSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.MotionYSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.MotionZSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.RangeSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.RedSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.ScaleSlider;
import com.chrischurchwell.radioheadlazershow.gui.widget.SpawnButton;
import com.chrischurchwell.radioheadlazershow.gui.widget.TypeCombo;

public class ParticleGUI extends GenericPopup {

	public ParticleGUI(SpoutBlock block) {
		
		//Type
		TypeCombo typeCombo = new TypeCombo(block);
		typeCombo.setX(5).setY(5);
		typeCombo.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), typeCombo);
		
		//Age
		AgeSlider ageSlider = new AgeSlider(block);
		ageSlider.setX(5).setY(55);
		ageSlider.setWidth(200).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), ageSlider);
		
		//Gravity
		GravitySlider gravitySlider = new GravitySlider(block);
		gravitySlider.setX(5).setY(80);
		gravitySlider.setWidth(200).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), gravitySlider);
		
		//Scale
		ScaleSlider scaleSlider = new ScaleSlider(block);
		scaleSlider.setX(5).setY(105);
		scaleSlider.setWidth(200).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), scaleSlider);
		
		//Range
		RangeSlider rangeSlider = new RangeSlider(block);
		rangeSlider.setX(5).setY(130);
		rangeSlider.setWidth(200).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), rangeSlider);
		
		//Color Red
		RedSlider redSlider = new RedSlider(block);
		redSlider.setX(5).setY(155);
		redSlider.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), redSlider);
		
		//Color Green
		GreenSlider greenSlider = new GreenSlider(block);
		greenSlider.setX(110).setY(155);
		greenSlider.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), greenSlider);
		
		//Color Blue
		BlueSlider blueSlider = new BlueSlider(block);
		blueSlider.setX(215).setY(155);
		blueSlider.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), blueSlider);
		
		//Motion X
		MotionXSlider motionXSlider = new MotionXSlider(block);
		motionXSlider.setX(5).setY(180);
		motionXSlider.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), motionXSlider);
		
		//Motion Y
		MotionYSlider motionYSlider = new MotionYSlider(block);
		motionYSlider.setX(110).setY(180);
		motionYSlider.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), motionYSlider);
				
		//Motion Z
		MotionZSlider motionZSlider = new MotionZSlider(block);
		motionZSlider.setX(215).setY(180);
		motionZSlider.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), motionZSlider);
		
		//close
		CloseButton closeButton = new CloseButton();
		closeButton.setX(5).setY(205);
		closeButton.setWidth(50).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), closeButton);
		
		//spawn
		SpawnButton spawnButton = new SpawnButton(block);
		spawnButton.setX(165).setY(205);
		spawnButton.setWidth(100).setHeight(20);
		attachWidget(RadioheadLazerShow.getInstance(), spawnButton);
	}
	
}
