
public class ArrayMethods3 {

	public static String[] mergeSort(String[] list)
	{
		int x = list.length / 2;
		
	}
	
	public static int partition(int[] list1, int front, int back)
	{
		front = list1[0];
		back = list1[list1.length-1];
		int a = 0;
		int pivot = 0;
		for(int x = 0; x < list1.length; x++)
		{
			if(list1[x] <= front)
			{
				a = list1[x];
			}
		}
		return pivot;
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
	
	public static void swap(int list[], int index1, int index2)
	{
		int x = list[index1];
		list[index1] = list[index2];
		list[index2] = x;
	}
	
	public static void main(String[] args)
	{
		
	}
}
