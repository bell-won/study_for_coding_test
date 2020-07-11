package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_2606 {
	static int[][] net;
	static boolean[] visit;
	static int N;
	public static int bfs(int e){
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(e);
		visit[e]=true;

		int count = 0;
		while(!qu.isEmpty()){
			int t = qu.poll();
			for(int i=1;i<N+1;i++){
				if(visit[i]==false&&net[t][i]==1){
					qu.add(i);
					visit[i]=true;
					count++;
				}
			}
		}
		
		return count; 
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		net = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			net[a][b] = 1;
			net[b][a] = 1;
		}
		System.out.println(bfs(1));
	}

}
