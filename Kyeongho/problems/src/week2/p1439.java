package week2;

import java.io.*;

public class p1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s  = br.readLine();
        String[] str = s.split("");
        int[] numbers = new int[str.length];
        int zero = 0;
        int one = 0;

        for (int i = 0; i < numbers.length; i++) {
            int n = Integer.parseInt(str[i]);
            numbers[i] = n;
        }

        for(int i = 1; i < numbers.length; i++) {
            if (numbers[i-1] != numbers[i]) {
                if (numbers[i] == 0) {
                    zero++;
                }
                else {
                    one++;
                }
            }
        }

        if (numbers[0] == 0) {
            zero++;
        }
        else {
            one++;
        }

        bw.write(Math.min(zero, one) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
