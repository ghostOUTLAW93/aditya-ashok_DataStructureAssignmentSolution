package com.aditya.skyscrapper.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class ChiefArchitect {

	public Integer totalFloors;
	public Integer[] floorSize;
	private Scanner sc;

	public void userInputs() {
		System.out.println("Enter total no of floors in building:");
		sc = new Scanner(System.in);
		totalFloors = sc.nextInt();
		floorSize = new Integer[totalFloors];

		for(int i = 1; i <= totalFloors; i++) {
			System.out.println("Enter the floor size given on day: " + i);
			floorSize[i - 1] = sc.nextInt();
		}
	}

	public void orderOfConstruction(Integer[] floorSize) {
		System.out.println("\nThe order of construction is as follows:");

		int j = 0;
		Integer[] totalFloorSizeSorted = floorSize.clone();
		Arrays.sort(totalFloorSizeSorted,Collections.reverseOrder());

		Stack<Integer> buildingStack = new Stack<Integer>();

		for(int i = 0; i < floorSize.length; i++) {

			if(floorSize[i] >= totalFloorSizeSorted[j]) {
				if(i == floorSize.length - 1)
					j = i;
				else
					j = i + 1;

				System.out.println("\nDay: " + (i + 1));

				if(buildingStack != null) {
					int  temp = floorSize[i];
					System.out.print(temp + " ");

					while(!buildingStack.isEmpty()) {
						int val = buildingStack.pop();

						if(val >= totalFloorSizeSorted[j]) {// DIFFERENCE 1

							if(temp-val == 1) {
								System.out.print(val + " ");
								temp--;
							}
							else {
								buildingStack.push(val);
								break;
							}
						}

						else {
							buildingStack.push(val);
							j -= buildingStack.size();//+1
							break;
						}
					}
					System.out.println();
				}

				else {
					System.out.println(floorSize[i]);
				}
			}
			
			else {
				System.out.println("\nDay: " + (i+1));
				buildingStack.push(floorSize[i]);
			}
		}
	}
}
