import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {
	static int[][] students;
	static int[][] seat;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		students = new int[N*N][5];
		seat = new int[N*N][N*N];
		
		for(int n = 0; n < N*N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int s = 0; s < 5; s++) {
				students[n][s] = Integer.parseInt(st.nextToken());
			}
		}
		
		
//		for(int[] a : students)
//			System.out.println(Arrays.toString(a));
		
		
		// 첫 번째 학생 위치시키기
		if(N %2 == 0) {
			seat[N*N/2-1][N*N/2-1] = students[0][0];
		}
		else
			seat[N*N/2][N*N/2] = students[0][0];
		
		
//		for(int[] a : seat)
//			System.out.println(Arrays.toString(a));
		
		
		// 두번째 학생부터 N*N번쨰 학생까지에 대해서 
		for(int i = 1; i < N*N; i++)
			solve(i); // 학생 위치
		
		calcSatis(); //만족도 계산
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] tempMap = new int[N*N][N*N];
	
	static void solve(int student) {
		int likes = 0; // 좋아하는 친구 수
		for(int i = 0; i < N*N; i++) {
			for(int j = 0; j < N*N; j++) {
				// 모든 지점 탐색하면서 인접 칸 살펴보기
				for(int d = 0; d < deltas.length; d++) {
					int ni = i + deltas[d][0];
					int nj = j + deltas[d][1];
					
					if(ni < 0 || nj < 0 || ni >= N*N || nj >= N*N)
						continue;
					
					// 인접 칸에 좋아하는 학생 있다면 추가
					for(int p = 1; p < 5; p++) {
						if(seat[ni][nj] == students[student][p]) {
							likes++;
						}
					}
				
				}
				tempMap[i][j] = likes; // 인접칸 좋아하는 학생 수 저장 배열.
			}
		}
		
		for(int[] a : tempMap) {
			System.out.println(Arrays.toString(a));
		}
		// 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸
		
		// 인접한 칸 중 비어있는 칸이 가장 많은 칸
		
		// 행의 번호가 가장 작은 칸 -> 열의 번호가 가장 작은 칸
	}
	
	static void calcSatis() {
		
	}
}
