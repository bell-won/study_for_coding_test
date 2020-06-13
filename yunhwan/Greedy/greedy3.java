package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int error = Integer.parseInt(st.nextToken());
		int tape = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[error];
		for(int i=0; i<error; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		boolean flag = true;
		int result = 1;
		int temp = arr[0];
		for(int i = 1; i<arr.length; i++) {
			if(arr[i]-temp+1 > tape) {
				result++;
				temp = arr[i];
			}
		}
		
		
		System.out.println(result);
}
}
