import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21758_꿀따기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 서로 다른 곳 벌 한마리씩
		// 한 장소에는 벌통
		// 벌은 날아가면서 꿀 딴다.
		// 숫자 : 꿀 딸 수 있는 양
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] sumArr = new int[N];
		int sum = 0;
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			sum += arr[n];
		}
		
		sumArr[0] = arr[0];
		for(int n = 1; n < N; n++) {
			sumArr[n] = sumArr[n-1] + arr[n];
		}
		int answer = 0;
		
		int answer1 = 0;
		// 꿀통 제일 오른쪽에 있는 경우
		for(int i = 1; i < N-1; i++) {
			answer1 = (sum - arr[0] - arr[i]) + (sum - sumArr[i]);
			answer = Math.max(answer1, answer);
		}
		// 꿀통 제일 왼쪽에 있는 경우
		int answer2 = 0;
		for(int i = 1; i < N-1; i++) {
			answer2 = (sum - arr[N-1]-arr[i]) + sumArr[i-1];
			answer = Math.max(answer2, answer);
		}
		//  꿀통 가운데 어딘가에 있는 경우
		int answer3 = 0;
		for(int i = 1; i < N-1; i++) {
			answer3 = (sumArr[i] - arr[0]) + (sumArr[N-2] - sumArr[i-1]);
//			System.out.println("answer3: " + answer3);
			answer = Math.max(answer3, answer);
		}
		
		System.out.println(answer);
	}
}
