package com.example.LinkedList;

public interface DoublyLinkedListADT<T> extends Cloneable {

	// Returns a copy of objects data in store
	// This method clones only the references stored in
	// each node of the list. The objects that the
	// list nodes point to are not cloned.
	public Object clone();
	
	// Method to determine whether the list is empty.
	// Postcondition: Returns true if the list is empty;
	//				  false otherwise.
	public boolean isEmptyList();
	
	// method to initialize the list to an empty state.
	// Postcondition: The list is initialized to an empty
	//				  state.
	public void initializeList();
	
	// Method to  return the number of nodes in the list.
	// Postcondition: The number of nodes in the list is
	// 				  returned.
	public int lenght();
	
	// Method to output the info of each node.
	public void print();
	
	// Method to output the info of each node in the reverse
	// order.
	public void reversePrint();

	// Method to determine whether searchItem is in
	// the list.
	// Postcondition: Returns true if searchItem is found
	//				  in the list.
	public boolean search(T searchItem);
	
	// Method to return the reference of the object containing
	// the data of the first node of the list.
	// Precondition: The list must exist and must not be empty.
	// Postcondition: The reference of the object that
	//				  contains the info of the first node
	//				  is returned.
	public T front();
	
	// Method to return the reference of the object containing
	// the data of the last node of the list.
	// Precondition: The list must exist and must not be empty.
	// Postcondition: The reference of the object that
	//				  contains the info of the last node
	//				  is returned.
	public T back();
	
	// Method to insert insertItem in the list.
	// Precondition: If the list is nonempty, it must
	//				 be in order.
	// Postcondition: insertItem is inserted at the proper
	//				  place in the list.
	public void insertNode(T insertItem);
	
	// Method to delete deleteItem form the list.
	// Postcondition: If found, the node containing
	//				  deleteItem is deleted from the list.
	//				  Otherwise, an appropriate message
	//				  is printed.
	public void deleteNode(T deleteItem);
	
}
