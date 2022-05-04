package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class MergeSort<E extends Comparable<E>> extends AbstractMergesort<E> {

	@Override
	protected void mergesort(E[] a, int left, int right) {
		if (left < right) {
			int midIndex = (left + right) / 2;
			mergesort(a, left, midIndex);
			mergesort(a, midIndex + 1, right);
			merge(a, left, midIndex, right);
		}
	}

	private void merge(E[] a, int left, int midIndex, int right) {
		int l = left;
		int r = midIndex + 1;
		for (int i = left; i <= right; i++) {
			if (r > right || (l <= midIndex && a[l].compareTo(a[r]) <= 0)) {
				b[i] = a[l];
				l++;
			} else {
				b[i] = a[r];
				r++;
			}
		}

		for (int i = left; i <= right; i++) {
			a[i] = b[i];
		}
	}
}