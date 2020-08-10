package week7;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p7569 {
    static int[][][] tomato;
    static int[][] direction = {{0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};
    static Queue<Integer> qh = new LinkedList<>();
    static Queue<Integer> qx = new LinkedList<>();
    static Queue<Integer> qy = new LinkedList<>();
    static int zeroCount = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int h = Integer.parseInt(str[2]);
        tomato = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                s = br.readLine();
                str = s.split(" ");
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(str[k]);
                    if (tomato[i][j][k] == 1) {
                        qh.offer(i);
                        qx.offer(j);
                        qy.offer(k);
                    }
                    else if (tomato[i][j][k] == 0) {
                        zeroCount++;
                    }
                }
            }
        }
        if (zeroCount == 0) {
            result = 0;
        }
        else {
            searchCount();
            if (zeroCount > 0) {
                result = -1;
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void searchCount() {
        int count = qh.size();

        while (!qh.isEmpty()) {
            if (count == 0) {
                count = qh.size();
                result++;
            }
            int h = qh.poll();
            int x = qx.poll();
            int y = qy.poll();
            count--;
            for (int i = 0; i < direction.length; i++) {
                int hIndex = h + direction[i][0];
                int xIndex = x + direction[i][1];
                int yIndex = y + direction[i][2];
                if (hIndex >= 0 && hIndex < tomato.length && xIndex >= 0 && xIndex < tomato[0].length && yIndex >= 0 && yIndex < tomato[0][0].length) {
                    if (tomato[hIndex][xIndex][yIndex] == 0) {
                        tomato[hIndex][xIndex][yIndex] = 1;
                        qh.offer(hIndex);
                        qx.offer(xIndex);
                        qy.offer(yIndex);
                        zeroCount--;
                    }
                }
            }
        }
    }
}
