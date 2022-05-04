package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

	@Test
	void sortedArray_SHOULD_remainSorted() {
		// arrange
		Integer[] sortedArrayToTest = { 0, 1, 2, 3, 4, 8, 12 };
		MergeSort<Integer> mergeSort = new MergeSort<>();

		// act
		mergeSort.sort(sortedArrayToTest);

		// assert
		Integer[] expectedArray = { 0, 1, 2, 3, 4, 8, 12 };
		assertArrayEquals(expectedArray, sortedArrayToTest);
	}

	@Test
	void unsortedArray_SHOULD_beSorted() {
		// arrange
		Integer[] arrayToSort = { 1, 3, 0, 12, 8, 4, 2 };
		MergeSort<Integer> mergeSort = new MergeSort<>();

		// act
		mergeSort.sort(arrayToSort);

		// assert
		Integer[] expectedSortedArray = { 0, 1, 2, 3, 4, 8, 12 };
		assertArrayEquals(expectedSortedArray, arrayToSort);
	}
}