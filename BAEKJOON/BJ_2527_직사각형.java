import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] rect1X = new int[2]; 
			int[] rect1Y = new int[2]; 
			int[] rect2X = new int[2]; 
			int[] rect2Y = new int[2]; 
			for (int i = 0; i < 2; i++) { 
				rect1X[i] = Integer.parseInt(st.nextToken());
				rect1Y[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 2; i++) { 
				rect2X[i] = Integer.parseInt(st.nextToken());
				rect2Y[i] = Integer.parseInt(st.nextToken());
			}

			if ((rect1X[0] > rect2X[1]) || (rect1X[1] < rect2X[0]) || (rect1Y[0] > rect2Y[1])
					|| (rect1Y[1] < rect2Y[0])) {
				System.out.println('d');
			} else if ((rect1X[0] == rect2X[1] && rect1Y[0] == rect2Y[1])
					|| (rect1X[1] == rect2X[0] && rect1Y[1] == rect2Y[0])
					|| (rect1X[0] == rect2X[1] && rect1Y[1] == rect2Y[0])
					|| (rect1X[1] == rect2X[0] && rect1Y[0] == rect2Y[1])) {
				System.out.println('c');
			} else if ((rect1X[0] == rect2X[1]) || (rect1X[1] == rect2X[0]) || (rect1Y[0] == rect2Y[1])
					|| (rect1Y[1] == rect2Y[0])) {
				System.out.println('b');
			} else { 
				System.out.println('a');
			}
		}
	}
}