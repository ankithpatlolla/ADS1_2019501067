import java.util.*;
/**
 * class sequentialsearchSt to create a symbol table.
 * @param <Key> the generic type keys.
 * @param <Value> generic type values.
 * reference algs4.
 * @author Ankith.
 */
class SequentialSearchST<Key , Value> {
    /**
     * @param n,first size and node.
     */
    int n;
    Node First;
    /**
     * class node to create linkedlist.
     */
    class Node {
        /**
         * @param key key type key.
         * @param val value type value.
         * @param next the next node.
         */
        Key key;
        Value val;
        Node next;

        /**
         * parametric constructor for node class.
         * @param key the key.
         * @param val the value.
         * @param next next node.
         */
        Node (Key key,Value val,Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    /**
    * size method to get soize of table.
    * @return the size.
    *constant complexity.
    */
    public int size() {
        return n;
    }

    /**
     * contains method to check whether the table containing tnhat key or not.
     * @param key the key that is to be check.
     * @return key if not null.
     * complexity is constant.
     */
    public boolean contains(Key key) {
        if(get(key) != null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * get method to obtain the value of the key that is passsed.
     * @param key that key that is to be search.
     * @return value of that key.
     * complexity is N.
     */
    public Value get(Key key) {
        for (Node x = First; x != null; x = x.next) {
            if (key.equals(x.key)) {

                moveToFront(x, key);
                
                return x.val;
            }
        }
        return null;
    }

    /**
     * movetofront method to move the key value pair to front.
     * @param node the node which is to be arrange at front
     * @param key the key of the node.
     * compllexity is N.
     */
    public void moveToFront(Node node, Key key) {
        Node tmp = First;
        while (tmp.next!= null && !tmp.next.key.equals(key)) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        Node tmp1 = tmp.next;
        while (tmp1.next != null) {
            tmp1 = tmp1.next;
        } 
        tmp1.next = node;
        node.next = null;
    }

    /**
     * put method to inserrt an eleement in bsst.
     * @param key the key that is to be put.
     * @param val the value that is to be fit.
     * complexity is N.
     */

    public void put(Key key, Value val) {
        for (Node x = First; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        First = new Node(key, val, First);
        n++;
    }

    /**
     * methhod iterable to iterate through the table.
     * @return queue with keys.
     * complexity is N.
     */
    
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = First; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

}