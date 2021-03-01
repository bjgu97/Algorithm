import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15565_귀여운라이언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 총 인형 개수
		int K = Integer.parseInt(st.nextToken()); //라이언인형 K개 이상
		
		st = new StringTokenizer(br.readLine());
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(NArr));
		
		// K 개 이상 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 킈
		
	}
}
