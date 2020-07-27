package String;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_9996 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String pattern = br.readLine();

		StringTokenizer st = new StringTokenizer(pattern, "*");
		String before = st.nextToken();
		String after = st.nextToken();
		
		for(int i=0;i<N;i++){
			boolean check_before = false;
			boolean check_after = false;
			String s = br.readLine();
			if(s.length()<before.length()+after.length()){
				System.out.println("NE");
				continue;
			}
			if(s.substring(0, before.length()).equals(before)){
				check_before=true;
			}
			if(s.substring(s.length()-after.length(), s.length()).equals(after)){
				check_after=true;
			}
			if(check_before==true&&check_after==true){
				System.out.println("DA");
			}else{
				System.out.println("NE");
			}
		}
		

	}// end of main

}// end of class
