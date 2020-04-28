package cecs328;

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
	
	
		
	public static void explore(Node v) {
		//Initialize vertex (parameter) to have gray
		v.color = 0;	
		
		//Change vertex color to blue
		v.color = 1;
		
		//Call is_bipartite on it
		if(is_bipartite(v)) {
			
		}else {
			
		}
		
	}
	
	public static boolean is_bipartite(Node s) {
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
			
			//Part a - Keep popping each vertex from queue
			Node u = q.poll();
			
			//Gives nullpointexception if not included
			if(u.adj != null) {
				//V are neighbors of u
				for(Node v : u.adj) {
					if(!v.hasParent()) {
						//Part C - Assigning a opposite color to V (u is blue)
						if(v.color == 0) {
							v.color = 1;		//neighbor nodes are red
						}
						
						if(v.color == u.color) {	//Neighboring nodes can not be the same color to be bipartite
							System.out.println("NOT Bipartite");
							return false;
						}
						q.add(v);
					}		
				}	
			}
		}	

		return true;
		
	}
	
	public static void main(String[] args) {
		//Part A
//		Node a_n = new Node("a");
//		Node b_n = new Node("b");
//		Node c_n = new Node("c");
//		Node d_n = new Node("d");
//		Node e_n = new Node("e");
//		Node f_n = new Node("f");
//		Node g_n = new Node("g");
//		Node h_n = new Node("h");
//	
//		
//		a_n.adj = new Node[] {c_n, d_n};	
//		b_n.adj = new Node[] {c_n, e_n};
//		c_n.adj = new Node[] {a_n, b_n, d_n};
//		d_n.adj = new Node[] {a_n, c_n, e_n, f_n};
//		e_n.adj = new Node[] {b_n, d_n, f_n};
//		f_n.adj = new Node[] {d_n, e_n, h_n};
//		h_n.adj = new Node[] {f_n};
		
//		BFS(a_n);
		
		
		//Part B - Bipartite
		Node a_n = new Node("a");
		Node b_n = new Node("b");
		Node c_n = new Node("c");
		Node d_n = new Node("d");
		Node e_n = new Node("e");
		Node f_n = new Node("f");
		Node g_n = new Node("g");
		Node h_n = new Node("h");
		Node i_n = new Node("i");
		
		a_n.adj = new Node[] {d_n};	
		b_n.adj = new Node[] {d_n, f_n};
		c_n.adj = new Node[] {d_n, e_n};
		d_n.adj = new Node[] {a_n, c_n, b_n};
		e_n.adj = new Node[] {c_n};
		f_n.adj = new Node[] {b_n};
		h_n.adj = new Node[] {g_n, i_n};
		i_n.adj = new Node[] {g_n, h_n};
		g_n.adj = new Node[] {h_n, i_n};
		
		explore(a_n);
		explore(b_n);
		explore(c_n);
		explore(d_n);
		explore(e_n);
		explore(f_n);
		explore(g_n);
		explore(h_n);
		explore(i_n);
		
		//Printing Color
		System.out.println("Colors: 0 = Gray, 1 = Blue, 2 = Red");
		System.out.println("Node a: " + a_n.color);
		System.out.println("Node b: " + b_n.color);
		System.out.println("Node c: " + c_n.color);
		System.out.println("Node d: " + d_n.color);
		System.out.println("Node e: " + e_n.color);
		System.out.println("Node f: " + f_n.color);
		System.out.println("Node g: " + g_n.color);
		System.out.println("Node h: " + h_n.color);
		System.out.println("Node i: " + i_n.color);
		
		
	}
	
	
}

