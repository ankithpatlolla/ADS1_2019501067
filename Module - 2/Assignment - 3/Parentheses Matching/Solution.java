/**
 * class stack to add methods like enqueue and dequeue
 */
class Stack {
	Node head;

	/**
	 * push method to add elements to stack.
	 * @param paran paranthesis character to add to stack.
	 */
	public void push (char paran) {
		Node node = new Node(paran);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	/**
	 * pop method to remove an element from head.
	 * @return teemp popped node data.
	 */
	public char pop() {
		char temp = head.data;
		head = head.next;
		return temp;
	}

	/**
	 * getHeaD method to get the head node data.
	 * @return head data.
	 */

	public char getHead () {
		if (head == null) {
			return ' ';
		} else {
			return head.data;
		}
	}
}
/**
 * class Solution the main class to perform stack operations.
 */
class Solution{

	/**
	 * method isMataching to cheack we have balanced paranthesis or not.
	 * @param str the string that is to be checked.
	 * @return returns yes if the string has balanced paranthesis no if not.
	 */
	public static String isMatching(String str){
		// fill you code Here
		Stack stack = new Stack();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (stack.head != null && ((ch == ')' && stack.getHead() == '(')
											|| (ch == '}' && stack.getHead() == '{' )
											|| (ch == ']' && stack.getHead() == '['))) {
				stack.pop();
			}
			else {
				return "NO";
			}
		}
		if (stack.head == null) {
			return "YES";
		} else {
			return "NO";
		}
	}
}