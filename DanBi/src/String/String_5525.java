package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class String_5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		
		String[] array_word = br.readLine().split("");

		for(int i=0;i<M;i++){
			if(array_word[i].equals("I")){
				li.add(i);
			}
		}
		
		int answer = 0;
		int cnt = 0;
		
		for(int i = 0;i<li.size()-1;i++){
			if(li.get(i+1)-li.get(i)==2){
				cnt++;
			}else{
				cnt=0;
			}
			if(cnt>=N){
				answer++;
			}
		}
		bw.write(""+answer+"\n");
		bw.close();
		br.close();
		
	}// end of main

}// end of class
