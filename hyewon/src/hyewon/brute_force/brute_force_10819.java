package hyewon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class brute_force_10819 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans = 0;
		
        do {
            int sum = 0;
            for (int i = 0; i < arr.length - 1; i++){
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            ans = Math.max(ans, sum);
        } while (permutation(arr));
        System.out.println(ans + "\n");

        
    }
    static boolean permutation(int[] array) {
        int i = array.length - 1;
        
        // 내림차순인지 확인
        while (i > 0 && array[i-1] >= array[i]) {
            i--;            
        }
        if (i <= 0)
            return false;
     
        int j = array.length - 1;
        while (array[j] <= array[i-1]) {
            j--;            
        }
        swap(array,i-1,j);
        j = array.length - 1;
        while (i < j) {
        	swap(array,i,j);
            i++;
            j--;
        }   
        return true;
    }
    static void swap(int[] arr, int i,int j){
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }

}
