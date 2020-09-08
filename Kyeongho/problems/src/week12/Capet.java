package week12;

import java.io.*;

public class Capet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int brown = Integer.parseInt(str[0]);
        int yellow = Integer.parseInt(str[1]);
        int[] result = solution(brown, yellow);

        bw.write(result[0] + " " + result[1]);
        br.close();
        bw.flush();
        bw.close();
    }

    private static int[] solution(int brown, int yellow) {
        int center = yellow;
        int border = 1;
        int[] answer ={center+2, border+2};
        boolean isEnd = false;

        while (!isEnd && border <= yellow / 2) {
            if (((answer[0] * 2) + (border * 2)) == brown) {
                isEnd = true;
            }
            else {
                if (yellow % (border+1) == 0) {
                    border++;
                    center = yellow / border;
                    answer[0] = center + 2;
                    answer[1] = border + 2;
                }
                else {
                    border++;
                }
            }
        }
        return answer;
    }
}
