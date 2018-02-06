/*************************************************************************
 *
 *  Problem: return the distance between two exits on a highway
 *  Description: Uses an array to find the distances between 2 exits on a highway
 *
 *  Input: int i and j - which represent the 2 exits on the highway 
 *  	   int nExits - which represents the number of exits on the same highway
 *  Output: The distance between the two exits which the user chooses
 *
 *  Visible data fields:
 *  int exitI
 *  int exitJ
 *  int nExits
 *
 *  Visible methods:
 *  public static void main(String[] args)
 *  public static distance(int i, int j,int[] a)
 *
 *************************************************************************/
import java.util.*;

public class Highway
{

	//distance(): returns distance b/w exits i and j
	public static int distance(int i, int j,int[] A)
	{
		final int DISTANCE = (j - i) + i;

		int result = 0;
		
		for ( i = 1; i < DISTANCE; i++)
		{
			result += A[i];
		}
		
		return result;
	}
	
//main(): obtains exits, creates an array and calls method above
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number(This will be exit i): ");
		int exitI = scan.nextInt();
		
		System.out.print("Enter a number(This will be exit j): ");
		int exitJ = scan.nextInt();
		
		System.out.print("Enter a number(This will be the number of exits): ");
		int nExits = scan.nextInt();
		
		int[] exits = new int[nExits];
		for(int n = 0; n < nExits ; n++ )
		{
			exits[n] = n;
		}

		int[] A = new int[nExits];
		for(int c = 0; c < nExits ; c++ )
		{
			Random random = new Random();
			
			int n = random.nextInt(100) + 1;
			
			A[c] = n;
		}
		
		System.out.println(distance(exitI, exitJ, A ) );
		
	}

}
