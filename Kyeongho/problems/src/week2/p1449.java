package week2;

import java.io.*;
import java.util.Arrays;

public class p1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] str = s.split(" ");
        int tapeLength = Integer.parseInt(str[1]);
        s = br.readLine();
        str = s.split(" ");
        int[] pipe = new int[str.length];

        int tapeCount = 0;
        int currTape = tapeLength - 1;

        for (int i = 0; i < pipe.length; i++) {
            pipe[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(pipe);

        if (pipe.length > 1) {
            for (int i = 1; i < pipe.length; i++) {
                if ((pipe[i] > 0 && pipe[i - 1] > 0) || (currTape > 0 && currTape < tapeLength - 1)) {
                    if (pipe[i] - pipe[i - 1] == currTape) {
                        pipe[i] = 0;
                        pipe[i - 1] = 0;
                        currTape = 0;
                        tapeCount++;
                    } else if (pipe[i] - pipe[i - 1] < currTape) {
                        currTape -= pipe[i] - pipe[i - 1];
                        pipe[i - 1] = 0;
                    } else if (pipe[i] - pipe[i - 1] > currTape) {
                        currTape = 0;
                        tapeCount++;
                        pipe[i - 1] = 0;
                    }
                }
                if (pipe[i - 1] == 0 && i == pipe.length - 1 && pipe[i] != 0) {
                    tapeCount++;
                }
                if (currTape == 0) {
                    currTape = tapeLength - 1;
                }
            }
        }
        else {
            tapeCount++;
        }

        bw.write(tapeCount + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
