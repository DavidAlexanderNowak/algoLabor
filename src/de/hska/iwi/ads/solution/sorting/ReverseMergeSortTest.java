package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ReverseMergeSortTest {

	@Test
	void sortedArray_SHOULD_remainSorted() {
		// arrange
		Integer[] arrayToSort = { 0, 1, 2, 3, 4, 8, 12 };
		ReverseMergeSort<Integer> mergeSort = new ReverseMergeSort<>();

		// act
		mergeSort.sort(arrayToSort);

		// assert
		Integer[] expectedArray = { 0, 1, 2, 3, 4, 8, 12 };
		assertArrayEquals(expectedArray, arrayToSort);
	}

	@Test
	void unsortedArray_SHOULD_beSorted() {
		// arrange
		Integer[] arrayToSort = { 1, 3, 0, 12, 8, 4, 2 };
		ReverseMergeSort<Integer> mergeSort = new ReverseMergeSort<>();

		// act
		mergeSort.sort(arrayToSort);

		// assert
		Integer[] expected = { 0, 1, 2, 3, 4, 8, 12 };
		assertArrayEquals(expected, arrayToSort);
	}
}