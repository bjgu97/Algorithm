import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2751_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
//		int[] arr = new int[N];
//		for(int n = 0; n < N; n++) {
//			arr[n] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(arr);
//		
//		for(int n = 0; n < N; n++) {
//			System.out.println(arr[n]);
//		}
		
		boolean[] temp = new boolean[2000001];
		
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			temp[num + 1000000] = true;
		}
		
		for(int n = 0; n < 2000001; n++) {
			if(temp[n]) {
				sb.append(n - 1000000).append("\n");
//				System.out.println(n - 1000000);
			}
		}
		System.out.println(sb);
		
	}
}
