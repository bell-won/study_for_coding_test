package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class String_10546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(int i=0;i<N;i++){
			String name = br.readLine();
			hm.put(name,hm.getOrDefault(name, 0)+1 );
		}
		
		for(int i=0;i<N-1;i++){
			String name = br.readLine();
			hm.replace(name, hm.get(name)-1);
		}
		Set<String> keys = hm.keySet();

		for (String key : keys) {
		  if(hm.get(key)==1){
			  System.out.println(key);
			  break;
		  }
		}
		br.close();
	}

}
