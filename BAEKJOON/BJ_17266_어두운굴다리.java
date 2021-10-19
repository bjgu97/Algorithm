import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17266_어두운굴다리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 굴다리의 모든 길 0~N 밝히게.
		// 가로등 설치할 개수 M, 각 가로등 위치 x
		// 각 가로등 높이만큼 주위 비출 수 있음.
		// 가로등 높을수록 가격 비싸기 때문에 최소한의 높이로 굴다리 모든 길 밝히기.
		// 가로등 높이 같아야 함.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 5
		int M = Integer.parseInt(br.readLine()); // 2
		
		int[] arr = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			arr[m] = Integer.parseInt(st.nextToken()); // 2 4
		}
		
		// 가로등 사이 길이가 가장 긴 것 찾기.
		int max = 0;
		for(int m = 0; m < M-1; m++) {
			int num = arr[m+1] - arr[m];
			if(num % 2 == 0)
				max = Math.max(max, num/2);
			else
				max = Math.max(max, num/2 + 1);
		}
		max = Math.max(max, N - arr[M-1]);
		max = Math.max(max, arr[0]);
		System.out.println(max);
	}
}
