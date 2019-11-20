/**
 * class Solution to check my bst is ordered or not.
 * @author Ankith.
 */
public class Solution {
	/**
	 * main method to perform operations on bst.
	 * @param args args.
	 */
	public static void main(String[] args) {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put (2, 5);
		bst.put(1, 6);
		bst.put(20, 2);
		bst.put(10, 4);
		System.out.println(bst.root.key);
		System.out.println(bst.root.value);
		System.out.println(bst.isOrdered(bst.root, 1, 20));
		System.out.println(bst.isOrdered(bst.root, 2, 20));
		}
	}
