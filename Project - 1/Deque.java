class Node<Item> {
	Item item;
	Node<Item> next;
}
public class Deque<Item> implements Iterable<Item>{
	Node head;
	Node tail;
	int size;

	public Deque() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		Node node = new Node(item);
		if (head == null) {
			head = node;
			tail = head;
			size++;
			return;
		}
		Node temp = head;
		head = node;
		head.next = temp;
	}
}