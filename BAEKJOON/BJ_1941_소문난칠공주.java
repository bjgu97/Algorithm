import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_1941_소문난칠공주 {
	static class Point {
		char name;
		int idx;
		int r;
		int c;
		
		Point(char name, int idx, int r, int c) {
			this.name = name;
			this.idx = idx;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [name=" + name + ", idx=" + idx + ", r=" + r + ", c=" + c + "]";
		}


	}
	
	static Point[][] map;
	public static void main(String[] args) throws IOException {
		// 이다솜파
		// 7명(가로세로 인접)
		// 이다솜파 학생 4명 이상
				
		map = new Point[5][5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		for(int i = 0; i < 5; i++) {
			char[] temp = br.readLine().toCharArray();
			
			for(int j = 0; j < 5; j++) {
				map[i][j] = new Point(temp[j], idx++, i, j);
			}
		}
		
		// 1. 조합으로 25명 중 7명 뽑기
		comb(0, 1);
	}
	
	static int[] numbers = new int[7];
	static void comb(int cnt, int start) {
		if(cnt == 7) {
			
			// 2. 이다솜파 4명 이상
			List<Point> list = checkOverFour(numbers);
			if(list.size() > 0) {
				// 3. 일곱명 다 서로 인접
				if(checkNear(list))
					System.out.println(Arrays.toString(numbers));	
			};
			
			return;
		}
		
		for(int i = start; i <= 25; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	// 5 7 9 16 19
	static List<Point> checkOverFour(int[] numbers) {
		int cnt = 0;
		List<Point> list = new ArrayList<>();
		List<Point> list1 = new ArrayList<>();
		
		for(int i = 0; i < 7 ; i++) {
			for(int r = 0; r < 5; r++) {
				for(int c = 0; c < 5; c++) {
					if(map[r][c].idx == numbers[i] && map[r][c].name == 'S') {
						cnt++;
						list.add(new Point(map[r][c].name, map[r][c].idx, r, c));
					}
				}
			}
		}
		
		if(cnt >= 4)
			return list;
		else
			return list1;
	}
	

	
	static boolean checkNear(List<Point> list) {

		int[][] temp = new int[5][5];
		
		for(Point p : list) {
			int r = p.r;
			int c = p.c;
			
			temp[r][c] = 1;
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(temp[i][j] == 1) {
					if(bfs(i, j, temp) == 7) {
						return true;
					}
				}
			}
		}
		

		return false;
	}
	
	static class Point2 {
		int r;
		int c;
		
		Point2(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int bfs(int i, int j, int[][] temp) {
		for(int[] a : temp)
			System.out.println(Arrays.toString(a));
		Queue<Point2> queue = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		queue.add(new Point2(i, j));
		visited[i][j] = true;
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Point2 p = queue.poll();
			
			int r = p.r;
			int c = p.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
					continue;
				
				if(temp[nr][nc] == 1 && !visited[nr][nc]) {
					System.out.println("nr, nc: " + nr + "," + nc);
					queue.add(new Point2(nr, nc));
					visited[nr][nc] = true;
					cnt++;
				}
			}
			
		}
		
		System.out.println("cnt: " + cnt);
		return cnt;
	}
}
