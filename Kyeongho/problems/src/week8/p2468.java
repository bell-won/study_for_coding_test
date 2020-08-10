package week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int size = Integer.parseInt(s);
        int[][] map = new int[size][size];
        int maxHeight = 0;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int result = 0;

        for (int i = 0; i < map.length; i++) {
            s = br.readLine();
            String[] str = s.split(" ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        for (int n = 0; n <= maxHeight; n++) {
            boolean[][] visited = new boolean[size][size];
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] > n && !visited[i][j]) {
                        qx.offer(i);
                        qy.offer(j);
                        count++;
                        visited[i][j] = true;
                        while (!qx.isEmpty()) {
                            int x = qx.poll();
                            int y = qy.poll();
                            for (int k = 0; k < direction.length; k++) {
                                int indexX = x + direction[k][0];
                                int indexY = y + direction[k][1];
                                if (indexX >= 0 && indexX < map.length && indexY >= 0 && indexY < map[0].length) {
                                    if (map[indexX][indexY] > n && !visited[indexX][indexY]) {
                                        visited[indexX][indexY] = true;
                                        qx.offer(indexX);
                                        qy.offer(indexY);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (result < count) {
                result = count;
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
