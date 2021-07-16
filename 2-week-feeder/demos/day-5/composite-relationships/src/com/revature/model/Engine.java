package com.revature.model;

public class Engine {

	public String engineConfiguration;
	public int cylinders;
	public int hp;
	public int torque;
	
	public Engine(String engineConfiguration, int cylinders, int hp, int torque) {
		this.engineConfiguration = engineConfiguration;
		this.cylinders = cylinders;
		this.hp = hp;
		this.torque = torque;
	}
	
}
