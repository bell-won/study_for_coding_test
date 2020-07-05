package week4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p2599 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalboys = Integer.parseInt(br.readLine());
        int totalgirls = totalboys;
        Queue<Integer> boys = new LinkedList<>();
        Queue<Integer> girls = new LinkedList<>();
        int[][] total = new int[3][2];

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            boys.offer(Integer.parseInt(str[0]));
            girls.offer(Integer.parseInt(str[1]));
        }
        boolean isPossible = true;
        for (int i = 0; i < boys.size(); i++) {
            int boy = boys.poll();
            int girlA = girls.poll();
            int girlB = girls.poll();
            int girlC = girls.poll();
            if (boy > girlB + girlC) {
                isPossible = false;
                break;
            }
            else {
                if (girlB >= boy) {
                    girlB = girlB - boy;
                    total[i][0] = boy;
                    boy = 0;
                }
                else {
                    total[i][0] = girlB;
                    boy = boy - girlB;
                    girlB = 0;
                }
                if (girlC >= boy) {
                    girlC = girlC - boy;
                    total[i][1] = boy;
                    boy = 0;
                }
                else {
                    total[i][1] = girlC;
                    boy = boy - girlC;
                    girlC = 0;
                }
            }
            girls.offer(girlB);
            girls.offer(girlC);
            boys.offer(boy);
            girls.offer(girlA);
        }
        if (isPossible) {
            bw.write(1 + "\n");
            for (int i = 0; i < total.length; i++) {
                if (i == 1) {
                    bw.write(total[i][1] + " " + total[i][0] + "\n");
                } else {
                    bw.write(total[i][0] + " " + total[i][1] + "\n");
                }
            }
        } else {
            bw.write(0 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
