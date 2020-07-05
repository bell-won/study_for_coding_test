package week1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class p1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		boolean finished = false;
		int resultCount = 0;

		for (int i = 0; i < count; i++) {
			String s = br.readLine();
			String priority = br.readLine();
			String[] str = s.split(" ");
			int priorityIndex = Integer.parseInt(str[1]);
			str = priority.split(" ");
			Queue<Integer> indexQ = new LinkedList<>();
			Queue<Integer> priorityQ = new LinkedList<>();
			Integer[] pivots = new Integer[str.length];
			int pivot = 0;

			for (int j = 0; j < str.length; j++) {
				indexQ.offer(j);
				priorityQ.offer(Integer.parseInt(str[j]));
				pivots[j] = Integer.parseInt(str[j]);
			}
			Arrays.sort(pivots, Comparator.reverseOrder());

			while (!finished) {
				if (priorityQ.peek() != pivots[pivot]) {
					int tmp = priorityQ.poll();
					priorityQ.offer(tmp);
					tmp = indexQ.poll();
					indexQ.offer(tmp);
				}
				else if (priorityQ.peek() == pivots[pivot]) {
					if (indexQ.peek() == priorityIndex) {
						finished = true;
					}
					else {
						indexQ.poll();
						priorityQ.poll();
					}
					pivot++;
				}
			}
			finished = false;
			bw.write(pivot + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
