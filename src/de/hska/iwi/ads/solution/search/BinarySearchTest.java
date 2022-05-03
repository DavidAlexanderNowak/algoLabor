package de.hska.iwi.ads.solution.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;

public class BinarySearchTest extends SearchTest {

	@Override
	public <E extends Comparable<E>> Search<E> createSearch() {
		return new BinarySearch<E>();
	}

//	@Test
//	void keyToTheLeftOfArray_SHOULD_returnSpecifiedValue() {
//		Search<Integer> search = createSearch();
//		Integer[] a = { 2, 4, 7, 8, 9, 10, 11 };
//
//		assertEquals(-1, search.search(a, 1));
//	}
}
