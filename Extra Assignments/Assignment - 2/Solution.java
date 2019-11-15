/**
 *class node to create a node. to create a circular queue.
 *@author Ankith.
*/
class Node {
	/**
	 *@param val the value that is to be add in node.
	 *@param next empty node.
	*/
	int val;
	Node next;
	
	/**
	 * constructor for node class.
	 *@param val the value that is to be add in a node.
	*/
	Node (int val) {
		this.val = val;
	}
}/**
 *Queue class to create a queue and perform enqueue and dequeue operations.
*/
class Queue {

	/**
	 * @param last an empty node.
	 * @param size size of a queue.
	 */
	Node last;
	int size;

	/**
	 * method enqueue to insert an given value to queue at end.
	 * @param val the value that is to be added to queue.
	 * complexity is constant.
	 */
	public void enqueue (int val) {
		if (last == null) {
			last = new Node(val);
			last.next = last;
			size++;
			return;
		}
		Node temp = last;
		last = new Node(val);
		last.next = temp.next;
		temp.next = last;
		size++;
	}

	/**
	 * method dequeue to delete an element from front side.
	 * @return value of first node.
	 * complexity is constant.
	 */
	public int dequeue () {
		if (isEmpty()) {
			return -1;
		}

		else if (size == 1) {
			Node temp = last;
			last = null;
			size--;
			return temp.val;
		}

		Node temp = last.next;
		last.next = last.next.next;
		size--;
		return temp.val;
	}

	/**
	 * methtod isEmpty to check whether the queue is empty or not.
	 * @return boolean true if queue is empty else false.
	 * complexity is constant.
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
}

/**
 * class solution to perform opearations on queue.
 */
public class Solution {
	/**
	 * main method. my program execution will start from here.
	 * we create an object for queue class and perform enqueue, dequeue operations.
	 * @param args args.
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(3);
		q.enqueue(8);
		q.enqueue(9);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(22);
		q.enqueue(2);
		q.enqueue(7);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}

