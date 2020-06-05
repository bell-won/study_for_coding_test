package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Queue1 {
	public static class Node{
		int num;
		int index;
		public Node(int num, int index) 
		{
			this.num = num;
			this.index = index;
		}
	}	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());

		for(int k=0; k<test; k++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());

			Queue<Node> qu = new LinkedList<Node>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				qu.add(new Node(Integer.parseInt(st.nextToken()), i));
			}

			int count = 0;
			boolean flag = true;
			while(true) {
				Node temp = qu.poll();
				
				Iterator<Node> it = qu.iterator();
				while(it.hasNext()) {
					Node temp2 = (Node)it.next();
					if(temp.num < temp2.num) {
						qu.add(temp);
						flag = false;
						break;
					}
				}

				if(flag == true) {
					count++;
					if(idx == temp.index) {
						break;
					}
				}else {
					flag = true;
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
	}
}
