package hyewon.bfs_n_dfs_2; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem_2644 {
	static int n,x,y,m;
	static int cnt =0;
	static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1][2];   
        visited = new boolean[n+1];           
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
     
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        
        System.out.println(bfs(x,y));
    }
 
    public static int bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<Integer>();
        visited[x] = true;
        q.add(x);
        int cnt = 0;
        while (!q.isEmpty()) {
            for(int k=0; k<q.size(); k++){
                int next_x = q.poll();
                if (next_x == y)
                    return cnt;
                for(int i=0; i<n; i++){
                    if (arr[i][0] == next_x && arr[i][1] == next_x && !visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}