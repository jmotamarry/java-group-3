import java.util.*;

public class SearchAlgorithm{
	public static void main (String[] args)
	{
		int[] arr;

		for (int i = 1; i <= 30000000; i += 100000) {
			arr = generateArray(i);
			double startTime = System.nanoTime();
			// linearSearch(arr, -1);
			binarySearch(arr, -1);
			// binarySearchR(arr, -1, 0, arr.length);
			double endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			System.out.print("(" + i + "," + totalTime + "),");
		}
	}

	public static int[] generateArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			// arr[i] = (int) (100000000 * Math.random());
			arr[i] = i;
		}
		// Arrays.sort(arr);
		return arr;
	}

    // linear search 
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
	
	
	// recursive binary search
	public static int binarySearchR(int[] arr, int target, int low, int high)
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
			 return binarySearchR(arr, target, mid+1, high);
		}
		else {
			 return binarySearchR(arr, target, low, mid-1);
		}
		
	}
	
    // binary search 
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

