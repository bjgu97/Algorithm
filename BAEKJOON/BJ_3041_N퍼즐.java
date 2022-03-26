import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_3041_N퍼즐 {
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Map<Character, Point> map = new HashMap<>();
		map.put('A', new Point(0, 0));
		map.put('B', new Point(0, 1));
		map.put('C', new Point(0, 2));
		map.put('D', new Point(0, 3));
		map.put('E', new Point(1, 0));
		map.put('F', new Point(1, 1));
		map.put('G', new Point(1, 2));
		map.put('H', new Point(1, 3));
		map.put('I', new Point(2, 0));
		map.put('J', new Point(2, 1));
		map.put('K', new Point(2, 2));
		map.put('L', new Point(2, 3));
		map.put('M', new Point(3, 0));
		map.put('N', new Point(3, 1));
		map.put('O', new Point(3, 2));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		for(int i = 0; i < 4; i++) {
			String s = br.readLine();
			for(int j = 0; j < 4; j++) {
				char c = s.charAt(j);
				
				if(c == '.')
					continue;
				answer += (Math.abs(i - map.get(c).r) + Math.abs(j - map.get(c).c));
			}
		}
		
		System.out.println(answer);
	}
}
