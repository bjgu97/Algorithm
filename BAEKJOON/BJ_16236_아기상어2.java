

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어2 {
	
	static int N, sharkSize = 2, fishCnt, time;
	static int[][] map;
	static int sharkX, sharkY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine()); // 공간의 크기
		map = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 9) {
					sharkX = n;
					sharkY = m;
					map[n][m] = 0;
				}
			}
		}
		
		// 물고기 크기 -> 위 -> 왼 순 정렬
				
		// 처음 아기 상어 크기 2
		// 자기보다 큰 물고기 칸 지나갈 수 없다
		// 자기보다 작은 물고기 먹을 수 있다
		// 크기가 같은 물고기 먹을 수 없지만 지나갈 수 있다
		
		// 더이상 먹을 수 있는 물고기가 공간에 없다면 끝
		// 물고기 1마리면 먹는다
		// 물고기 1마리 이상이면 거리가 가까운 물고기부터. 
		// 거리가 같으면 가장 위에있는, 가장 왼쪽의 물고기 먹는다.
		
		while(bfs());
		System.out.println(time);
	}
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static final int INF = Integer.MAX_VALUE;
	
	static boolean bfs() {
		boolean isEat = false;
		Queue<Pair> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[sharkX][sharkY] = true;
		
		queue.add(new Pair(sharkX, sharkY));
		
		int fishX = INF;
		int fishY = INF;
		
		int distance = 0;
		while(!queue.isEmpty()) {
			distance++;
			int size = queue.size();
			while(size-- > 0) { // 거리가 같은 구간까지만 while문 돌게.
				int x = queue.peek().x;
				int y = queue.poll().y;
				
				for(int i = 0; i < 4; i++) {
					int nx = x + deltas[i][0];
					int ny = y + deltas[i][1];
					
					if(canGo(nx, ny) == false || visited[nx][ny] == true)
						continue;
					
					visited[nx][ny] = true;
					
					// 그냥 지나가기만 할 경우 
					// (맵이 0이거나. 믈고기가 있는데 나랑 크기가 같을 경우)
					if(canEat(nx, ny) == false) {
						System.out.println("!!");
						queue.add(new Pair(nx, ny));
					}
					else { // 물고기를 먹을 수 있는 경우
						if(nx < fishX) {
							fishX = nx;
							fishY = ny;
						}
						else if(nx == fishX && ny < fishY) {
							fishX = nx;
							fishY = ny;
						}
					}
					
				}
			}
			
			if(isEat) {
				// 물고기를 먹었다면 아기상어 위치 바꾸기
				// 맵도 바꿔주기
				// 상어 크기도 바꿔주기
				sharkX = fishX;
				sharkY = fishY;
				
				map[sharkX][sharkY] = 0;
				fishCnt ++;
				if(fishCnt == sharkSize) {
					sharkSize++;
					fishCnt = 0;
				}
				time += distance;
				System.out.println();
				return true;
			}
		}
		return false;
	}
	
	
	static boolean canEat(int nx, int ny) {
		if(map[nx][ny] > 0 && map[nx][ny] < sharkSize) return true;
		return false;
	}
	
	static boolean canGo(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N && map[x][y] <= sharkSize;
	}
}
