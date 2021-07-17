import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_5212_지구온난화 {
	static int R;
	static int C;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R+2][C+2]; // 지도 범위 벗어난 칸도 바다 => 사방 행/열 추가
		
		for(int i = 0; i < R+2; i++) {
			Arrays.fill(map[i], '.');
		}
		
//		for(char[] a : map)
//			System.out.println(Arrays.toString(a));
//		System.out.println();
		
		for(int r = 1; r < R+1; r++) {
			String s = br.readLine();
			for(int c = 1; c < C+1; c++) {
				map[r][c] = s.charAt(c-1);
			}
		}

//		for(char[] a : map)
//			System.out.println(Arrays.toString(a));
//		System.out.println();

		for(int r = 1; r < R+1; r++) {
			for(int c = 1; c < C+1; c++) {
				if(map[r][c] == 'X') {
					landToSea(r, c); // 땅이면, 사방 검색
				}
			}
		}
		

//		for(char[] a : map)
//			System.out.println(Arrays.toString(a));
		
		printMap();
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void landToSea(int r, int c) {
		int cnt = 0;
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
//			if(nr < 0 || nc < 0 || nr >= R || nc >= C) // 범위 벗어날일 없으니까 뺌.
//				continue;
			
			if(map[nr][nc] == '.') {
				cnt++;
			}
			
		}
		
		if(cnt >= 3) {
			map[r][c] = 'O';
		}
	}
	
	static void printMap() {
		// 좌상 
		int minR = R;
		int minC = C;
		int maxR = 0;
		int maxC = 0;
		
		for(int r = 0; r < R+2; r++) {
			for(int c = 0; c < C+2; c++) {
				if(map[r][c] == 'X') { // x가 위치한 좌표(꼭짓점)의 최대,최소값들
					minR = Math.min(minR, r);
					minC = Math.min(minC, c);
					maxR = Math.max(maxR, r);
					maxC = Math.max(maxC, c);
				}
			}
		}
		
		for(int i = minR; i <= maxR; i++) {
			for(int j = minC; j <= maxC; j++) {
				if(map[i][j] == 'O') // 없어진 땅은 .로 출력
					System.out.print('.');
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}
