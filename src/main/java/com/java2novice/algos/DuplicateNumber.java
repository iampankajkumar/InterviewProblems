package com.java2novice.algos;

public class DuplicateNumber {

	public static void findDuplicateNumber(Integer[] numbers) {
		while (true) {
			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = i + 1; j < numbers.length - 1; j++) {
					if (numbers[i] == numbers[j] && i != j) {
						System.out.println("Elemnt " + numbers[i] + " is duplicate");
						continue;
					}
				}
			}
			break;
		}
	}

	public static void main(String a[]) {
		Integer[] list = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 7, 9, 6, 4, 8, 2, };
		findDuplicateNumber(list);
	}
}