package hyewon.greedy;

import java.util.Scanner;

public class greedy_1439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int zero =0;
		int one =0;
		
		if(s.charAt(0)=='0'){
			zero++;
		}else{
			one++;
		}
		
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i-1)!=s.charAt(i)){
				if(s.charAt(i)=='0')
					zero++;
				else if(s.charAt(i)=='1')
					one++;
			}
		}
		
		System.out.println(Math.min(zero,one));

	}

}
