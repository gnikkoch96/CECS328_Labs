package cecs328;

import java.util.Random;
import java.util.Scanner;

public class Lab_One {
	
	//Implementing Linear Search Algorithm
	public static int linearSearch(int arr[], int x) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(arr[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	
	//Implementing Binary Search Algorithm
	public static int binarySearch(int arr[], int size, int key) {
		int low = 0;
		int high = size - 1;
		
		while(high >= low) {
			int middle = (low + high)/2;
			if(arr[middle] == key) {
				return middle;
			}
			
			if(arr[middle] < key) {
				low = middle + 1;
			}
			
			if(arr[middle] > key) {
				high = middle - 1;
			}
		}
		
		return -1;
	}
	
	
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
	
	
	public static void partA() {
		//Part A
		
		//1. Request the User to enter a postive integer
		Scanner console = new Scanner(System.in);
		System.out.print("Enter Array Size: ");
		int n = console.nextInt(); 													//User Types: 10^5
		
		//2. Generate n random integers between -1000 to 1000 and save them in array a
		int a[] = new int[n];
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			a[i] = rand.nextInt(1000 + 1000) - 1000;								//Range -1000 to 1000
		}
		
		//3. Sort Array
		selectSort(a);
		
		//Starting Time
		double startTime = System.nanoTime();
		
		//Executes Step 4 and 5 100 Times
		for(int i = 0; i < 100; i++) {
			//4.Pick a random number in array and save it in a variable called key
			int key = a[rand.nextInt(n - 1)];
			System.out.println("\nKey = " + key);
			
			//5. Call each function separately to search for the key in the given array (Comment out the Algorithm that you aren't using)
			System.out.println("==============Linear Search==============");
			System.out.println("Index = " + linearSearch(a, key));
			
//			System.out.println("==============Binary Search==============");
//			System.out.println("Index = " + binarySearch(a, n, key));	
		}
		
		//Ending Time
		double endTime = System.nanoTime();
		
		double elapsedTime = (endTime - startTime)/10000000;
		
		//Output Elapsed Time
		System.out.println("Elasped Time (Per Run): " + elapsedTime/100 + " Seconds");
		
		
	}
	
	
	public static void partB() {
		//Part B
		//1. Request the User to enter a postive integer
		Scanner console = new Scanner(System.in);
		System.out.print("Enter Array Size: ");
		int n = console.nextInt(); 													//User Types: 10^5
		
		//2. Generate n random integers between -1000 to 1000 and save them in array a
		int a[] = new int[n];
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			a[i] = rand.nextInt(1000 + 1000) - 1000;								//Range -1000 to 1000
		}
		
		//3. Sort Array
		selectSort(a);
		
		//4. Set the Value of Key to 5000
		int key = 5000;
		

		//5. Execute the Search Algorithm Once (Comment out the Algorithm that you aren't using) when n = 10^5
		double startTime = System.nanoTime();
//		System.out.println("==============Linear Search==============");
//		System.out.println("Index = " + linearSearch(a, key));
		
		System.out.println("==============Binary Search==============");
		System.out.println("Index = " + binarySearch(a, n, key));	
		
		double endTime = System.nanoTime();
		
		double elapsedTime = (endTime - startTime)/10000000;
		
		//6.Calculate the time it takes to run one single line of code (Binary Search is O(log(n)) and Linear Search is O(n))
		
		//Linear Search
//		double execTime = elapsedTime/n;
				
		//Binary Search
		double execTime = elapsedTime/Math.log(n);
		
		System.out.println("Execution Time for One Single Line: " + execTime + " Seconds");
		
		//7. Using execTime, estimate Worst-Case Running Time for each algorithm when n = 10^15
		n = (int) Math.pow(10, 15);
		
		//Linear Search
//		double estimation = n * execTime;
		
		//Binary Search
		double estimation = Math.log(n) * execTime;
		
		System.out.println("(n = 10^15) Estimation: " + estimation + " Seconds");
		
		
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Choose Part: \n1.Part A\n2.Part B\nChoice: ");
		int choice = console.nextInt();
		
		if(choice == 1) {
			partA();
		}else {
			partB();
		}
	}
}
