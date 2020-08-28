package DfsBfs4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsBfs4_9205 {
	private static int[][] map;
	private static boolean happy;
	private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int csN = Integer.parseInt(br.readLine());
			map = new int[csN+2][csN+2]; // 플로이드 와셜 용도 배열(최단거리 구하기!)
			int[][] point = new int[csN+2][2];
			visit = new boolean[csN+2];
			st = new StringTokenizer(br.readLine(), " ");
			point[0][0] = Integer.parseInt(st.nextToken());
			point[0][1] = Integer.parseInt(st.nextToken());
			for (int j = 1; j < 1 + csN; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				point[j][0] = Integer.parseInt(st.nextToken());
				point[j][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			point[csN+1][0] = Integer.parseInt(st.nextToken());
			point[csN+1][1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < map.length; i++) {
				for (int j = 1+i; j < map.length; j++) {
					if(i==j) continue;
					map[i][j] = Math.abs(point[i][0]-point[j][0])+ Math.abs(point[i][1]-point[j][1]);
					map[j][i] = map[i][j];
				}
			}
			happy = false;
			if(map[0][csN+1]<=1000) {
				happy = true;
			}else {
				Dfs(0);
			}
			if(happy) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}			
			
		}
		System.out.println(sb.toString());

	}
	public static void Dfs(int start) {
		if(start == map.length - 1) {
			happy = true;
			return;
		}
		for (int i = 1; i < map.length&& !happy; i++) {
			if(map[start][i]<=1000&&!visit[i]&& !happy) {
				visit[i] = true;
				Dfs(i);
			}
		}
	}

}