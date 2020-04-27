package cecs328;

import java.util.Arrays;

public class Lab_Six {
	
	//Implementing Quicksort Algorithm (Ascending Order)
	public static int partition(int arr[], int low, int high) 
	{ 
		
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element
		
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than the pivot 
			if (arr[j] < pivot) 
			{ 
				i++; 
				System.out.println("i = " + i);
				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 	
			} 			
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 
		return i+1; 
	} 

	
	public static void quick_sort(int arr[], int low, int high, int order)		//order 1 - Ascending, 2 - Descending 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			
			int pi = partition(arr, low, high); 
			
			// Recursively sort elements before 
			quick_sort(arr, low, pi-1, order);
			quick_sort(arr, pi+1, high, order); 
		} else if(order == 2) {
			//reverse array
			for(int i = 0; i < arr.length/2; i++) {
				int temp = arr[arr.length - 1 - i];
				arr[arr.length - 1 - i] = arr[i];
				arr[i] = temp;
			}
		}
	} 
	
	public static int find_min(int var1, int var2, int var3) {
		//Returns the minimum value of the three variables
		int min = var1;
		
		if(var1 < min)
			min = var1;
		
		if(var2 < min)
			min = var2;
		
		if(var3 < min)
			min = var3;
		
		return min;
	}
	
	public static int mpss_middle(int arr[], int min, int max) {
		//Create mid index
		int mid = (max + min)/2;
		System.out.println("Mid: " + mid);
		System.out.println("Max: " + max);
		//Split the array in to 2 (Come back to change the size of each array)
		int arr_left[];
		int arr_right[];
		
		if(mid != 0) {
			arr_left = Arrays.copyOfRange(arr, min, mid + 1);
			
//			if((mid + 1) != max)
				arr_right = Arrays.copyOfRange(arr, mid, max);
//			else
//				arr_right = new int[1];
			
		}else {
			arr_left = new int[1];
		    arr_right = new int[1];
		}

		
		//Store arr_left
		for(int i = 0; i < arr_left.length; i++) {
			arr_left[i] = arr[i];
		}
		
		//Stores arr right
		for(int i = 0; i < arr_right.length; i++) {
			arr_right[i] = arr[mid + i + 1];
		}
		
		//Store left sums 
		int sums_left[] = new int[arr_left.length];
		System.out.println("Sums Left: "  + sums_left.length);
		System.out.println("Arr Left: " + arr_left.length);
		for(int i = arr_left.length - 1; i >=0; i--) {
			
			if(i != arr_left.length - 1)
				sums_left[i] = arr_left[i] + sums_left[i + 1];
			else {
				sums_left[i] = arr_left[i];
			}
		}
		
		//Store right sums
		int sums_right[] = new int[arr_right.length];
		System.out.println("Sums Right: "  + sums_right.length);
		System.out.println("Arr Right: " + arr_right.length);
		for(int i = 0 ; i < arr_right.length; i++) {
			if(i > 0)
				sums_right[i] = arr_right[i] + sums_right[i - 1];
			else
				sums_right[i] = arr_right[i];
		}
		

		//Quicksort sums_left and sums_right by their respective ascending and descending order
		quick_sort(sums_left, 0, sums_left.length - 1, 1);
		quick_sort(sums_right, 0, sums_right.length -1, 2);
		
		
		//Marker for sums_left
		int sl_mark = 0;
		
		//Marker for sums_right
		int sr_mark = sums_right.length - 1;
		
		//Finding the smallest smin value
		int s_min = 1000000000;			 //Dummy value to have a large #
		
		System.out.println("Arr_Left: " + Arrays.toString(arr_left));
		System.out.println("Sums_Left: " + Arrays.toString(sums_left));
		
		System.out.println("Arr_Right: " + Arrays.toString(arr_right));
		System.out.println("Sums_Right: " + Arrays.toString(sums_right));
		

		while(sl_mark < sums_left.length && sr_mark >= 0) {
			
			int s = sums_left[sl_mark] + sums_right[sr_mark];
			
			if(s <= 0)
				sl_mark++;
			else if(s < s_min) {
				s_min = s;
				sr_mark--;
			}
			else
				sr_mark--;
		}
		
		return s_min;
		
	}
	
	
	public static int mpss(int arr[], int min, int max) {
		//Adjust the mid value
		int mid = (max + min)/2;
		
		
		//Base Case
		if(min == max) {
			//If the value is positive, then return it as is
			if(arr[min] >= 0)					
				return arr[min];
			else	//If the value is negative, then return infinity (we don't want to add any negatives)
				return 1000000;
		}
		
		//Finds the smallest positive sum on the left side

		int mpss_left = mpss(arr, min, mid);	
		System.out.println("MPSS_LEFT: " + mpss_left);
		System.out.println("mpss mid: " + mid);
		//Finds the smallest positive sum on the right side
		int mpss_right = mpss(arr, mid + 1, max);
		System.out.println("MPSS_RIGHT: " + mpss_right);

		//Find the smallest positive sum in the middle
		int mpss_mid = mpss_middle(arr, min, max);
		System.out.println("MPSS_MID: " + mpss_mid);
		
//		//Try to look for the min on the left side
//		int sum_left = 0;
//		for(int i = 0; i < mid - 1; i++) {
//			sum_left += arr[i];
//			if(sum_left < mpss_left)
//				mpss_left = sum_left;
//		}
//		
//		//Tries to look for the min on the right side
//		int sum_right = 0;
//		for(int i = mid; i > 0; i--) {
//			sum_right += arr[i];
//			if(sum_right < mpss_right)
//				mpss_right = sum_right;
//		}
		
		return find_min(mpss_left, mpss_right, mpss_mid);
	}
		
		
	
	public static void main(String[] args) {
		int arr[] = new int[] {-34, 49, -58, 76, 29, -71, -54, 63};
//		int arr[] = new int[] {44,1,6,8,12,13};
//		int arr[] = new int[] {4,2,-6,1,-7};
		
		System.out.println("Finding the Minimum Positive Sub-Sequence Sum....");
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("MPSS: " + mpss(arr, 0, arr.length - 1));
	}
}
