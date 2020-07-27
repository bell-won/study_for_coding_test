package hyewon.bfs_n_dfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem_11403 {
	static int[][] matrix;
	static boolean[] visited;
	static LinkedList<Integer> queue = new LinkedList<>();

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(matrix, n);

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
			

	}
	
	private static void BFS(int[][] m, int n){
		for(int i=0; i<n; i++){
			boolean visited[] = new boolean[n];
			queue.add(i);
			while(!queue.isEmpty()){
				int tmp = queue.poll();
				for(int j=0; j<n; j++){
					if(m[tmp][j]==1 && !visited[j]){
						visited[j] = true;
						m[i][j] =1;
						queue.add(j);
					}		
				}
				
			}
		}
	}
	

}
