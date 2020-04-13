package cecs328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exam_2_PartTwo {
	
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

	
	//Deletes the root node
	public static int[] delete_root(int arr[], int n) {
		//Get Last Element
		int last_element = arr[n - 1];
		
		//Replace root with last
		arr[0] = last_element;
		
		//Decrease size of heap by 1
		n = n - 1;
		
		//Heapify root
		max_heapify(arr, 0, n);
		
		return Arrays.copyOfRange(arr, 0, n);

	}
	
	
	public static int[] merge_sort_array(int arr[][]) {
		int k = arr.length;
		int n = arr[0].length;
		
		int arr_one[] = new int[arr.length * arr[0].length];
		int arr_one_index = 0; 
		
		
		int largest_k_index = 0;
		int largest_k;
		
		while(arr_one_index < arr_one.length) {
			largest_k = -999999;
			for(int i = 0; i < k; i++) {
				if(arr[i].length > 0) {
					if(largest_k < arr[i][0]) {
						largest_k = arr[i][0];
						largest_k_index = i;
						
					}
				}
			}
			
			arr_one[arr_one_index++] = largest_k;				
			
			if(arr[largest_k_index].length >  0)
				arr[largest_k_index] = delete_root(arr[largest_k_index], arr[largest_k_index].length);
			
		}		
			
		return arr_one;
	}
		
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("How many arrays do you have: ");
		int k = console.nextInt();

		System.out.print("Size of each array: " );
		int n = console.nextInt();
		
		//Stores the descending order arrays
//		int arrays[][] = new int[k][n];
		
	
		//Example
		int arrays[][] = {{8,4,2,0}, {20,15,5,3}, {10,7,6,1}};
		
		for(int i = 0; i < k; i++) {
			System.out.println(Arrays.toString(arrays[i]));
		}
		
		//Creates an array the size of all array
		int arr_one[] = merge_sort_array(arrays);
		
		System.out.println("Array: " + Arrays.toString(arr_one));

	}
}
