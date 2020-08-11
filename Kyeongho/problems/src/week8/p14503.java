package week8;

import java.io.*;

public class p14503 {
    static int[][] map;
    static int[][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int[][] backDirection = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int count = 0;

    private static class Element {
        int x, y, dir;
        Element (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        s = br.readLine();
        str = s.split(" ");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        int d = Integer.parseInt(str[2]);
        Element base = new Element(r, c, d);
        map = new int[x][y];

        for (int i = 0; i < map.length; i++) {
            s = br.readLine();
            str = s.split(" ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        cleanMap(base);

        bw.write(count + " ");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void cleanMap(Element base) {
        int x = base.x;
        int y = base.y;
        int dir = base.dir;
        int endCount = 0;

        while (true) {
            if (endCount == 4) {
                int indexX = x + backDirection[dir][0];
                int indexY = y + backDirection[dir][1];
                if (indexX >= 0 && indexX < map.length && indexY >= 0 && indexY < map[0].length) {
                    if (map[indexX][indexY] == 1) {
                        return;
                    }
                    else {
                        x = indexX;
                        y = indexY;
                        endCount = 0;
                    }
                }
            }
            if (map[x][y] == 0) {
                map[x][y] = 2;
                count++;
            }
            int nextDir = dir - 1;
            if (nextDir < 0) {
                nextDir = 3;
            }
            int indexX = x + direction[dir][0];
            int indexY = y + direction[dir][1];

            if (indexX >= 0 && indexX < map.length && indexY >= 0 && indexY < map[0].length) {
                if (map[indexX][indexY] == 0) {
                    x = indexX;
                    y = indexY;
                    dir = nextDir;
                    endCount = 0;
                }
                else {
                    dir = nextDir;
                    endCount++;
                }
            }
            else {
                dir = nextDir;
                endCount++;
            }
        }
    }
}
