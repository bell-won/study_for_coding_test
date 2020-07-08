package bfs_n_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class problem_5639 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node node = new Node(n);
		String s = "";
		while((s=br.readLine())!=null && s.length()!=0) {
			node = node.add(node, Integer.parseInt(s));
		}//전위 순회는 루트가 맨 처음 이니까 순서대로 트리 만들면 된다.
		postOrder(node);


	}
	
	public static void postOrder(Node node) {
		if(node.left!=null) {
			postOrder(node.left);
		}
		if(node.right!=null) {
			postOrder(node.right);
		}
		System.out.println(node.num);
	}
}

class Node {
	int num;
	Node right; 
	Node left;

	public Node(int num) {
		this.num = num;
		this.left=null;
		this.right=null;
	}
	
	public Node add(Node node, int number) {
		Node current = null;
		if(node==null) return new Node(number);
		if(node.num>=number) {
			current = add(node.left,number);
			node.left = current;
		}
		else if(node.num<number) {
			current = add(node.right,number);
			node.right = current;
		}
		return node;
	}
}



