

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15686_치킨배달 {
	
	static int N;
	static int M;
	
	static int[][] house;
	static int[][] chicken;
	
	static int[][] answer; 
	
	static int houseCnt; // 집 수
	static int chickenCnt; // 치킨집 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 입력받기
		int[][] NArr = new int[N][N];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				NArr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		house = new int[N*N][2]; // 집 좌표 담을 배열 넉넉히 잡아주기
		chicken = new int[N*N][2]; // 치킨집 좌표 담을 배열 넉넉히 잡아주기
		
		houseCnt = 0;
		chickenCnt = 0;
		int i= 0;
		int j = 0;
		
		// 집, 치킨집 좌표 찾아서 담아주기 
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				if(NArr[n][m] == 1) {
					house[i][0] = n;
					house[i][1] = m;
					i = i + 1;
					houseCnt++; // 집 개수
				}
				else if(NArr[n][m] == 2) {
					chicken[j][0] = n;
					chicken[j][1] = m;
					j = j + 1;
					chickenCnt++; // 치킨집 개수
				}
			}
		}

		answer = new int[M][2]; // 치킨집 조합 담을 배열(numbers)
		comb(0, 0);
		
		System.out.println(sum);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == M) { 
			findMin();
			return;
		}
		
		for(int i = start; i < chickenCnt; i++) {
			answer[cnt][0] = chicken[i][0];
			answer[cnt][1] = chicken[i][1];

			comb(cnt+1, i+1);
		}
		
	}
	
	static int minLen = Integer.MAX_VALUE;
	static int xLen;
	static int yLen;
	static int sum;
	static int answ = Integer.MAX_VALUE;
	
	public static void findMin() {
		sum = 0; // 합 초기화
		for(int i = 0; i < houseCnt; i++) {
			minLen = Integer.MAX_VALUE; // minLen 초기화
			for(int j = 0; j < answer.length; j++) { 
				xLen = Math.abs(house[i][0] - answer[j][0]); 
				yLen = Math.abs(house[i][1] - answer[j][1]);
				minLen = Math.min(minLen, (xLen + yLen)); // 각 집의 치킨거리 찾기
			}
			sum += minLen; // 모든 집의 치킨거리 합
		}
		answ = Math.min(answ, sum); // 도시의 치킨거리 최솟값 구하기
	}
}
