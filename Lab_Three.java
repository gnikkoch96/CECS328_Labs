package cecs328;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab_Three {
	/*
	 *  Part A:
	 *  1. Implement a Quick_Select Method to find the kth smallest element in an array
	 *  2. The Running time should be O(n) - Worst Case
	 *  3. Hint: Use Partitioning Algorithm
	 */
	
	public static int partition(int arr[], int low, int high) {
		//Takes the Most Left Index of Current Partition
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
	
//	public static int partition(int arr[], int low, int high) {
//		//Pivot 
//		int pivot = arr[high - 1];
//		int i = high;
//		if(high - 2 >= 0) {
//			if((arr[high - 2]) > pivot) {
//				int temp = arr[high - 2];
//				arr[high - 2] = pivot;
//				pivot = temp;
//				i--;
//			}
//		}
//		
//		return i - 1;
//	}
	
	
	public static int quick_select_small(int arr[], int low, int high, int k) {
		//Question: So we keep sorting only the left side recursively instead of both like in quick sort?
		
		int partitionIndex = partition(arr, low, high);
		
		if(partitionIndex == k)
			return arr[partitionIndex];
		else if(partitionIndex < k)						//Means that the value is going to be on the right side of current partition
			return quick_select_small(arr, partitionIndex + 1, high, k);
		else											//Means that the value is going to be on the left side of current partition
			return quick_select_small(arr, low, partitionIndex - 1, k);
		
		
	}
	
	/*	Part B
	 *  1. Same as above, but instead of finding the the kth smallest, we are trying to find the kth largest
	 */
	public static int[] quick_select_large(int arr[], int low, int high, int k) {
		//Example: The fifth largest from a size of 15 would be in the 9th Index (Adjusted to Computer Indexing), so
		
		int partitionIndex = partition(arr, low, high);
		
		//Adjust the value of the K to give proper comparison...
		int adjustK = arr.length - 1 - k;
		
		if(partitionIndex == adjustK) {
			return Arrays.copyOfRange(arr, adjustK, arr.length);	
		}
		
		else if (partitionIndex < adjustK) 													//Check Right 
			return quick_select_large(arr, partitionIndex + 1, high, k);
		else																				//Check Left
			return quick_select_large(arr, low, partitionIndex - 1, k);
			
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		
		//Part A
		
		//Generating Array
		System.out.println("Quick Select: Find the kth Smallest Element!");
		System.out.print("Enter Array Size: ");
		int n = console.nextInt();
		int arr[] = new int[n];

		int max = 100, min = -100;
		
		for(int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(max - min) + min;
		}
		System.out.println("Generating Array....\n");
		System.out.println(Arrays.toString(arr));
		
		
		//User inputs Kth Smallest Value to Search in Array
		System.out.print("Enter kth value: ");
		int k = console.nextInt();
		
		int value = quick_select_small(arr, 0, n - 1, k - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println("kth smallest element is: " + value);
		
		//Used to Check Answer
		System.out.println("\n(Debug) Check Answer: ");
		Arrays.parallelSort(arr);
		System.out.println(Arrays.toString(arr));
		
		//Part B
		
		//Generating Array
		System.out.println("\nQuick Select: Find the kth Largest Element!");
		System.out.print("Enter Array Size: ");
		int n2 = console.nextInt();
		int arr2[] = new int[n2];
		
		for(int i = 0; i < n2; i++) {
			arr2[i] = rand.nextInt(max - min) + min;
		}
		System.out.println("Generating Array....\n");
		System.out.println(Arrays.toString(arr2));
		
		
		//User inputs Kth Smallest Value to Search in Array
		System.out.print("Enter kth value: ");
		int k2 = console.nextInt();
		
		int maxValues[] = quick_select_large(arr2, 0, n2 - 1, k2 - 1);
		
		System.out.println("kth largest elements are: " + Arrays.toString(maxValues));
		
		//Used to Check Answer
		System.out.println("\n(Debug) Check Answer: ");
		Arrays.parallelSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}
