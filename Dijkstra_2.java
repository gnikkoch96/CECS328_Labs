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
			public LinkedList<Integer> weight;
			
			//Distance
			public int dst;
			
			public boolean hasParent() {
				if(parent != null)
					return true;
				else
					return false;
			}	
	}

		
	public static void dijkstra_algorithm(Node vertex) {
		vertex.dst = 0;
		vertex.parent = vertex;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(vertex);
		
		while(q.size() > 0) {
			Node next = q.peek();
			q.poll();
			
			int i = 0;
			for(Node n: next.adj) {
				int distance = next.dst + next.weight.get(i);
				if(distance < n.dst) {
					n.parent = next;
					n.dst = distance;
					q.add(n);
				}
				i++;
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
		
		
		a.weight = new LinkedList<Integer>();
		a.weight.add(2);
		a.weight.add(15);
		a.weight.add(3);
		
		b.weight = new LinkedList<Integer>();
		b.weight.add(15);
		b.weight.add(8);
		b.weight.add(2);

		c.weight = new LinkedList<Integer>();
		c.weight.add(2);
		c.weight.add(8);
		c.weight.add(7);
		c.weight.add(5);

		d.weight = new LinkedList<Integer>();
		d.weight.add(3);
		d.weight.add(1);

		e.weight = new LinkedList<Integer>();
		e.weight.add(1);
		e.weight.add(2);

		f.weight = new LinkedList<Integer>();
		f.weight.add(1);
		f.weight.add(7);
		f.weight.add(2);

		g.weight = new LinkedList<Integer>();
		g.weight.add(5);
		g.weight.add(2);
		g.weight.add(1);

		h.weight = new LinkedList<Integer>();
		h.weight.add(1);

	
		//Initialize their distance to a high number
		for(int i = 1; i < graph.size(); i++) {
			graph.get(i).dst = 1000;
		}
		
		System.out.println("Before Dijkstra---------------------Shortest Distance from A");
		for(int i = 0; i < graph.size(); i++) {
			System.out.println(graph.get(i).name + " : " + graph.get(i).dst);
		}
		
		dijkstra_algorithm(a);
		
		System.out.println("After Dijkstra---------------------Shortest Distance from A");
		for(int i = 0; i < graph.size(); i++) {
			System.out.println(graph.get(i).name + " : " + graph.get(i).dst);
		}
		
	}
}
