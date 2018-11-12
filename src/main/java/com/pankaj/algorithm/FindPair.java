package com.pankaj.algorithm;

import java.util.HashMap;
import java.util.Map;

class FindPair {
	// Naive method to find a pair in an array with given sum
	public static void findPair(int[] A, int sum) {
		// create an empty Hash Map
		Map<Integer, Integer> map = new HashMap<>();
		int counter = 0;
		// do for each element
		for (int i = 0; i < A.length; i++) {
			// check if pair (arr[i], sum-arr[i]) exists

			// if difference is seen before, print the pair
			if (map.containsKey(sum - A[i])) {
				System.out.println("Pair found at index " + map.get(sum - A[i]) + " and " + i);
				counter++;
			}

			// store index of current element in the map
			map.put(A[i], i);
		}
		if (counter == 0)
			System.out.println("No pair found !!");
	}

	// Find pair with given sum in the array
	public static void main(String[] args) {
		int[] A = { 8, 7, 2, 5, 3, 1 };
		int sum = 50;
		findPair(A, sum);
	}
}