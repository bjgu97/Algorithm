import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3190_뱀_1 {
	static int N;
	static int[][] map;
	static Snake snake;
	
	static class Snake {
		int headR;
		int headC;
		int tailR;
		int tailC;
		int dir;
		int cnt;
		
		Snake(int headR, int headC, int tailR, int tailC, int dir, int cnt) {
			this.headR = headR;
			this.headC = headC;
			this.tailR = tailR;
			this.tailC = tailC;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Snake [headR=" + headR + ", headC=" + headC + ", tailR=" + tailR + ", tailC=" + tailC + ", dir="
					+ dir + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		int K = Integer.parseInt(br.readLine());
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1; // 사과 = 1
		}
		snake = new Snake(1, 1, 1, 1, 4, 0);
		map[1][1] = 2; // 뱀 = 2
		int L = Integer.parseInt(br.readLine());
		for(int l = 0; l < L; l++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); // 이동 횟수
			char Dir = st.nextToken().charAt(0); // 회전 방향
			System.out.println("-----------------" + T + "/" + Dir + "------------------");
			System.out.println("1. 이동 시작");
			System.out.println(snake);
			
			boolean flag = moveSnake(T, Dir);
			System.out.println("FLAG: " + flag);
			if(flag) // 끝나버리면
				break;
			
			}
	}
	static int t;
	static int[][] deltas = {{0, 0}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	static boolean moveSnake(int T, char Dir) {
		System.out.println("T: " + T);
		while(t < T) { // T초동안 Dir 방향으로 이동
			System.out.println("t: " + t);
			System.out.println("2. 이동중");
			System.out.println(snake);

			int headR = snake.headR;
			int headC = snake.headC;
			int tailR = snake.tailR;
			int tailC = snake.tailC;
			int dir = snake.dir;
			int cnt = snake.cnt;
			
			int nheadR = headR + deltas[dir][0];
			int nheadC = headC + deltas[dir][1];
			
			// 벽이면 break;
			if(nheadR <= 0 || nheadC <= 0 || nheadR > N || nheadC > N) {
				System.out.println("!!! 벽 만남");
				System.out.println(cnt+1);
				return true;
			}
			
			// 평지이면 head 증가, tail 감소
			if(map[nheadR][nheadC] == 0) {
				System.out.println("!!! 평지 만남");
				snake.headR = nheadR;
				snake.headC = nheadC;
				snake.tailR = tailR + deltas[dir][0];
				snake.tailC = tailC + deltas[dir][1];
				snake.cnt = cnt + 1;
				map[nheadR][nheadC] = 2;
				map[tailR][tailC] = 0;
				t++;
				
				System.out.println(snake);
			}
			// 사과이면 head만 증가
			else if(map[nheadR][nheadC] == 1) {
				System.out.println("!!1 사과 만남");
				snake.headR = nheadR;
				snake.headC = nheadC;
				snake.cnt = cnt + 1;
				map[nheadR][nheadC] = 2;
				t++;
			}
			// 자기 자신 만나면 종료
			else if(map[nheadR][nheadC] == 2) {
				System.out.println(cnt+1);
				return true;
			}
		}
		
		System.out.println("3. 회전시작");

		// 회전
		if(Dir == 'L') {
			int dir = snake.dir;
			snake.dir = (dir % 4) + 1;
		}
		else if(Dir == 'D') {
			int dir = snake.dir;
			switch(dir) {
			case 1: snake.dir = 4; break;
			case 2: snake.dir = 1; break;
			case 3: snake.dir = 2; break;
			case 4: snake.dir = 3; break;
			}
		}
		System.out.println(snake);

		return false;
	}
}
