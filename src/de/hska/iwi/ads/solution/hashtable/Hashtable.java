package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

	public Hashtable(int capacity) {
		super(capacity);
	}

	@Override
	public V get(Object o) {

		int i = 0;
		do {
			Entry<K, V> entry = hashtable[getIndex((K) o, i)];
			if (entry != null && entry.getKey() == (K) o) {
				return entry.getValue();
			}
		} while (hashtable[i] != null && i < hashtable.length);
		return null;
	}

	@Override
	public V put(K key, V value) {
		int i = 0;
		do {
			Entry<K, V> entry = hashtable[getIndex((K) key, i)];
			if (entry == null) {
				hashtable[getIndex((K) key, i)] = createNewEntry(key, value);
				return null;
			} else if (entry.getKey() == key) {
				return replaceExistingEntryValue(entry, value);
			}
		} while (i < hashtable.length);
		throw new DictionaryFullException();
	}
	
	private Entry<K,V> createNewEntry(K key, V value) {
		Entry<K,V> entry= new SimpleEntry<>(key, value);
		size++;
		return entry;
	}
	
	/**
	 * 
	 * @param entry
	 * @param value
	 * @return the value previously stored in the entry
	 */
	private V replaceExistingEntryValue(Entry<K,V> entry, V value) {
		V oldValue = entry.getValue();
		entry.setValue(value);
		return oldValue;
	}

	private int getIndex(K key, int i) {
		return (key.hashCode() + i * i) % hashtable.length;
	}

	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}
}