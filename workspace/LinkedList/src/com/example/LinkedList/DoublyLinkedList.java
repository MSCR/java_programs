package com.example.LinkedList;

public class DoublyLinkedList<T> implements DoublyLinkedListADT {

	protected int count;
	protected DoublyLinkedListNode<T> first;
	protected DoublyLinkedListNode<T> last;	
	
	public class DoublyLinkedListNode<T> implements Cloneable{
	
		T info;
		DoublyLinkedList<T> next;
		DoublyLinkedList<T> back;
		
		public DoublyLinkedListNode(){}
		
		public Object clone(){
			DoublyLinkedListNode<T> copy = null;
			
			return copy;
		}
		
		public String toString(){
			return info.toString();
		}
		
	}
	
	// Default constructor
	public DoublyLinkedList(){}
	
	public Object clone(){
		Object a = null;
		return a;
	}
	
	public boolean isEmptyList(){
		return (first == null);
	}
	
	public void initializeList(){}
	
	public int lenght(){
		return count;
	}
	
	public void print(){}
	
	public void reversePrint(){}
	
	public boolean search(T searchItem){
		return false;
	}
	
	public T front(){
		T a = null;
		return a;
	}
	
	public T back(){
		T a = null;
		return a;
	}
	
	public void insertNode(T insertItem){
		
	}
	
	public void deleteNode(T deleteItem){}
	
}
