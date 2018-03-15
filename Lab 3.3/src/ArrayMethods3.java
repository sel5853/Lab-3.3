import java.util.Arrays;

	/*
	 * Name: Stanley Liang
	 * Date: 3/11/18
	 * Period 2
	 */

public class ArrayMethods3 {

	public static String[] mergeSort(String[] list)
	{
		int x = list.length / 2;
		int y = list.length;
		
		if(y == 1)																	//Base case
		{
			return list;															//Returns original array
		}
		
		String[] left = Arrays.copyOfRange(list, 0, x);								//Creates new array from left side of original
		String[] right = Arrays.copyOfRange(list, x, y);							//Creates new array from right side of original
		
		return merge(mergeSort(left), mergeSort(right));							//Returns the merged left and right arrays
	}
	
	public static int partition(int[] list1, int front, int back)
	{
		int pivot = list1[front];													
		while(front < back)															//While first index < last index
		{
			while(list1[front] < pivot)												//While value of front index < value of pivot
			{
				front++;															//Move on from front b/c value is < pivot, it stays on the left
			}
			
			while(list1[back] > pivot)												//While value of back index > pivot
			{
				back--;																//Move on from back b/c value is > pivot, it stays on the right
			}
			
			if(front <= back)														//If front index <= back index
			{
				swap(list1, front, back);											//Swap the values in of the indexes
				front++;
				back--;
			}
		}
		return front;																//Returns index of the pivot
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		if(back > front)															
		{
			int pivdex = partition(list1, front, back);
			quickSort(list1, front, pivdex - 1);									//Quicksorts left side
			quickSort(list1, pivdex, back);											//Quicksorts right side
		}
	}
	
	public static void swap(int list[], int index1, int index2)						//Swap helper method
	{
		int x = list[index1];
		list[index1] = list[index2];
		list[index2] = x;
	}
	
	public static String[] merge(String[] list1, String[] list2)					//Taken from Lab 3.2
	{
		int x = 0; 																	//Used for list1[]
		int y = 0;																	//Used for list2[]
		int z = 0;																	//Used for combinedArray
		String[] combinedArray = new String[list1.length + list2.length];			//Creates new array for the sorted array
		while(x < list1.length && y < list2.length && z < combinedArray.length)		//While each index is less than their array lengths
		{			
			if(list1[x].compareTo(list2[y]) <= 0)									//If value of list1[x] is before list2[y]
			{
				combinedArray[z] = list1[x];										//The next value of combinedArray will = list1[x]
				x++;
			}
			
			else if(list1[x].compareTo(list2[y]) > 0)								//Else if list2[y] is before list1[x]
			{
				combinedArray[z] = list2[y];										//The next value of combinedArray will = list2[y]
				y++;
			}
			z++;
		}
		
		if(x == list1.length)														//If at the end of list1
		{
			for(int n = y; n < list2.length; n++)									//Loops through second array
			{
				combinedArray[z] = list2[n];										//Next value of combinedArray is going to be front the second array b/c no more values are present in the first array
				z++;
			}
		}
		
		if(y == list2.length)														//If at end of list2
		{
			for(int m = x; m < list1.length; m++)									//Loops through first array
			{
				combinedArray[z] = list1[m];										//Next value of combined array is going to be from the first array b/c no more values are present in the second array
				z++;
			}
		}
		return combinedArray;														//Returns the merged sorted array
	}
	
	public static void main(String[] args)											//Testing code for Lab 3.3
	{
		int[] intList = {6, 3, 15, 2, 1, 9, 4, 0, 3, 17, 22, 14, 3};
		String[] stringList = {"hi", "yellow", "apple", "cookie", "bye", "orange", "blue", "yellow"};
		
		long start = System.nanoTime();
		String[] mergeResult = mergeSort(stringList);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("MergeSort Test Took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		
		start = System.nanoTime();
		end = System.nanoTime();
		time = end - start;
		quickSort(intList, 0, intList.length-1);
		System.out.println("QuickSort Test Took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(intList));
	}
}
