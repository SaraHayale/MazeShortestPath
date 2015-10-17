package ShortestPath;
public class Queue<T> {
	    private int N;               // number of elements on queue
	    private Node<T> first;    // beginning of queue
	    private Node<T> last;     // end of queue
	    int maxSize;

	    private static class Node<T> {
	        private T data;
	        private Node<T> next;
	     
	    }

	    public Queue(int maxSize) {
	        first = null;
	        last  = null;
	        N = 0;
	        this.maxSize=maxSize;
	    }
	    public Queue() {
	        first = null;
	        last  = null;
	        N = 0;

	    }
	    public boolean isEmpty() {
	        return first == null;
	    }


	    public int size() {
	        return N;     
	    }

	 
	    public T top() {
	        return first.data;
	    }

	    public void enqueue(T data) {
	        Node<T> oldlast = last;
	        last = new Node<T>();
	        last.data = data;
	        last.next = null;
	        if (isEmpty()) 
	        	first = last;
	        else           
	        	oldlast.next = last;
	        N++;
	    }
	    public Boolean isFull(){
	    	return N==maxSize;
	    }
	    public T dequeue() {
	        if (!isEmpty()){ 
	            T item = first.data;
	            first = first.next;
	            N--;
	            if (isEmpty()) last = null;   // to avoid loitering
	            return item;
	        }
	        
	        else
	        	return null;

	    }
	}


