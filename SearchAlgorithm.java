import java.util.*;

public class SearchAlgorithm{
	public static void main (String[] args)
	{
		int[] arr = {0,1,2,3,4,5,6,7};
		System.out.println(binarySearch(arr,2));
		
	}

    //linear search 
	public static int linearSearch(int[] arr, int target)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == target)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
	//recursive way 
	public static int binarySearch1(int[] arr, int target, int low, int high)
	{
		
		int mid = (low + high)/2;
		if(low > high)
		{
			return -1;
		}
		if (arr[mid] == target){
			return mid;	
		}
		else if(arr[mid] < target){
			 return binarySearch1(arr, target, mid+1, high);
		}
		else {
			 return binarySearch1(arr, target, low, mid-1);
		}
		
	}
	
    //binary search 
	public static int binarySearch(int [] numbers, int target) {
		   int mid = 0;
		   int low = 0;
		   int high = numbers.length - 1;
		   
		   while (high >= low) 
		   {
		      mid = (high + low) / 2;
		      if (numbers[mid] < target) {
		         low = mid + 1;
		      }
		      else if (numbers[mid] > target) {
		         high = mid - 1;
		      }
		      else {
		         return mid;
		      }
		   }
		   
		   return -1; 
		}
	

}

