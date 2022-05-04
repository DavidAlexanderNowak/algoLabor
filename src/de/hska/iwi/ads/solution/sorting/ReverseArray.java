package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

	@Override
	public void reverse(E[] a, int from, int to) {
		for (int i = from; i <= (to + from) / 2; i++) {
			E valueAtCurrentPosition = a[i];
			a[i] = a[to - (i - from)];// Current position replaced by pos but from the back
			a[to - (i - from)] = valueAtCurrentPosition;// Position from the back replaced by current position
		}
	}
}