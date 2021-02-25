import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) { 
			for(int j = i; i*j <= n; j++) {
				cnt++;
				System.out.println("i, j: " + i + "," + j);
			}
		}
		
		System.out.println(cnt);
	}
}
