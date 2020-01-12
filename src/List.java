	/**
	 * Defines a singly-linked list class
	 * @author
	 * @author
	 */

	import java.util.NoSuchElementException;

	public class List<T> {
	    private class Node {
	        private T data;
	        private Node next;
	       
	        public Node(T data) {
	            this.data = data;
	            this.next = null;
	        }
	    }
	   
	    private int length;
	    private Node first;
	    private Node last;
	   
	    /****CONSTRUCTOR****/
	   
	    /**
	     * Instantiates a new List with default values
	     * @postcondition initialized the fields inside the List class with a starting value (null)
	     */
	    public List() {
	    	first = null;
	        last = null;//you fill in here
	        length = 0;//you fill in here
	    }
	   
	    /****ACCESSORS****/
	   
	    /**
	     * Returns the value stored in the first node
	     * @precondition length is not 0
	     * @return the value stored at node first
	     * @throws NoSuchElementException when precondition is violated
	     */
	    public T getFirst() throws NoSuchElementException{
	    	if (length == 0) {
	            throw new NoSuchElementException("getFirst: List is Empty. No data to access!");
	        }
	        return first.data;
	    }
	   
	    /**
	     * Returns the value stored in the last node
	     * @precondition length is not 0
	     * @return the value stored in the node last
	     * @throws NoSuchElementException when precondition is violated
	     */
	    public T getLast() throws NoSuchElementException{
	    	if (length == 0) {
	            throw new NoSuchElementException("getLast: List is Empty. No data to access!");
	        }
	        return last.data;
	    }
	   
	    /**
	     * Returns the current length of the list
	     * @return the length of the list from 0 to n
	     */
	    public int getLength() {
	        return length;
	    }
	   
	    /**
	     * Returns whether the list is currently empty
	     * @return whether the list is empty
	     */
	    public boolean isEmpty() {
	    	return length == 0;
	    }
	   
	    /****MUTATORS****/
	   
	    /**
	     * Creates a new first element
	     * @param data the data to insert at the front of the list
	     * @postcondition creates a new element in front of the first element 
	     */
	    public void addFirst(T data) {
	    	if (first == null) {
	            first = last = new Node(data);
	        } else {
	            Node N = new Node(data);
	            N.next = first;
	            first = N;
	        }
	        length++;
	    }
	   
	    /**
	     * Creates a new last element
	     * @param data the data to insert at the
	     * end of the list
	     * @postcondition creates a new element next to the last element
	     */
	    public void addLast(T data) {
	    	if (first == null) {
	            first = last = new Node(data);
	        } else {
	        	Node N = new Node(data);
	            last.next = N;
	            last = N;
	        }
	        length++;
	    }
	   
	    /**
	    * removes the element at the front of the list
	    * @precondition length is not 0
	    * @postcondition removes the data at the front of the list
	    * @throws NoSuchElementException when precondition is violated
	    */
	    public void removeFirst() throws NoSuchElementException{
	    	if (length == 0) {
	            throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
	        } else if (length == 1) {
	            first = last = null;
	        } else {
	            first = first.next;
	        }
	        length--;
	    }
	   
	    /**
	     * removes the element at the end of the list
	     * @precondition length is not 0
	     * @postcondition removes the element at the end of the list
	     * @throws NoSuchElementException when precondition is violated
	     */
	    public void removeLast() throws NoSuchElementException{
	    	//add your if statement here
	    	if (length ==0) {
	            throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
	    	}
	    	else if (length == 1) {
	    		first = last = null;
	        } else {
	            Node temp = first;
	            while (temp.next != last) {
	                temp = temp.next;
	            }
	            last = temp;
	            last.next = null;
	        }
	        length--;
	    }
	   
	    /****ADDITIONAL OPERATIONS****/
	   
	    /**
	     * List with each value on its own line
	     * At the end of the List a new line
	     * @return the List as a String for display
	     */
	    @Override public String toString() {
	    	String result = "";
	        Node temp = first;
	        while(temp != null) {
	            result += temp.data + "\n";
	            temp = temp.next;	            
	        }
	        return result;
	    }
	   

	}

