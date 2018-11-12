package com.pankaj.multithreading;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerProblem {

	public static void main(String[] args) throws InterruptedException {

		List<Integer> sharedList = new LinkedList<>();
		Thread t1 = new Thread(new Proudcer(sharedList));
		Thread t2 = new Thread(new Consumer(sharedList));
		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}

class Proudcer implements Runnable {

	private List<Integer> sharedList;
	private static final int MAX_SIZE = 5;
	int value = 0;

	public Proudcer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while (true) {
			try {
				produce(value++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void produce(int i) throws InterruptedException {
		synchronized (sharedList) {
			while (sharedList.size() == 5) {
				System.out.println("Producer waiting for consume..............");
				sharedList.wait();
			}
		}
		synchronized (sharedList) {
			System.out.println("Producer produced : " + value);
			sharedList.add(value);
			Thread.sleep(500);
			sharedList.notify();
		}
	}
}

class Consumer implements Runnable {

	private List<Integer> sharedList;

	public Consumer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		try {
			{
				while (true) {
					consume();
				}
			}
		} catch (InterruptedException e) {
		}

	}

	public void consume() throws InterruptedException {
		synchronized (sharedList) {
			while (sharedList.isEmpty()) {
				System.out.println("Consumer waiting for produce..............");
				sharedList.wait();
			}
		}
		synchronized (sharedList) {
			System.out.println("Consumer consumed : " + sharedList.remove(0));
			Thread.sleep(500);
			sharedList.notify();
		}
	}
}
