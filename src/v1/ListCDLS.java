package v1;

/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete
 * Last update: 10/08/20
 * Submitted:  10/08/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.08
 */
public class ListCDLS<T> implements ListInterface<T> {
	
	private DNode<T> tail;
	private int numItems;
	
	public ListCDLS() {
		tail = null;
	}
	
	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public void add(int index, T item) throws ListIndexOutOfBoundsException {
		if(isValidIndex(index)) {
			
			DNode<T> newNode = new DNode<T>(item);
			
			if(numItems == 0) {
				tail = newNode;
			}
			else if(index == 0 && numItems != 0) {				
				DNode<T> start = tail.getNext();
				newNode.setBack(tail);
				tail.setNext(newNode);
				start.setBack(newNode);
				newNode.setNext(start);
				start = newNode;
			}
			else if(index == numItems) {
				tail.setNext(newNode);
				newNode.setBack(tail);
				newNode.setNext(find(0));
				tail = newNode;
			}
			else {
				DNode<T> prevIndex = find(index-1);
				DNode<T> nextIndex = find(index);
				newNode.setNext(nextIndex);
				newNode.setBack(prevIndex);
				nextIndex.setBack(newNode);
				prevIndex.setNext(newNode);
			}
			numItems++;
		}
		else {
			throw new ListIndexOutOfBoundsException("The index is out of bounds!");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(int index) throws ListIndexOutOfBoundsException {
		if(isValidIndex(index)) {
			T dataItem = (T) find(index).getItem();
			return dataItem;
		} 
		else {
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		}
	}
	
	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if(isValidIndex(index)) {
			if(index == 0 && numItems == 1) {
				tail = null;
			} 
			else if(index == 0 && this.size() > 1) {
				tail.getNext().getNext().setBack(tail);
				tail.setNext(tail.getNext().getNext());
			}
			else {
				DNode<T> nodeToDelete = find(index);
				nodeToDelete.getNext().setBack(nodeToDelete.getBack());
				nodeToDelete.getBack().setNext(nodeToDelete.getNext());
				nodeToDelete = null;
			}
			numItems--;
		} 
		else {
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
		}
	}

	@Override
	public void removeAll() {
		numItems = 0;
		tail = null;
	}
	
	/**
	 * This method will take the index as a parameter, and use it against the size of the 
	 * collection to test whether or not it is a valid index.
	 * @param index the index needed to find
	 * @return true if valid index false if invalid index
	 */
	public boolean isValidIndex(int index) {
		if( index >= 0 && index <= numItems ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method will find the node, in which the user specified index and will
	 * return it.
	 * @param index the index needed to find
	 * @return the node at the specific index
	 */
	private DNode<T> find(int index) {
		DNode<T> current;
		int possibleIndicies = numItems - 1;

		if( (possibleIndicies/2) < index ) {
			current = tail.getNext();
			for(int i = 0; i < index; i++)  {
				current = current.getNext();
			}
		}
		else {
			current = tail;
			for(int i = possibleIndicies; i > index; i--)  {
				current = current.getBack();
			}
		}	
		return current;
	}
	
	/**
	 * @return the contents of the list ended with comma excluding the last element in list
	 */
	public String toString() {
		String theList = "";
		DNode<T> current;
		
		for(int i = 0; i < numItems; i++) {
			if( (i+1) == numItems ) {
				theList = theList + tail.getItem();
			}
			else {
				current = find(i);
				theList =  theList + current.getItem() + ", ";
			}
		}
		return theList;
	}
}
