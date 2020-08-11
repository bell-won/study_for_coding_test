package hyewon.bfs_n_dfs_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node{
    int x;
    int y; 
    Node(int x, int y){
        this.x=x; 
        this.y=y;
    }
}

public class problem_2589{
    static int n,m,ans;
    static int[][] map;
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];  
        ans = 0;
       
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='L'){
                    bfs(i,j);
                }
            }
        }  
        System.out.println(ans);
    }
    public static void bfs(int x, int y){
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] dist = new int[n+1][m+1];
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        
        while(!q.isEmpty()){
        	Node node = q.poll();
            int cx = node.x;
            int cy = node.y;
            for(int i=0;i<4;i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                	if(!visited[nx][ny] && map[nx][ny]=='L'){
                		q.offer(new Node(nx,ny));
                		visited[nx][ny] = true;
                        dist[nx][ny] = dist[cx][cy] + 1;
                        ans = Math.max(ans, dist[nx][ny]);
                	}
                	
                }
                
            }
        }
    }
}
