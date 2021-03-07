package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2696_중앙값구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int cnt = 0;
			int M = Integer.parseInt(br.readLine());
			int[] MArr = new int[M];
			if(M <= 10) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int m = 0; m < M; m++) {
					MArr[m] = Integer.parseInt(st.nextToken());
				}				
			}
			else if(M > 10) {
				int m = 0;
				for(int i= 0; i < (M/10+1); i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					while(st.hasMoreTokens())
						MArr[m++] = Integer.parseInt(st.nextToken());
				}
			}
			
//			System.out.println(Arrays.toString(MArr));
			
			// 중앙값의 개수 출력
			int medianNum = (M+1) / 2;
			System.out.println(medianNum);
			
			// 중앙값 차례로 출력
			PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 작은거부터 춫력. 중앙값보다 큰 값들 저장.
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> { // 큰거부터 정렬. 중앙값보다 작은 값들 저장. 
				return o2 - o1;
			});
			
			for(int m = 0; m < M; m++) {
				int num = MArr[m];
				if(minHeap.size() == 0 && maxHeap.size() == 0) {
					maxHeap.offer(num);
				}
				else {
					if(minHeap.size() == maxHeap.size()) {
				
						maxHeap.offer(MArr[m]);
					
						if(minHeap.peek() < maxHeap.peek()) {
							int temp = minHeap.poll();
							minHeap.offer(maxHeap.poll());
							maxHeap.offer(temp);
							
						}
					}
					
					else if(minHeap.size() != maxHeap.size()) {
						minHeap.offer(MArr[m]);
					}
				}
				
				if(m % 2 == 0) {
					if(medianNum <=10)
						System.out.print(maxHeap.peek() + " ");
					else {
						cnt++;
						System.out.print(maxHeap.peek() + " ");
						if(cnt % 10 == 0)
							System.out.println();
					}
				}
			}
			System.out.println();
		}
	}
}
