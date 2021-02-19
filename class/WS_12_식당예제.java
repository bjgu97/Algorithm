import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

public class WS_12_식당예제 {
	static int[] answer;
	static int R;
	static int C;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		for(char[] a : map)
			System.out.println(Arrays.toString(a));
		
		// 시작점 고르기
		for(int r = R; r >=0; r--) {
			answer = new int[r];
			comb(0, 0, r);
		}
		// 델타로 오른쪽으로 이동 가능한만큼 이동
		
		
	}
	
	public static void comb(int cnt, int start, int r) {
		if(cnt == r) { // 시작점 다 뽑았다면
			//System.out.println(Arrays.toString(answer));
			move(answer);
			return;
		}
		for(int i = start; i < R; i++) {
			answer[cnt] = i;
			comb(cnt+1, i+1, r);
		}
		
	}
	static boolean[][] visited;
	static int[][] deltas = {{1, 0}, {1, -1}, {1, 1}};
	
	public static void move(int[] answer) {
		for(int i = 0; i <= answer.length; i++) {
			visited[0][i] = true;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = 0 + deltas[d][1];
				int nc = i + deltas[d][0];
			}
		}
	}
}
