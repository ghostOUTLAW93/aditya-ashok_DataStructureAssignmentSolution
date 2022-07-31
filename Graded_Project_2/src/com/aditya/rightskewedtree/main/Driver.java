package com.aditya.rightskewedtree.main;

import com.aditya.rightskewedtree.service.Node;
import com.aditya.rightskewedtree.service.RightSkewed;

public class Driver {
	
	public static void main (String[] args) {
		
		RightSkewed tree = new RightSkewed();
		
		RightSkewed.node = new Node(50);
		RightSkewed.node.left = new Node(30);
		RightSkewed.node.right = new Node(60);
		RightSkewed.node.left.left = new Node(10);
		RightSkewed.node.right.left = new Node(55);

		// Order of the Skewed tree can
		// be defined as follows -
		// For Increasing order - 0
		// For Decreasing order - 1
		int order = 0;
		tree.convertedRightSkewed(RightSkewed.node, order);
		tree.traverseRightSkewed(RightSkewed.headNode);
	}
}


