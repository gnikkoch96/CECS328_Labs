package cecs328;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab_Four {
	/* Lab 4: Find the K elements that are closest to the median
	 * by Nikko Chan (CECS 328)
	 */
	
	//Implementing Quick_Select and Partition
	public static int partition_norm(int arr[], int low, int high) {
		int pivLoc = low;
		
		//Used for Comparisons
		int pivot = arr[high];
		
		for(int i = low; i <= high; i++) {
			//Loops through current Partition
			
			if(arr[i] < pivot) {					//Moves values less than pivot to the left side
				
				//Swap
				int temp = arr[i];
				arr[i] = arr[pivLoc];
				arr[pivLoc] = temp;
				
				pivLoc++;
			}
		}
		
		//Swap current Pivot with the Value in arr[pivLoc]
		int temp = arr[high];
		arr[high] = arr[pivLoc];
		arr[pivLoc] = temp;
		

		return pivLoc;
	}
	
	public static int partition_abs(int diff[], int low, int high) {
		//Partioning Array using Absolute Value
		int pivot = diff[high];
		int pivLoc = low;
		
		for(int i = low; i <= high; i++) {
			if(Math.abs(diff[i]) < Math.abs(pivot)) {
				
				int temp = diff[i];
				diff[i] = diff[pivLoc];
				diff[pivLoc] = temp;
				
				pivLoc++;
			}
		}
		
		int temp = diff[high];
		diff[high] = diff[pivLoc];
		diff[pivLoc] = temp;
		
		return pivLoc;
		
	}
	
	public static int quick_select(int arr[], int low, int high, int k, boolean isNorm) {
		int partitionIndex;
		if(isNorm)
			//Normal Partition
			partitionIndex = partition_norm(arr, low, high);
		else
			//Partitioning with absolute values
			partitionIndex = partition_abs(arr, low, high);
		
		
		if(partitionIndex == k)
			return arr[partitionIndex];
		else if(partitionIndex < k)										
			//Means that the value is going to be on the right side of current partition
			return quick_select(arr, partitionIndex + 1, high, k, isNorm);
		else											
			//Means that the value is going to be on the left side of current partition
			return quick_select(arr, low, partitionIndex - 1, k, isNorm);	
	}
	
	public static void generateArray(int arr[], int max, int min) {				//Stores Random Values with Range Max and Min into Array	
		Random rand = new Random();									
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = rand.nextInt(max - min) + min;
		}	
	}
	
	public static void storeDiff(int diff[], int arr[], int median) {			//Stores the difference of elements between the arr[] and median to diff[]
		//Time Complexity is O(n)
		for(int i = 0; i < diff.length; i++) {
			diff[i] = arr[i] - median;
 		}
	}
	
	public static void main(String[] args) {
		//Utilities
		Scanner console = new Scanner(System.in);
		
		//User inputs size
		System.out.print("Enter n: " ); 
		int n = console.nextInt();
		
		//User inputs k
		System.out.print("Enter k: ");
		int k = console.nextInt();
	
		//Generate Array
		int arr[] = new int[n]; 
		generateArray(arr, 100, -100);
	
		//Use Quick_Select to find Median
		int median = quick_select(arr, 0, n - 1, (n-1)/2, true);
		
		//Find difference
		int diff[] = new int[n];
		storeDiff(diff, arr, median);

		//Swapping median to be in the end of the array
		int temp = diff[(n-1)/2];
		diff[(n-1)/2] = diff[n - 1];
		diff[n - 1] = temp;

		quick_select(diff, 0, n - 1, k + 1, false);
		
		int ans[] = new int[k];
		for(int i = 1; i <= k; i++) {
			ans[i - 1] = diff[i] + median;
		}
		
		System.out.println("The closest " + k + " elements to " + median + " => " + Arrays.toString(ans));
		
		//Check Answer
		System.out.println("\nCheck Answer: ");
		Arrays.parallelSort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
