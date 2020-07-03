package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_1654 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] line = new int[K];
		for(int i=0;i<K;i++){
			line[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(line);
		
		long first =1;
		long last = line[K-1];
		while(first<=last){
			long mid = (first+last)/2;
			int count = 0;
			for(int i=0;i<K;i++){
				count += line[i]/mid;
			}
			if(count<N){
				last=mid-1;
			}else if(count>=N){
				first=mid+1;
			}
		}
		System.out.println(last);
	}
}
