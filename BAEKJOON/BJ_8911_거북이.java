import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8911_거북이 {
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// F: 앞
		// B: 뒤
		// L: 왼쪽 회전
		// R: 오른쪽 회전
		
		// 거북이가 니자간 영역 포함할 수 있는 가장 작은 직사각형 넓이
		
		// 처음엔 (0,0), 북쪽
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
				
		for(int t = 0; t < T; t++) {
			String s = br.readLine();
			char[] sArr = s.toCharArray();
			
			int x = 0;
			int y = 0;
			int d = 0;
			int maxX = 0;
			int maxY = 0;
			int minX = 0;
			int minY = 0;
			
			for(int c = 0; c < sArr.length; c++) {
				if(sArr[c] == 'F') {
					x += deltas[d][0];
					y += deltas[d][1];
				}
				else if(sArr[c] == 'B') {
					x -= deltas[d][0];
					y -= deltas[d][1];
				}
				else if(sArr[c] == 'L') {
					d = d - 1;
					if(d < 0) {
						d = 3;
					}
				}
				else if(sArr[c] == 'R') {
					d = d + 1;
					if(d > 3) {
						d = 0;
					}
				}
				
				maxX = Math.max(x,  maxX);
				maxY = Math.max(y,  maxY);
				minX = Math.min(x,  minX);
				minY = Math.min(y,  minY);
			}
			
//			System.out.println(maxX + "," + maxY + "," + minX + ","  + minY);
			System.out.println(Math.abs(maxX - minX) * Math.abs(maxY - minY));

		}
		
	}
}
