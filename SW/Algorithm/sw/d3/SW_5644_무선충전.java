package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_5644_무선충전 {
	
	static int[][] deltas = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	
	static class BC {
		int kind;
		int power;
		
		BC(int kind, int power) {
			this.kind = kind;
			this.power = power;
		}

		@Override
		public String toString() {
			return "BC [kind=" + kind + ", power=" + power + "]";
		}
	}
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		// 일단 int[][] map에 각 BC 위치시키며 충전 범위 및 성능 표시. 이 때 BC 종류도 표시 필요
		// A 사용자, B 사용자 이동시키기
		// 같은 BC 범위 만나면... 에 대한 처리 필요. 
		
		for(int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // M: 총 이동 시간
			int A = Integer.parseInt(st.nextToken()); // A: BC의 개수
			
			int[] person1 = new int[M];
			int[] person2 = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int m =0; m < M; m++) {
				person1[m] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				person2[m] = Integer.parseInt(st.nextToken());
			}
			
			BC[][] map = new BC[10][10];
			int num = 1;
			// AP1 정보
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int kind = num;
			
			map[x][y] = new BC(kind, P);
			for(int d = 0; d < deltas.length; d++) {
				int nx = x;
				int ny = y;
				map[nx][ny] = new BC(kind, P);
				for(int c = 0; c < C; c++) {
					nx = nx + deltas[d][0];
					ny = ny + deltas[d][1];	
					map[nx][ny] = new BC(kind, P);
				}
				
			}
			
			for(BC[] a : map)
				System.out.println(Arrays.toString(a));
			
		}
	}
}