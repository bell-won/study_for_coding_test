package week7;

import java.io.*;


public class p11403 {
    static int[] result;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        result = new int[size];


        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            for (int j = 0; j < str.length; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            searchNode(i);
            for (int j = 0; j < result.length; j++) {
                bw.write(result[j] + " ");
                result[j] = 0;
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void searchNode(int index) {
        for (int i = 0; i < result.length; i++) {
            if (graph[index][i] == 1 && result[i] == 0) {
                result[i] = 1;
                searchNode(i);
            }
        }
    }
}
