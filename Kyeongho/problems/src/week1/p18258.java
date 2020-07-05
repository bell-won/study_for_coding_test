package week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            String[] instruction = input.split(" ");
            switch (instruction[0]) {
                case "push" :
                    q.offer(Integer.parseInt(instruction[1]));
                    break;
                case "pop" :
                    if (q.isEmpty()) {
                        bw.write(-1 + "\n");
                    }
                    else {
                        bw.write(q.poll() + "\n");
                    }
                    break;
                case "size" :
                    bw.write(q.size() + "\n");
                    break;
                case "empty" :
                    if (q.isEmpty()) {
                        bw.write(1 + "\n");
                    }
                    else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "front" :
                    if (q.isEmpty()) {
                        bw.write(-1 + "\n");
                    }
                    else {
                        bw.write(((LinkedList<Integer>) q).getFirst() + "\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        bw.write(-1 + "\n");
                    }
                    else {
                        bw.write(((LinkedList<Integer>) q).getLast() + "\n");
                    }
                    break;
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
