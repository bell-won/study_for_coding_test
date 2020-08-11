package week5;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class p15686 {
    static int[][] homes;
    static int[][] chickens;
    static ArrayList<Integer> list = new ArrayList<>();

    public static int searchMin(int[][] chickens, int[][] homes) {
        int sum = 0;
        for (int i = 0; i < homes.length; i++) {
            int result = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                int x = homes[i][0];
                int y = homes[i][1];
                int distance = (Math.abs(x - chickens[list.get(j)][0])) + (Math.abs(y - chickens[list.get(j)][1]));
                if (distance < result) {
                    result = distance;
                }
            }
            sum += result;
        }
        return sum;
    }

    public static void selectMin(int start, int count, boolean[] visited, int size, ArrayList<Integer> resultList) {
        int result = Integer.MAX_VALUE;
        list.add(start);

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                selectMin(i, count + 1, visited, size, resultList);
                visited[i] = false;
            }
        }

        if (count == size - 1) {
            int sum = searchMin(chickens, homes);
            if (sum < result) {
                result = sum;
            }
            resultList.add(result);
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] str = s.split(" ");
        int citySize = Integer.parseInt(str[0]);
        int stores = Integer.parseInt(str[1]);
        int[][] city = new int[citySize][citySize];
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < citySize; i++) {
            s = br.readLine();
            str = s.split(" ");
            for (int j = 0; j < str.length; j++) {
                city[i][j] = Integer.parseInt(str[j]);
                if (city[i][j] == 1) {
                    q1.offer(i);
                    q1.offer(j);
                }
                else if (city[i][j] == 2) {
                    q2.offer(i);
                    q2.offer(j);
                    count++;
                }
            }
        }

        homes = new int[q1.size()/2][2];
        chickens = new int[q2.size()/2][2];

        for (int i = 0; i < homes.length; i++) {
            homes[i][0] = q1.poll();
            homes[i][1] = q1.poll();
        }

        for (int i = 0; i < chickens.length; i++) {
            chickens[i][0] = q2.poll();
            chickens[i][1] = q2.poll();
        }

        boolean[] visited = new boolean[chickens.length];
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < chickens.length; i++) {
            visited[i] = true;
            selectMin(i, 0, visited, stores, resultList);
            visited[i] = false;
        }
        Collections.sort(resultList);
        int resultNumber = resultList.get(0);
        bw.write(resultNumber + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
