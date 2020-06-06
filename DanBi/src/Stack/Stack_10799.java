package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> st = new Stack<>();
		boolean op = true;
		int result = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				op = true;
				st.push('(');
			}else{
				st.pop();
				if(op==false){
					result += 1;
				}else{
					result += st.size();
				}
				op = false;
			}
		}
		System.out.println(result);
		
	}

}
