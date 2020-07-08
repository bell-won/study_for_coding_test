package hyewon.bfs_n_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem_2606 {
	static int node[][]; // 그래프 배열
	static int visit[]; // 방문 배열 
	static int count = 0;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int link = Integer.parseInt(br.readLine());
		
		node=new int[computer+1][computer+1];
		visit = new int[computer+1];
	
		for(int i=0; i<link; i++){	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b]=1;
			node[b][a]=1;
		}
		bfs(1);
		System.out.println(count);

	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();		
		visit[start] =1;
		q.offer(start);
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i=1;i<node.length;i++) {
				if(node[x][i]==1 && visit[i]!=1) {
					q.offer(i);
					visit[i] = 1;
					count++;
				}
			}
		}
	}

}