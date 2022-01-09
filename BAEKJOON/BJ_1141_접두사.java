import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1141_접두사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 접두사X 집합 : 집합의 어떤 한 단어가 다른 단어의 접두어가 되지 않는.
		// 접두사X 집합인 부분집합의 최대 크기?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			arr[n] = s;
		}
		
		
		int total = N;
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

		for(int n = 0; n < N-1; n++) {
			String first = arr[n];
			String second = arr[n+1];
			
//			System.out.println("first, second: " + first + "," + second);
			boolean flag = true;
			for(int f = 0; f < first.length(); f++) {
				if(first.charAt(f) != second.charAt(f)) {
					flag = false;
					break;
				}
			}
			
//			System.out.println("flag: " + flag);
			if(flag) {
				total--;
			}
		}
		
		System.out.println(total);
	}
}
