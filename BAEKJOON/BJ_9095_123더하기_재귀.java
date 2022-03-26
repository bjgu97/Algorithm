import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095_123더하기_재귀 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// n을 1, 2, 3의 합으로 나타내는 방법의 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			// {0, 1, 2, 3} 중 중복 포함해서 N개 뽑기!
			
			System.out.println(func(0, 0, N));
		}
	}
	
	// cnt : 사용한 수의 개수
	// sum : 전체의 합
	// 입력: n
	
	// 1) 다음 경우 호출? 
	// 1을 사용함: func(cnt+1, sum+1, n)
	// 2를 사용함 func(cnt+1, sum+2, n)
	// 3을 사용함. func(cnt+1, sum+3, n)
	
	// 2) 정답을 찾은 경우
	// sum == n
	
	// 3) 불가능한 경우
	// 문제의 조건을 지키지 않은 경우 
	// 절대로 답을 구할 수 없는 경우
	// sum > n
	static int func(int cnt, int sum, int N) {
		// 불가능한 경우
		if(sum > N) return 0;
		if(sum == N) return 1; // 정답 찾음
		
		int now = 0;
		now += func(cnt+1, sum + 1, N);
		now += func(cnt+1, sum+2, N);
		now += func(cnt+1, sum+3, N);
		
		return now;
	}
}
