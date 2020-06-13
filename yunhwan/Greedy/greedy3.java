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

		int result = 1;
		int temp = arr[0];

		// 현재위치에서 temp를 빼고 1을 더한값이 테이프 길이보다 짧으면 테이프를 더 붙일 수 있음
		for(int i = 1; i<arr.length; i++) {
			if(arr[i]-temp+1 > tape) {   
				result++;
				temp = arr[i];
			}
		}

		System.out.println(result);
	}
}
