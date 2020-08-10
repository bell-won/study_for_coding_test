package week7;

import java.io.*;

public class p2644 {
    static int[][] relation;
    static int count = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] str = s.split(" ");
        int person1 = Integer.parseInt(str[0]) - 1;
        int person2 = Integer.parseInt(str[1]) - 1;
        relation = new int[size][size];
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            s = br.readLine();
            str = s.split(" ");
            int x = Integer.parseInt(str[0]) - 1;
            int y = Integer.parseInt(str[1]) - 1;
            relation[x][y] = 1;
            relation[y][x] = 1;
        }
        searchRelation(person1, person2, person1);
        if (result == 0) {
            result = -1;
        }
        bw.write(result + "\n");


        br.close();
        bw.flush();
        bw.close();
    }

    private static void searchRelation(int person1, int person2, int recent) {
        if (relation[person1][person2] == 1) {
            result = count + 1;
        }
        else {
            for (int i = 0; i < relation[person1].length; i++) {
                if (relation[person1][i] == 1 && i != recent) {
                    count++;
                    searchRelation(i, person2, person1);
                    if (result != 0) {
                        break;
                    }
                    count--;
                }
            }
        }
    }
}
