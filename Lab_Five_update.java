package cecs328;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab_Five {
	
	//Selection Sort Algorithm
		public static void selectSort(int arr[]) {
			int n = arr.length;
			
			for(int i = 0; i < n - 1; i++) {
				int min_index = i;
				for(int j = i + 1; j < n; j++) {
					if(arr[j] < arr[min_index])
						min_index = j;
				}
				
				//Swap
				int temp = arr[min_index];
				arr[min_index] = arr[i];
				arr[i] = temp;
			}
		}
		
	//build_maxheap
	public static void build_maxheap(int arr[]) {
		int n = arr.length;
		for(int i = n/2; i >= 0; i--) {		
			max_heapify(arr, i, n);
			System.out.println("i = " + i + "\n" + Arrays.toString(arr));
//			System.out.println("i = " + i + "\nn = " + n);
//			System.out.println(Arrays.toString(arr));
//			System.out.println();

		}
		System.out.println("\nFinish Build: " + Arrays.toString(arr) + "\n");
	}
	
	/*
	 *  arr[] - array to max_heapify
	 *  i - 
	 *  n - range of focus of the array
	 */
	public static void max_heapify(int arr[], int i, int size) {
		
		//Storing the Left and Right Indexes (Simulate the Binary Tree)
		int left_index = (2 * i) + 1;
		int right_index = (2 * i) + 2;
		int max_index = i;
		
		System.out.println("Index i = " + i + "\nleft_index = " + left_index + "\nright_index = " + right_index + "\nmax_index = " + max_index + "\nSize = " + size);
		System.out.println();
		
		if(left_index < size)
			System.out.println("Left Index = " + arr[left_index]);
		
		if(right_index < size)
			System.out.println("Right Index = " + arr[right_index]);
		
		System.out.println("Max Index = " + arr[max_index]);
		
		//There is no need to check if the current index is greater than the left index
		if(left_index < size  && arr[max_index] < arr[left_index]) {
			System.out.println(arr[max_index] + " > " + arr[left_index]);
			//No Right Node
			if(right_index >= size)
				max_index = left_index;
		
			//Check if Left Index Contains the Higher Value
			else if(arr[left_index] > arr[right_index])
				max_index = left_index;
		}
		
		
		//There is no need to check if the current index is greater than the right index
		if(right_index < size && arr[max_index] < arr[right_index]) {
			//No Left Node
			if(left_index >= size)
				max_index = right_index;
			
			//Check if Right Index Contains the Higher Value
			else if(arr[right_index] > arr[left_index])
				max_index = right_index;
		}
		
		//Don't perform swap if the current node is already in max-heap
		System.out.println(max_index + " != " + i + "?");
		if(max_index != i) {
			//Swap
			System.out.println("Swapping: " + arr[max_index] + " <-> " + arr[i]);
			
			int temp = arr[max_index];
			arr[max_index] = arr[i];
			arr[i] = temp;

			//Recursive Call to Check if Current Index in Max_index is also in max-heap
			max_heapify(arr, max_index, size);
			
		}	
	}
	
	/*
	 * arr[] - array to sort 
	 */
	public static void heap_sort(int arr[]) {
		//Build 
		build_maxheap(arr);
//		System.out.println("End Build-MaxHeap===========");
		
		int n = arr.length - 1;
		for(int i = n; i >= 0; i--) {
			//swap a[0] with last element
//			System.out.println("Array(Before Swapping): " + Arrays.toString(arr));
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
//			System.out.println("Array(After Swapping): " + Arrays.toString(arr));

			//max-Heapify
			max_heapify(arr, 0, i);
		}

	}
	
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Part A=====================");
		//Ask User for Array Size
		System.out.print("Enter n: ");
		int n = console.nextInt();
		
		//Range of Random
		int max = 100, min = -100;
		
		System.out.print("Choose Sorting Algorithm: \n1.Heap_Sort\n2.Selection_Sort\nChoice: ");
		int choice = console.nextInt();
		
		//Generate Array
		int arr[] = new int[n];
		double startTime = System.currentTimeMillis();
		
		for(int j = 0; j < 100; j++) {
			//Generate Array
			for(int i = 0; i < n; i++) {
				arr[i] = rand.nextInt(max - min) + min;
			}
			
			//(Debug) Display Array Before Sort
//			System.out.println("Before Sort: \n" + Arrays.toString(arr));
			
			//Sort Array using Heap_Sort/Selection Sort
			if(choice == 1)
				heap_sort(arr);
			else
				selectSort(arr);
			
			
			//(Debug) Display Array After Sort
//			System.out.println("After Sort: \n" + Arrays.toString(arr));
		}
		
		double endTime = System.currentTimeMillis();
		double elaspedTime = endTime - startTime;
		System.out.println("\nAverage Running Time = " + elaspedTime + "ms");
		
		
		System.out.println("\nPart B=====================");
		int sizeArr2 = 10;
		int arr2[] = new int[] {-86, -52, -79, -98,-22,50};
//		
//		for(int i = 0; i < sizeArr2; i++) {
//			arr2[i] = rand.nextInt(max - min) + min;
//		}
//		
		System.out.println("Before Sort: \n" + Arrays.toString(arr2));
		heap_sort(arr2);
		System.out.println("\nAfter Sort: \n" + Arrays.toString(arr2));
		
	}
}
