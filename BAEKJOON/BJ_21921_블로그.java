import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_21921_블로그 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		List<Long> list = new ArrayList<>();
		
		for(int x = 0; x < X; x++) {
			sum += arr[x];
		}
		
		list.add(sum);
		long max = sum;
		
		for(int n = X; n < N; n++) {
			sum += arr[n];
			sum -= arr[n-X];
			
			list.add(sum);
			max = Math.max(max, sum);
		}
		int cnt = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == max)
				cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		if(max == 0) {
			sb.append("SAD");
		}else {
			sb.append(max).append("\n");
			sb.append(cnt);
		}
		
		System.out.println(sb);
	}
}
