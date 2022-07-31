package com.aditya.rightskewedtree.service;

public class RightSkewed {

	public static Node node;
	static Node prevNode = null;
	public static Node headNode = null;

	// Function to convert into right skewed the binary
	// search tree 
	public void convertedRightSkewed(Node root, int order) {

		// Base Case
		if(root == null) {
			return;
		}

		// Condition to check the order
		// in which the skewed tree to
		// maintained
		if(order > 0) {
			convertedRightSkewed(root.right, order);
		}
		else {
			convertedRightSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// Condition to check if the root Node
		// of the skewed tree is not defined
		if(headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// recurse for the left / right
		// subtree on the basis of the order
		if (order > 0) {
			convertedRightSkewed(leftNode, order);
		}
		else {
			convertedRightSkewed(rightNode, order);
		}
	}

	// Function to traverse the right
	// skewed tree using recursion
	public void traverseRightSkewed(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.key + " ");
		traverseRightSkewed(root.right);	
	}
}
