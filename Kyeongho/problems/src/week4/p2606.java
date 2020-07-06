package week4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int computers = Integer.parseInt(br.readLine());
        int relations = Integer.parseInt(br.readLine());
        int[][] relationMatrix = new int[computers][computers];
        for (int i = 0; i < relations; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            int x = Integer.parseInt(str[0]) - 1;
            int y = Integer.parseInt(str[1]) - 1;
            relationMatrix[x][y] = 1;
            relationMatrix[y][x] = 1;
        }
        for (int i = 0; i < relationMatrix.length; i++) {
            if (relationMatrix[0][i] == 1) {
                q.offer(i);
            }
            else if (relationMatrix[i][0] == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int base = q.poll();
            if (!list.contains(base)) {
                list.add(base);
                for (int i = 1; i < relationMatrix.length; i++) {
                    if (relationMatrix[base][i] == 1) {
                        q.offer(i);
                    }
                }
            }
        }

        bw.write(list.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
