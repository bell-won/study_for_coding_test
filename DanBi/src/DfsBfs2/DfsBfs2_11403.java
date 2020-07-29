package DfsBfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DfsBfs2_11403 {
	static int[][] arr;
	static int[][] result;
	static int N;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], -1);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit = new boolean[N];
				result[i][j] = Dfs(i,j);
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

	private static int Dfs(int start, int end) {
		if( result[start][end] == 1) {
			return 1;
		}else if( result[start][end] == 0) {
			return 0;
		}else {
			for (int i = 0; i < N; i++) {
				if(arr[start][i] == 1&&visit[i]==false) {
					visit[i]= true;
					if(i == end) {
						return 1;
					}
					if(Dfs(i,end)==1) {
						return 1;
					}
				}
			}
			return 0;
		}
	}

}
