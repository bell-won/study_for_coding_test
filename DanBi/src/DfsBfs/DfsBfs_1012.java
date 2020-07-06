package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_1012 {
	static int map[][];
	static boolean vmap[][];
	static int rl[] = {0,0,-1,1};
	static int ud[] = {1,-1,0,0};
	static int M,N;
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		vmap[x][y]=true;
		while(!q.isEmpty()){
			int l[] = q.poll();
			for(int i =0;i<4;i++){
				int r = l[0] + rl[i]; 
				int c = l[1] + ud[i];
				if(r>=0&&c>=0&&r<N&&c<M){
					if(vmap[r][c]==false && map[r][c]==1){
						vmap[r][c] = true;
						q.offer(new int[] {r,c});
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			String s = br.readLine();
			StringTokenizer st =new StringTokenizer(s," ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			vmap = new boolean[N][M];
			
			for(int j=0;j<K;j++){
				s=br.readLine();
				st =new StringTokenizer(s," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[b][a] = 1;
			}
			int count = 0;
			for(int x=0;x<N;x++){
				for(int y=0;y<M;y++){
					if(vmap[x][y]==false&&map[x][y]==1){
						bfs(x,y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

}
