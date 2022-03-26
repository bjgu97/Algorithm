import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1439_뒤집기 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String S = br.readLine();
	
	int L = S.length();
	
	int cnt = 0;
	for(int s = 0; s < L-1; s++) {
		char c = S.charAt(s);
		char nc = S.charAt(s+1);
		
		if(c == nc) continue;
		else {
			cnt++;
		}
		
	}
	
	System.out.println((cnt+1)/2);
	
}
}
