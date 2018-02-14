
public class ArrayMethods3 {

	public static String[] mergeSort(String[] list)
	{
		
	}
	
	public static int partition(int[] list1, int front, int back)
	{
		front = list1[0];
		back = list1[list1.length-1];
		
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		//Base Case
		if(back > front)
		{
			int pivdex = partition(list1, front, back);
			//Left Side
			quickSort(list1, front, pivdex - 1);
			//Right Side
			quickSort(list1, pivdex + 1, back);
		}
	}
}
