import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(isPrime(num))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static boolean isPrime(int num) {
		if(num < 2)
			return false;
		for(int n = 2; n*n < num; n++) {
			if(num % n == 0)
				return false;
		}
		return true;
	}
}
