/**
 * @author Ankith.
 * Node class to create nodes of circular linked list.
 * Cpomplexity is O(1).
 */
class Node {
    Node next;
    Node prev;
    int data;
    /**
     * constructor.
     * @param data  data that is to be added at node.
     */
    Node(int data) {
        this.data = data;
    }
}