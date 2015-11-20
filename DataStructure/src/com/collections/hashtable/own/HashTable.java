package com.collections.hashtable.own;

public class HashTable {

	private ListNode[] table;
	private int bucketSize;
	private int count;

	private static class ListNode {
		String key;
		String value;
		ListNode next;
	}

	public HashTable(int bucketSize) {
		this.bucketSize = bucketSize;
		this.table = new ListNode[bucketSize];
	}

	public void put(String key, String value) {

		int hashIndex = getBucket(key);

		ListNode bucket = table[hashIndex];

		//if key matches then go out of loop and update value
		while (bucket != null) {
			if (bucket.key.equals(key))
				break;

			bucket = bucket.next;
		}

		//if key matched then bucket cannot be null so update value
		if (bucket != null) {
			bucket.value = value;
		} else {
			//else add new element at front
			ListNode newEntry = new ListNode();
			newEntry.key = key;
			newEntry.value = value;
			//new entry points to current linked list of bucket
			newEntry.next = table[hashIndex];
			//now first element point to linked list with added element
			table[hashIndex] = newEntry;
		}

	}

	public String getValue(String key) {
		int hashIndex = getBucket(key);

		ListNode list = table[hashIndex];

		while (list != null) {
			//if key then return value otherwise traverse to next
			if (list.key.equals(key)) {
				return list.value;
			} else {
				list = list.next;
			}
		}

		return null;
	}

	public void remove(String key) {
		
		//get bucket
		int hashIndex = getBucket(key);

		ListNode list = table[hashIndex];

		//if first element's key matches
		if (list.key.equals(key)) {
			ListNode next = list.next;
			table[hashIndex] = next;
			return;
		}

		//if first elemnet does not match then
		//track previous elements so it can used 
		//to point next element of element where key is matched.
		ListNode prev = table[hashIndex];
		//start from second element
		ListNode current = prev.next;
		while (current != null) {
			
			//if there is match then point previous's next to current's next
			if (current.key.equals(key)) {
				prev.next = current.next;
				count--;
				return;
			}
			//till match is found keep previous and current updated
			prev = current;
			current = current.next;

		}

	}

	private int getBucket(String key) {
		// int hashIndex = Math.abs(key.hashCode() % this.bucketSize);
		int hashIndex = Math.abs(key.length() % this.bucketSize); //simple hash function for simplicity
		// System.out.println(" hashIndex : " + hashIndex);
		return hashIndex;
	}

	public void print() {
		
		//Loop though buckets
		for (int i = 0; i < this.table.length; i++) {
			if (table[i] != null) {
				System.out.println();
				ListNode listNode = table[i];

				//Loop through elements whithin buckets
				while (listNode != null) {
					System.out.print(i + " (" + listNode.key + " : " + listNode.value + ") ");
					listNode = listNode.next;
				}
			}

		}

	}

	public static void main(String... args) {

		HashTable hashTable = new HashTable(10);

		hashTable.put("Ronak", "Chaudhari");
		hashTable.put("Ronak", "Patel");
		hashTable.put("Ronak", "Shah");
		hashTable.put("Ronaw", "Chaudhari");
		hashTable.put("Rachana", "Chaudhari");
		hashTable.put("Vandana", "Chaudhari");
		hashTable.put("Vandanw", "Chaudhari");
		hashTable.put("Meenaben", "Chaudhari");
		System.out.println();
		hashTable.print();
		hashTable.remove("Ronaw");
		System.out.println();
		hashTable.print();
		hashTable.remove("Vandana");
		System.out.println();
		hashTable.print();
	}

}
