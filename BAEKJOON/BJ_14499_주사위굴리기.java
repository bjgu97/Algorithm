import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {
	static int[][] deltas = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int r;
	static int c;
	static int[][] map;
	static int N;
	static int M;
	static Dice dice;
	
	static class Dice {
		int up;
		int down;
		int left;
		int right;
		int front;
		int back;
		
		Dice(int up, int down, int left, int right, int front, int back) {
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
			this.front = front;
			this.back = back;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도 세로 크기
		M = Integer.parseInt(st.nextToken()); // 지도 가로 크기
		r = Integer.parseInt(st.nextToken()); // 주사위 좌표 x
		c = Integer.parseInt(st.nextToken()); // 주사위 좌표 y
		int K = Integer.parseInt(st.nextToken()); // 명령어 개수 k
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		dice = new Dice(0, 0, 0, 0, 0, 0); // 초기 주사위
		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			move(dir);	
		}
	}
	
	static void move(int dir) {
		int nr =  r + deltas[dir][0];
		int nc = c + deltas[dir][1];
				
		if(nr < 0 || nc < 0 || nr >= N || nc >= M) // 바깥 이동하면 무시
			return;
		
		if(map[nr][nc] == 0) { // 이동칸에 쓰여있는 수가 0이면
			// 주사위 -> 칸
			switch(dir) {
			case 1: //오른쪽이면
				roll(dir); // 주사위 굴리기
				map[nr][nc] = dice.down;
				break; 
			case 2: // 왼쪽이면
				roll(dir);
				map[nr][nc] = dice.down;
				break;
			case 3: // 위로면
				roll(dir);
				map[nr][nc] = dice.down;
				break;
			case 4: // 앞으로면
				roll(dir);
				map[nr][nc] = dice.down;
				break;
			}
			
		}
		else { 
			// 칸 -> 주사위
			roll(dir);
			dice.down = map[nr][nc];
			map[nr][nc] = 0;
		}


		r = nr;
		c = nc;
		
		System.out.println(dice.up);
	}

	static void roll(int dir) {
		int front = dice.front;
		int back = dice.back;
		int left = dice.left;
		int right = dice.right;
		int up =dice.up;
		int down = dice.down;

		if(dir == 1) {
			dice = new Dice(left,right,down,up,front,back);
		}
		else if(dir == 2) {
			dice = new Dice(right,left,up,down,front,back);
		}
		else if(dir == 3) {
			dice = new Dice(front,back,left,right,down,up);
		}
		else if(dir == 4) {
			dice = new Dice(back,front,left,right,up,down);
		}
	}
}