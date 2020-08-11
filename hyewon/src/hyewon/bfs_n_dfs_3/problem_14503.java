package hyewon.bfs_n_dfs_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem_14503 {
	static int n,m,cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Dot dot;
	
	static class Dot{
		int x;
		int y;
		int dir;
		
		public Dot(int x,int y, int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());  
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		cnt = 1;
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dot = new Dot(r,c,dir);
		visited[r][c] = true;
		bfs(r,c,dir); 
		System.out.println(cnt);

	}
	public static void bfs(int start, int end, int dir){
		LinkedList<Dot> q = new LinkedList<Dot>();
		int nextx=0;
		int nexty=0;
		q.add(dot);		
		while(!q.isEmpty()){
			Dot dot = q.poll();
			int currentx = dot.x;
			int currenty = dot.y;
			int currentdir = dot.dir;
			Boolean flag = false;
			for(int i=0; i<4; i++){
				currentdir = (currentdir+3) % 4;
				nextx = currentx + dx[currentdir];
				nexty = currenty + dy[currentdir];	
				if(nextx>=0 && nextx<n && nexty>=0 && nexty<m){
					if(arr[nextx][nexty]==0 && visited[nextx][nexty]==false){
						visited[nextx][nexty] = true;
						q.add(new Dot(nextx,nexty,currentdir));
						++cnt;
						flag = true;
						break;
					}
				}
			}			
			if(!flag){
				int nextdir = (currentdir+2) % 4;
				nextx = currentx + dx[nextdir];
				nexty = currenty + dy[nextdir];		
				if(arr[nextx][nexty]==0){
					q.add(new Dot(nextx,nexty,currentdir));
				}
			}
		}
	}
	

}
