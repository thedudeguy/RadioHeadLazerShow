package com.chrischurchwell.radioheadlazershow.cloud;

public class Point {

	private float x;
	private float y;
	private float z;
	private int intensity;
	
	public Point(float x, float y, float z, int intensity) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.setIntensity(intensity);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
}
