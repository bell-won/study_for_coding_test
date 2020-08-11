package hyewon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_1449 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[]hole = new int[n];
		int count =0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){	
			hole[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(hole);
		int cur = hole[0];
		int range = (int)(hole[0]-0.5+l);
		count++;
		
		for(int i=1; i<n; i++){
			cur = hole[i];
			if(cur<=range){
				continue;
			}else{
				count++;
				range = (int)(hole[i]-0.5+l);
			}
		}
		
		System.out.println(count);

	}

}
