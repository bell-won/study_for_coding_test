package hyewon.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarySearch_2110 {

	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int []array = new int[n];
        
        for(int i=0; i<n; i++){
        	array[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(array);
        
        int start = 1;
        int end = array[n-1]-1;
        int count =1;
        int result,mid =0;
        
        while(start<=end){
        	mid = (start+end)/2;
        	int prev = array[0];
        	for(int i=1; i<array.length; i++){
        		if(array[i]-prev>=mid){
        			count++;
        			prev = array[i];
        		}
        	}
        	if(count>=c){
        		result = mid;
        		start = mid + 1;        		
        	}else{
        		end = mid - 1;
        	}
        
        	
        }
        System.out.println(mid);
        
    }

}

