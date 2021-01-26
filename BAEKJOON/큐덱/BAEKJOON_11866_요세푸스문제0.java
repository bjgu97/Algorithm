package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백으로 구분
		
		int N = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queueTemp = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int n = 1;
		
		for(int i = 0; i < N; i++) {
			if(i % 3 == 0)
				System.out.println(i & 3);
				queueTemp.add(queue.poll());
			else
				continue;
		}

		System.out.println(queueTemp.poll());
		System.out.println(queueTemp.poll());
		System.out.println(queueTemp.poll());
	}

}
