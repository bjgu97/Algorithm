import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15787_기차가어둠을헤치고은하수를 {
	
	public static void main(String[] args) throws IOException {
		// N개의 기차
		// 20개의 일렬도 된 좌석, 한 개의 좌석에는 한 사람
		// 어떠한 기차에 대하여 M개의 명령
		
		// 1번째 기차부터 순서대로 은하수 건넌다.
		// 앉은상태 이미 목록에 존재하면 은하수 건널 수 없다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 기차 수(100000)
		int M = Integer.parseInt(st.nextToken()); // 명령 수(100000)
		
		int[][] arr = new int[N][20];
		
		for(int n = 0; n < N; n++) {
			for(int i = 0; i < 20; i++) {
				arr[n][i] = 0;
			}
		}

		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int i;
			int x;
			if(command == 1) {
				i = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				
				arr[i-1][x-1] = 1;
			}
			else if(command == 2) {
				i = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				
				arr[i-1][x-1] = 0;
			}
			else if(command == 3) {
				i = Integer.parseInt(st.nextToken());
				
				for(int k = 18; k >= 0; k--) {
					arr[i-1][k+1] = arr[i-1][k];
				}
				arr[i-1][0] = 0;
			}
			else if(command == 4) {
				i = Integer.parseInt(st.nextToken());
				
				for(int k = 1; k <= 19; k++) {
					arr[i-1][k-1] = arr[i-1][k];
				}
				
				arr[i-1][19] = 0;
			}
		}
		
		Set<String> set = new HashSet<>();
		for(int[] a : arr) {
			String s = Arrays.toString(a);
			set.add(s);
		}
		
		System.out.println(set.size());

	}
}
