package week11;

import java.io.*;

public class p10026 {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        boolean[][] visited1 = new boolean[size][size];
        boolean[][] visited2 = new boolean[size][size];
        char[][] mat1 = new char[size][size];
        char[][] mat2 = new char[size][size];
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < mat1.length; i++) {
            String s = br.readLine();
            char[] c = s.toCharArray();
            for (int j = 0; j < mat1[0].length; j++) {
                mat1[i][j] = c[j];
                mat2[i][j] = c[j];
                if (mat1[i][j] == 'G') {
                    mat2[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (!visited1[i][j]) {
                    count1 = count1 + search(i, j, mat1[i][j], mat1, visited1);
                }
                if (!visited2[i][j]) {
                    count2 = count2 + search(i, j, mat2[i][j], mat2, visited2);
                }
            }
        }

        bw.write(count1 + " " + count2 + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int search(int x, int y, char color, char[][] mat, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < direction.length; i++) {
            int indexX = x + direction[i][0];
            int indexY = y + direction[i][1];
            if (indexX >= 0 && indexX < visited.length && indexY >= 0 && indexY < visited.length && !visited[indexX][indexY] && mat[indexX][indexY] == color) {
                search(indexX, indexY, color, mat, visited);
            }
        }
        return 1;
    }
}
