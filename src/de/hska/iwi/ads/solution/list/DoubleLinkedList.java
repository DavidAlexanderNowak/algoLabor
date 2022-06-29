package de.hska.iwi.ads.solution.list;

import java.util.Objects;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {

	@Override
	public V get(Object o) {
		AbstractDoubleLinkedList<K, V>.ListElement listElement = searchElement((K) o);
		if (listElement != null) {
			return listElement.entry.getValue();
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		AbstractDoubleLinkedList<K, V>.ListElement oldElement = searchElement(key);

		if (oldElement != null) {
			return replaceExistingElementValue(oldElement, value);
		} else {
			addNewElement(new ListElement(new SimpleEntry<>(key, value), null, head));
		}
		return null;
	}
	
	/**
	 * @param element
	 * @param value
	 * @return the value previously stored in the element
	 */
	private V replaceExistingElementValue(ListElement element, V value) {
		V oldValue = element.entry.getValue();
		element.entry.setValue(value);
		return oldValue;
	}
	
	private void addNewElement(ListElement element) {
		if (head != null) {
			head.previous = element;
		}
		head = element;
		size++;
	}

	private AbstractDoubleLinkedList<K, V>.ListElement searchElement(K key) {
		Objects.requireNonNull(key);

		ListElement element = head;
		while (element != null) {
			if (element.entry.getKey() == key) {
				return element;
			}
			element = element.next;
		}
		return null;
	}

	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}
}
