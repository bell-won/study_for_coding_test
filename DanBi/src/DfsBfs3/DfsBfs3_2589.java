package DfsBfs3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs3_2589 {
	private static char[][] map;
	private static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L') {
					visit = new boolean[N][M];
					int len = Bfs(i,j);
					if(len>answer) {
						answer = len;
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static int Bfs(int i, int j) {
		int len = 0;
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {i,j});
		visit[i][j] = true;
		while(!qu.isEmpty()) {
			int size = qu.size();
			for (int t = 0; t < size; t++) {
				int[] temp = qu.poll();
				for (int k = 0; k < dr.length; k++) {
					int r = temp[0] + dr[k];
					int c = temp[1] + dc[k];
					if(r>=0&&r<N &&c>=0 &&c<M && map[r][c] == 'L' && !visit[r][c]) {
						visit[r][c] = true;
						qu.add(new int[] {r,c});
					}
				}
			}
			len++;
		}
		return len-1;
	}

}

