package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BinarySearch_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//HashMap 방식
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		HashMap<Long,Long> hm = new HashMap<Long,Long>();
		for(int i=0;i<N;i++){
			long key = Long.parseLong(st.nextToken());
			hm.put(key, hm.getOrDefault(key, (long) 0)+1);
		}
		int M = Integer.parseInt(br.readLine());
		s = br.readLine();
		st = new StringTokenizer(s," ");
		for(int i=0;i<M;i++){
			long key = Long.parseLong(st.nextToken());
			if(hm.containsKey(key)){
				System.out.print(hm.get(key)+" ");
			}else{
				System.out.print(0+" ");
			}
		}
		*/
		//이분탐색 방식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		int[] card = new int[N];
		for(int i=0;i<N;i++){
			card[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		s = br.readLine();
		st = new StringTokenizer(s," ");
		
		for(int i=0;i<M;i++){
			int target = Integer.parseInt(st.nextToken());
			int countup = 0;
			int countdown = 0;
			int first = 0;
			int last = N-1;
			while(first<=last){
				int mid = (first+last)/2;
				if(card[mid]<target){
					first=mid+1;
				}else if(card[mid]>target){
					last=mid-1;
				}else{
					if(card[mid]==target){
						while(mid+countup<N&&card[mid+countup]==target){
							countup++;
						}
						while(mid-countdown-1>=0&&card[mid-countdown-1]==target){
							countdown++;
						}
						break;
					}
				}
			}
			bw.write(Integer.toString(countup+countdown)+" ");
		}
		bw.flush();
		bw.close();
	}
}
