import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15666_N과M12 {
	static int N;
	static int M;
	static int[] arr;
	static int[] numbers;
	static List<int[]> list;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[M+1];
		numbers = new int[N];
		temp = new int[N];
		for(int n = 0; n < M; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		// 중복조합
		list = new ArrayList<int[]>();
		comb(0, 1);
		
		System.out.println(sb);
	}
	
	static int[] temp; 
	
	static void comb(int cnt, int start) {
		if(cnt == N) {
			Arrays.sort(numbers);

			for(int i= 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i= start; i <= M; i++) {
			if(arr[i-1] == arr[i]) 
				continue;
			numbers[cnt] = arr[i];
			comb(cnt+1, i);
		}
	}
}
