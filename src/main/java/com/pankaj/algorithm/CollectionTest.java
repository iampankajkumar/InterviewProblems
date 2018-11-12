package com.pankaj.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		List<Integer> newList = new ArrayList<>();
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		newList.add(5);
		newList.add(6);
		list.addAll(newList);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
			System.out.println(list.size());
		}
	}
}
