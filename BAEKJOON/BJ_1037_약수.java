import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1037_약수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// A가 N의 진짜 약수 : N은 A의 배수이고, A는 1과 N 아니다.
		// A가 주어질 떄, N은?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < num; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(num%2 == 0) {
			System.out.println(arr[0] * arr[num-1]);
		}
		else {
			System.out.println(arr[num/2] * arr[num/2]);
		}
	}
}
