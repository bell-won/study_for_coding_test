package hyewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class String_10546 {
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++){
			String str = br.readLine();
			if(map.containsKey(str)){
				map.replace(str, map.get(str)+1);
			}else{
				map.put(str, 1);
			}
		}
		
		for(int i=0; i<n-1; i++){
			String str = br.readLine();
			if(map.containsKey(str)){
				map.replace(str, map.get(str)-1);
			}
		}

		Set set = map.keySet();
		Iterator iterator = set.iterator();		
		while(iterator.hasNext()){
			String key = (String) iterator.next();
			if(map.get(key)>0){
				System.out.println(key);
			}
		}

	}

}
