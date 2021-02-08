package Algorithm.sw.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1868_파팡파팡지뢰찾기2 {
	static char[][] graph;
	static int[][] deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	                         //위       위오    오       아오   ㅇ      아왼     왼        위왼
	
	static int N;
	static int cnt; // cnt: 폭탄 개ㅜ수
	static boolean[][] visited;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		//테케 시작
		for(int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			graph = new char[N][N];
			answer = 0;
			
			
			
			// 1. 입력받기
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					graph[i][j] = s.charAt(j);
				}
			}
			

			//2. boolean 배열 만들기 (방문 안한곳: false/ 방문 한곳&지뢰: true)
			for(int w= 0; w < N; w++) {
				for(int h = 0; h < N; h++) {
					if(graph[w][h] == '*') //일단 지뢰 있는 곳은 true로 
						visited[w][h] = true;
					else 
						visited[w][h] = false;
				}
			}
				
			
			// 3. 주변(8곳)에 폭탄이 없으면 answer + 1 
			// 4. 그 다음 주변을 true로 변경. (다시 방문 안하기 위해)
			for(int w= 0; w < N; w++) {
				for(int h = 0; h < N; h++) {
					// . 지점을 찾고, 주변에 폭탄이 없고, 방문하지 않은 곳이면, 
					if(graph[w][h] == '.' && isZero(w, h)  && visited[w][h] == false) {
						answer++; // 일단 answer +1 하고
						search(w, h); // 탐색
					}
					
					
				}
			}
			
			// 5. 결과 출력 (false로 남은 곳 출력)
			for(int w = 0; w < N; w++) {
				for(int h = 0; h < N; h++) {
					if(visited[w][h] == false) // 남은 곳: '.'
						answer++;
				}
			}
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	// 주변 True로 바꿔주기 
	public static void search(int w, int h) { //들어오는 좌표는 주변에 지뢰 없는 좌표만. 
		visited[w][h] = true; //일단 자기 자신 true로 바꿔주고
		
		for(int d = 0; d < deltas.length; d++) {
			int nh = h + deltas[d][0];
			int nw = w + deltas[d][1];
			// 주변이 . 이고 방문하지 않은 곳이고 
			if(isIn(nw, nh) && graph[nw][nh] == '.' && visited[nw][nh] == false) { 
				//visited[nw][nh] = true;
				if(isZero(nw, nh) == true) {
					search(nw, nh);
				}
				
				visited[nw][nh] = true;
				
			}	
		}
	}
	
	
	// 팔방탐색해서 주변에 지뢰가 있는지 확인하는 함수
	public static boolean isZero(int w, int h) { 
		cnt = 0;
		for(int d = 0; d < deltas.length; d++) {
			int nh = h + deltas[d][0];
			int nw = w + deltas[d][1];
			
			//주변에 폭탄 있는지 확인
			if(isIn(nh, nw)  && graph[nw][nh] == '*') { 
				cnt++;
			}			
		}
		if(cnt == 0)
			return true;
		else
			return false;
	
	}

	 public static boolean isIn(int w, int h) {
		 return h >= 0 && h < N && w >= 0 && w < N;
	}

}
