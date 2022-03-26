import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17136_색종이붙이기 {
	static int[][] map;
	static int[]papers = {0, 5, 5, 5, 5, 5};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// 색종이 크기 : 1*1, 2*2, 3*3, 4*4, 5*5
		// 종이 10*10
		// 1 적힌 칸은 모두 색종이로 덮기.
		// 0이 적힌 칸 색종이 있으면 안됨.
		
		// 1이 적힌 칸 모두 붙이는데 필요한 색종이 최소 개수?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void dfs(int x, int y, int cnt) {
		
		// 기저조건
		if(x == 9 && y == 10) {
			min = Math.min(min, cnt);
			return;
		}
		
		// 다음줄 이동
		if(y == 10) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		// 가지치기
		if(cnt > min)
			return;
		
		// 1 발견하면
		if(map[x][y] == 1) {
			// 큰 색종이부터 하나씩 붙이기
			for(int i = 5; i >= 1; i--) {
				// 색종이 붙일 수 있다면
//				System.out.println("x, y, i: " + x + "," + y + "," + i);
				if(canAttach(x, y, i) && papers[i] > 0) {
					// 붙이기
					attach(x, y, i);
					dfs(x, y+1, cnt+1);
					detach(x, y, i);
				}
			}
		}
		else {
			// 옆칸 이동
			dfs(x, y+1, cnt);
		}
	}
	
	static void attach(int x, int y, int len) {
//		System.out.println("붙임!! x, y: " + x + "," + y);
		
		for(int i = x; i < x + len; i++) {
			for(int j = y; j < y + len; j++) {
				map[i][j] = len;
			}
		}
		papers[len]--;
	}
	
	static void detach(int x, int y, int len) {
		for(int i = x; i < x + len; i++) {
			for(int j = y; j < y + len; j++) {
				map[i][j] = 1;
			}
		}
		papers[len]++;
	}
	
	static boolean canAttach(int x, int y, int len) {
		for(int i = x; i < x + len; i++) {
			for(int j = y; j < y + len; j++) {
//				System.out.println("i, j: " + i + "," + j);
				if(i >= 10 || j >= 10) {
					return false;
				}
				
				if(map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
