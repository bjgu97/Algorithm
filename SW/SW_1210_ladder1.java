/**
* @since 2021. 2. 3.
* @author bjgu9
* @see
* @mem
* @time
* @caution $단순배열 $시뮬레이션
* [고려사항]
* [입력사항]
* [출력사항]
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1210_ladder1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	
	static int[][] deltas = {{0,1}, {0, -1}, {-1, 0}}; //오, 왼, 위
	public static void main(String[] args) throws IOException {
		for(int t = 1; t <= 10; t++) {
			br.readLine(); //테케 번호는 읽고 버리자.
			
			map = new int[100][100];
			
			int answer = 0;
			for(int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c =0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					
					if(r == 99 && map[r][c] == 2) { //마지막줄이고, 정답이면
						//System.out.println("출발점: " + r + ", " + c);
						answer = findPath(r, c);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			// 입력 끝났으니 확인해보자
			for(int[] row: map)
				System.out.println(Arrays.toString(row));
		}
		
	}
	/**
	 * 
	 * @param r 출발점 r
	 * @param c 출발점 c
	 * @return 도착점의 c, 도착하지 못하면 -1
	 */
	static int findPath(int r, int c) {
		boolean canGo = true;
		// while의 반복 하나가 한칸의 진전 나타냄. 
		while(canGo) {
			//배수진을 치자. 
			canGo = false;
			//여기에서 다음으로 가지 못하면..반복 벗어나고 -1 리턴
			//거쳐온 곳은 1이 아닌 값으로 변경해서 지나온 길을 표시해주자. 
			map[r][c] = 0;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				//새로운 좌표로 갈 수 있을까?
				if(isIn(nr, nc) && map[nr][nc] == 1) { //이거를 통과하면 가는것. 
					if(nr == 0) { //맨 처음 행이면 끝. 
						return nc;
					}
					r = nr;
					c = nc;
					canGo = true;
					//다음 좌표가 결정되면 다음 방향 체크는 불필요. 
					break;
				}
			}
		}
		return -1;
	}
	
	static boolean isIn(int r, int c ) {
		return 0<r && r < 100 && 0 <= c && c < 100;
	}
}
//public class SW_1210_ladder1 {
//public static void main(String[] args) throws NumberFormatException, IOException {
//	//10 번의 테케
//	// 첫번째줄은 테케 번호
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	StringBuilder sb = new StringBuilder();	
//	
//	
//	for(int t = 0; t< 1; t++) { //테케 10번
//		int[][] arr = new int[100][100];
//		// 번호 입력받고
//		int N = Integer.parseInt(br.readLine());
//		int jj = 0;
//		// 테케 입력받기
//		for(int i = 0; i < 100; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			
//			//2차원 배열에 테케 입력
//			for(int j = 0; j < 100; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken()); 
//			}
//		}
//		
//		// 정답찾기
//		for(int j = 0; j < 100; j++) {
//			if(arr[99][j] == 2)
//				jj = j;
//		} //j = 57
//		
//		// 정답 j 열부터 위로 올라가면서 1 따라가기
//		int ii = 99;
//		while(true) {
//			//System.out.println("while start");
//			if(ii == 0)
//				break;
//			if(arr[ii-1][jj] == 1) { //현위치 위가 1이며ㅑㄴ 
//				ii = ii-1; // 위로 올라가기 
//			}
////			System.out.println("ii: " + ii + " jj: " + jj);
//
//			if(jj != 0 && arr[ii][jj-1] == 1) { //왼쪽이 1이면
//				while(arr[ii][jj-1] == 1) {
//					jj = jj-1; //오른쪽으로 이동
//				}
//			}
//
//			else if(jj != 99 && arr[ii][jj+1] == 1) { //오른쪽이 1이면
//				while(arr[ii][jj+1] == 1) {
//					jj = jj+1; //오른쪽으로 이동
//				}
//			}
////			System.out.println("ii: " + ii + " jj: " + jj);
//		}
//		sb.append("#").append(t+1).append(" ").append(jj).append("\n");
//		}
//		
//	System.out.println(sb);
//		
//
//	}
//}



//package Algorithm.sw.d3;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class SW_1210_ladder1 {
//public static void main(String[] args) throws NumberFormatException, IOException {
//
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	StringBuilder sb = new StringBuilder();	
//	
//	
//	for(int t = 0; t< 1; t++) { //테케 10번
//		int[][] arr = new int[100][100];
//		// 번호 입력받고
//		int N = Integer.parseInt(br.readLine());
//		int jj = 0;
//		
//		// 사다리 입력받기
//		for(int i = 0; i < 100; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//	
//			for(int j = 0; j < 100; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken()); 
//			}
//		}
//		
//		//답 찾기
//		for(int j = 0; j < 100; j++) {
//			if(arr[99][j] == 2)
//				jj = j;
//		} //j = 57
//		
//		// 정답 j 열부터 위로 올라가면서 1 따라가기
//		int ii = 99;
//		while(true) {
//			System.out.println("ii? " + ii + "jj? " + jj);
//			if(ii == 0)
//				break; //위 도착하면
//			
//			if(arr[ii-1][jj] == 1) { //현위치 위가 1이면
//				ii = ii-1; // 위로 올라가기 
//			}
//			
//			// 끝에 위치하면
////			if(jj == 0 || jj == 99) {
////				continue;
////			}
//			
//			else if(arr[ii][jj-1] == 1) { //왼쪽이 1이면
//				while(arr[ii][jj-1] == 1) {
//					jj = jj-1; //왼쪽으로 쭉 이동
//				}
//			}
//			else if(arr[ii][jj+1] == 1) { //오른쪽이 1이면
//				while(arr[ii][jj+1] == 1) {
//					jj = jj+1; //오른쪽으로 이동
//				}
//			}
//			
//			System.out.println("ii: " + ii + " jj: " + jj);
//		}
//		
//		sb.append("#").append(t+1).append(" ").append(jj).append("\n");
//		}
//		
//	System.out.println(sb);
//		
//
//	}
//}
//
