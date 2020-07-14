package hyewon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class brute_force_14501 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n+10];
		int[] pay = new int[n+10];
		int[] dp= new int[n+10];
		int max =0;

		
		for(int i=1; i<=n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
			
			dp[i] = pay[i];
		}
		
		for (int i = 2; i <= n; i++) {
	        for (int j = 1; j < i; j++) {
	            if (i - j >= time[j]) {
	                dp[i] = Math.max(pay[i] + dp[j], dp[i]);
	            }
	        } 
	    }
	    for (int i = 1; i <= n; i++) {
	        if (i + time[i] <= n + 1) {
	            if (max < dp[i]) {
	                max = dp[i];
	            }
	        }
	    }
	    System.out.println(max);


	}

}
