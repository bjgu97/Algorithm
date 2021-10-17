import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11508_21세일 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
	
		Arrays.sort(arr, (o1, o2) -> o2 - o1); // 내림차순
		
		System.out.println(Arrays.toString(arr));
		
		int sum = 0;
		for(int n = 0; n < N; n++) 
			if(n % 3 != 2) sum += arr[n];
		
		System.out.println(sum);
	}
}
