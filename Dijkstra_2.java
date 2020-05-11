package cecs328;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra_2 {
	
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
						
			//Adjacency (Parallel indexing with weight)
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
	
	//Finds the index of the smallest weight
	public static Node find_min_weight(Node s) {
		int min_weight_index = 0;
		int min_weight = s.weight[0];
		
		for(int i = 1; i < s.weight.length; i++) {
			if(s.weight[i] < min_weight) {
				min_weight = s.weight[i];
				min_weight_index = i;
			}
		}
		
		return s.adj[min_weight_index];
		
	}
	
	
	public static void dijkstra_algorithm(Node vertex) {
		vertex.dst = 0;
		vertex.parent = vertex;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(vertex);
		
		while(q.size() > 0) {
			Node next = q.peek();
			q.poll();
			
			for(Node n: next.adj) {
				int distance = next.dst + n.weight(next);
				if(distance < n.dst) {
					n.parent = next;
					n.dst = distance;
					q.add(n);
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
		
		
		LinkedList<Node> order = new LinkedList<Node>();
		
		//Array to be Heapified
		LinkedList<Node> graph = new LinkedList<Node>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		graph.add(h);
		
		//Might just be the adjacency + weight
		a.adj = new Node[] {c,b,d};
		b.adj = new Node[] {a,c,e};
		c.adj = new Node[] {a,b,f,g};
		d.adj = new Node[] {a,e};
		e.adj = new Node[] {d,b};
		f.adj = new Node[] {b,c,g};
		g.adj = new Node[] {c,f,h};
		h.adj = new Node[] {g};
		
		
		a.weight = new int[] {2,15,3};
		b.weight = new int[] {15,8,2};
		c.weight = new int[] {2,8,7,5};
		d.weight = new int[] {3,1};
		e.weight = new int[] {1,2};
		f.weight = new int[] {1,7,2};
		g.weight = new int[] {5,2,1};
		h.weight = new int[] {1};
		
		
		
		
		

		
		//Initialize their distance to a high number
		for(int i = 1; i < graph.size(); i++) {
			graph.get(i).dst = 1000;
		}
		
		System.out.println("Before Dijkstra---------------------Shortest Distance from A");
		for(int i = 0; i < graph.length; i++) {
			System.out.println(graph[i].name + " : " + graph[i].dst);
		}
		
		System.out.println("After Dijkstra---------------------Shortest Distance from A");
		for(int i = 0; i < graph.length; i++) {
			System.out.println(graph[i].name + " : " + graph[i].dst);
		}
		
	}
}
