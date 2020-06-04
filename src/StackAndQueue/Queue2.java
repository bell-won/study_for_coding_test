package StackAndQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> qu = new LinkedList<Integer>();
		for(int i=0; i<test; i++) {
			String[] str = br.readLine().split(" ");

			if(str[0].equals("push")) {
				qu.add(Integer.parseInt(str[1]));
			}else if(str[0].equals("pop")) {
				if(qu.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(qu.poll()+"\n");
				}
			}else if(str[0].equals("front")) {
				if(qu.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(String.valueOf(qu.peek())+"\n");
				}
			}else if(str[0].equals("back")) {
				if(qu.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(qu.getLast()+"\n");
				}
			}else if(str[0].equals("size")) {
				bw.write(qu.size()+"\n");
			}else if(str[0].equals("empty")) {
				if(qu.isEmpty()) {
					bw.write(1+"\n");
				}else {
					bw.write(0+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
