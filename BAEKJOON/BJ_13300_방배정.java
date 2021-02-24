import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {
	static char[][] graph;
	static int H;
	static int W;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] graph = new char[H][W];
		for(int h =  0; h < H; h++) {
			String s = br.readLine();
			for(int w = 0; w < W; w++) {
				graph[h][w] = s.charAt(w);
			}
		}
	}
}
