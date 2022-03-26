import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어_2 {
	static int N;
	static int[][] map;
	static BabyShark shark;
	static List<Fish> Fishes;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 9) {
					shark = new BabyShark(n, m, 2, 0, 0); // 초기 상어 위치 & 크기 지정
				}
			}
		}
		
		// 2. 구현
		while(true) {
			if(canFindFish()) { // 먹을 수 있는 물고기가 있다면
				eatFish(); // 물고기 먹는다.
				grow(); // 상어 자란다.
			}
			else { // 먹을 수 있는 물고기 없다면(엄마상어 도움 요청!!)
				System.out.println(shark.move);
				break;
			}
		}
	}

	static boolean canFindFish() {
		Fishes = new ArrayList<>();
		Queue<BabyShark> queue = new LinkedList<>();
		
		queue.add(shark);
		visited = new boolean[N][N];		
		visited[shark.r][shark.c]= true; 
		
		while(!queue.isEmpty()) {
			BabyShark babyShark = queue.poll();
			
			int r = babyShark.r;
			int c = babyShark.c;
			int size = babyShark.size;
			int move = babyShark.move;
			int num = babyShark.num;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] > babyShark.size) continue; // 더 큰 물고기 있는 곳은 못지나가므로.
				
				queue.add(new BabyShark(nr,  nc, size, move+1, num));
				
				if(map[nr][nc] != 0 && map[nr][nc] != 9 && map[nr][nc] < size) // 먹을 수 있는 물고기 발견하면
					Fishes.add(new Fish(nr, nc, map[nr][nc], move+1)); // 리스트에 추가
				
				visited[nr][nc] = true;
			}
			
		}

		if(Fishes.size() != 0) // 먹을 수 있는 물고기 있으면 true 리턴
			return true;
		return false;
	}
	
	static void eatFish() {
		Collections.sort(Fishes);

		Fish fish = Fishes.get(0);
		
		map[shark.r][shark.c]=0; // 상어 현재 좌표 0으로.
		map[fish.r][fish.c]= 0; // 잡힌 물고기 자리는 0으로.
		shark.move = fish.dist; // 상어 이동 횟수 업데이트.
		shark.num = shark.num + 1; // 잡은 물고기 횟수 업데이트.
		shark.r = fish.r; // 상어 좌표 업데이트.
		shark.c = fish.c;
	}
	
	static void grow() {
		if(shark.size == shark.num) { // 상어 크기와 먹은 물고기 개수 같아지면
			shark.size = shark.size + 1; // 상어 크기 증가시키기
			shark.num = 0; // 먹은 물고기 개수는 다시 0으로.
		}
	}
	
	//아기상어
	static class BabyShark {
		int r; // 좌표
		int c;
		int size; // 상어크기
		int move; // 이동 횟수(최종 정답)
		int num; // 먹은 물고기 수
		
		BabyShark(int r, int c, int size, int move, int num) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.move = move;
			this.num = num;
		}
	}
	
	// 물고기
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int dist; // 상어와의 거리
		
		Fish(int r, int c, int size, int dist) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
			
		}
		
		@Override
		public int compareTo(Fish o) {
			// 상어와의 거리 -> r -> c 순으로 정렬
			if(this.dist != o.dist) return this.dist - o.dist;
			else {
				if(this.r != o.r) return this.r - o.r;
				else {
					if(this.c != o.c) return this.c - o.c;
				}
			}
			return 0;
		}
	}
	
}
