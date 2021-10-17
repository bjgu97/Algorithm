import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15829_Hashing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long L = Long.parseLong((br.readLine()));
		String s = br.readLine();
		
		System.out.println(hash(L, s));

	}
	
	static long hash(long L, String s) {
		char[] arr = s.toCharArray();
		long answer = 0;
		long pow = 1;
		for(int c = 0; c < L; c++) {
			answer += (arr[c] - 96) * pow;
			pow = (pow *= 31) % 1234567891;
		}
		return answer % 1234567891;
	}
}
