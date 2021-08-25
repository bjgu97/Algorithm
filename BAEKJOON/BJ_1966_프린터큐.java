

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966_프린터큐 {
	
	// 값 정보와 위치정보 저장
	public static class point {
		int val;
		int pos;
		
		public point(int val, int pos) {
			this.val = val;
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "point [val=" + val + ", pos=" + pos + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
	
		for(int t = 0; t < T; t++) {
			Queue<point> queue = new LinkedList<point>();
			
			// 결과 저장용
			List<point> result = new ArrayList<>();
			
			// 중요도 저장용
			List<Integer> list = new ArrayList<>();
			
			//문서의 개수 N, 궁금한 문서 위치 M
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			point p = new point(N, N);
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				int num = Integer.parseInt(st.nextToken());
				p = new point(N, N);
				p.val = num;
				p.pos = n;
				queue.offer(p);
				list.add(num);
			}
			
			Collections.sort(list); // 리스트 저장
			// [1, 1, 1, 2, 3, 9]
			
			// 중요도 높은순으로 출력 -> 리스트에 저장
			while(!queue.isEmpty()) {
				point firstPoint = queue.peek();

				//while문 종료 조건
				if(list.size() == 0)
					break;
				
				if(firstPoint.val == list.get(list.size()-1)) {
					result.add(firstPoint);
					list.remove(list.size()-1);
					queue.poll();
				}
				else {
					queue.offer(queue.poll());
				}
				
//				System.out.println(queue);
//				System.out.println(list);
//				System.out.println(result);
//				System.out.println();
				
			}
			
			for(int i = 0; i < result.size(); i++) {
				if(result.get(i).pos == M)
					sb.append(i+1).append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
