package DfsBfs4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs4_14502 {
	
	static char map1[][];
	static char map2[][];
	static boolean visit[][];
	static int rl[] = {0,0,-1,1};
	static int ud[] = {1,-1,0,0};
	static int N;
	public static void bfs(int x, int y, char[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		visit[x][y]=true;
		while(!q.isEmpty()){
			int l[] = q.poll();
			for(int i =0;i<4;i++){
				int r = l[0] + rl[i]; 
				int c = l[1] + ud[i];
				if(r>=0&&c>=0&&r<N&&c<N){
					if(visit[r][c]==false && map[r][c]==map[x][y]){
						visit[r][c] = true;
						q.offer(new int[] {r,c});
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map1 = new char[N][N];
		map2 = new char[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++){
		 String s = br.readLine();
		 for(int j=0;j<N;j++){
			 map1[i][j]= s.charAt(j);
			 if(s.charAt(j)=='G'){
				 map2[i][j]= 'R';
			 }else{
				 map2[i][j]= s.charAt(j);
			 }
		 }
		}
		for(int i=0;i<N;i++){
			 Arrays.fill(visit[i],false);
		}
		int count1 = 0;
		for(int i=0;i<N;i++){
			 for(int j=0;j<N;j++){
				 if(visit[i][j]==false){
					 bfs(i,j,map1);
					 count1++;
				 }
			 }
		}
		
		for(int i=0;i<N;i++){
			 Arrays.fill(visit[i],false);
		}
		int count2 = 0;
		for(int i=0;i<N;i++){
			 for(int j=0;j<N;j++){
				 if(visit[i][j]==false){
					 bfs(i,j,map2);
					 count2++;
				 }
			 }
		}
		System.out.println(count1+" "+count2);
	}
}