import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_1075_나누기 {
	public static void main(String[] args) throws IOException {
		// N을 F로 나누어 떨어지게
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.valueOf(br.readLine());
		long F = Long.valueOf(br.readLine());
		long answer = 0;
		N = N - (N%100);

		for(int i = 0; i < 100; i++) {
			if(N % F == 0) {
				answer = N;
				break;
			}
			N++;
		}
		
		System.out.println(Long.toString(N).substring(Long.toString(N).length()-2, Long.toString(N).length()));
	}
}
