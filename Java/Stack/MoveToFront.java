/*************************************************************************
 *  Problem: implement a generic MoveToFront<T> class
 *  Description: maintains a collection of items of generic type T 
 *               in LIFO order without duplicates with linkedlist
 *
 *  Input: none
 *  Output: none
 *
 *  Visible data fields:
 *	private LinkedList<T> stack = new LinkedList<T>()  
 *
 *  Visible methods:
 *  public void push(T item)
 *  public T pop()
 *	public boolean contains(T item)  
 *	public boolean isEmpty()
 *	public String toString()
 *
 *************************************************************************/
import java.util.*;

public class MoveToFront<T>
{
	//data fields
	private LinkedList<T> stack = new LinkedList<T>();

	//push()
	public void push(T item)
	{
		if(stack.contains(item))
		{
			stack.removeFirstOccurrence(item);
		}

			stack.addLast(item);
	}	

	//pop()
	public T pop()
	{
		return stack.removeLast(); 
	}

	//contains()
	public boolean contains(T item)
	{
		return stack.contains(item);
	}

	//isEmpty()
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}

	//toString()
	public String toString()
	{		
		return stack.toString();
	}
}
