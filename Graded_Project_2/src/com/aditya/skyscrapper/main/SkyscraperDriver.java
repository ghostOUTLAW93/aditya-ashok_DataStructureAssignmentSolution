package com.aditya.skyscrapper.main;

import com.aditya.skyscrapper.service.ChiefArchitect;

public class SkyscraperDriver {

	public static int totalFloors;
	public static int[] floorSize;

	public static void main(String[] args) {

		ChiefArchitect ca = new ChiefArchitect();

		ca.userInputs();
		ca.orderOfConstruction(ca.floorSize);
	}

}
