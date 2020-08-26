package hyewon.bfs_n_dfs_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_10026 {
	static int n;
	static int rgb =0;
	static int rgb2 =0;
	static char[][] color;
	static char[][] copy;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		color = new char[n][n];
		copy = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++){
			String s = br.readLine();
			for(int j=0; j<n; j++){
				color[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				copy[i][j] = color[i][j];
				if(color[i][j]=='R'){
					copy[i][j] = 'G';
				}
			}
		}
		
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(!visited[i][j]){    // 방문한 적이 없는 경우
					dfs(i,j,color);
					rgb++;
				}
			}
		}
		
		visited = new boolean[n][n];   // 다시 초기화
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(!visited[i][j]){
					dfs(i,j,copy);
					rgb2++;
				}
			}
		}
		
		
		System.out.println(rgb +" "+rgb2);

	}
	
	public static void dfs(int x,int y,char[][] array){
		visited[x][y] = true;
		char current = array[x][y];
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n){
				if(!visited[nx][ny] && array[nx][ny]==current){
					visited[nx][ny] = true;
					dfs(nx,ny,array);	
				}
			}
		}
		
	}

}
