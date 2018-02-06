/*************************************************************************
 *
 *  Problem: Running the Fibonacci Sequence
 *  Description: This will print numbers in the Fibonacci sequence that are less than or
 *               equal to x, when x is a positive integer.
 *
 *  Input: int limit - a limit chosen by the user 
 *  Output: numbers in the fibonacci sequence until the limit chosen by a user
 *
 *  Visible data fields:
 *  int limit
 *
 *  Visible methods:
 *  public static void main(String[] args)
 *	public static int printFib(int x)
 *
 *
 *   Remarks
 *   -------
 *	2a) The worst case running time of my printFib() method is O(n).
 *   
 *	2b) There is one loop inside the printFib() method with n, number of iterations.
 *		Inside the while loop there are 4 consecutive statements, which makes the 
 *		running time of the while loop 4n. Outside of the loop there are 3 more 	
 *		consecutive statements, which makes the total running time 4n+3. When we	
 *		use big O notation, we discard any constants in the running time. This makes
 *		the worst case running time O(n).
 *
 *************************************************************************/
import java.util.*;

public class Fibonacci
{

	//printFib(): prints numbers in fibonacci sequence
	public static void printFib(int x)
	{
		int last = 1;
		int secondLast = 0;
		int result = 1;

		while (result < x)
		{
			System.out.println(result);
			
			last = secondLast;
			secondLast = result; 
			result = last + secondLast;
		}
	}

	//main: prints method above
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a limit: ");		
		int limit = scan.nextInt();

		Fibonacci.printFib(limit);				
	}
}
