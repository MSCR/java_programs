package com.example.LinkedList;

import java.util.NoSuchElementException;

public abstract class LinkedListClass<T> implements LinkedListADT<T>
{

	protected LinkedListNode<T> first;
	protected LinkedListNode<T> last;
	protected int count;
	
	// Place definition of the class LinkedListNode<T> here.
	protected class LinkedListNode<T> implements Cloneable
	{
		public T info;	// Reference variable to store the data
		public LinkedListNode<T> link;	// Reference variable to
										// store the reference of
										// the next node.
		
		// Default constructor
		// Postcondition: info = null, link = null
		public LinkedListNode()
		{
			info = null;
			link = null;
		}
		
		// Constructor with parameters
		// This method sets info pointing to the object to
		// which elem points and link is set to point to
		// the object to which ptr points.
		// Postcondition: inf = elem, link = null
		public LinkedListNode(T elem, LinkedListNode<T> ptr)
		{
			info = elem;
			link = ptr;
		}
		
		// Returns a copy of objects data in store.
		// This method clones only the references store in
		// the node. The objects that the nodes point to
		// are not clone.
		public Object clone()
		{
			LinkedListNode<T> copy = null;
			
			try
			{
				copy = (LinkedListNode<T>) super.clone();
			}
			catch (CloneNotSupportedException e){
				return null;
			}
			
			return copy;
		}
		
		// Method to return the info as a String.
		// Postcondition: info as a String object is
		//				  returned.
		public String toString()
		{
			return info.toString();
		}	
		
	}

	// Place the definition of the class linkedListIterator<T>
	// here.
	public class LinkedListIterator<T>
	{
		protected LinkedListNode<T> current;	// variable to point to
												// the current node in list
		protected LinkedListNode<T> previous;	// variable to point to
												// the node before the current node
		
		// Default constructor
		// Sets current to point to the first node in the
		// list and sets previous to null
		// Postcondition: current = first; previous = null
		public LinkedListIterator()
		{
			current = (LinkedListNode<T>) first;
			previous = null;
		}
		
		// Method to reset the iterator to the first node
		// in the list.
		// Postcondition: current = first, previous = null
		public void reset()
		{
			current = (LinkedListNode<T>) first;
			previous = null;			
		}
		
		// Method to return a reference of the info of the 
		// current node in the list and to advance iterator
		// to the next node.
		// Postcondition: previous = current;
		//				  current = current.link;
		//				  A reference of the current node
		//				  is returned.
		public T next()
		{
			if (!hasNext())
				throw new NoSuchElementException();
			LinkedListNode<T> temp = current;
			previous = current;
			current = temp.link;
			
			return temp.info;
		}
		
		// Method to determine whether ther is a next
		// element in the list.
		// Postcondition: Return true if there is a next
		//				  node in the list; otherwise
		//				  return false.
		public boolean hasNext()
		{
			return (current.link != null);
		}
		
		// Method to remove the node currently pointed to
		// by the iterator.
		// Postcondition: If iterator is not null, then the
		//				  node that the iterator points to
		//				  is removed. Otherwise the method
		//				  throws NoSuchElement Exception
		public void remove()
		{
			if (current == null)
				throw new NoSuchElementException();
			
			if (current == first)
			{
				first = first.link;
				current = (LinkedListNode<T>) first;
				previous = null;
				
				if (first == null)
					last = null;
			}
			else
			{
				previous.link = current.link;
				if (current == last)
				{
					last = first;
					// Let's search the last item
					while(last.link != null)
						last = last.link;
				}	
				current = previous.link;
			}
		}
		
		// Method to return the info as a String.
		// Postcondition: info as a String object is returned
		public String toString()
		{
			return current.info.toString();
		}
		
	}
	
	// Place the definition of the non-abstract methods and the
	// abstract methods here.
	
	// Default constructor
	// Initializes the list to an empty state
	// Postcondition: first = null, last = null
	//				  count = 0
	public LinkedListClass()
	{
		first = last = null;
		count = 0;
	}
	
	// Method to determine whether the list is empty.
	// Postcondition: Returns true if the list is empty;
	//				  false otherwise.
	public boolean isEmptyList()
	{
		return (first == null);
	}
	
	// Method to initialize the list at an empty state.
	// Postcondition: first = null, last = null
	//				  count = 0
	public void initializeList()
	{
		first = last = null;
		count = 0;
	}
	
	// Method to output the data contained in each node.
	public void print()
	{
		LinkedListNode<T> current = first;
		while(current != null)
		{
			System.out.println(current + " ");
			current = current.link;
		}
	}
	
	// Method to return the number of nodes in the list.
	// Postcondition: The value of count is returned.
	public int lenght()
	{
		return count;
	}
	
	// Method to return a reference of the object containing
	// the data of the first node of the list.
	// Precondition: The list exist and must not be empty.
	// Postcondition: The reference of the object that 
	// 				  contains the info of the first node 
	// 				  is returned.
	public T front()
	{
		return first.info;
	}

	// Method to return a reference of object containing
	// the data of the last node of the list.
	// Postcondition: The reference of the last node
	//				  is returned.
	public T back()
	{
		return last.info;
	}

	// Returns a copy of objects data in store.
	// This method clones only the references stored in
	// each node of the list. The objects that the 
	// list nodes point to are not clone.
	public Object Clone()
	{
		LinkedListClass<T> copy;
		try{
			copy = (LinkedListClass<T>) super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
		
		// If the list is not empty, clone each node 
		// of the list
		if (first != null){
			// Clone the first node
			copy.first = (LinkedListNode<T>) first.clone();
			copy.last = copy.first;
			
			LinkedListNode<T> current; // current = first.link;
			
			if (first != null)
				current = first.link;
			else
				current = null;
			
			// Clone the remaining nodes of the list
			while(current != null)
			{
				copy.last.link = 
						(LinkedListNode<T>) current.clone();
				copy.last = copy.last.link;
				current = current.link;
			}
		}
		
		return copy;
	}
	
	// Method to return an iterator of the list.
	// Postcondition: An iterator is instantiated and 
	//				  returned.

	
	// Method to determine whether searchItem is in 
	// the list.
	// Postcondition: Returns true if searchItem is found 
	// 				  in the list; false otherwise
	public abstract boolean search(T searchItem);
	
	// Method to insert new Item in the list.
	// Postcondition: first points to the new list 
	//				  and newItem is inserted at the 
	//				  beginning of the list. Also, 
	//				  last point to the last node and 
	//				  count is decremented by 1.
	public abstract void insertFirst(T newItem);
	
	// Method to insert newItem at the end of the list.
	// Postcondition: first points to the new list and 
	//				  newItem is inserted at the end 
	//				  of the list. Also, last points to 
	//				  the last node and 
	//				  count is incremented by 1.
	public abstract void insertLast(T newItem);
	
	// Method to delete deleteItem from the list.
	// Postcondition: If found, the node containing
	//				  deleteItem is deleted from the 
	//				  list. Also, first points to the first 
	//				  node, last points to the last 
	//				  node of the updated list, and count 
	//				  is decremented by 1.
	public abstract void deleteNode(T deleteItem);
	
	
	
}
