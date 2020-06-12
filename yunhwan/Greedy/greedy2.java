package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int Gline = Integer.parseInt(st.nextToken());
		int Brand = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[Brand];
		int[] arr2 = new int[Brand];
		
		for(int i=0; i<Brand; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int pri = Integer.parseInt(st.nextToken());
			
			arr[i] = set;
			arr2[i] = pri;
		}
		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		int temp = Gline/6+1;
		int temp2 = Gline%6;
		
		int num1 = arr[0]*temp;
		int num2 = (arr[0]*(temp-1)) + arr2[0]*temp2;
		int num3 = arr2[0]*Gline;
		
		int min = Math.min(num1, num2);
		int min2 = Math.min(min, num3);
		System.out.println(min2);
	}

}
