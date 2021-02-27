package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete
 * Last update: 09/25/20
 * Submitted:  09/25/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.09.23
 */
public class DNode<T> {
	
	private T item;
	private DNode<T> next;
	private DNode<T> back;

	public DNode(T item) {
		this.item = item;
		next = this;
		back = this;
	}
	
	public DNode(T item, DNode<T> nextNode, DNode<T> backNode) {
		this.item = item;
		this.next = nextNode;
		this.back = backNode;
	}

	public void setItem(T item) {
		this.item = item;
	} 

	public Object getItem() {
		return item;
	} 

	public void setNext(DNode<T> next) {
		this.next = next;
	} 

	public DNode<T> getNext() {
		return next;
	} 
	
	public void setBack(DNode<T> back) {
		this.back = back;
	}
	
	public DNode<T> getBack() {
		return back;
	}

}
