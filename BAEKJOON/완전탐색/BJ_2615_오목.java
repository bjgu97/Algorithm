package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_2615_오목 {
	static int[][] graph;
	static boolean[][][] visited;
	static int[][] deltas = {{1, 0}, {1, 1}, {0, 1}, {1, -1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new int[19][19];
		visited = new boolean[19][19][4];
		
		// 입력받기
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 탐색
		for(int i= 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(graph[i][j] == 1 || graph[i][j] == 2) {  
					
				}
		
	}
}
/*
public class BJ_2615_오목 {
	static int[][] graph;
	static boolean[][] visited;
	static boolean success;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		graph = new int[19][19];
		visited = new boolean[19][19];
		
		BufferedReader br = new BufferedReader(new StringReader(src));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		// 입력받기
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		outer:for(int i= 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(graph[i][j] == 1 || graph[i][j] == 2) {             // 흰돌이나 검정돌 발견하면
					System.out.println("i, j: " + (i+1) + "," + (j+1));
					success = search(i, j, graph[i][j]);               // x좌표, y좌표, 돌색깔(1 or 2) 넘겨주기
					if(success) {                                      // 오목 완성이면  출력 후 종료
						sb.append(graph[i][j]).append("\n").append(i+1).append(" ").append(j+1);
						break outer;
					}
					else {                                             // 오목 완성 아니면 계속 탐색
						System.out.println("오목 실패");
						continue;
					}
				}
			}
		}
		
		if(!success) // 결국 오목 발견 못하면
			sb.append(0); // 0 출력
		
		System.out.println(sb);
	}
	
	//static int[][] deltas = {{1, 0}, {1, 1}, {0, 1}, {1, -1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}};
	static int[][] deltas = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	static int cnt;
	static boolean check;
	
	static boolean search(int r, int c, int color) {
		visited[r][c] = true;
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr < 0 || nc < 0 || nr >= 19 || nc >= 19) 
				continue;
			
			if(graph[nr][nc] == color && visited[nr][nc] == false) { // 다음 돌 색이 현재 돌 색과 같으면
				cnt = 2; // 2목 완성
//				System.out.println("nr, nc: " + nr + "," + nc);
				check = find(d, nr, nc, color); // 같은 방향으로 계속 탐색
			}
		}
		
		if(check) { // 오목 완성이면 true 리턴
			return true;
		}
		else {// 오목 완성 못하면 false 리턴 
			visited[r][c] = false; //방문 전으로 되돌려주기
			return false;
		}
	}
	
	static boolean isTrue;
	static boolean find(int d, int nr, int nc, int color) {
		visited[nr][nc] = true;
		
		int nnr = nr + deltas[d][0];
		int nnc = nc + deltas[d][1];
		
//		System.out.println("nnr, nnc: " + nnr + "," + nnc);
		
		if(nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19) // 범위 벗어나면 continue
			return false;
		
		if(cnt == 5) { // 오목 완성 하면 6목은 아닌지 확인 필요
			if(graph[nnr][nnc] == color) {//6목이면
//				System.out.println("오목 넘어감");
				isTrue = false;
			}
			else { //오목이면
//				System.out.println("오목 완성?");
				isTrue = true;
			}
		}
		
		if(nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
			isTrue = false;
		
		if(graph[nnr][nnc] == color) { // 다음 좌표도 동일하다면
			cnt++; //3목 완성
			find(d, nnr, nnc, color);
		}
		
		if(isTrue)
			return true;
		else {
			visited[nr][nc] = false;
			return false;
		}
	}
	
	static String src = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 1 1 1 1 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
}
*/
