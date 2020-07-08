package stack;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class stack1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		Stack stack = new Stack();

		for(int i=0; i<count; i++) {
			String input = br.readLine();
			boolean check = true;
		
			for(int j=0; j<input.length(); j++) {
				char ch = input.charAt(j);
				if(ch=='(')
					stack.push(ch);
				else if(ch==')')
					if(stack.empty()) {
						check = false;
						
					}else {
						stack.pop();
					}
			}
			if(stack.empty()&& check==true) {
				bw.write("YES \n");
			}else {
				bw.write("NO \n");
				
			}
			stack.clear();
		}
		bw.flush();
		bw.close();
		
	}

}
