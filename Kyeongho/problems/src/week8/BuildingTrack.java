package week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BuildingTrack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] board = new int[size][size];

        for (int i = 0; i < board.length; i++) {
            String s = br.readLine();
            String[] str = s.split("");
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }
        int result = solution(board);
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static class Element {
        int x, y, price, dir;
        Element(int x, int y, int price, int dir) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.dir = dir;
        }
    }

    private static int solution(int[][] board) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int [][] visited = new int [board.length][board.length];
        Queue<Element> q = new LinkedList<>();
        int endX = board.length-1;
        int endY = board.length-1;

        if (board[0][1] != 1) {
            q.offer(new Element(0, 1, 100, 0));
            visited[0][1] = 100;
        }
        if (board[1][0] != 1) {
            q.offer(new Element(1, 0, 100, 1));
            visited[1][0] = 100;
        }

        while (!q.isEmpty()) {
            Element tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int dir = tmp.dir;
            if (visited[x][y] != 0 && tmp.price > visited[x][y]) {
                continue;
            }

            for (int i = 0; i < direction.length; i++) {
                int indexX = x + direction[i][0];
                int indexY = y + direction[i][1];
                int tmpPrice = 100;
                if (i != dir) {
                    tmpPrice += 500;
                }
                if ((indexX > 0 || indexY > 0) && indexX >= 0 && indexY >= 0 && indexX < board.length && indexY < board.length) {
                    if (board[indexX][indexY] != 1) {
                        int price = visited[x][y] + tmpPrice;
                        if (visited[indexX][indexY] == 0 || price <= visited[indexX][indexY]) {
                            visited[indexX][indexY] = price;
                            q.offer(new Element(indexX, indexY, price, i));
                        }
                    }
                }
            }
        }
        return visited[endX][endY];
    }
}
