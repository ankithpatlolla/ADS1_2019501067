class Node {
	int data;
	Node next;
	Node (int data) {
		this.data = data;
		this.next = null;
	}
}

class Queue {
	Node head;
	Node tail;
	int size;
	public void enqueue (int data) {
		Node node = new Node(data);
		if (tail == null) {
			tail = node;
			head = node;
			size++;
		} else {
			tail.next = node;
			tail = tail.next;
			size++;
		}
	}
	public int dequeue () {
		Node temp = head;
		head = head.next;
		return temp.data;
	}
}
class Solution{
	public static String Josephus(int a, int b){
		// fill you code Here
		Queue queue = new Queue();
		for (int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < a; i++) {
			if (i == b) {
				String s += queue.dequeue();
			}
		}
		return "";
	}
}