package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BruteForce_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] t = new int[n+2];
		int[] p = new int[n+2];
		int[] dp = new int[n+2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			t[i] = d;
			p[i] = w;
		}
		for(int i=n; i>0; i--) {
			int n_day = i + t[i];
			if(n_day > n+1) {
				dp[i] = dp[i+1];
			}else {
				dp[i] = Math.max(dp[i+1], p[i] + dp[n_day]);
			}
		}
		System.out.println(dp[1]);
	}
}