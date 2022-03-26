import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_5545_최고의피자 {
	static int[] numbers;
	static int A;
	static int B;
	static int C;
	static int[] DArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 토핑 종류
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 도우 가격
		B = Integer.parseInt(st.nextToken()); // 토핑 가격
		C = Integer.parseInt(br.readLine()); // 도우 열량
		
		DArr = new int[N];
		for(int n = 0; n < N; n++) {
			DArr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(DArr);
		
		int price = A;
		int cal = C; 
		int answer = C / A;
		
		for(int i = N-1; i >=0; i--) {
			 price += B;
			 cal += DArr[i];

			 answer = Math.max(cal / price, answer);
		}
		
		System.out.println(answer);

	}

}
