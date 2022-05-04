package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ReverseArrayTest {

	@Test
	void reversingWholeArray_SHOULD_reverseWholeArray() {
		// arrange
		Integer[] arrayToReverse = { 1, 3, 0, 12, 8, 4, 2 };
		ReverseArray<Integer> reverseArray = new ReverseArray<>();

		// act
		reverseArray.reverse(arrayToReverse, 0, arrayToReverse.length - 1);

		// assert
		Integer[] expectedArray = { 2, 4, 8, 12, 0, 3, 1 };
		assertArrayEquals(expectedArray, arrayToReverse);
	}

	@Test
	void reversingSmallArray_SHOULD_reverseSmallArray() {
		// arrange
		Integer[] arrayToReverse = { 1, 7 };
		ReverseArray<Integer> reverseArray = new ReverseArray<>();

		// act
		reverseArray.reverse(arrayToReverse, 0, arrayToReverse.length - 1);

		// assert
		Integer[] expectedArray = { 7, 1 };
		assertArrayEquals(expectedArray, arrayToReverse);
	}

	@Test
	void reversingPartOfArray_SHOULD_reversePartOfArray() {
		// arrange
		Integer[] arrayToReverse = { 1, 3, 0, 12, 8, 4, 2 };
		ReverseArray<Integer> reverseArray = new ReverseArray<>();

		// act
		reverseArray.reverse(arrayToReverse, 1, 5);

		// assert
		Integer[] expectedArray = { 1, 4, 8, 12, 0, 3, 2 };
		assertArrayEquals(expectedArray, arrayToReverse);
	}
}