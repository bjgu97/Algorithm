import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_19236_청소년상어 {

	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int num;
		int dir;
		int alive;
		
		Fish(int r, int c, int num, int dir, int alive) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
			this.alive = alive;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", num=" + num + ", dir=" + dir + "]";
		}

		@Override
		public int compareTo(Fish o) {
			return o.num - this.num;
		}
	}
	
	static class Shark {
		int r;
		int c;
		int dir;
		
		Shark(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}
	
	static int[][] map;
	static Shark shark;
	static Fish[] fishArr;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[4][4];
		fishArr = new Fish[17];
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[i][j] = a; // 지도에 저장
				
				fishArr[map[i][j]]=  new Fish(i, j, a, b, 1); // 물고기 저장
			}
		}

		int sd = fishArr[map[0][0]].dir;
		
		// 0, 0 물고기 먹는다.
		fishArr[map[0][0]].alive = 0;
		answer = map[0][0];
		map[0][0] = -1;
	
		dfs(0, 0, sd, 0);
		
		System.out.println(answer);
	}
	
	static int[][] deltas = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	static void dfs(int r, int c, int dir, int sum) {
		answer = Math.max(answer, sum);
		// dfs 수행을 위한 복사
		int[][] tmpMap = new int[4][4];
		for(int i = 0; i < 4; i++) {
			System.arraycopy(map[i], 0, tmpMap[i], 0, 4);
		}
		
		Fish[] tmpFishArr = new Fish[fishArr.length];
		for(int i = 1; i <= 16; i++) {
			tmpFishArr[i] = new Fish(fishArr[i].r, fishArr[i].c, fishArr[i].num, fishArr[i].dir, fishArr[i].alive);
		}

		
		// 물고기 이동
		for(int i = 1; i <= 16; i++) {
			if(fishArr[i].alive == 0) continue;
			
			int d = fishArr[i].dir;
			int nr = 0;
			int nc = 0;
			int cnt = 0;
			
			while(cnt < 8) { // 8방향 검색용
				d %= 8;
				fishArr[i].dir = d;
				
				nr = fishArr[i].r + deltas[d][0];
				nc = fishArr[i].c + deltas[d][1];
				
				if(nr >= 0 && nc >= 0 && nr < 4 && nc < 4 && (map[nr][nc] != -1)) {
					// 이동할 위치에 물고기 없음
					if(map[nr][nc] == 0) {
						
						map[fishArr[i].r][fishArr[i].c] = 0; // 기존 위치 0으로 하고 
						
						// 물고기 배열도 이동.
						fishArr[i].r = nr;
						fishArr[i].c = nc;
						map[nr][nc] = i;
					}
					// 이동할 위치에 다른 물고기 있음
					else {
						Fish changeFish = fishArr[map[nr][nc]];
						
						// 바꿀 물고기 위치 변경
						fishArr[changeFish.num].r = fishArr[i].r;
						fishArr[changeFish.num].c = fishArr[i].c;
						map[fishArr[changeFish.num].r][fishArr[changeFish.num].c] = changeFish.num;
						
						// 현재 물고기 위치 변경
						fishArr[i].r = nr;
						fishArr[i].c = nc;
						map[nr][nc] = i;
						
					}
					break;
				}
				else {
					d++;
					cnt++;
				}
			}
		}
		
		//  상어 이동

		for(int i= 1; i < 4; i++) {
			int nr = r + deltas[dir][0]* i;
			int nc = c + deltas[dir][1] * i;
			
			if(nr >= 0 && nc >= 0 && nr < 4 && nc < 4 && map[nr][nc] != 0) {
				int eatFish = map[nr][nc];
				int nd = fishArr[eatFish].dir;
				
				map[r][c] = 0;
				map[nr][nc] = -1;
				fishArr[eatFish].alive = 0;
				
				dfs(nr, nc, nd, eatFish+ sum);
				
				fishArr[eatFish].alive = 1;
				map[r][c] = -1;
				map[nr][nc] = eatFish;
			}
		}
		
		// 맵 되돌리기
		for(int j = 0; j < map.length; j++) {
			System.arraycopy(tmpMap[j], 0, map[j], 0,4);
		}
		for(int i = 1; i <= 16; i++) {
			fishArr[i] = new Fish(tmpFishArr[i].r, tmpFishArr[i].c, tmpFishArr[i].num, tmpFishArr[i].dir, tmpFishArr[i].alive);
		}
	}
	
}
