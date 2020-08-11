package week7;

import java.io.*;

public class p1987 {
    static int max = 0;
    static int count = 0;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] alphabet;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        alphabet = new char[x][y];

        for (int i = 0; i < x; i++) {
            s = br.readLine();
            char[] arr = s.toCharArray();
            for(int j = 0; j < y; j++) {
                alphabet[i][j] = arr[j];
            }
        }
        visited[(int) alphabet[0][0] - 65] = true;
        searchLoot(0, 0);

        if (max == 0) {
            max = 1;
        }
        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void searchLoot(int x, int y) {
        count++;
        for (int i = 0; i < directions.length; i++) {
            int xIndex = x + directions[i][0];
            int yIndex = y + directions[i][1];
            if (xIndex >= 0 && xIndex < alphabet.length && yIndex >= 0 && yIndex < alphabet[0].length){
                if (!visited[(int) alphabet[xIndex][yIndex] - 65]) {
                    visited[(int) alphabet[xIndex][yIndex] - 65] = true;
                    searchLoot(xIndex, yIndex);
                    if (max < count) {
                        max = count;
                    }
                    count--;
                    visited[(int) alphabet[xIndex][yIndex] - 65] = false;
                }
            }
        }
    }
}
