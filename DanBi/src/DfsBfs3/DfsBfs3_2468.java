package DfsBfs3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs3_2468 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max) {
					max = map[i][j]; 
				}
				if(map[i][j]<min) {
					min = map[i][j];
				}
			}
		}
		if(min==max) {
			System.out.println(1);
			return;
		}
		int answer = 0;
		int h = min;
		while(h<=max) {
			int count = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]&&map[i][j]>h) {
						Bfs(i,j,h);
						count++;
					}
				}
			}
			if(count>answer) {
				answer = count;
			}
			h++;
		}
		System.out.println(answer);
	}
	private static void Bfs(int i, int j, int h) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {i,j});
		visit[i][j] = true;
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int k = 0; k < 4; k++) {
				int row = temp[0] + dr[k];
				int col = temp[1] + dc[k];
				if(0<=row&&row<N&&0<=col&&col<N&&!visit[row][col]&&map[row][col]>h) {
					visit[row][col] = true;
					qu.add(new int[] {row,col});
				}
			}
 		}
		
	}

}