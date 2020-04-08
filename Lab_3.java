package cecs328;

import java.util.Arrays;

public class Lab_3 {
	//Goal of the QuickSelect: Find the right index of the pivot
//	
//	public static int partition(int arr[], int low, int high){
//		//Stores the index of the lowest
//		int numIndex = low;
//		
//		//Stores the last index as the pivot
//		int pivot = arr[high];
//		
//		//Used to switch the pivot once in the array 
//		Boolean occursOnce = false;
//		
//		//Used to count how many times the pivot needs to switch to be placed properly
//		int count = 0;
//		
//		//Exit Statement
//		int i = 0;
//		
//		while (i < high) {
//			
//			//If the pivot value is less than arr[i] then swap them out. Then let the program know that the pivot has been swapped (with occursOnce Boolean var)
//			if(pivot < arr[i] && !occursOnce) {
//				//Swap
//				int temp = pivot;
//				pivot = arr[i];
//				arr[i] = pivot;
//				
//				//
//				count++;
//				occursOnce = true;
//			}
//			
//			if(pivot > arr[i] && occursOnce)
//				count++;
//			i++;
//		}
//		
//		//Swap again
//		int temp = pivot;
//		pivot = arr[count];
//		arr[count] = pivot;
//		
//		return count;
//		
//	}
	
	
	
	public static int partition(int arr[], int low, int high){
		//Stores values that are less than pivot
		int numArr[] = Arrays.copyOf(arr, high);
		
		//Stores the index of values less than pivot
		int indArr[] = Arrays.copyOf(arr, high);
		
		int pivIndex = high;
		
		int pivot = arr[high];
		Boolean occursOnce = false;
		
		int count = 0;
		int i = 0;


		while (i < high) {
			if(pivot < arr[i] && !occursOnce) {
				//Swap
				int temp = pivot;
				pivot = arr[i];
				arr[i] = pivot;
				
				pivIndex = i;
				occursOnce = true;
			}
			
			if(pivot > arr[i] && occursOnce) {
				count++;
			}
			i++;
		}
		
		//Swap again
		if(occursOnce) {
			for(int j = 0; i < count; j++) {
				int temp = arr[pivIndex];
				arr[pivIndex] = arr[pivIndex + j + 1];
				arr[pivIndex + j + 1] = temp;
				
				pivIndex++;
			}

			
			return pivIndex;
		}
	
	
}
