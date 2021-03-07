package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_11279_최대힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] NArr= new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(br.readLine());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int n = 0;n < N; n++) {
			if(NArr[n] > 0) {
				pq.add(NArr[n]);
			}
			else if(NArr[n] == 0) {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
		}
	}
}
