package hyewon.kakaoproblem;

// https://programmers.co.kr/learn/courses/30/lessons/42842

public class carpet {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;   
        int w,h;
        for(int i=3; i<area; i++){
        	if(area%i==0){
        		w = i;
        		h = area/i;		
        		if(w>=h && (w-2)*(h-2)==yellow){ 
        			answer[0] = w;
        			answer[1] = h;
        		}
        		continue;
        	}
        }
 
        return answer;
    }
}
