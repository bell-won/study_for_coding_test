package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Stack2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String[] str = br.readLine().split("");
		Stack<String> st = new Stack<String>();
		
		int sum = 0;
		
		st.push(str[0]);
		for(int i=1; i<str.length; i++) {
			if(str[i].equals("(")) {
				st.push("(");
			}else if(str[i].equals(")") && str[i-1].equals(")")) 
			{
				st.pop();
				sum++;
			}else {
				st.pop();
				sum += st.size();
			}
		}
		System.out.println(sum);
	}
}
