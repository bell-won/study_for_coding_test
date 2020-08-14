package week10;

import java.io.*;


public class p9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] lcs = new int[c2.length][c1.length];
        int max = 0;

        for (int i = 0; i < lcs.length; i++) {
            char base = c2[i];
            for (int j = 0; j < lcs[0].length; j++) {
                char tmp = c1[j];
                if (base == tmp) {
                    if (i == 0 || j == 0) {
                        lcs[i][j] = 1;
                    }
                    else {
                        lcs[i][j] = lcs[i-1][j-1] + 1;
                    }
                }
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = lcs[i-1][j];
                    }
                    if (j > 0) {
                        left = lcs[i][j-1];
                    }
                    lcs[i][j] = Math.max(up, left);
                }

                if (lcs[i][j] > max) {
                    max = lcs[i][j];
                }
            }
        }

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
