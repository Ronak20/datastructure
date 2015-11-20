package com.collections.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePractice {

	static class PQsort implements Comparator<Integer> {

		public int compare(Integer one, Integer two) {
			return one.compareTo(two);
		}
	}

	public static void main(String[] args) {
		int[] ia = { 1, 10, 5, 3, 4, 8, 6,7 ,2};

		PQsort pqs = new PQsort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);
		// In this particular case, we can simply use Collections.reverseOrder()
		// instead of self-defined comparator
		for (int x : ia) {
			pq2.offer(x);

			System.out.println("pq2: " + pq2);
		}
		// return highest priority element and removes it from the queue
		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

		System.out.println("poll: " + pq2.poll());

	}
}