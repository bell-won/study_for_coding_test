package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_1049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		s = br.readLine();
		st = new StringTokenizer(s," ");
		int pack_min = Integer.parseInt(st.nextToken());
		int one_min = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<M;i++){
			s = br.readLine();
			st = new StringTokenizer(s," ");
			int pack = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			if(pack<pack_min){
				pack_min = pack;
			}
			if(one<one_min){
				one_min = one;
			}
		}
		int all_pack=pack_min*(N/6+1);
		int all_one=one_min*N;
		int mix=pack_min*(N/6)+one_min*(N%6);
		if(all_pack<=all_one&&all_pack<=mix){
			System.out.println(all_pack);
		}else if(all_one<=all_pack&&all_one<=mix){
			System.out.println(all_one);
		}else{
			System.out.println(mix);
		}
		
		
	}

}
