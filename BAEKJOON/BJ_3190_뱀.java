/**
* @since 2021. 2. 14.
* @author bjgu9
* @see
* @mem
* @time
* @caution 큐,,어떻게 떠올리지
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190_뱀 {
	// 방향
	static int[][] deltas = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
	
	// 위치 
	static class Pos {
		int r;
		int c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 보드의 크기
		
		
		// 1. map 만들어주기 (다 0으로 채워넣기)
		int[][] map = new int[N+1][N+1]; //인덱스 1부터 시작
		for(int n = 0; n < map.length; n++) {
			for(int m = 0; m < map.length; m++) {
				map[n][m] = 0;
			}
		}
		
		
		// 2. 사과가 있는 곳 1로 표시
		int K = Integer.parseInt(br.readLine()); // 사과의 개수
		for(int k = 0; k < K; k++) { 
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		
		// 3. 명령어 저장
		int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
		char[] command = new char[10000];
		for(int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			command[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		
		
		// 4. 구현 
		int time = 0;
		int dir = 0;
		Deque<Pos> deque = new LinkedList<>();
		deque.add(new Pos(1, 1)); // 시작 위치 큐에 저장
		
		while(true) {
			time++;
			
			Pos head = deque.peekLast();// 현재 머리 있는 좌표
			
			// 몸 길이를 늘려 다음칸에 위치
			// dir 0: 우, dir 1: 하, dir 2: 좌, dir 3: 상
//			System.out.println("dir: " + dir);
			int nr = head.r + deltas[dir][0] ;
			int nc = head.c + deltas[dir][1] ;
			
//			System.out.println("(nr, nc): " + nr + "," + nc);
			// 벽에 부딪히거나 몸통(2) 만나면 종료
			if((nr <= 0 || nr > N || nc <= 0 || nc >N) || map[nr][nc] == 2)
				break;
			
			// 사과(1) 있다면
			if(map[nr][nc] == 1) {
				deque.add(new Pos(nr, nc)); // 이동 하고
				map[nr][nc] = 2; // 2로 표시
			}
			
			//사과가 없는 곳으로 이동했다면
			else if(map[nr][nc] == 0) {
				// 한칸 이동 하고
				deque.add(new Pos(nr, nc)); 
				map[nr][nc] = 2;
				//꼬리 한칸 자르기
				Pos tail = deque.poll(); //(1,1)
				map[tail.r][tail.c]= 0; 
			}
			
			
			// 방향 전환 수행
			if(command[time] == 'D') {
				dir += 1;
				if(dir > 3)
					dir = dir % 4;
			}
			else if(command[time] == 'L') {
				dir -= 1;
				if(dir < 0)
					dir = 3;
				
			}

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("queue: " + deque);
//			System.out.println("time: " + time);
//			System.out.println();
			
			

		}
		System.out.println(time);
		
	}
}