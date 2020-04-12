package cecs328;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_2_PartB {

		
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
		
		//Creates an array the size of all array
		int arr_one[] = new int[k * arrays[0].length];
	
		/*
		 * The largest # are the internal nodes which can be found @ n/2 lower bound
		 *
		 */
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				arr_one[]
			}
		}
		
	}
}
