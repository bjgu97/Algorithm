

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2075_N번째큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < N-1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.peek());
	}
}
