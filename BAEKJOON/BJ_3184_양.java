import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_3184_양 {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int wolf;
	static int sheep;
	public static void main(String[] args) throws IOException {
		// . : 빈 필드
		// # : 울타리
		// o : 양
		// V : 늑대
		
		// 영역 안의 양의 수가 늑대보다 많으면 이기고 늑대 쫓아낸다.
		// 그렇지 않으면 늑대가 양 모두 먹는다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r] = s.toCharArray();
			}
		}
		
		int totalWolf = 0;
		int totalSheep = 0;
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if((map[r][c] == 'v' || map[r][c] == 'o') && visited[r][c] == false) {
//					System.out.println("r, c: " + r + "," + c);
					
//					printVisited();
					
					if(map[r][c] == 'v')
						wolf++;
					else if(map[r][c] == 'o')
						sheep++;
					
					bfs(r, c);
					
//					System.out.println("wolf, sheep: " + wolf + "," + sheep);
					if(wolf >= sheep)
						sheep = 0;
					else
						wolf = 0;
					
					totalWolf += wolf;
					totalSheep += sheep;
					
					wolf = 0;
					sheep = 0;
//					System.out.println("totalWolf, totalSheep: " + totalWolf + "," + totalSheep);

				}
			}
		}
		
		System.out.println(totalSheep + " " + totalWolf);
		
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void bfs(int r, int c) {

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
//			System.out.println("p: " + p);
			int rr = p.r;
			int cc = p.c;
			
			visited[rr][cc] = true;
			
//			printVisited();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = rr + deltas[d][0];
				int nc = cc + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				
				if(map[nr][nc] == '#') 
					continue;
				
				if(map[nr][nc] == 'v' && visited[nr][nc] == false) {
					wolf++;
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
				
				if(map[nr][nc] == 'o' && visited[nr][nc] == false) {
					sheep++;
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
				
				if(map[nr][nc] == '.' && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
				
			}

		}
		
	}
	
	static void printVisited() {
		for(boolean[] a : visited)
			System.out.println(Arrays.toString(a));
	}

}
