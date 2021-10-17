import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_22993_서든어택3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N-1];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		long A1 = Long.parseLong(st.nextToken());
		
		for(int n = 0; n < N-1; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
				
		boolean flag = false;
		for(int n = 0; n < N-1; n++) {
			if(A1 > arr[n]) {
				A1 += arr[n];
				flag = true;
			}
			else {
				flag = false;
				break;
			}
		}
		
		if(flag || arr.length == 0) // 예외처리: 준완 혼자 있을 때. 
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
