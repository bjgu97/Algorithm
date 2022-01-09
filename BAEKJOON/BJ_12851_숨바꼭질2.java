import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_12851_숨바꼭질2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수빈
		int K = Integer.parseInt(st.nextToken()); // 동생
		
		bfs(N, K);
		
	}
	static boolean visited[] = new boolean[100001];
	static int pos[] = new int[100001];
	static int cnt;
	static int minP;
	
	static class Point {
		int p;
		int cnt;
		
		Point(int p, int cnt) {
			this.p = p; // 위치
			this.cnt = cnt; // 이동 횟수
		}
	}
	
	static void bfs(int N, int K) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(N, 0));
		visited[N] = true;

		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			int[] next = {curr.p - 1, curr.p + 1, curr.p * 2};
			
			
			for(int n = 0; n < 3; n++) {
				int nextN = next[n];
				
				if(curr.p == K  && pos[K] == cnt) {
					cnt++;
				}
				
				if(nextN < 0 || nextN > 100000)
					continue;
				
				if(visited[nextN]) {
					continue;
				}
				visited[nextN] = true;
				pos[nextN] = pos[curr.p] + 1;
				queue.add(new Point(nextN, curr.cnt+1));
				
				
			}
		}
		System.out.println(pos[K]);
		System.out.println(cnt-1);
	}
}
