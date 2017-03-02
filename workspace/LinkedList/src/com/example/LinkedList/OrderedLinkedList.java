package com.example.LinkedList;

public class OrderedLinkedList<T> extends LinkedListClass<T> {

	// Default constructor
	public OrderedLinkedList()
	{}
	
	// Method to determine whether searchItem is in
	// the list.
	// Postcondition: Returns true if searchItem is found
	//				  in the list; false otherwise.
	public boolean search(T searchItem)
	{
		return true;
	}
	
	// Method to insert insertItem in the list.
	// Postcondition: First points to the new list,
	//				  insertItem is inserted at the proper place
	//				  in the list, and count is incremented by 1.
	public void insert(T insertItem)
	{}
	
	// Method to insert newItem in the list.
	// Because the resulting list is sorted, newitem is
	// inserted at the proper place.
	// This method uses the method insert to insert newItem.
	// Postcondition: first points to the new list
	//				  and newItem is inserted at the
	//				  proper place. Also,
	//				  last points to the last node and 
	//				  count is incremented by 1.
	public void insertFirst(T newItem)
	{}
	
	// Method to insert newItem in the list.
	// Because the resulting list is sorted, newItem is
	// inserted at the proper place.
	// This method uses the method insert to insert newItems.
	//  Postcondition: first points to the new list
	//				   and newItem is inserted at the
	//				   proper place. Also,
	//				   last points to the last node and
	//				   count is incremented by 1.
	public void insertLast(T newItem)
	{}
	
	// Method to delete deleteItem from the list.
	// Postcondition: If found, the node containing
	//				  deleteItem is deleted from the
	//				  list. Also, first point to the first
	//				  node, last points to the last
	//				  node of the updated list, and count
	//				  is incremented by 1.
	public void deleteNode(T deleteItem)
	{}
	
}
