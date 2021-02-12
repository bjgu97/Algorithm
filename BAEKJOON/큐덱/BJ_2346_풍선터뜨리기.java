package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_2346_풍선터뜨리기 {

	// 위치 알려주는 객체 생성 
	public static class balloon {
		int num; // 번호
		int val; // 위치
		
		balloon(int num, int val) {
			this.num = num;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 풍선 저장 덱
		Deque<balloon> deque = new ArrayDeque<>();
		
		// 결과 저장 리스트
		List<balloon> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 큐에다가 더해주기
		for(int n = 0; n < N; n++) {
			balloon b = new balloon(N, N);

			b.num = Integer.parseInt(st.nextToken());
			b.val = n+1;
			deque.offer(b);
		}
		
		
		//이제 하나씩 풍선 터뜨리기
		while(!deque.isEmpty()) {
			int num = deque.getFirst().num;
			
			// while문 종료 조건
			if(deque.size() == 1) {
				list.add(deque.getFirst());
				break;
			}
			
			if(num > 0) {
				list.add(deque.removeFirst());
				for(int n = 0; n < num-1; n++) { // (num-1) 횟수만큼 반복
					deque.addLast(deque.removeFirst());
				}
			}
			else if(num < 0) {
				num = num*(-1);
				list.add(deque.removeFirst());
				for(int n = 0; n < num; n++) {
					deque.addFirst(deque.removeLast());
				}
			}
		}
		
		for(int i= 0; i < list.size(); i++) {
			sb.append(list.get(i).val).append(" ");
		}
		
		System.out.println(sb);// [3, -3, -1, 1, 2]

	}

}
