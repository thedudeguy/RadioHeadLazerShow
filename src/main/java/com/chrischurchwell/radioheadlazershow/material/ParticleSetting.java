package com.chrischurchwell.radioheadlazershow.material;

import org.getspout.spoutapi.particle.Particle.ParticleType;

public class ParticleSetting {
	
	private int amount = 1;
	private int age = 20;
	private float gravity = 0.0F;
	private float scale = 1.0F;
	private float red = 0.0F;
	private float green = 0.0F;
	private float blue = 0.0F;
	private double motionX = 0.0F;
	private double motionY = 0.0F;
	private double motionZ = 0.0F;
	private double range = 100d;
	private ParticleType type = ParticleType.SMOKE;
	
	private int rotationX = 200;
	private int rotationY = 0;
	private int rotationZ = 0;
	
	private boolean useIntensity = false;
	
	private long updateInterval = 5L;
	
	private double heightAdjustment = 30d;
	
	private int quality = 3;
	
	private double scaleDown = 10;
	
	public ParticleType getType() {
		return type;
	}
	public void setType(ParticleType type) {
		this.type = type;
	}
	public double getMotionX() {
		return motionX;
	}
	public void setMotionX(double motionX) {
		this.motionX = motionX;
	}
	public double getMotionY() {
		return motionY;
	}
	public void setMotionY(double motionY) {
		this.motionY = motionY;
	}
	public double getMotionZ() {
		return motionZ;
	}
	public void setMotionZ(double motionZ) {
		this.motionZ = motionZ;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getGravity() {
		return gravity;
	}
	public void setGravity(float gravity) {
		this.gravity = gravity;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getScale() {
		return scale;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	public float getRed() {
		return red;
	}
	public void setRed(float red) {
		this.red = red;
	}
	public float getGreen() {
		return green;
	}
	public void setGreen(float green) {
		this.green = green;
	}
	public float getBlue() {
		return blue;
	}
	public void setBlue(float blue) {
		this.blue = blue;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public long getUpdateInterval() {
		return updateInterval;
	}
	public void setUpdateInterval(long updateInterval) {
		this.updateInterval = updateInterval;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getRotationX() {
		return rotationX;
	}
	public void setRotationX(int rotationX) {
		this.rotationX = rotationX;
	}
	public double getHeightAdjustment() {
		return heightAdjustment;
	}
	public void setHeightAdjustment(double heightAdjustment) {
		this.heightAdjustment = heightAdjustment;
	}
	public double getScaleDown() {
		return scaleDown;
	}
	public void setScaleDown(double scaleDown) {
		this.scaleDown = scaleDown;
	}
	
}