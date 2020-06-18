package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1449 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		s = br.readLine();
		st = new StringTokenizer(s," ");
		int[] pipe = new int[N];
		for(int i=0;i<N;i++){
			pipe[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pipe);
		int answer = 1;
		int point = pipe[0]+(L-1);
		for(int i=1;i<N;i++){
			if(point<pipe[i]){
				point = pipe[i]+(L-1);
				answer++;
			}
		}
		System.out.println(answer);
	}

}
