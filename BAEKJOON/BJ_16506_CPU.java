import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16506_CPU {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String opcode = st.nextToken();
			int rD = Integer.parseInt(st.nextToken());
			int rA = Integer.parseInt(st.nextToken());
			int rB = Integer.parseInt(st.nextToken());
			
			
		}
	}
}
