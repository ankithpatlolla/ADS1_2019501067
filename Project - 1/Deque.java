class Node<Item> {
	Item item;
	Node<Item> next;
	Node<Item> previous;

	Node(Item item) {
		this.item = item;
	}
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
		if (isEmpty()) {
			head = node;
			tail = head;
			size++;
			return;
		}
		Node temp = head;
		head = node;
		head.next = temp;
		size++;
	}

	public void addLast(Item item) {
		Node node = new Node(item);
		if (isEmpty()) {
			tail = node;
			head = tail;
			size++;
			return;
		}
		Node temp = tail;
		tail = node;
		tail.previous = temp;
		size++;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			Node temp = head;
			head = null;
			size--;
			return temp;
		} else {
			Node temp = head;
			head = head.next;
			size--;
			return temp;
		}
	}

	public Item removeLast() {
		if (isEmpty()) {
			return null;
	} else if (size == 1) {
		Node temp = tail;
		tail = null;
		size--;
		return temp;
	} else {
		Node temp = tail;
		tail = tail.previous;
		size--;
		return temp;
	}

	 public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}