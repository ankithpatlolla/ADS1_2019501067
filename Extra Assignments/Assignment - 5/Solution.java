/**
 * class Solution to create an Binary search symbol table to
 * perform operations.
 * @author Ankith.
 */
public class Solution {
	/**
	 * main method to create an object for binary search symbol tree.
	 * @param args args.
	 */
	public static void main(String[] args) {
		BSST<Integer, Integer> bsst = new BSST<Integer, Integer>(4);
		bsst.put(1, 2);
		bsst.put(0, 4);
		bsst.put(3,5);
		bsst.put(3, 9);
		bsst.put(4, 10);
		bsst.put(5, 12);
		bsst.put(8, 0);
		System.out.println(bsst.toString());
	}
}