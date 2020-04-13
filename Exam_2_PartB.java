package cecs328;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_2_PartB {
	//build_maxheap
		public static void build_maxheap(int arr[]) {
			int n = arr.length;
			for(int i = n/2; i >= 0; i--) {		
				max_heapify(arr, i, n);

			}
		}
		
		public static void max_heapify(int arr[], int i, int size) {
			
			//Storing the Left and Right Indexes (Simulate the Binary Tree)
			int left_index = (2 * i) + 1;
			int right_index = (2 * i) + 2;
			int max_index = i;
			
			//There is no need to check if the current index is greater than the left index
			if(left_index < size  && arr[max_index] < arr[left_index]) {
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
			if(max_index != i) {
				//Swap
				
				int temp = arr[max_index];
				arr[max_index] = arr[i];
				arr[i] = temp;

				//Recursive Call to Check if Current Index in Max_index is also in max-heap
				max_heapify(arr, max_index, size);
				
			}	
		}
		

		public static void heap_sort(int arr[]) {
			//Build 
			build_maxheap(arr);
			
			int n = arr.length - 1;
			for(int i = n; i >= 0; i--) {
				//swap a[0] with last element
				int temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				
				//max-Heapify
				max_heapify(arr, 0, i);
			}

		}
		
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("How many arrays do you have: ");
		int k = console.nextInt();

		System.out.print("Size of each array: " );
		int n = console.nextInt();
			
		//Example
		int arrays[][] = {{8,4,2,0}, {20,15,5,3}, {10,7,6,1}};
		
		int arr_one[] = new int[k * n];
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				arr_one[i * n + j] = arrays[i][j];
			}
		}
		
		heap_sort(arr_one);
		
		System.out.println("Array: " + Arrays.toString(arr_one));
		
	}
}
