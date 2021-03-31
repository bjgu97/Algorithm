package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BJ_1715_카드정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
//		for(int n = 0; n < N; n++) {
//			arr[n] = Integer.parseInt(br.readLine());
//		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int n = 0; n < N; n++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int num = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		while(pq.size() > 1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			
			num = num1 + num2;
			list.add(num); // 비교 횟수 저장
			
			pq.add(num);
		}
		
		int sum = 0;
		for(int i : list)
			sum += i;
		
		System.out.println(sum);
	}
}
