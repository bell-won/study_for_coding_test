package hyewon.kakaoproblem;

import java.util.LinkedList;

public class cache {
	
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0){
        	return cities.length * 5;
        }
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){
        	String s = cities[i];
        	s = s.toUpperCase();
        	
        	if(cache.contains(s)){   // cache hit
        		cache.remove(s);
        		cache.add(s);
        		answer+=1;
        	}else{                   // cache miss
        		if(cache.size()>=cacheSize){  
        			cache.remove(0);
        		}
        		cache.add(s);
    			answer += 5; 
        	}
        }
        
        return answer;
    }

}
