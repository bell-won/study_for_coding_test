package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		StringTokenizer s;		
		s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken());
		
		boolean flag = true;
		for(int i=0; i<n; i++) {
			Stack<String> st = new Stack<String>();
			
			String[] str = br.readLine().split("");
			for(int j=0; j<str.length; j++) {
				if(str[j].equals("(")) {
					st.push(str[j]);
				}else if(str[j].equals(")")) {
					if(st.isEmpty()) {
						flag = false;
						break;
					}else {
						st.pop();
					}
				}
				
			}
			
			if(flag == false || !st.isEmpty()) 
			{
				bw.write(String.valueOf("NO")+"\n");				
				flag = true;
			}else {
				bw.write(String.valueOf("YES")+"\n");
			}
			
			while(!st.isEmpty()) {
				st.pop();
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}

}

