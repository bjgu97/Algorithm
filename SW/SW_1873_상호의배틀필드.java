

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SW_1873_상호의배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//테스트케이스 T
		int T = Integer.parseInt(br.readLine());
		
		//방향
		int[][] deltas = {{0,1}, {0, -1}, {-1, 0}, {1, 0}}; //오, 왼, 위, 아
		//테케 시작
		for(int t = 0; t < T; t++) {
			
			// 게임의 높이와 너비 (H, W)
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			// H * W 맵 저장 
			char[][] map = new char[H][W];
			for(int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
			}
			
			// 사용자가 넣을 입력 개수 N
			int N = Integer.parseInt(br.readLine());
			
			// 사용자가 넣는 입력의 종류: SURSSSSUSLSRSSSURRDSRDS
			char[] User = br.readLine().toCharArray();
			
			// 전차 시작위치
			int hh = 0;
			int ww = 0;
			
			// 방향
			int d = 0;

			//처음 위치 저장: hh, ww
			for(int h = 0;h < H; h++) {
				for(int w = 0; w < W; w++) {
					if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
						hh = h;
						ww = w;		
						if(map[h][w] == '^') d = 2;
						if(map[h][w] == 'v') d = 3; //4번케이스,, d = 3
						if(map[h][w] == '<') d = 1;
						if(map[h][w] == '>') d = 0;
					}
				}
			}
			
			//System.out.println("d: " + d);
			for(int u = 0; u < N; u++) {
				int nh, nw; //다음 위치
				switch(User[u]) {
				case 'U': //위로 올라간다.
					d = 2;
					nh = hh + deltas[d][0];
					nw = ww + deltas[d][1];
					
					if(nh>=0 && nh<H && nw>=0 && nw<W) {//범위 내에 있고
						if(map[nh][nw] == '.') { //다음칸이 평지이면
							map[nh][nw] = '^';
							map[hh][ww] = '.';
							hh = nh; ww = nw; //현재 위치 변ㄱㅇ
						}
						else {
							map[hh][ww] = '^';
						}
					}
					else {
						map[hh][ww] = '^';
					}
//					print(map);
					break;
					
				case 'D': //아래로 내려간다.
					d = 3;
					nh = hh + deltas[d][0];
					nw = ww + deltas[d][1];
					
					if(nh>=0 && nh<H && nw>=0 && nw<W) {//범위 내에 있고
						if(map[nh][nw] == '.') { //다음칸이 평지이면
							map[nh][nw] = 'v';
							map[hh][ww] = '.';
							hh = nh; ww = nw; //현재 위치 변경
						}
						else {
							map[hh][ww] = 'v';
						}
					}
					else {
						map[hh][ww] = 'v';
					}
//					print(map);
					break;

				case 'L': //왼쪽으로 간다.
					d = 1;
					
					nh = hh + deltas[d][0];
					nw = ww + deltas[d][1];
					
					if(nh>=0 && nh<H && nw>=0 && nw<W) {//범위 내에 있고
						if(map[nh][nw] == '.') { //다음칸이 평지이면
							map[nh][nw] = '<';
							map[hh][ww] = '.';
							hh = nh; ww = nw; //현재 위치 변ㄱㅇ
						}
						else {
							map[hh][ww] = '<';
						}
					}
					else {
						map[hh][ww] = '<';
					}
//					print(map);
					break;
					
				case 'R': //오른쪽으로 간다.
					d = 0;
					nh = hh + deltas[d][0];
					nw = ww + deltas[d][1];
					
					if(nh>=0 && nh<H && nw>=0 && nw<W) {//범위 내에 있고
						if(map[nh][nw] == '.') { //다음칸이 평지이면
							map[nh][nw] = '>';
							map[hh][ww] = '.';
							hh = nh; ww = nw; //현재 위치 변ㄱㅇ
						}
						else {
							map[hh][ww] = '>';
						}
					}
					else {
						map[hh][ww] = '>';
					}
//					print(map);
					break;
					
				case 'S':
					nh = hh;
					nw = ww;
					
					while(true) {
						nh += deltas[d][0]; // d[3][0] = 1
						nw += deltas[d][1]; // d[3][1] = 0
						
						if(nh< 0 || nh >= H || nw< 0 || nw >= W) 
							break;
						else if(map[nh][nw] == '#'){
							break;
						}
						else if(map[nh][nw] == '*') {
							map[nh][nw] = '.';
							break;
						}
					}
					//print(map);
				}
				
			}
			sb.append("#").append(t+1).append(" ");
			
			for(char[] a:map)
				sb.append(a).append("\n");
			
		}
			System.out.println(sb);
		}
	
	static void print(char[][] map) {
		for(int i = 0; i<map.length; ++i) {
			for(int j = 0; j<map[i].length; ++j) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		System.out.println();
	}
}
	

