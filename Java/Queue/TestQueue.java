/*************************************************************************
 *  Problem: tests the Queue class
 *  Description: This class tests and prints all 
 *  			 the methods in the Queue class.
 *
 *  Input: none 
 *  Output: items listed in the queue, whether the queue is empty or not,
 *  		whether an item is in the queue
 *
 *  Visible data fields:
 *  None
 *
 *  Visible methods:
 *	public static void main (String[] args)
 *	  
 *************************************************************************/
import java.util.*;

public class TestQueue
{
	public static void main (String[] args)
	{
		Queue<String> starbucks = new Queue<String>();
		
		System.out.println(starbucks.isEmpty()); //returns true if queue is empty
		
		starbucks.enqueue("Espresso");		//adds items in the queue
		starbucks.enqueue("Latte");
		starbucks.enqueue("Cake Pop");
		starbucks.enqueue("Frappucino");
		
		System.out.println(starbucks.toString());	//prints a string of the queue
		
		starbucks.dequeue();	//removes items
		starbucks.dequeue();
		
		System.out.println(starbucks.toString());
		
		System.out.println(starbucks.inQueue("Frappucino"));	//returns true if item
							                //is in queue
		System.out.println(starbucks.isEmpty());
		
		System.out.println(starbucks.inQueue("Espresso"));	
		
	}
}
