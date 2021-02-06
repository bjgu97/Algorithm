package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SW_1868_파팡파팡지뢰찾기 {
	static char[][] graph;
	static int[][] deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	                         //위       위오    오       아오   ㅇ      아왼     왼        위왼
	
	static int N;
	static int cnt; // cnt: 폭탄 개ㅜ수
	static boolean[][] visited;
	static char[][] graphNum;
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
			graphNum = new char[N][N];
			answer = 0;
			
			
			
			// 1. 입력받기
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					graph[i][j] = s.charAt(j);
				}
			}
			
			
			// 2-1. 숫자 배열 clone 해오기
			graphNum = new char[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graphNum[i][j] = graph[i][j];
				}
			}

			
			// 2-2. 숫자 배열에 지뢰 수 업데이트
			int num = 0;
			for(int i = 0;i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][j] == '.') {
						num = count(i, j);
						graphNum[i][j] = String.valueOf(num).charAt(0);
					}
				}
			}
			
			
			// 2-3. 출력해보기
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(graphNum[i][j]);
//				}
//				System.out.println();
//			}
			
			
			// boolean 배열 만들기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][j] == '*')
						visited[i][j] = true; //방문한 곳!
					else
						visited[i][j] = false; //아직 방문 안한곳 
				}
			}
			
			
			// 2-3. 출력해보기
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(visited[i][j]);
//				}
//				System.out.println();
//			}
						
						
			// 0  찾기
			answer = 0;
			for(int w= 0; w < N; w++) {
				for(int h = 0; h < N; h++) {
					if(graphNum[w][h] == '0' && visited[w][h] == false) { //원래는 주변에 지뢰 개수 새서 찾았는데,,
						answer++;
//						System.out.println("search function call!!");
						search(w, h);
						
					}
				}
			}
			
			
			System.out.println("answer???? " + answer);
			//정답 출력
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


	
	// 0 주변 True로 바꿔주기
	public static void search(int w, int h) { 
		visited[w][h] = true; //일단 자기 자신 true로 바꿔주고
		
		for(int d = 0; d < deltas.length; d++) {
			
			int nh = h + deltas[d][0];
			int nw = w + deltas[d][1];
						
			if( !(nh >= 0 && nh < N && nw >= 0 && nw < N)) //범위 안에 있게. 
				continue;
			
//			System.out.println("nw: " + nw + ", nh: " + nh);
			if(graphNum[nw][nh] != '*' && visited[nw][nh] == false) { 
				visited[nw][nh] = true;
			}
			
			if(graphNum[nw][nh] == '0' && visited[nw][nh] == false) {
				visited[nw][nh] = true;
				search(nw, nh);
			}

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}
	
	
	
	/// 지뢰찾기 숫자 표시
	public static int count(int w, int h) {
		cnt = 0;
		for(int d = 0; d < deltas.length; d++) {
			int nh = h + deltas[d][0];
			int nw = w + deltas[d][1];
			
			if( !(nh >= 0 && nh < N && nw >= 0 && nw < N)) //범위 안에 있게. 
				continue;
			if(graph[nw][nh] == '*') { 
				cnt++;
			}			
		}
		return cnt;
	}
}