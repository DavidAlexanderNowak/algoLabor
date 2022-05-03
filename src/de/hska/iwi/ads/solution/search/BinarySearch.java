package de.hska.iwi.ads.solution.search;

import java.util.Arrays;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

//	@Override
//	public int search(E[] array, E key, int left, int right) {
//
//		
//		
//		// The key is not in array
//		if (left > right) {
//			return right + 1;
//		}
//		if (right < left) {
//			return left - 1;
//		}
//
//		// The key is not in array
////		if (left > right) {
////			// Case 1. key < array[left]
////			if (key.compareTo(array[left]) <= -1) {
////				return left - 1;
////			}
////
////			// Case 2. key > array[right]
////			if (key.compareTo(array[right]) >= 1) {
////				return right + 1;
////			}
////
////			// Case 3. array[left] <= key <= array[right]
////			if (key.compareTo(array[left]) > -1 && key.compareTo(array[right]) < 1) {
////				// TODO
////				return Integer.MAX_VALUE / 2;
////			}
////		}
//		// It is not not in the array?
//
//		int mid = (left + right) / 2;
//
//		// Mid is the searched key
//		if (key.compareTo(array[mid]) == 0) {
//			return mid;
//		}
//
//		// The Searched key lies to the left
//		if (key.compareTo(array[mid]) <= -1) {
//			return search(array, key, left, mid - 1);
//		}
//
//		// The searched key lies to the right
//		if (key.compareTo(array[mid]) >= 1) {
//			return search(array, key, mid + 1, right);
//		}
//
//		// If none of the above match, this is used as an error
//		return Integer.MAX_VALUE / 4;
//	}



		@Override
		public int search(E[] a, E key, int left, int right) {
			if (a[left].compareTo(key) > 0) {
				return left - 1;
			}

			if (a[right].compareTo(key) < 0) {
				return right + 1;
			}

			return simpleSearch(a, key, left, right);
		}

		private int simpleSearch(E[] a, E key, int left, int right) {
			if (right < left) {
				return left;
			}
			int midIndex = (left + right) / 2;
			E midValue = a[midIndex];

			if (midValue.compareTo(key) == 0) {
				if (midIndex - 1 >= 0 && a[midIndex - 1].compareTo(key) == 0) {
					return simpleSearch(a, key, left, midIndex - 1);
				}
				return midIndex;
			} else if (midValue.compareTo(key) < 0) { // midValue is less than key
				return simpleSearch(a, key, midIndex + 1, right);
			} else { // midValue is greater than key
				return simpleSearch(a, key, left, midIndex - 1);
			}
		}
	
}
