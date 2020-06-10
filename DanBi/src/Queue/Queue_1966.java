package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseN = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		for(int i=0;i<testCaseN;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int n = Integer.parseInt(st.nextToken()); //문서 개수
			int target = Integer.parseInt(st.nextToken()); // 궁금한 문서 인덱스
			int[] arr = new int[n]; // 정렬용 배열
			LinkedList<Integer> qu = new LinkedList<>();
			s = br.readLine();
			st = new StringTokenizer(s," ");
			for(int j=0;j<n;j++){
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num; 
				qu.add(num);
			}
			Arrays.sort(arr);
			int index = arr.length-1;
			int answer = 1; //몇번째로 인쇄
			while(true){
				//queue.peek()이 현재 가장 큰 수가 될때까지 
				while(qu.peek()!=arr[index]){
					qu.add(qu.poll());
					if(target==0){
						target = qu.size()-1;
					}else{
						target--;
					}
				}
				if(target==0){ // 해당 문서 인덱스인 경우
					System.out.println(answer);
					break;
				}else{ // 해당 문서가 아닌 경우
					qu.poll();
					answer++;
					index--;
					if(target==0){
						target = qu.size()-1;
					}else{
						target--;
					}
				}
			}
		}
		
	}

}
