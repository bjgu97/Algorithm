import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4963_섬의개수 {
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	                        //   위     아래    오른    왼    오른아래  오른위   왼아래   왼위
	static int[][] place;
	static boolean[][] visited;
	static int H;
	static int W;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0)
				break;
			
			visited = new boolean[H][W];
			place= new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					place[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for(int i = 0; i <H; i++) {
				for(int j = 0; j < W; j++) {
					if(place[i][j] == 1) { // and visited
						answer++;
						land(i, j);
						System.out.println("HH");
					}
				}
			}
			System.out.println(answer);
		} 	
	}
	
	static void land(int h, int w) {
		place[h][w] = 0;
		for(int d = 0; d < deltas.length; d++) {
			int nh = h + deltas[d][0];
			int nw = w + deltas[d][1];
		
		
			if(isIn(nh, nw) && place[nh][nw] == 1) {
				//place[h][w] = 0;
				land(nh, nw);
			}
		}
	}
	
	private static boolean isIn(int h, int w) {
		return 0 <= h && h < H && 0 <= w && w < W;
	}

}
