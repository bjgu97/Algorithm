import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수빈 위치
		int K = Integer.parseInt(st.nextToken()); //동생 위치
		
		int cnt = 1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[100001]; 
		
		// 처음 수빈 위치 추가 + 방문처리
		queue.offer(N);
		visited[N] = 1;
		// 실수1: visited[N] = 0 -> if문에서 걸릴 수 있음. 
		
		while(true) { // 모든 경우를 탐색해보자!
			int val = queue.poll(); // 5 -> 10, 6, 4 -> 20 11 9, 12 7 5, 8 5 3 -> 
			
			if(val == K)
				break;
			
			if(val*2 <=100000 && visited[val*2]==0) { // if(val*2 < K) -> K보다 커질 수 있음. (커지고나서 -1 -1)
				queue.offer(val*2);
				//visited[val*2] = true;
				visited[val*2] = visited[val] + 1;
			}
			
			if(val+1 <= 100000 && visited[val+1]==0) {
				queue.offer(val + 1);
				visited[val+1] = visited[val] + 1;
			}
			
			if( val-1 >= 0 && visited[val-1]==0) {
				queue.offer(val-1);
				visited[val-1] = visited[val] + 1;
			}
			
//			cnt++;
//			System.out.println(queue);
		}
		
		System.out.println(visited[K]-1);
		
//		visited를 boolean 배열로 만들었을 때 cnt 값 어떻게..?
//		if(cnt <= 1) 1; if(cnt <= 9) 2; if(cnt<=27) 3; 
//		for(int c = 1; c < 100; c++) {
//			System.out.println(Math.pow(3, c));
//			System.out.println(Math.pow(3, c+1));
//			if(cnt >= Math.pow(3, c) && cnt < Math.pow(3, c+1)) {
//				System.out.println(c+1);
//				break;
//			}
//		}
		
//		첫시도. 
//		while(true) {			
//			if(N == K)
//				break;
//			
//			if(N*2 < K) { // N에 2를 곱해도 K보다 작다면
//				N = N * 2;
//				cnt++;
//			}
//			else {
//				if(K > N) {
//					N = N + 1;
//					cnt++;
//				}
//				else if(K < N) {
//					N = N -1;
//					cnt++;
//				}
//			}
//			
//			System.out.println("N: " + N); // 5 10 11 12 13 14 15 16 17 (다시 되돌아갈수없음)
		                                   // 5 10 9 18 17
//			System.out.println();
//		}
		
	}
}
