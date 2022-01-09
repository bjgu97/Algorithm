import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_23351_물주기 {
	public static void main(String[] args) throws IOException {
		// N개의 화분에 캣닢 하나씩
		// 각 화분 초기에 K만큼의 수분
		
		// 1. 연속된 A개 화분에 물 준다
		// 믈 즌 화분의 수분은 B만큼 증가
		//  2. 모든 화분 수분 1씩 감소
		// 3. 수분 0 된 화분 캣닢 죽는다.
		
		// 첫 캣닢이 죽는 날짜는?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N개의 화분
		int K = Integer.parseInt(st.nextToken()); // 초기에 K만큼 수분
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] plants = new int[N];
		Arrays.fill(plants, K);
		boolean check = false;
		int day = 0;
		while(true) {
			check = false;
			day = 0;
			
			// 연속된 A개 화분에 물을 준다.
			
			// 모든 화분의 수분 1씩 감소
			for(int n= 0; n < N; n++) {
				plants[n]--;
			}
			
			// 수분이 0인 된 화분 죽는다.
			for(int n = 0; n < N; n++) {
				if(plants[n] <= 0) {
					check = true;
					day++;
				}
			}
			
			if(check) {
				break;
			}
		}
		
		System.out.println(day);
	}
}
