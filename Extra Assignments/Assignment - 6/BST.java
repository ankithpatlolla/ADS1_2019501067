import java.util.*;
/**
 * class BST to create a bst. which includes put is ordered methods.
 * @param <Key> generic key.
 * @param <Value> generic value.
 */
public class BST<Key extends Comparable<Key>, Value> {
	Node root;
	/**
	 * class node to create node objects.
	 */
class Node {
	Key key; // key type key.
	Value value; //value type value.
	Node left; //Node left.
	Node right; //Node right.

	/**
	 * Node class constructor.
	 * @param key key that is to be added.
	 * @param value value that is to be added.
	 */
Node (Key key, Value value) {
	this.key = key;
	this.value = value;
}
}
    /**
	 * methid put to insert a key value pair in to bst.
	 * @param key key that is be inserted.
	 * @param value value that is to be inserted.
	 * complexity is O(N).
	 */
	public void put(Key key, Value value) {
		if (key == null) throw new IllegalArgumentException("key can't be null");
		root = put(root, key, value);
	}

	/**
	 * private method put which takes node key value as a input.
	 * @param x the node.
	 * @param key  key that is to be added.
	 * @param value value that is to be added.
	 * @return Node.
	 */
	private Node put (Node x, Key key, Value value) {
		if (x == null) return new Node(key, value);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = put(x.left, key, value);
		else if (cmp > 0) x.right = put(x.right, key, value);
		else x.value = value;
		return x;
	}

	/**
	 * method isOrdered boolean method hich checks bst is in order or not.
	 * @param x the node.
	 * @param min minimum value.
	 * @param max maximum value.
	 * @return true or false.
	 * complexity is O(N).
	 */

    public boolean isOrdered(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) < 0) return false;
        if (max != null && x.key.compareTo(max) > 0) return false;
        return isOrdered(x.left, min, x.key) && isOrdered(x.right, x.key, max);
    } 
}