package com.example.LinkedList;

public class UnorderedLinkedList<T> extends LinkedListClass<T>{

	// Default constructor
	public UnorderedLinkedList()
	{}
	
	// Method to determine whether searchItem 
	// is in the list.
	// Postcondition: Returns true if serachItem is found 
	//				  in the list; otherwise false.
	public boolean search(T searchItem)
	{
		LinkedListNode<T> current = first;	// Variable to traverse the list
		boolean found = false;
		
		while(current != null && !found)	// Search the list
			if (current.info.equals(searchItem))	// Item found
				found = true;
			else
				current = current.link;	// Make current point to the next node
		
		return found;
	}
	
	// Method to insert newItem in the list.
	// Postcondition: first points to the new list 
	// 				  and newItem is inserted at the 
	//				  beginning of the list. Also, 
	//				  last points to the last node and 
	//				  count is incremented by 1.
	public void insertFirst(T newItem)
	{
		LinkedListNode<T> newNode = new LinkedListNode<T>(newItem, first);
		
		if (last == null)
			last = newNode;
		count++;
		
	}
	
	// Method to insert newItem at the end of the list.
	// Postcondition: first point to the new list and 
	//				  newItem is inserted at the end 
	//				  of the list. Also, last points to 
	//				  the last node and 
	//				  count ins incremented by 1.
	public void insertLast(T newItem)
	{
		LinkedListNode<T> newNode = new LinkedListNode<T>(newItem, null);
		
		if (first == null)
			first = newNode;
		else
			last.link = newNode;
		
		last = newNode;
		count++;
	}
	
	// Method to deleteItem from the list.
	// Postcondition: If found, the node containing 
	//				  deleteItem is deleted from the 
	//				  list. Also, first point to the first 
	//				  node, last points to the last 
	//				  node of the updated list, and count 
	//				  is decremented by 1.
	public void deleteNode(T deleteItem)
	{
		LinkedListNode<T> current;	// Variable to traverse 
									// the list
		LinkedListNode<T> trailCurrent;	// Variable just
										// before current
		boolean found;
		
		if (first == null)	// Case 1; the list is empty
			System.err.println("Cannot delete from an empty "
							+  "list.");
		else{
			if(first.info.equals(deleteItem)){	// Case 2
				first = first.link;
				if (first == null)	// The list has only one node
					last = null;
			}else{	// search the list for the given info
				found = false;
				
				trailCurrent = first;			// set trailCurrent to
												// point the first node
				current = trailCurrent.link;	// set current to point to
												// the second node
				
				while (current != null && !found){
					if (current.info.equals(deleteItem))
						found = true;
					else {
						trailCurrent = current;
						current = current.link;
					}
				}
				
				if (found){	// Case 3: if found, delete the node
					count--;
					trailCurrent.link = current.link;
					if (current == last)	// node to be deleted was the last one
						last = trailCurrent;	//update the value of last
				}else
					System.out.println("Item to be deleted is "
									 + "not in the list.");
			}
		}
		
	}
}
