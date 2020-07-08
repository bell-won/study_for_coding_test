package bfs_n_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem_1012 {
	static int m,n,k;
	static int node[][]; // 배추밭 배열
	static int visit[][]; // 배추방문 배열
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int count =0; 
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());		
		
		for(int i =0; i<t; i++){
			st = new StringTokenizer(br.readLine()); 
			m = Integer.parseInt(st.nextToken()); 
			n = Integer.parseInt(st.nextToken()); 
			k = Integer.parseInt(st.nextToken());

			node = new int[n][m];
			visit = new int[n][m];
			count=0;
			
			
			for(int j=0; j<k; j++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				node[y][x] = 1;
			}
						
			for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (node[a][b] == 1 && visit[a][b] == 0) {
                        dfs(a, b);
                        count++;
                    }
                }
            }

			System.out.println(count);	
		}
	
	}
	static void dfs(int y, int x) {

        visit[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
 
            if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
                if (node[next_y][next_x] == 1 && visit[next_y][next_x] == 0)
                    dfs(next_y, next_x);
            }
        }
 
    }

}