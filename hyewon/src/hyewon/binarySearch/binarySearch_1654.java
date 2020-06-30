package hyewon.binarySearch;
//https://dundung.tistory.com/53 참고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarySearch_1654 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] array = new int[k];
		
		for(int i=0; i<k; i++){
			array[i] = Integer.parseInt(br.readLine());			
		}
		
		Arrays.sort(array);
		
		long min =1;
		long max = array[k-1];     // int로 할 경우 error 발생
		long middle =0;
		
		while(min <= max) {
            middle = (max+min)/2;
            long count = 0;
            for(int j=0; j<array.length; j++) {
                count += array[j]/middle;
            }
            if(count >= n) {  
                min = middle + 1;
            }else if(count < n) {
                max = middle - 1;   
            }
        }
		System.out.println(max);

	}
}
