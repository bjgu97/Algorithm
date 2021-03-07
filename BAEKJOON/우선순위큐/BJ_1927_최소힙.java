package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[N];
		
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(br.readLine());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int n = 0; n < N; n++) {
			if(NArr[n] > 0) { // 자연수면
				pq.add(NArr[n]);
			}
			else if(NArr[n] == 0) { // 가장 작은 값 출력
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
		}
	}
}
