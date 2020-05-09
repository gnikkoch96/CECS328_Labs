package cecs328;

import java.util.Arrays;
import java.util.LinkedList;
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
						
			//List of Adjacent Nodes
			public Node adj[];
							
			//Weight
			public int weight[];
			
			//Distance
			public int dst;
			
			public boolean hasParent() {
				if(parent != null)
					return true;
				else
					return false;
			}	
	}
	
	//build_min_heap (Big O(nlogn))
	public static void build_min_heap(LinkedList<Node> arr, int weight[]) {
		int n = arr.size() - 1;
		for(int i = n; i >= 0; i--) {		
			min_heapify(arr, weight, i, n + 1);
		}
	}
	
	//Implementing Min Heapify
	public static void min_heapify(LinkedList<Node> arr, int weight[], int i, int size) {
		//Node arr[] is for swapping
		//int weight[] is for comparing the weights of the nodes
		
		//Storing the Left and Right Indexes (Simulate the Binary Tree)
		int left_index = (2 * i) + 1;
		int right_index = (2 * i) + 2;
		int min_index = i;
		
		//There is no need to check if the current min index has a smaller weight than the left index
		if(left_index < size  && weight[min_index] > weight[left_index]) {
			//No Right Node
			if(right_index >= size)
				min_index = left_index;
			
			//Check if Left Index Contains the Smaller Value
			else if(weight[left_index] < weight[right_index])
				min_index = left_index;
		}
		
		
		//There is no need to check if the current index is smaller than the right index
		if(right_index < size && weight[min_index] > weight[right_index]) {
			//No Left Node
			if(left_index >= size)
				min_index = right_index;
			
			//Check if Right Index Contains the Smaller Value
			else if(weight[left_index] > weight[right_index])
				min_index = right_index;
		}
		
		//Don't perform swap if the current node is already in min-heap
		if(min_index != i) {
			//Swap Node Array
			Node temp = arr.get(min_index);
			arr.set(min_index, arr.get(i));
			arr.set(i, temp);

			//Swap Weight Array
			int tempInt = weight[min_index];
			weight[min_index] = weight[i];
			weight[i] = tempInt;

			//Recursive Call to Check if Current Index in Max_index is also in max-heap
			min_heapify(arr, weight, min_index, size);		
		}	
	}
	
	public static int getWeight(LinkedList<Node> V, int start, int end) {
		return V.get(start).weight[end];
	}
	
	public static void dijkstra_algo(Node v, LinkedList<Node> V) {
		//Set the parent
		v.dst = 0;
		v.parent = v;
		
		//V[0] = 'a'
		build_min_heap(V, V.get(0).weight);
		
		
		for(int i = 0; i < V.size(); i++) {
			Node next = V.get(i);
			System.out.println("i : " + i + ": " + next.name);
			//Work on this when you come back
			for(Node n:next.adj) {
				int weight = getWeight(V, V.indexOf(next),V.indexOf(n));
				if(weight + next.dst < n.dst) {
					V.get(V.indexOf(n)).parent = next;
					n.dst = next.dst + weight;
					build_min_heap(V, V.get(0).weight);
				}
			}
	
		}
		
	}
	
	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		
		LinkedList<Node> graph = new LinkedList<Node>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		graph.add(h);

		
		a.adj = new Node[] {c,b,d};
		b.adj = new Node[] {a,c,e};
		c.adj = new Node[] {a,b,f,g};
		d.adj = new Node[] {a,e};
		e.adj = new Node[] {d,b};
		f.adj = new Node[] {b,c,g};
		g.adj = new Node[] {c,f,h};
		h.adj = new Node[] {g};
		
		//Add the weights of each node		
		a.weight = new int[] {0, 15, 2, 3, 0, 0, 0, 0};
		b.weight = new int[] {15, 0, 8, 0, 2, 0, 0, 0};
		c.weight = new int[] {2, 8, 0, 0, 0, 7, 5, 0};
		d.weight = new int[] {3, 0, 0, 0, 1, 0, 0, 0};
		e.weight = new int[] {0, 2, 0, 1, 0, 0, 0, 0};
		f.weight = new int[] {0, 1, 7, 0, 0, 0, 2, 0};
		g.weight = new int[] {0, 0, 5, 0, 0, 2, 0, 1};
		h.weight = new int[] {0, 0, 0, 0, 0, 0, 1, 0};
		
		//Initialize their distance to a high number
		for(int i = 1; i < graph.size(); i++) {
			graph.get(i).dst = 1000;
		}
		
		System.out.println("Before Dijkstra---------------------Shortest Distance from A");
		for(int i = 0; i < graph.size(); i++) {
			System.out.println(graph.get(i).name + " : " + graph.get(i).dst);
		}
		
		dijkstra_algo(a, graph);
		
		System.out.println("After Dijkstra---------------------Shortest Distance from A");
		for(int i = 0; i < graph.size(); i++) {
			System.out.println(graph.get(i).name + " : " + graph.get(i).dst);
		}
		
		
	}

}
