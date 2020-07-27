package hyewon.bfs_n_dfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem_7569 {
	static int n,m,h;
	static int[][][] matrix;
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0, 0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	
	static class Dot{
		int x;
		int y;
		int z;
		int day;
		
		public Dot(int x,int y, int z, int day){
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		matrix = new int[h][n][m];  // 높이 행 열
		
		for(int i=0; i<h; i++){
			for(int j=0; j<n; j++){
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<m; k++){
					matrix[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();		

	}
	
	static void bfs(){
		LinkedList<Dot> queue = new LinkedList<Dot>();
		int day =0;
		
		for(int i=0; i<h; i++){
			for(int j=0; j<n; j++){
				for(int k=0; k<m; k++){
					if(matrix[i][j][k]==1){
						queue.offer(new Dot(i,j,k,0));
					}
				}
			}
		}
		
		while(!queue.isEmpty()){
			Dot dot = queue.poll();
			day = dot.day;
			for(int i=0; i<6; i++){
				int next_x = dot.x+dx[i];
				int next_y = dot.y+dy[i];
				int next_z = dot.z+dz[i];
				
				if(next_x>=0&&next_x<h&&next_y>=0&&next_y<n&&next_z>=0&&next_z<m){
					if(matrix[next_x][next_y][next_z]==0){
						matrix[next_x][next_y][next_z]=1;
						queue.add(new Dot(next_x,next_y,next_z,day+1));
					}
				}
			}
		}
		if(check()){
			System.out.println(day);
		}else{
			System.out.println(-1);
		}
		
	}
	
	static boolean check(){
		for(int i=0; i<h; i++){
			for(int j=0; j<n; j++){
				for(int k=0; k<m; k++){
					if(matrix[i][j][k]==0){
						return false;
					}
				}
			}
		}
		return true;
	}

}
