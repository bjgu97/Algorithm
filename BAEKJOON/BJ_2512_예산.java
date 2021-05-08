import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_예산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 지방의 수
		int[] NArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int summ = 0;
		int maxx = 0;
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
			summ += NArr[n]; // 요청 예산 합
		}
		
		int M = Integer.parseInt(br.readLine()); // 총 예산
		
		Arrays.sort(NArr);
		
		int top = 100000;
		int down = 0;
		int mid = 0;
		boolean check = false;
		
		if(summ <=M) //요청 예산이 총 예산보다 적으면
			System.out.println(NArr[N-1]); // 그냥 출력
		else {
			while(down <= top) {
				int sum = 0;
				mid = (top + down) / 2;
				
				for(int i = 0; i < N; i++) {
					if(NArr[i] > mid) {
						sum += mid;
					}
					else
						sum += NArr[i];
				}
				if(sum > M) { // 총 예산을 넘어가면
					top = top -1;
				}
				else if(sum < M) { // 총예산보다 적으면
					down = down + 1;
				}
				else if(sum == M) {
					check = true;
					break;
				}
			}
			
			if(check)
				System.out.println(mid);
			else
				System.out.println(mid-1);
		}
		

	}
}

