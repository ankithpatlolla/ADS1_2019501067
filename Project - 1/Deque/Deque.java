import java.util.NoSuchElementException;
import java.util.Iterator;
public class Deque<Item> implements Iterable<Item>{
	private Node<Item> head;
	private Node<Item> tail;
	private int size;

	class Node<Item> {
	Item item;
	Node<Item> next;
	Node<Item> previous;

	Node(Item item) {
		this.item = item;
	}
}

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
		if (item == null) throw new IllegalArgumentException("empty deque");
		Node<Item> node = new Node<Item>(item);
		if (isEmpty()) {
			head = node;
			tail = head;
			size++;
			return;
		}
		Node<Item> temp = head;
		head = node;
		head.next = temp;
		size++;
	}

	public void addLast(Item item) {
		if (item == null) throw new IllegalArgumentException("empty deque");
		Node<Item> node = new Node<Item>(item);
		if (isEmpty()) {
			tail = node;
			head = tail;
			size++;
			return;
		}
		Node<Item> temp = tail;
		tail = node;
		tail.previous = temp;
		size++;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("empty deque");
		} else if (size == 1) {
			Node<Item> temp = head;
			head = null;
			size--;
			return temp.item;
		} else {
			Node<Item> temp = head;
			head = head.next;
			size--;
			return temp.item;
		}
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("empty deque");
	} else if (size == 1) {
		Node<Item> temp = tail;
		tail = null;
		size--;
		return temp.item;
	} else {
		Node<Item> temp = tail;
		tail = tail.previous;
		size--;
		return temp.item;
	}
}

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (current == null) throw new NoSuchElementException();
            Item value = current.item;
            current = current.next;
            return value;
        }
    }
	
	public static void main(String[] args) {
		// Deque<Integer> d = new Deque<Integer>();
		// d.addFirst(2);
		// d.addLast(4);
		// d.addFirst(3);
		// d.addLast(8);
		// System.out.println(d.removeFirst());
		// System.out.println(d.removeLast());
	}
}