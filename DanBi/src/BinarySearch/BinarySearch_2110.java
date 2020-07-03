package BinarySearch;
// 참고 : https://mygumi.tistory.com/301
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_2110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] house = new int[N];
		for(int i=0;i<N;i++){
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int first = 1; // 최소거리 
	    int last = house[N-1]-house[0]; //최대거리 
	    int answer = 0;
	    int d = 0;
	    
	    
	    // 기준을 정해서 공유기 수 + 간격 조정
	    while(first<=last){
	    	int mid = (first+last)/2;
	    	int count = 1;
	    	int start = house[0];
	    	for (int i = 1; i < N; i++) {
	            d = house[i] - start;
	            if (mid <= d) {
	                ++count;
	                start = house[i];
	            }
	        }
	 
	        if (count >= C) {
	            // 공유기의 수를 줄이자 => 간격 넓히기
	        	answer = mid;
	            first = mid + 1;
	        } else {
	            // 공유기가 더 설치되어야한다. => 간격 좁히기
	            last = mid - 1;
	        }
	    }
	    System.out.println(answer);
	}

}
