package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queue_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			switch(st.nextToken()){
				case "front" :
					if(dq.isEmpty()){
						bw.write(Integer.toString(-1));
						bw.newLine();
					}else{
						bw.write(Integer.toString(dq.peekFirst()));
						bw.newLine();
					}
					break;
				case "back" :
					if(dq.isEmpty()){
						bw.write(Integer.toString(-1));
						bw.newLine();
					}else{
						bw.write(Integer.toString(dq.peekLast()));
						bw.newLine();
					}
					break;
				case "size" :
					bw.write(Integer.toString(dq.size()));
					bw.newLine();
					break;
				case "empty" :
					if(dq.isEmpty()){
						bw.write(Integer.toString(1));
						bw.newLine();
					}else{
						bw.write(Integer.toString(0));
						bw.newLine();
					}
					break;
				case "pop" :
					if(dq.isEmpty()){
						bw.write(Integer.toString(-1));
						bw.newLine();
					}else{
						bw.write(Integer.toString(dq.pop()));
						bw.newLine();
					}
					break;
				default :
					dq.add(Integer.parseInt(st.nextToken()));
					
			}
		}
		bw.flush();
		bw.close();
		
	}

}
