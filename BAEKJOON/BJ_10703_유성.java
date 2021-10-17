import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10703_유성 {
	public static void main(String[] args) throws IOException {
		// X: 유성 일부
		// #: 땅의 일부
		// .: 나머지 공기
		// 유성 떨어진 후 사진?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][S];
		char[][] tempMap = new char[R][S];
		
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			map[r] = s.toCharArray();
			tempMap[r] = s.toCharArray();
		}
		
		int min = Integer.MAX_VALUE;
		for(int s = 0; s < S; s++) {
			int Pos1 = -1;
			int Pos2 = -1;
			for(int r = 0; r < R; r++) {
//				System.out.println("r, s:"  + r + "," + s);
				if(map[r][s] == 'X') {
					Pos1 = r;
				}
				
				if(map[r][s] == '#') {
					Pos2 = r;
					break;
				}
			}
			
			System.out.println("Pos1, Pos2: " + Pos1 + "," + Pos2);
			if(Pos1 != -1) {
				min = Math.min(min, Pos2 - Pos1);
			}
		}
		
		// min-1 : 이동 횟수
		int move = min-1;
		
		boolean[][] visited = new boolean[R][S];
	
		
		for(int r = R-1; r >=0; r--) {
			for(int s = S-1; s >=0; s--) {
				if(map[r][s] == 'X' && visited[r][s] == false) {
					
					tempMap[r][s] = '.';
					tempMap[r + move][s] = 'X';
					visited[r][s] = true;
					
				}
			}
		}
StringBuilder sb = new StringBuilder();
		for(int r = 0; r < R; r++) {
			for(int s = 0; s < S; s++) {
				sb.append(tempMap[r][s]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
