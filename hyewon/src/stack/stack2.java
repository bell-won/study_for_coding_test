package stack;

import java.util.Scanner;
import java.util.Stack;

public class stack2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack();
		int size =0;	
		String input = sc.next();
		
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '(') {
				stack.push('(');
			}else if(input.charAt(i) == ')') {
				stack.pop();
				if(input.charAt(i-1) == '(') {
					size += stack.size();
				}else if(input.charAt(i-1) == ')') {
					size += 1;
				}
			}
		}
		System.out.println(size);
	}
		

}
