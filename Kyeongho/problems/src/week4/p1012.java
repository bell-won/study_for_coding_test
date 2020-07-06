package week4;

import java.io.*;
import java.util.Stack;

public class p1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int latters = Integer.parseInt(str[2]);
            int[][] matrix = new int[x][y];
            int totalCount = 0;
            for (int j = 0; j < latters; j++) {
                s = br.readLine();
                str = s.split(" ");
                matrix[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            }
            Stack<Integer> stackX = new Stack<>();
            Stack<Integer> stackY = new Stack<>();
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (matrix[j][k] == 1) {
                        matrix[j][k] = 0;
                        stackX.push(j);
                        stackY.push(k);
                        int count = 0;
                        while(!stackX.isEmpty() && !stackY.isEmpty()) {
                            int indexX = stackX.peek();
                            int indexY = stackY.peek();
                            boolean isFinished = true;
                            for (int l = 0; l < directions.length; l++) {
                                int tmpX = indexX + directions[l][0];
                                int tmpY = indexY + directions[l][1];
                                if (tmpX >= 0 && tmpX < matrix.length && tmpY >= 0 && tmpY < matrix[0].length) {
                                    if (matrix[tmpX][tmpY] == 1) {
                                        matrix[tmpX][tmpY] = 0;
                                        stackX.push(tmpX);
                                        stackY.push(tmpY);
                                        isFinished = false;
                                        break;
                                    }
                                }
                            }
                            if (isFinished) {
                                stackX.pop();
                                stackY.pop();
                                count++;
                            }
                        }
                        count--;
                        totalCount += count;
                    }
                }
            }
            bw.write((latters - totalCount) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
