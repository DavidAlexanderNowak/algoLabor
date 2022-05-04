package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

	@Override
	public int search(E[] a, E key, int left, int right) {
		// Key is to the left of the array
		if (a[left].compareTo(key) > 0) {
			return left - 1;
		}

		// Key is to the right of the array
		if (a[right].compareTo(key) < 0) {
			return right + 1;
		}

		return actualSearch(a, key, left, right);
	}

	private int actualSearch(E[] a, E key, int left, int right) {
		// Ending condition
		if (right < left) {
			return left;
		}

		// Calculate new mid
		int midIndex = (left + right) / 2;
		E midValue = a[midIndex];

		// Middle value is equal to the key
		if (midValue.compareTo(key) == 0) {

			// Mid is not at the left end of the array yet
			// AND
			// The value to the left of the mid is equal to the mid
			// (to get the leftmost value)
			if (midIndex - 1 >= 0 && a[midIndex - 1].compareTo(key) == 0) {
				return actualSearch(a, key, left, midIndex - 1);
			}
			return midIndex;
		}
		// Middle value is less than key (search the right part of the array)
		else if (midValue.compareTo(key) < 0) {
			return actualSearch(a, key, midIndex + 1, right);
		}
		// Middle value is greater than key (search the left part of the array)
		else {
			return actualSearch(a, key, left, midIndex - 1);
		}
	}

}
