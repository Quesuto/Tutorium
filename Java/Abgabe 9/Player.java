package info1Classes;

import info1Classes.Physics;

public class Player {
	
	private String name;
	private float[] points;
	public float mass;
	
	public String getName() {
		return name;
	}
	
	public void setName(String inName) {
		name = inName;
	}
	
	public float[] getPoints() {
		return points;
	}
	
	public void setPoints(float[] inPoints) {
		points = inPoints;
	}
	
	public Player() {
		name = "Default";
		points = new float[0];
		mass = 80;
	};
	
	public Player(String inName, float[] inPoints, int inMass) {
		name = inName;
		points = inPoints;
		mass = inMass;
	};
	
	public Player(Player inPlayer) {
		name = inPlayer.getName();
		points = inPlayer.getPoints();
		mass = inPlayer.mass;
	};
	
	public void showPoints() {
		int length = points.length;
		if (length == 0) {
			System.out.println("Bisher keine Spiele gespielt");
		}
		for (int i = 0; i < length; i++) {
			System.out.println(points[i]);
		}
	}
	
	public float massDiff(Player secondPlayer) {
		return Math.abs(secondPlayer.mass - mass);
	}
	
	public float[] pointDiff(Player secondPlayer) {
		int length = Math.min(points.length, secondPlayer.getPoints().length);
		float[] differences = new float[length];
		
		if (length == 0) return differences;
		
		for (int i = 0; i < length; i++) {
			differences[i] = Math.abs(points[i] - secondPlayer.getPoints()[i]);
		}
		return differences;
	}
	
	private float getWeight() {
		return mass * Physics.getGravity();
	}
}
