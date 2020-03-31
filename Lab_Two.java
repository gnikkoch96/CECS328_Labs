package cecs328;

import java.util.Arrays;
import java.util.Scanner;

public class Lab_Two {
	/*
	 * 1. Running time for all algorithms used should be O(log(n))
	 * For an algorithm to be of log(n), the size of the list to be used be decreasing by 2^k (where k is the # of iterations)
	 * Returns upperbound (so round up)
	 */
	
	//Question One
	public static double squareRoot(int n, double min, double max) {
		//n = Entered Number, min = to search lower half, max = to search upper half (where n is the max number)
		
		double mid = (max + min)/2;
		
		//Performing calculations 
		while(Math.ceil(mid * mid) != n) {
			if(mid * mid < n) {						//Value is not located in the lower half
				min =  mid;
			}else {	//mid * mid > n					Value is not located in the upper half
				max =  mid;
			}
					
			mid = (max + min)/2;
		}
		
		return  Math.ceil(mid);						//Returns Upper Bound
	}
	
	//Question Two
	public static int findSmallMissInt(int arr[], int min, int max, int m) {
		
		//0 is missing
		if(arr[0] != 0)
			return 0;
		
	   int mid = (max - min)/2;
		
	   while(true) {
		int prevMid = mid;							//Used to check if the values are repeating, if so then break from loop and the answer will be mid
		if(arr[mid] == mid) {						//Left spectrum is not missing any numbers, so we need to check the other half
			min = mid + 1;							//Since we know that arr[mid] == mid, then we can ignore this value and make min the value following mid (i.e. mid + 1)
		}else if (arr[mid] != mid) {				//Left spectrum is missing a number, so we need to check left
			max = mid;
		}
		mid = (max + min)/2;						//Updates Mid
	
		if(prevMid == mid || min == max)			//prevMid == mid if the answer keeps repeating itself then the value of mid is the missing index
			break;									//If min == max then it means that all the values are there except the max value
		
	   }
	   
		return mid;
		
	}
	
	public static void main(String[] args) {
		//Question One
		Scanner console = new Scanner(System.in);
		
		System.out.println("Question 1======================================");
		System.out.print("Enter Number: ");
		int n = console.nextInt();
		System.out.println("Square Root of " + n + " = " + squareRoot(n, 0, n));
		
		System.out.println("\nQuestion 2======================================");
		System.out.print("Enter a size: ");
		int n2 = console.nextInt();
		System.out.print("Enter a m: " );
		int m = console.nextInt();
		
		int arr[] = new int[n2];
		
		//Storing values in the array
		for(int i = 0 ; i < n2; i++) {
			System.out.print("Arr[" + i + "]: ");
			arr[i] = console.nextInt();
		}
		
	
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("The smallest integer missing is: " + findSmallMissInt(arr, 0, n2, m));
		
		
	}
}
