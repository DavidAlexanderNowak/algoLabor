package de.hska.iwi.ads.solution.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardboxTest {

	@Test
	void testCompare() {
		// arrange
		Cardbox c1 = new Cardbox<>(2, "Content");
		Cardbox c2 = new Cardbox<>(1, 4.24);

		// assert
		assertTrue(c1.compareTo(c2) >= 1);

	}

}
