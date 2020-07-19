package hyewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class String_5525 {
	static int n,m;
	static String s;
	static StringBuilder pattern;
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		s = br.readLine();
		setting();
		
		ArrayList<Integer> list = KMP(s, pattern.toString());
		
		System.out.println(list.size());
		
	}
	public static void setting() {
		pattern = new StringBuilder("IOI");
		
		for(int i=1; i<n; i++){
			pattern.append("OI");
		}
    }
	public static int[] getPi(String pattern){   // 접두사와 접미사를 매칭하여 count
		int lengthOfP = pattern.length();   
		int []pi = new int[lengthOfP];       
		int j =0;                                
		
		for(int i=1; i<lengthOfP; i++){
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
				j= pi[j-1];
			}if(pattern.charAt(i)==pattern.charAt(j)){
				pi[i] = ++j;
			}
		}
		return pi;		
		
	}
	public static ArrayList<Integer> KMP(String s, String pattern){    // 매칭되는 s를 arraylist에 저장
		ArrayList<Integer> list = new ArrayList<>();     
		int []pi = getPi(pattern);
		int lengthOfS = s.length();
		int lengthOfP = pattern.length();
		int j =0;
		
		for(int i=0; i<lengthOfS; i++){
			while(j>0 && s.charAt(i)!=pattern.charAt(j)){
				j = pi[j-1];
			}if(s.charAt(i)==pattern.charAt(j)){
				if(j==lengthOfP-1){
					list.add(i-lengthOfP+1);
					j = pi[j];
				}else{
					j++;
				}
			}
		}
		return list;	
	}
}
