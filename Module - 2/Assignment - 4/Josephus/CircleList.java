/**
 * class CircleList 
 * @author Ankith.
 */
class CircleList {
    Node head;
    Node tail;
    /**
     * enqueue method to insert an element into queue.
     * @param data data that is to be added to queue.
     * complexity is O(N).
     */
    public void enqueue(int data) {
        Node node = new Node(data);
        
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        }
        else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    /**
     * linkedcircle method to make linked list as circular list.
     */
    public void linkCircle() {
        tail.next = head;
        head.prev = tail;
    }
}