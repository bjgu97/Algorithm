import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1085_직사각형에서탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 6
		int y = Integer.parseInt(st.nextToken()); // 2
		int w = Integer.parseInt(st.nextToken()); // 10
		int h = Integer.parseInt(st.nextToken()); // 3
		
		int len1 = Math.min(x, w-x);
		int len2 = Math.min(y, h-y);
		
		System.out.println(Math.min(len1, len2));
	}
}
