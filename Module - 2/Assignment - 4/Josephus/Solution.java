/**
 * class solution. main class.
 * @author Ankith.
 */
class Solution{
	/**
	 * method Josephus.
	 * @param a,b the prameters for the methods.
	 * @return string with all the popped items. 
	 * complexity is O(N).
	 */
	public static String Josephus(int a, int b){
		
		CircleList queue = new CircleList();

		for (int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		queue.linkCircle();
		int pos = 1;
		int poppedItems = 0;
		String res = "";
		Node temp = queue.head;
		while (poppedItems != a) {
			temp = temp.next;
			pos++;

			if(pos == b) {
				pos = 1;
				res += temp.data + " "; 
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;

				poppedItems++;
				temp = temp.next;
			}
		}
		return res.trim();
		// return res;
	}
}