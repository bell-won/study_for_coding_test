package queue;

import java.io.*;
import java.util.*;

public class queue1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());

		for(int i = 0; i<testcase; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> doc = new LinkedList<Integer>();
			LinkedList<Integer> key = new LinkedList<Integer>();
			int count =0;
			
			for(int j=0; j<n; j++){
				doc.add(Integer.parseInt(st.nextToken()));
				key.add(j);     // 각 문서의 고유 index 부여
			}
			
			while(!doc.isEmpty()){
				boolean check = true;
				for(int k=0; k<doc.size(); k++){
					if(doc.get(0)<doc.get(k)){
						check = false;
					}
				}
				
				if(check){
					count++;
					doc.poll();
					int tmp = key.poll();
					if(tmp == m){
						bw.write(count + "\n");
						break;
					}
					
				}else{
					int temp = doc.poll();
					doc.add(temp);
					temp = key.poll();
					key.add(temp);
				}
			}

		}
		
		bw.flush();
		bw.close();
		

	}

}

