/*************************************************************************
 * Problem: implement a generic class Queue<T> 
 *  Description: The class must maintain a collection of items of 
 *  			 generic type T in FIFO order and use the LinkedList class	
 *               to implement it.
 *  Input: none
 *  Output: none 
 *
 *  Visible data fields:
 *  private LinkedList<T> line = new LinkedList<T>();
 *
 *  Visible methods:
 *  public void enqueue(T item)
 *  public T dequeue()
 *	public boolean inQueue(T item)  
 *	public boolean isEmpty()
 *	public String toString()
 *
 *************************************************************************/
import java.util.*;

public class Queue<T>
{

	//data fields
	private LinkedList<T> line = new LinkedList<T>();

	//constructors 
	Queue()			
	{
		//this constructor doesn't need anything 
		//inside it b/c it has a default
	}

	//other methods

	//enqueue()
	public void enqueue(T item)
	{
		line.addLast(item); 
	}	

	//dequeue()
	public T dequeue()
	{
		return line.removeFirst(); 
	}

	//inQueue()
	public boolean inQueue(T item)
	{
		return line.contains(item);
	}

	//isEmpty()
	public boolean isEmpty()
	{
		return line.isEmpty();
	}

	//toString()
	public String toString()
	{		
		return line.toString();
	}
}
