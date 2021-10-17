import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2417_정수제곱근 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long n = Long.parseLong(br.readLine());
		Long sqrtN = (long)Math.sqrt(n);
		
		System.out.println((sqrtN * sqrtN == n) ? sqrtN : sqrtN+1);
	}
}