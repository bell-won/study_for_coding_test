package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++){
			Stack<Character> st = new Stack<Character>();
			String s = br.readLine();
			boolean ch = true;
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)=='('){
					st.push(s.charAt(j));
				}
				else{
					if(st.empty()==true){
						ch=false;
					}
					else st.pop();
				}
			}
			if(st.empty()==true&&ch==true){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		
	}

}
