package com.pankaj.algorithm;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set set1 = new HashSet<>();
		set1.add("pankaj");
		set1.add("kumar");
		set1.add("prajapati");

		Set set2 = new LinkedHashSet<>();
		set2.add("pankaj");
		set2.add("prajapati");
		set2.add("kumar");
		System.out.println(set1.hashCode());
		System.out.println(set2.hashCode());
		System.out.println(set1.equals(set2));
	}
}
