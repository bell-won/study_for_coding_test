package hyewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string_9996 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String start = "",end = "";
		boolean check = false;
		for(int i=0; i<pattern.length(); i++){
			if(pattern.charAt(i)=='*'){
				check = true;
				continue;
			}
			if(check==false){
				start += pattern.charAt(i);
			}else{
				end += pattern.charAt(i);
			}
		}
		

		for(int i=0; i<n; i++){
			String s = br.readLine();
			check = false;
			
			if(s.length()>=start.length()+end.length()){
				for(int j=0; j<start.length(); j++){
					if(s.charAt(j)!=start.charAt(j)){
						check = true;
						break;
					}	
				}
				
				int a =1;
				for(int j=end.length()-1; j>=0; j--){
					if(s.charAt(s.length()-a)!=end.charAt(j)){
						check = true;
						break;
					}
					a++;
				}
				
				if(check==true){
					System.out.println("NE");				
				}else{
					System.out.println("DA");
				}
				
			}else{
				System.out.println("NE");	
			}
			
			
		}
		
		
		

	}

}
