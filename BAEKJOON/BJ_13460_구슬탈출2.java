import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13460_구슬탈출2 {
	static char[][] map;
	static boolean[][] visitedRed;
	static boolean[][] visitedBlue;
	static int dir;
	static boolean[][][][] visited;
	static int N;
	static int M;
	static int answer = -1;
	
	static class Red {
		int r;
		int c;
		int cnt;
		
		Red(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Red [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}
	
	static class Blue {
		int r;
		int c;
		int d;
		
		Blue(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Blue [r=" + r + ", c=" + c + "]";
		}
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 아래 위 오 왼
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Red> redQ = new LinkedList<>();
		Queue<Blue> blueQ = new LinkedList<>();
		
		map = new char[N][M];
		visitedRed = new boolean[N][M];
		visitedBlue = new boolean[N][M];
		visited = new boolean[N][M][N][M];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m);
				// 빨강, 파랑 구슬 위치 저장
				if(map[n][m] == 'R') {
					redQ.add(new Red(n, m, 1));
				}
				if(map[n][m] == 'B') {
					blueQ.add(new Blue(n, m, 0));
				}
			}
		}
		
		
		bfs(redQ, blueQ);
		
		
		System.out.println(answer);
		
	}
	
	static void bfs(Queue<Red> redQ, Queue<Blue> blueQ) {
		while(!redQ.isEmpty() || !blueQ.isEmpty()) {
			Red red = redQ.poll();
			int redR = red.r;
			int redC = red.c;
			int cnt = red.cnt;
			
			System.out.println("-------------------- cnt : "+ cnt);
			Blue blue = blueQ.poll();
			int blueR = blue.r;
			int blueC = blue.c;
			
			visitedRed[redR][redC] = true;
			visitedBlue[blueR][blueC] = true;
			visited[redR][redC][blueR][blueC] = true;
			// 종료조건
			if(cnt > 10) {
				break;
			}
			
			for(int d = 0; d < deltas.length; d++) {
//				System.out.println("redR, redC " + redR + "," + redC);
//				System.out.println("blueR, blueC " + blueR + "," + blueC);
				int redNR = redR;
				int redNC = redC;

				int blueNR = blueR;
				int blueNC = blueC;

//				System.out.println("--- while문 시작");
				while(true) {
//					System.out.println("tmpR: " + redNR + "," + redNC);
//					System.out.println("tmpB: " + blueNR + "," + blueNC);
//					System.out.println();
					
					// 둘중 하나가 구멍에 빠지면
					if(map[redNR][redNC] == 'O' || map[blueNR][blueNC] == 'O') {
//						System.out.println("빠짐!");
//						System.out.println("redNR, redNC: " + redNR + "," + redNC);
						dir = d;
//						System.out.println("blueNR, blueNC: " + blueNR + "," + blueNC + "," + d);
						break;
					}
					
					// 둘다 벽 직전까지 가면
					if(map[redNR + deltas[d][0]][redNC + deltas[d][1]] == '#' && map[blueNR + deltas[d][0]][blueNC + deltas[d][1]] == '#') {
						break;
					}
					
					// 다음칸 이동 가능하면 
					if(map[redNR + deltas[d][0]][redNC + deltas[d][1]] != '#') {
						redNR = redNR + deltas[d][0];
						redNC = redNC + deltas[d][1];
						
					}
					
					if(map[blueNR + deltas[d][0]][blueNC + deltas[d][1]] != '#') {					
						blueNR = blueNR + deltas[d][0];
						blueNC = blueNC + deltas[d][1];

					}
				}
//				System.out.println("-11-- while문 종료");
//				System.out.println("RR: " + redNR + "," + redNC);
//				System.out.println("BB: " + blueNR + "," + blueNC);
				// 두 구슬 위치가 같아지면 (아래 왼쪽 오른쪽 위)
				
				if(redNR == blueNR && redNC == blueNC) {
//					System.out.println("같아요");
//					System.out.println("d: " + d);
//					System.out.println("redR, blueR: " + redC + "," + blueC);
					
					// 아래 위 오 왼
					if(d == 0) {
						if(redR > blueR) blueNR -= 1;
						else redNR -= 1;
					}
					else if(d == 1) {
						if(redR > blueR) redNR += 1;
						else blueNR += 1;
					}
					else if(d == 2) {
						if(redC > blueC) blueNC -= 1;
						else redNC -= 1;
					}
					else if(d == 3) {
						if(redC > blueC) redNC += 1;
						else blueNC += 1;
					}
				}
				
				
//				System.out.println("-22-- while문 종료");
//				System.out.println("RR: " + redNR + "," + redNC);
//				System.out.println("BB: " + blueNR + "," + blueNC);
//				System.out.println();
				// 빠진게 빨간 구슬이라면
				if(map[redNR][redNC] == 'O') {
					// 빨간구슬, 파란구슬 둘다 빠진다면
					if(map[blueNR+deltas[dir][0]][blueNC+deltas[dir][1]] == 'O') {
						System.out.println("둘다빠짐");
						continue;
					}
					answer = cnt;
//					System.out.println("정답!!!");
					
					System.out.println("빨강구슬 빠짐");
					System.out.println("red" + redR + "," + redC  + " --> " + redNR + "," + redNC);
					System.out.println("blue" + blueR + "," + blueC  + " --> " + blueNR + "," + blueNC);
					System.out.println();
					return;
				}
				
				// 빠진게 파란 구슬이라면
				if(map[blueNR][blueNC] == 'O') continue;
				
				
				if(visited[redNR][redNC][blueNR][blueNC]) {
//				if(visitedRed[redNR][redNC] && visitedBlue[blueNR][blueNC]) {
					System.out.println("방문?");
					continue;
				}
				
//				System.out.println("큐 추가");
				System.out.println("다음이동");
				System.out.println("red" + redR + "," + redC  + " --> " + redNR + "," + redNC);
				System.out.println("blue" + blueR + "," + blueC  + " --> " + blueNR + "," + blueNC);
				System.out.println();
				redQ.add(new Red(redNR, redNC, cnt+1));
				blueQ.add(new Blue(blueNR, blueNC, d));
				System.out.println("redQ: " + redQ);
				System.out.println("blueQ: " + blueQ);
			}
			
//			System.out.println("redQ: " + redQ);
//			System.out.println("blueQ: " + blueQ);
		}
	}
}