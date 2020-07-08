package queue;

import java.io.*;
import java.util.*;
 
public class queue2{
    public static void main(String[] args) throws IOException {
    	LinkedList<Integer> que = new LinkedList<Integer>();    // 큐의 생성
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int count = Integer.parseInt(st.nextToken());
    	
    	for(int i=0; i<count; i++) {
    		st = new StringTokenizer(br.readLine());
    		String temp =st.nextToken();
    		if(temp.equals("push")) {
    			que.add(Integer.parseInt(st.nextToken()));
    		}else if(temp.equals("pop")) {
    			if(que.size()==0)
    				bw.write("-1 \n");
    			else
    				bw.write(que.poll() + "\n");
    		}else if(temp.equals("size")) {
    			bw.write(que.size() + "\n");
    		}else if(temp.equals("empty")) {
    			if(que.size()==0)
    				bw.write("1 \n");
    			else
    				bw.write("0 \n");
    		}else if(temp.equals("front")) {
    			if(que.size()==0)
    				bw.write("-1 \n");
    			else
    				bw.write(Integer.toString(que.get(0)) + "\n");
    		}else if(temp.equals("back")) {
    			if(que.size()==0)
    				bw.write("-1 \n");
    			else
    				bw.write(que.peekLast() + "\n");
    			}
    		
    	}
    	bw.flush();
    	bw.close();
        
    }
}