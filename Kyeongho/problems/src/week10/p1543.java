package week10;

import java.io.*;

public class p1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String base = br.readLine();
        int count = 0;

        int num = s.indexOf(base);
        while (num >= 0) {
            count++;
            int nextIndex = num + base.length();
            s = s.substring(num + base.length());
            num = s.indexOf(base);
        }

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
