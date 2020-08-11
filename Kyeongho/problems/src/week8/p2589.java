package week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p2589 {
    public static class Element {
        int x, y, dist;
        Element (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        char[][] map = new char[x][y];
        int max = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Element> distance = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            s = br.readLine();
            char[] c = s.toCharArray();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = c[j];
                if (map[i][j] == 'L') {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }

        while (!qx.isEmpty()) {
            int tmpX = qx.poll();
            int tmpY = qy.poll();
            int[][] visited = new int[x][y];
            distance.offer(new Element(tmpX, tmpY, 0));
            map[tmpX][tmpY] = 'W';
            while (!distance.isEmpty()) {
                Element base = distance.poll();
                int baseX = base.x;
                int baseY = base.y;
                int dist = base.dist;
                for (int i = 0; i < direction.length; i++) {
                    int indexX = baseX + direction[i][0];
                    int indexY = baseY + direction[i][1];
                    if (indexX >= 0 && indexX < map.length && indexY >= 0 && indexY < map[0].length) {
                        if (map[indexX][indexY] == 'L') {
                            if (visited[indexX][indexY] == 0 || visited[indexX][indexY] > dist + 1) {
                                visited[indexX][indexY] = dist + 1;
                                distance.offer(new Element(indexX, indexY, dist + 1));
                                if (max < dist + 1) {
                                    max = dist + 1;
                                }
                            }
                        }
                    }
                }
            }
            map[tmpX][tmpY] = 'L';
        }
        bw.write(max + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
