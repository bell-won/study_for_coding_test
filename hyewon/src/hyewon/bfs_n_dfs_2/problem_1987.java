package hyewon.bfs_n_dfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_1987 {
	static int r,c;
	static int ans=0;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[26];
		
		for(int i=0; i<r; i++){
			String s = br.readLine();
			for(int j=0; j<c; j++){
				 map[i][j] = (char) (s.charAt(j) - 'A');
			}
		}
		dfs(0,0,0);
		
		System.out.println(ans);
		

	}
	static void dfs(int x, int y,int cnt){
		if(visited[map[x][y]]){
			ans = Math.max(ans, cnt);
			return;
			
			
		} else{
			visited[map[x][y]] = true;
			for(int i=0; i<4; i++){
				int next_x = x + dx[i];
				int next_y = y + dy[i];	
				if(next_x>=0&& next_x<r&& next_y>=0&&next_y<c){
					dfs(next_x,next_y,cnt+1);					
				}
			}
			
			visited[map[x][y]] = false;
			
		}
	}

}
