## [IOIOI (백준5525)](https://www.acmicpc.net/problem/5525)

- #### 문제

N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

- P1 IOI
- P2 IOIOI
- P3 IOIOIOI
- PN IOIOI...OI (O가 N개)

I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.

---



- #### 입력

첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다. (1 ≤ N ≤ 1,000,000, 2N+1 ≤ M ≤ 1,000,000)

---



- #### 출력

S에 PN이 몇 군데 포함되어 있는지 출력한다.

---



- #### 코드풀이

처음에는 입력값 N에 따라 O의 개수가 정해지므로 비교할 문자열(ex) n = 3, str = IOIOIOI)을 만든 후 비교하려 하였지만

N == O의 개수이기 때문에

I와 다음 I의 거리를 이용하여 해결하였다.



주어진 문자열에서 I만 빼내 새로운 Integer List에 저장한다.

반복문을 돌면서 get(i) - get(i-1)이 2이면 하나의 O가 들어갈 수 있기 때문에

차이가 2이면 cont를 증가시키고 결국, cont가 원하는 값 N보다 크거나 같아지면 결과값을 증가시킨다.

차이가 2가 아닐 경우, cont를 0으로 초기화 시킨 후 계속해서 진행한다.

---



- #### 코드

```java
package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String[] s = st.nextToken().split("");
		
		List<Integer> list = new ArrayList<Integer>();
		
		int cont = 0;
		int result = 0;
		
		for(int i=0; i<s.length; i++) {
			if(s[i].equals("I")) {
				list.add(i);
			}
		}
		
		System.out.println(list);
		for(int i=1; i<list.size(); i++) {
			if(list.get(i) - list.get(i-1) == 2) {
				cont++;
			}else {
				cont = 0;
			}
			
			if(cont >= n) {
				result++;
			}
		}
		System.out.println(result);	
	}
}

```