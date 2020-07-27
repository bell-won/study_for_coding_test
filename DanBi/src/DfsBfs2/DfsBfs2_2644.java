package DfsBfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs2_2644 {
	static int n;
	static int[][] members;
	static int[] visit;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		members = new int[n+1][n+1];
		visit = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			members[a][b] = 1;
			members[b][a] = 1;
			
		}
		System.out.println(Bfs(p1,p2));
		
	}
	private static int Bfs(int p1, int p2) {
		int count = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(p1);
		while(!qu.isEmpty()) {
			count++;
			int temp = qu.poll();
			for(int i=0;i< n+1;i++) {
				if(visit[i]==0&&members[temp][i]==1) {
					visit[i]=visit[temp]+1;
					qu.add(i);
					if(i==p2) {
						return visit[i];
					}
				}
			}
		}
		return -1;
	}

}
