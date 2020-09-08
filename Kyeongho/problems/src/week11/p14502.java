package week11;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class p14502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);
        int [][] lab = new int[row][col];
        boolean [][] visited = new boolean[row][col];
        int wallCount = 3;
        int max = Integer.MAX_VALUE;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> virus = new LinkedList<>();

        for (int i = 0; i < lab.length; i++) {
            s = br.readLine();
            str = s.split(" ");
            for (int j = 0; j < str.length; j++) {
                lab[i][j] = Integer.parseInt(str[j]);
                if (lab[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                }
                else if (lab[i][j] == 2) {
                    virus.offer(i);
                    virus.offer(j);
                }
                else {
                    wallCount++;
                }
            }
        }

        while (!qx.isEmpty()) {
            int baseX = qx.poll();
            int baseY = qy.poll();
            for (int i = 0; i < qx.size(); i++) {
                int x2 = qx.poll();
                int y2 = qy.poll();
                for (int j = 0; j < qx.size(); j++) {
                    int x3 = qx.poll();
                    int y3 = qy.poll();
                    int count = findSafeArea(baseX, baseY, x2, y2, x3, y3, lab, virus);
                    if (count < max) {
                        max = count;
                    }
                    qx.offer(x3);
                    qy.offer(y3);
                }
                qx.offer(x2);
                qy.offer(y2);
            }
        }
        max = (row * col) - wallCount - max;
        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findSafeArea(int x1, int y1, int x2, int y2, int x3, int y3, int[][] lab, Queue<Integer> v) {
        int[][] mat = new int[lab.length][lab[0].length];
        Queue<Integer> virus = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = lab[i][j];
            }
        }
        mat[x1][y1] = 1;
        mat[x2][y2] = 1;
        mat[x3][y3] = 1;
        int count = 0;

        Iterator<Integer> iter = v.iterator();
        while (iter.hasNext()) {
            virus.offer(iter.next());
        }

        while (!virus.isEmpty()) {
            int x = virus.poll();
            int y = virus.poll();
            visited[x][y] = true;
            count++;
            for (int i = 0; i < direction.length; i++) {
                int indexX = x + direction[i][0];
                int indexY = y + direction[i][1];
                if (indexX >= 0 && indexX < mat.length && indexY >= 0 && indexY < mat[0].length) {
                    if (!visited[indexX][indexY] && mat[indexX][indexY] == 0) {
                        virus.offer(indexX);
                        virus.offer(indexY);
                        visited[indexX][indexY] = true;
                    }
                }
            }
        }

        return count;
    }
}
