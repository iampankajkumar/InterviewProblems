package com.pankaj.problems;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {

	public static void main(String[] args) throws InterruptedException {

		final PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

}

class PC {

	private List<Integer> sharedResource = new ArrayList<>();
	private static final int MAX_CAPACITY = 5;

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (sharedResource) {
				// wait until list is full
				while (sharedResource.size() == MAX_CAPACITY) {
					System.out.println("Producer waiting for consume..............");
					sharedResource.wait();
				}

				// Produces one job and adds to list
				System.out.println("Producer produced :- " + value);
				sharedResource.add(value++);
				sharedResource.notify();
				Thread.sleep(1000);
			}

		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (sharedResource) {
				// wait until list is empty
				while (sharedResource.isEmpty()) {
					System.out.println("Consumer waiting for produce..............");
					sharedResource.wait();
				}
				// Consumes one job
				System.out.println("Consumer consumed :- " + sharedResource.remove(0));
				sharedResource.notify();
				Thread.sleep(1000);
			}
		}
	}

}
