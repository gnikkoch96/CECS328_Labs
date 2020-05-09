package cecs328;

import java.util.Arrays;
import java.util.Queue;

public class Dijkstra_Algorithm_Test {
	
	//Node Object
	static class Node{
			public Node() {}
			
			//Overloaded Constructor
			public Node(String name) {
				this.name = name;
			}
	
			//Name of Node
			public String name;
			
			//Parent Node
			public Node parent;
			
			//Distance
			public int dst;
			
			//Weight
			public int weight;
			
			//List of Adjacent Nodes
			public Node adj[];
									
			public boolean hasParent() {
				if(parent != null)
					return true;
				else
					return false;
			}	
	}
	
	//build_min_heap (Big O(nlogn))
	public static void build_min_heap(int arr[]) {
		int n = arr.length - 1;
		for(int i = n; i >= 0; i--) {		
			min_heapify(arr, i, n + 1);
		}
	}
	
	//Implementing Min Heapify
	public static void min_heapify(int arr[], int i, int size) {
		
		//Storing the Left and Right Indexes (Simulate the Binary Tree)
		int left_index = (2 * i) + 1;
		int right_index = (2 * i) + 2;
		int min_index = i;
		
		//There is no need to check if the current index is smaller than the left index
		if(left_index < size  && arr[min_index] > arr[left_index]) {
			//No Right Node
			if(right_index >= size)
				min_index = left_index;
			
			//Check if Left Index Contains the Smaller Value
			else if(arr[left_index] < arr[right_index])
				min_index = left_index;
		}
		
		
		//There is no need to check if the current index is smaller than the right index
		if(right_index < size && arr[min_index] > arr[right_index]) {
			//No Left Node
			if(left_index >= size)
				min_index = right_index;
			
			//Check if Right Index Contains the Smaller Value
			else if(arr[right_index] < arr[left_index])
				min_index = right_index;
		}
		
		//Don't perform swap if the current node is already in min-heap
		if(min_index != i) {
			//Swap
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;

			//Recursive Call to Check if Current Index in Max_index is also in max-heap
			min_heapify(arr, min_index, size);		
		}	
	}
	
	public static void dijkstra_algo(Node v, Node V[]) {
		//Set the parent
		v.dst = 0;
		v.parent = v;
		
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
