package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_개미 {
	static int[][] deltas = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()) + 1;
		int h = Integer.parseInt(st.nextToken()) + 1;
		
		int[][] arr = new int[h][w]; // 전체 크기
		
		st = new StringTokenizer(br.readLine());
		int[] ant = new int[2]; // 개미 시작 좌표 저장
		ant[0] = Integer.parseInt(st.nextToken()); 
		ant[1] = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine()); // 시간
		
		
		int x = ant[0];
		int y = ant[1];
		int d = 0; // 처음 방향은 오위
		int cnt = 0;
		int nx = 0;
		int ny = 0;
		while(true) {
			nx  = x + deltas[d][0];
			ny = y + deltas[d][1];
			if(nx >= w) { // 오른쪽 벽
				d = 1;
				continue;
			}
			else if(ny < 0) { // 윗쪽 벽
				d = 2;
				continue;
			}
			else if(ny >= h) {
				d = 1;
				continue;
			}
			else if(nx < 0) { // 왼쪽 벽
				d = 0;
				continue;
			}
			else { 
				x = nx;
				y = ny;
				
			}
			cnt++;
			if(cnt == t)
				break;
		}
			
		System.out.println(nx + " " + ny);
	}
}
