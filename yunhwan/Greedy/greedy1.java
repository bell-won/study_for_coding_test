package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greedy1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int zero = 0;
		int one = 0;
		int temp = 0;
		String[] str = s.split("");
		if(str[0].equals("0")) {
			zero++;	temp = 0;
		}else {
			one++; temp = 1;
		}
		
		for(int i=1; i<s.length(); i++) {
			if(str[i].equals(temp+"")) {
				continue;
			}else {
				temp = Math.abs(temp-1);
				if(temp == 0) {
					zero++;
				}else {
					one++;
				}
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
