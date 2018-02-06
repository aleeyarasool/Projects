/*************************************************************************
 *
 *  Problem: comparing quick sort and selection sort
 *  Description: evaluate experimentally the performance of Quick Sort 
 *  for different methods of choosing the pivot, and compare with Selection Sort,
 *  which is simpler but quadratic.
 *
 *  Input: 
 *  Output: 
 *
 *  Visible data fields:
 *  None
 *
 *  Visible methods:
 *  public static void selectionSort()
 *  public static ArrayList<Integer> quickSortFirst(List<Integer> list1)
 *	public static List<Integer> quickSortMedian(List<Integer> list)
 *
 *   Remarks
 *   -------
 *	3)    | Increasing Order | Decreasing Order |      Random
 *    --------------------------------------------------------------
 *      1 |       25576      |      5559        |     429789      
 *    ---------------------------------------------------------------
 * 	   2a |     1135245      |     544245       |     141553      
 *    ---------------------------------------------------------------
 *     2b |     1358862      |     951522       |     193726      
 *    --------------------------------------------------------------- 
 *
 *************************************************************************/
import java.util.*;

public class Sorting 
{

	//implements Selection Sort
	public static void selectionSort()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=0; i < list.size()-1; i++)
		{
			// finds the smallest value
			int min = i;

			for(int j = i+1; j<list.size(); j++)
			{
				if(list.get(j) < list.get(min))
				{
					min = j;
				}
			}

			// swaps values
			int temp = list.get(i);
			list.set( i, list.get(min) );
			list.set( min, temp );
		}		
	}

	//quick sort that chooses pivot from first position of subarray
	public static ArrayList<Integer> quickSortFirst(List<Integer> list2)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		if(list.size() <= 1)
		{
			return list;
		}

		int pivot = list.get(0);
		int i = 0;          // i is the rightmost index with  
		//value < pivot

		//uses swap method to go through the array and swap vales when necessary
		for(int j =1; j < list.size(); j++)
		{
			if(pivot > list.get(j))
			{
				swap(i + 1, j, list);
				i++;
			}
		}

		swap(0, i, list);

		//creates 2 subarrays to be sorted
		ArrayList<Integer> left = quickSortFirst(list.subList(0, i));
		ArrayList<Integer> right = quickSortFirst(list.subList(i + 1, list.size()));

		//sorted array
		ArrayList<Integer> sorted = new ArrayList<>(left.size() + right.size() + 1);

		//adds values
		sorted.addAll(left);
		sorted.add(list.get(i));
		sorted.addAll(right);

		return sorted;
	}

	//this method will be used to switch the values
	private static void swap(int a, int b, List<Integer> list)
	{
		int temp = list.get(a);

		list.set(a, list.get(b));
		list.set(b, temp);
	}

	// quick sort that chooses 3 positions of the subarray at random 
	//and make the median of the values in these positions the pivot
	public static List<Integer> quickSortMedian(List<Integer> list2)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int vOne = list.get(0); //represents the 3 random positions in subarray
		int vTwo = list.get(1); 
		int vThree = list.get(2);

		Integer pivot = null;

		//sets value 1 as the pivot when it's the median
		if (vTwo < vOne && vOne < vThree || (vThree < vOne && vOne < vTwo))
		{ 
			pivot = vOne;
		}

		//sets value 2 as the pivot when it's the median 
		else if (vOne < vTwo && vTwo <vThree || (vThree < vTwo && vTwo < vOne ))
		{ 
			pivot = vTwo;
		}

		//sets value 3 as the pivot when it's the median
		else if (vOne < vThree && vThree < vTwo || (vTwo< vThree && vThree < vOne))
		{
			pivot = vThree;
		}

		if(list.size() <= 1) //returns list when there's only 1 value left
		{					 //meaning when sorting is completed for that subarray
			return list;
		}

		int h = 0;

		//uses swap method to go through the array and swap vales when necessary
		for(int j =1; j < list.size(); j++)
		{
			if(pivot > list.get(j))
			{
				swap(h + 1, j, list);
				h++;
			}
		}

		swap(0, h, list);

		//creates 2 subarrays to be sorted
		List<Integer> left = quickSortMedian(list.subList(0, h));
		List<Integer> right = quickSortMedian(list.subList(h + 1, list.size()));

		//sorted array
		ArrayList<Integer> sorted = new ArrayList<>(left.size() + right.size() + 1);

		//adds values
		sorted.addAll(left);
		sorted.add(list.get(h));
		sorted.addAll(right);

		return sorted;
	}

	//main method to test running times
	public static void main(String[] args)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();

		//increasing order
		for(int i = 1; i <= 100;i++)
		{
			array.add(i);
		}

		long preTime = System.nanoTime();

		selectionSort();

		System.out.println("Time taken by Selection sort for increasing order: " 
							+ (System.nanoTime() - preTime)+ " nanoseconds"); 

		array.clear();

		for(int i = 0; i <= 100;i++)
		{
			array.add(i);
		}

		long preTime2 = System.nanoTime();

		quickSortFirst(array);

		System.out.println("Time taken by Quick sort (pivot is 1st #) for increasing order: " 
							+ (System.nanoTime() - preTime2)+ " nanoseconds"); 

		array.clear();

		for(int i = 0; i <= 100;i++)
		{
			array.add(i);
		}

		long preTime3 = System.nanoTime();

		quickSortMedian(array);

		System.out.println("Time taken by Quick sort (median) for increasing order: " 
							+ (System.nanoTime() - preTime3)+ " nanoseconds"); 

		array.clear();
		System.out.println();

		//decreasing order
		Collections.reverse(array);
		
		System.out.println();
		
		long preTime4 = System.nanoTime();

		selectionSort();

		System.out.println("Time taken by Selection sort for decreasing order: " 
							+ (System.nanoTime() - preTime4)+ " nanoseconds");
		
		array.clear();
		
		for(int i = 0; i <= 100;i++)
		{
			array.add(i);
		}
		
		Collections.reverse(array);
		
		long preTime5 = System.nanoTime();

		quickSortFirst(array);

		System.out.println("Time taken by Quick sort (pivot is 1st #) for decreasing order: " 
								+ (System.nanoTime() - preTime5)+ " nanoseconds");
		
		array.clear();
		
		for(int i = 0; i <= 100;i++)
		{
			array.add(i);
		}
		
		Collections.reverse(array);
		
		long preTime6 = System.nanoTime();

		quickSortMedian(array);

		System.out.println("Time taken by Quick sort (median) for decreasing order: " 
								+ (System.nanoTime() - preTime6)+ " nanoseconds");
		
		array.clear();
		System.out.println();
		
		//numbers generated at random
		Random random = new Random();
				
		for(int i = 0; i <= 100;i++)
		{
			int value = random.nextInt(10000);
			array.add(value);
		}
		
		long preTime7 = System.nanoTime();

		selectionSort();

		System.out.println("Time taken by Selection sort for random numbers: " 
							+ (System.nanoTime() - preTime7)+ " nanoseconds");
		
		array.clear();
		
		for(int i = 1; i <= 100;i++)
		{
			int value = random.nextInt(10000);
			array.add(value);
		}
		
		long preTime8 = System.nanoTime();

		quickSortFirst(array);

		System.out.println("Time taken by quick sort (1st # for pivot) for random numbers: " 
							+ (System.nanoTime() - preTime8)+ " nanoseconds");
		
		array.clear();
		
		for(int i = 0; i <= 100;i++)
		{
			int value = random.nextInt(10000);
			array.add(value);
		}
		
		long preTime9 = System.nanoTime();

		quickSortMedian(array);

		System.out.println("Time taken by quick sort (median) for random numbers: " 
							+ (System.nanoTime() - preTime9)+ " nanoseconds");
		
		array.clear();
	}
}
