package cecs328;

import cecs328.Lab_Seven.Node;

public class Lab_Eight {
	
	//Class Node to use for the BFS
	static class Node{
			public Node() {}
			
			//Overloaded Constructor
			public Node(String name) {
				this.name = name;
			}
			
			//Globally Time Count the Nodes of a Graph 
			public static int time = 0;
			
			//Name of Node
			public String name;
			
			//Time Start
			public int start;
			
			//Time End
			public int end;
			
			//Parent Node
			public Node parent;
			
			//List of Adjacent Nodes
			public Node adj[];
						
			public boolean hasParent() {
				if(parent != null)
					return true;
				else
					return false;
			}	
		}
	
	
	public static void dfs_visit(Node v) {
		v.start = ++Node.time;

		if(v.adj != null) {
			for(Node n: v.adj) {
				if(n.start == 0) {
					//Parameter v becomes parent of adjacent nodes
					n.parent = v;
				
					dfs_visit(n);
				
					n.end = ++Node.time;
				}	
			}
		}
	}
	
	
	public static void dfs(Node V[]) {
		for(Node v: V) {
			if(!v.hasParent()) {
				//Assign the parent as itself
				v.parent = v;
				
				//Visit through neighboring nodes recursively
				dfs_visit(v);
				
				//Parent Nodes wouldn't get an end time without this code
				v.end = ++Node.time;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		//Part A 
		
		//Creating the Nodes
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		
		//Connect Nodes by placing values in their adjacent array
		a.adj = new Node[] {c,b,d};
		b.adj = new Node[] {d};
		c.adj = new Node[] {d};
		d.adj = new Node[] {e};
		e.adj = new Node[] {g};
		f.adj = new Node[] {e};
		
		Node graph[] = new Node[]{a,b,c,d,e,f,g};
		
		dfs(graph);
		
		for(Node n: graph) {
			System.out.println("Node: " + n.name);
			System.out.println("Start Time: " + n.start);
			System.out.println("End Time: " + n.end + "\n");
		}
		
		
	
	}
}
