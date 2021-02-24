import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_3985_롤케이크 {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			int L = Integer.parseInt(br.readLine()); // 롤케이크 길이 L
			int[] cake = new int[L+1]; // 케이크 배열
			
			int N = Integer.parseInt(br.readLine()); // 방청객 수 N
			int[][] NArr = new int[N+1][2]; // 방청객 번호 저장 배열
			
			for(int n = 1; n <= N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
//				if(cake[a] == 0)
//					cake[a] = n; // 케이크 배열에 번호 저장(처음과 끝)
//				if(cake[n] == 0)
//					cake[b] = n;
				NArr[n][0] = a; // 방청객 번호 따로 또 저장
				NArr[n][1] = b;
			}
			
			// cake : [0 1 1 1 0 3 2 2 3 0]
			// NArr: 2 4 
			//       7 8
			//       6 9
			
			
			
			// 1. 가장 많은 조각을 받을 것으로 기대하고 있던 방청객 번호
			// 최댓값 구하고
			int max = 0;
			for(int n = 1; n <= N; n++) {
				max = Math.max(max, NArr[n][1] - NArr[n][0]);
			}
			
			//최댓값 받을 방청객 번호 출력 (가장 작은 번호)
			for(int n = 1; n <= N; n++) {
				if(NArr[n][1] - NArr[n][0] == max) {
					System.out.println(n);
					break;
				}
			}
			
			
			
			
			// 2. 실제로 가장 많은 조각을 받은 방청객 번호	
			// 먼저 값 채우기
			int answ = 0;
			int[] arr = new int[N];
			
			for(int n = 1; n <= N; n++) {
				answ = 0;
				for(int i = NArr[n][0]; i <= NArr[n][1]; i++) {
					if(cake[i] == 0)
						cake[i] = n;
				}
			}
			
//			System.out.println(Arrays.toString(cake));
			
			// 값 count
			int max2 = 0;
			int[] newArr = new int[N+1];
			
			for(int i = 1; i < cake.length; i++) {
				if(cake[i] == 0)
					continue;
				newArr[cake[i]]++;
			}
			
//			System.out.println(Arrays.toString(newArr));
			
			for(int i = 1; i < newArr.length; i++) {
				max2 = Math.max(max2, newArr[i]);
			}
			
//			System.out.println(max2);
			
			// 최대로 많이 받는 방청객 번호 출력
			for(int i= 1; i < newArr.length; i++) {
				if(newArr[i] == max2) {
					System.out.println(i);
	                break;
	            }
			}
		}
}
