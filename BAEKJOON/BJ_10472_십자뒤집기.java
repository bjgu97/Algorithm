import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10472_십자뒤집기 {
	static int[] numbers;
	static int[][] arr = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

	static int answer ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		
		for(int p = 0; p < P; p++) {
			char[][] map = new char[3][3];
			answer = Integer.MAX_VALUE;
			
			for(int i = 0; i < 3; i++) {
				String s = br.readLine();
				map[i] = s.toCharArray();
			}
			
			// 흰 보드를 map로 바꾸는 데 필요한 최소 클릭 횟수?
			
			
		}
		
	}
	


}
