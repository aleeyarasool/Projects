/*************************************************************************
 *
 *  Problem: test the MoveToFront class
 *  Description: tests all operations of the MoveToFront class and 
 *  			 overrides toString to display all items in collection	
 *  			 after each method is called
 *
 *  Input: None
 *  Output: items in stack, whether an item is in the stack 
 *  		and if the stack is empty
 *
 *  Visible data fields:
 *  None
 *
 *  Visible methods:
 *  public static void main (String[] args)
 *
 *************************************************************************/
import java.util.*;

public class TestMtF
{
	public static void main (String[] args)
	{
		MoveToFront<String> mtf = new MoveToFront<String>();
		
		System.out.println(mtf.isEmpty()); //returns true if stack is empty
		
		mtf.push("Harry Potter");	   //adds items in the stack
		mtf.push("The Outsiders");
		mtf.push("Harry Potter");
		mtf.push("Gone Girl");
		mtf.push("To Kill a Mockingbird");
		
		System.out.println(mtf.toString());	//prints a string of the stack
		
		mtf.pop();	//removes items
		mtf.pop();
		
		System.out.println(mtf.toString());
		
		System.out.println(mtf.contains("Harry Potter"));	//returns true if item
									//is in stack
		System.out.println(mtf.isEmpty());
		
		System.out.println(mtf.contains("Gone Girl"));	
	}
}
