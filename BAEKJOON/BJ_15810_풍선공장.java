import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15810_풍선공장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 스태프 수
		int M = Integer.parseInt(st.nextToken()); //풍선 개수
		
		int[] time = new int[N]; //걸리는 시간
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			time[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);
		
		long low = 0l;
//		long high = (long) time[N-1] * (long) M;
		long high = Long.MAX_VALUE;
		
		long numBalloon = 0;
		while(low <= high) {
			long mid = (low + high) / 2;
			
			numBalloon = 0;
			
			for(int i = 0; i < time.length; i++){
				numBalloon += mid / time[i];
				if(numBalloon >= M) {
					break;
				}

			}
			
			if(numBalloon >= M) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
//		System.out.println(low);

			System.out.println(low);
	}
}
