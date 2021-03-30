import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO_1661_미로탈출로봇 {
	static int X;
	static int Y;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int[][] map;
	static boolean[][] visited;
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());
		
		map = new int[Y+1][X+1];
		visited = new boolean[Y+1][X+1];
		
		for(int y = 0; y < Y; y++) {
			String s = br.readLine();
			for(int x = 0; x < X; x++) {
				map[y][x] = s.charAt(x) - '0';
			}
		}
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
		
		bfs();
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startY, startX, 0));
		visited[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= Y || nc >= X)
					continue;
				
				if(visited[nr][nc])
					continue;
				
				if(nr == endY && nc == endX)
					System.out.println(cnt + 1);
				
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc, cnt+1));
			}
		}
	}
}
