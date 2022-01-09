import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_6588_골드바흐의추축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 2보다 큰 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[1000001];
		
		arr[0] = arr[1] = true; // 소수 아님
		
		for(int n = 2; n * n <= 1000000; n++) {
			if(arr[n])
				continue;
			for(int m = n * 2; m <= 1000000 ; m+= n) 
				arr[m] = true;
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine()); //1000000
			if(N == 0)
				break;
			
			int a = 0;
			int b = 0;
			
			for(int n = 3; n <= N; n++) {
				if(arr[n] == false && arr[N-n] == false) {
					a = n;
					b = N-n;
					break;
				}
			}
			
			sb.append(N).append(" = ").append(a).append(" + ").append(b).append("\n");
			
		}
		System.out.println(sb);
	}
}
