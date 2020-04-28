package cecs328;

import java.util.LinkedList;
import java.util.Queue;

public class Lab_Seven {
	
	//Class Node to use for the BFS
	static class Node{
		public Node() {}
		
		//Overloaded Constructor
		public Node(String name) {
			this.name = name;
		}
		
		//Name of Node
		public String name;
		
		//Distance
		public int dst;
		
		//Parent Node
		public Node parent;
		
		//List of Adjacent Nodes
		public Node adj[];
		
		//Color - Used for Part B (0 - Gray, 1 - Blue, 2 - Red)
		public int color;
		
		public boolean hasParent() {
			if(parent != null)
				return true;
			else
				return false;
		}
		
		
	}
	
	public static void print_queue(Queue<Node> q) {
		for(Node x: q) {
			System.out.print(x.name + ",");
		}
		System.out.println();
	}
	
	public static void BFS(Node s) {
		//Creates the queue used for bfs
		Queue<Node> q = new LinkedList<Node>();
		
		//Set Distance to 0
		s.dst = 0;
		
		//Set s to be its own parent
		s.parent = s;
		
		//Push node into the queue
		q.add(s);
		
		while(!q.isEmpty()) {
			//Stores first node from the queue
			System.out.print("Queue: ");
			print_queue(q);
			Node temp = q.poll();
			
			//Gives nullpointexception if not included
			if(temp.adj != null) {
				for(Node x : temp.adj) {
					if(!x.hasParent()) {
						x.parent = temp;
						x.dst = temp.dst + 1;
						q.add(x);
						
						System.out.println("Parent = " + temp.name);
						System.out.println("Node = " + x.name);
						System.out.println("Node Distance from First Node = " + x.dst + "\n");
					}		
				}	
			}
		}	
	}
	
		
	public static void explore() {
		//Initialize all nodes to have all color gray
	}
	
	public static boolean is_bipartite() {
		
		
	}
	public static void main(String[] args) {
		//Part A
		Node a_n = new Node("a");
		Node b_n = new Node("b");
		Node c_n = new Node("c");
		Node d_n = new Node("d");
		Node e_n = new Node("e");
		Node f_n = new Node("f");
		Node g_n = new Node("g");
		Node h_n = new Node("h");
	
		
		a_n.adj = new Node[] {c_n, d_n};	
		b_n.adj = new Node[] {c_n, e_n};
		c_n.adj = new Node[] {a_n, b_n, d_n};
		d_n.adj = new Node[] {a_n, c_n, e_n, f_n};
		e_n.adj = new Node[] {b_n, d_n, f_n};
		f_n.adj = new Node[] {d_n, e_n, h_n};
		h_n.adj = new Node[] {f_n};
		
		BFS(a_n);
		
		
		//Part B - Bipartite
		
		
		
		
		
		
		
	}
	
	
}
