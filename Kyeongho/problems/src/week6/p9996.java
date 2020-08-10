package week6;

import java.io.*;

public class p9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int fileCount = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] files = new String[fileCount];

        for (int i = 0; i < files.length; i++) {
            files[i] = br.readLine();
        }

        for (int i = 0; i < files.length; i++) {
            if(findName(files[i], pattern)) {
                bw.write("DA\n");
            }
            else {
                bw.write("NE\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean findName(String file, String pattern) {
        boolean result = false;
        String s = pattern.replace("*", " ");
        String[] str = s.split(" ");
        String start = str[0];
        String[] starts = start.split("");
        String end = str[1];
        String[] ends = end.split("");
        String[] base = file.split("");
        int count = 0;

        if (base.length >= starts.length + ends.length) {
            for (int i = 0; i < starts.length; i++) {
                if (base[i].equals(starts[i])) {
                    count++;
                    if (count == starts.length) {
                        result = true;
                    }
                }
            }
            if (result) {
                result = false;
                count = 0;
                for (int i = 0; i < ends.length; i++) {
                    if (base[base.length - ends.length + i].equals(ends[i])) {
                        count++;
                        if (count == ends.length) {
                            result = true;
                        }
                    }
                }
            }
        }

        return result;
    }
}
