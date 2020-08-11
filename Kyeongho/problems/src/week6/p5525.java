package week6;

import java.io.*;

public class p5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] str = s.split("");
        int result = 0;
        int count = 0;

        for (int i = 1; i < length - 1; i++) {
            if (str[i-1].equals("I") && str[i].equals("O") && str[i+1].equals("I")) {
                count++;
                if (count == size) {
                    result++;
                    count--;
                }
                i++;
            }
            else {
                count = 0;
            }
        }


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
