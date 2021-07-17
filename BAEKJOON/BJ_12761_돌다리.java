import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_12761_돌다리 {
	static int A, B, N, M;
	static boolean[] map;
	final static int MAX = 100001;
	
	static class Point {
		int x;
		int cnt;
		
		Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", cnt=" + cnt + "]";
		}
		
		
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new boolean[MAX]; // 1차원이고, 최대 크기 정해져있으므로 boolean만 필요.
		
		bfs(N);
		
		System.out.println(answer);
	}
	
	static int answer;
	
	static void bfs(int N) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0));
		map[N] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x; // 좌표
			int cnt = p.cnt; // 좌표까지 이동 횟수
			
			if(x == M) { // 도착하면
				answer = cnt;
				return;
			}
			
			if(x+1 < MAX && map[x+1] == false) { // 한 칸 앞으로 이동
				map[x+1] = true;
				queue.add(new Point(x+1, cnt+1));
			}
			if(x-1 >= 0 && map[x-1] == false) { // 한 칸 뒤로 이동
				map[x-1] = true;
				queue.add(new Point(x-1, cnt+1));
			}
			if(x+A < MAX && map[x+A] == false) { // A칸 앞으로 이동
				map[x+A] = true;
				queue.add(new Point(x+A, cnt+1));
			}
			if(x-A >=0 && map[x-A] == false) { // A칸 뒤로 이동
				map[x-A] = true;
				queue.add(new Point(x-A, cnt+1));
			}
			if(x+B < MAX && map[x+B] == false) { // B칸 앞으로 이동
				map[x+B] = true;
				queue.add(new Point(x+B, cnt+1));
			}
			if(x-B >=0 && map[x-B] == false) { // B칸 뒤로 이동
				map[x-B] = true;
				queue.add(new Point(x-B, cnt+1));
			}
			if(x*A < MAX && map[x*A] == false) { // A배 앞으로 이동
				map[x*A] = true;
				queue.add(new Point(x*A, cnt+1));
			}
			if(x*B < MAX && map[x*B] == false) { // B배 앞으로 이동
				map[x*B] = true;
				queue.add(new Point(x*B, cnt+1));
			}
			
//			System.out.println(queue);
		}
	}
}
