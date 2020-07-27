package BruteForce;
// 참고 : https://leveloper.tistory.com/98
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BruteForce_15686 {
	public static int N, M,r,len,min = Integer.MAX_VALUE;
	public static ArrayList<Index> chicken = new ArrayList<>();
	public static ArrayList<Index> house = new ArrayList<>();
	public static boolean[] check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if(temp==1){
					house.add(new Index(i,j));
				}else if(temp ==2 ){
					chicken.add(new Index(i,j));
				}
			}
		}
			len = chicken.size();
			check = new boolean[len];
			for (int i = M; i >= 1; i--) {
				r = i;
				comb(0, 0);
			}
			System.out.println(min);
			
	}

	private static void comb(int start, int depth) {
		if (depth == r) {
			// r개의 치킨집을 고름
			min = Math.min(min, getMin());
			return;
		}
		for (int i = start; i < len; i++) {
			check[i] = true;
			comb(i + 1, depth + 1);
			check[i] = false;
		}
	}
	private static int getMin() { // 치킨집이 골라졌을 때 도시의 치킨 거리 값을 구함
		int total = 0, temp;
		for (Index house : house) {
			temp = 2 * N;
			for (int i = 0; i < len; i++) {
				if (!check[i]) continue;
				temp = Math.min(temp, getDir(house, chicken.get(i)));
			}
			total += temp;
			if (total > min) return total;
		}
		return total;
	}
	private static int getDir(Index a, Index b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}

class Index {
	int x, y;

	Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
