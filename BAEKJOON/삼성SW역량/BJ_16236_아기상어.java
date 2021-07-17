package 삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
	static class sharkPoint {
		int r;
		int c;
		int size;
		int dd;
		
		sharkPoint(int r, int c, int size, int dd) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dd = dd;
		}

		@Override
		public String toString() {
			return "sharkPoint [r=" + r + ", c=" + c + ", size=" + size + "]";
		}
		

	}
	
	static class fishPoint {
		int r;
		int c;
		int dist;
		
		fishPoint(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		

		@Override
		public String toString() {
			return "fishPoint [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}
		
	}
	
	static sharkPoint shark;
	static int N;
	static int[][] map;
	static int answ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 더 이상 먹을 물고기 없으면 끝
		// 먹을 수 있는 물고기 1마리면, 그 물곡.
		// 먹을 수 있는 물고기 2마리 이상이면 가장 가까운 물고기. 
		// 가까운 물고기 많으면 가장 위에 -> 가장 왼쪽에.
		// 자신의 크기와 같은 수의 물고기 먹을 떄마다 크기 1 증가. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 9) {
					shark = new sharkPoint(n, m, 2, 0);
					map[n][m] = 0;
				}
				else {
					map[n][m] = num;
				}
			}
		}
		
	
		
		// 물고기 찾으러 가기
		int numFish = 0; // 먹은 물고기 개수
		while(true) {
			if(findFish(shark)) { // 물고기 있다면
//				System.out.println("fishList: " + fishList);
				// 가까운 물고기 찾기 위해 정렬
				Collections.sort(fishList, new Comparator<fishPoint>() {
					@Override
					public int compare(fishPoint o1, fishPoint o2) {
						if(o1.dist != o2.dist) {
							return o1.dist - o2.dist; // 거리 가까운 물고기 부터.
						}
						else { // 거리 동일하다면
							if(o1.r != o2.r) // 위에 있는거부터 
								return o1.r - o2.r;
							else // 같은 높이에 있다면 왼쪽에 있는거부터.
								return o1.c - o2.c;
							}
					}
					
				});
				
				fishPoint nearestFish = fishList.get(0);
				numFish++;
				
				if(numFish == shark.size) { // 자기 크기 만큼 물고기 먹었다면
					shark = new sharkPoint(nearestFish.r, nearestFish.c, shark.size + 1, 0);
					answ += nearestFish.dist;
					numFish = 0;
				}else {
					shark = new sharkPoint(nearestFish.r, nearestFish.c, shark.size, 0);
					answ += nearestFish.dist;
				}
				map[nearestFish.r][nearestFish.c]= 0; 
				fishList.clear();
				
				
				// 시간 더해주기
				
			}
			else {
				break;
			}
		}
		
		System.out.println(answ);
		
	}
	static int answer = 0;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static List<fishPoint> fishList = new ArrayList<>();

	static boolean findFish(sharkPoint shark) {
		Queue<sharkPoint> queue = new LinkedList<>();
		queue.add(shark);
		int dist = 0;
		boolean[][] visited = new boolean[N][N];

		while(!queue.isEmpty()) {
			sharkPoint currShark = queue.poll();
//			System.out.println("현재 상어 위치: " + currShark);
			int r = currShark.r;
			int c = currShark.c;
			int size = currShark.size;
			int dd = currShark.dd;
			
			visited[r][c] = true;
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
//				System.out.println("위치 nr, nc: " + nr + "," + nc);
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) // 범위 벗어나면
					continue;
//				System.out.println("111");
//				System.out.println("map: " + map[nr][nc]);
//				System.out.println("visited: " + visited[nr][nc]);
				if(map[nr][nc] > size) // 자기보다 큰 물고기 있으면
					continue;
//				System.out.println("222");
				if(visited[nr][nc] == true) {// 방문 했으면
//					System.out.println("방문!");
					continue;
				}
					
				
				if(map[nr][nc] < size && map[nr][nc] != 0 && visited[nr][nc] == false) { // 먹을 수 있는 물고기는 리스트에 추가.
//					System.out.println("먹을 수 있는 물고기 존재!");
					fishList.add(new fishPoint(nr, nc, dd+1));
				}
				
				queue.add(new sharkPoint(nr, nc, size, dd+1));
				visited[nr][nc] = true;
				
//				System.out.println("fishlist: " + fishList);
			}
//			System.out.println();
		}
		
		if(fishList.isEmpty()) { // 먹을 수 있는 물고기가 전혀 없다면
			return false;
		}
		return true;
	}
	
	
	
	
//	static void findFish(sharkPoint shark, List<fishPoint> fishList) {
//		while(true) {
//			// 가장 가까운 물고기 찾기
//			Collections.sort(fishList, new Comparator<fishPoint>() {
//
//				@Override
//				public int compare(fishPoint o1, fishPoint o2) {
//					if(o1.r != o2.r) // 같은 높이에 있다며
//						return o1.r - o2.r;
//					else // 다른 높이에 있다면 왼쪽에 있는 물고기
//						return o1.c - o2.c;
//				}
//				
//			});
//
//			// 물고기 없으면 0 출력
//			if(fishList.size() == 0) {
//				answer = 0;
//				break;
//			}
//			
//			fishPoint currFish = fishList.get(0);
//			int fishSize = currFish.size;
//			int sharkSize = shark.size;
//			if(sharkSize > fishSize) // 상어가 더 크면
//				shark = new sharkPoint(currFish.r, currFish.c, sharkSize++);
//		}
//	}
	
	
}
