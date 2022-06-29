package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

	@Override
	public V get(Object o) {
		final AbstractBinaryTree<K, V>.Node node = binaryTreeSearch(root, (K) o);
		if (node != null) {
			return node.entry.getValue();
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		Node parentNode = null;
		Node newNode = new Node(key, value);
		Node current = root;

		while (current != null) {
			if (newNode.entry.getKey() == current.entry.getKey()) {
				return replaceExistingNodeValue(current, newNode.entry.getValue());
			}
			
			parentNode = current;
			current = nextPossibleInsertion(current, newNode);
		}

		return addNewNode(parentNode, newNode);
	}
	
	private V addNewNode(Node parentNode, Node newNode) {
		if (parentNode == null) {
			root = newNode;
		} else if (newNode.entry.getKey().compareTo(parentNode.entry.getKey()) < 0) {
			parentNode.left = newNode;
		} else {
			parentNode.right = newNode;
		}
		size++;
		return null;
	}
	
	private V replaceExistingNodeValue(Node node, V value) {
		V oldValue = node.entry.getValue();
		node.entry.setValue(value);
		return oldValue;
	}
	
	private Node nextPossibleInsertion(Node current, Node newNode) {
		if (newNode.entry.getKey().compareTo(current.entry.getKey()) < 0) {
			return current.left;
		} else {
			return current.right;
		}
	}

	private Node binaryTreeSearch(Node node, K key) {
		if (node == null || node.entry.getKey() == key) {
			return node;
		}
		if (key.compareTo(node.entry.getKey()) < 0) {
			return binaryTreeSearch(node.left, key);
		}
		return binaryTreeSearch(node.right, key);
	}

	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}

}
