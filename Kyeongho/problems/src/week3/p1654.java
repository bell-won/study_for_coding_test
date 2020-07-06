package week3;

import java.io.*;
import java.util.Arrays;

public class p1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] str = s.split(" ");
        int count = Integer.parseInt(str[0]);
        long needCount = Integer.parseInt(str[1]);
        long[] lines = new long[count];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        boolean isFinished = false;
        long end = lines[lines.length-1];
        long start = 1;
        while (start <= end) {
            long mid = (end + start) / 2;
            long baseCount = 0;
            for (int i = 0; i < lines.length; i++) {
                baseCount += lines[i] / mid;
            }
            if (baseCount >= needCount) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        bw.write(start-1 + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
