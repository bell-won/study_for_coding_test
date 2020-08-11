package hyewon.bfs_n_dfs_2; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem_2644 {
	static int n,x,y,m;
	static int count =0;
	static int[][] arr;
    static boolean[] visited;
    static int[] cnt;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1][2];   
        visited = new boolean[n+1];    
        cnt = new int[n+1];       
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
     
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        
        System.out.println(bfs(x,n));
    }
 
    public static int bfs(int x, int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        while (!q.isEmpty()) {
            int next_x = q.poll();
            visited[next_x] = true;
            for (int i=0; i<n; i++) {
                if (arr[i][0]==next_x && !visited[arr[i][1]]) {
                    q.add(arr[i][1]);
                    cnt[arr[i][1]] = cnt[arr[i][0]] + 1;
                } else if (arr[i][1] == next_x && !visited[arr[i][0]]) {
                    q.add(arr[i][0]);
                    cnt[arr[i][0]] = cnt[arr[i][1]] + 1;
                }
            }

            if (!q.isEmpty() && q.peek() == y) {
                return cnt[y];
            }
        }
		return -1;
    }
}