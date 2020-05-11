package cecs328;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FE_Problem_2 {
	//Class Node to use for the BFS
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
			public LinkedList<Node> adj;
			
			//boolean visited
			public boolean visited[];
									
			public boolean hasParent() {
				if(parent != null)
					return true;
				else
					return false;
			}	
		}
	
	public static void BFS(Node s, LinkedList<Node> graph) {
		//Creates the queue used for bfs
		Queue<Node> q = new LinkedList<Node>();
	
		//Push node into the queue
		q.add(s);
		
		while(!q.isEmpty()) {
			//Stores first node from the queue
			Node temp = q.poll();
			
			//Gives nullpointexception if not included
			if(temp.adj != null) {
				for(Node x : temp.adj) {
					if(!x.hasParent()) {
						x.parent = temp;
						q.add(x);
						
						s.visited[graph.indexOf(x)] = true;
						
					}		
				}	
			}
		}	
	}

	
	//Adjacencies are created by comparing 
	public static void main(String[] args) {
		
		//Input Array
		String arr[] = new String[] {"abc", "cdx", "xpc", "cga"};	
		
		//Creating Nodes for each word element
		Node word;
		LinkedList<Node> graph = new LinkedList<Node>();
		for(int i = 0; i < arr.length; i++) {
			word = new Node(arr[i]);
			word.adj = new LinkedList<Node>();
			word.visited = new boolean[arr.length];
			graph.add(word);
		}	

		
		//Find adjacencies for each node
		for(int i = 0; i < graph.size(); i++) {
			int compare_index = 0;

			while(compare_index < graph.size()) {
				if(compare_index != i) {
					//Compares last letter of node B to first letter of node A
					if(graph.get(i).name.charAt(graph.get(i).name.length() - 1) == graph.get(compare_index).name.charAt(0))
						graph.get(i).adj.add(graph.get(compare_index));
				}				
				compare_index++;							
			}
		}
		
		//Used to see if one node could traverse to other nodes
		boolean isCyclable[] = new boolean[arr.length];
		
		//Use DFS on each node
		for(int i = 0; i < graph.size(); i++) {
			BFS(graph.get(i), graph);
			
			//Reset parents for the next iteration
			for(int j = 0; j < graph.size(); j++){
				graph.get(j).parent = null;
			}
		}
	
		
		//Results
		for(int i = 0; i < graph.size(); i++) {
			int count = 0;
			for(int j = 0; j < arr.length; j++) {
				if(graph.get(i).visited[j])
					count++;
			}
			
			if(count < 4) {
				isCyclable[i] = false;
			}else
				isCyclable[i] = true;
		}
		
		boolean cycl = true;
		for(int i = 0; i < isCyclable.length; i++) {
			if(isCyclable[i] == false) {
				cycl = false;
				System.out.println("NO");
				break;
			}
		}
		
		//Yes if cyclable
		if(cycl)
			System.out.println("Yes");
	}
}
