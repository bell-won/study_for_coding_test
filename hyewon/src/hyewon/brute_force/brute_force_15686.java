package hyewon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class brute_force_15686 {
    static int[][] array;
    static int n,m,MIN = Integer.MAX_VALUE;
    static ArrayList<Node> chicken;
    static ArrayList<Node> home;
    static Node[] selected;
    static int size;
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());      
        array = new int[n][n];
        selected = new Node[m];
        chicken = new ArrayList<Node>();
        home = new ArrayList<Node>();  
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
                else if(array[i][j] == 1) {
                    home.add(new Node(i, j));
                }
            }
        }      
        size = chicken.size();
        search(0,0);    
        System.out.println(MIN);
    }
    
    public static void search(int idx, int cnt) {
        if(cnt == m) {
            int dist = 0;        
            for (int j = 0; j < home.size(); j++) {
                Node h = home.get(j);
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    Node c = selected[i];
                    min = Math.min(min, getDistance(h.x, h.y, c.x, c.y));
                }
                dist += min;
            }
            
            MIN = Math.min(MIN, dist);
            return ;
        }
        
        for (int i = idx; i < size; i++) {
            selected[cnt] = chicken.get(i);
            search(i+1, cnt+1);
        }
    }
    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2); 
    }
}
 
class Node {
    int x;
    int y;
 
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
