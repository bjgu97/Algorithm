

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BJ_1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(br.readLine());
		}
		
		// 작은거부터 정렬
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		
		// 큰거부터 정렬
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int n = 0; n < N; n++) {
			int num = NArr[n];
			
			// 처음 들어온 값은 그냥 출력
			if(pq1.isEmpty() && pq2.isEmpty()) {
				pq2.offer(num);
				System.out.println(num);
			}
			
			// 두번째 값 삽입 부터
			else {
				if(pq1.size() != pq2.size()) {
					pq1.offer(num);
				}
				else { 
					pq2.offer(num); 
				}
				if(pq1.peek() < pq2.peek()) {
					int tmp = pq1.poll();
					pq1.offer(pq2.poll());
					pq2.offer(tmp);
				}
//				System.out.println(pq1);
//				System.out.println(pq2);
				sb.append(pq2.peek()).append("\n");
			}
		}		
		System.out.println(sb);
	}
}
