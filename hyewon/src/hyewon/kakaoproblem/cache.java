package hyewon.kakaoproblem;

import java.util.LinkedList;

public class cache {
	public static void main(String[] args) {
		System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 50
		System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju"
                , "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); // 21
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 60
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 52
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); // 16
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 25

		
    }

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
