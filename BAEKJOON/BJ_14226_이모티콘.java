import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14226_이모티콘 {
	
	static class Point {
		int s;
		int cnt;
		
		Point(int s, int cnt) {
			this.s = s;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [s=" + s + ", cnt=" + cnt + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		
		func(1, S, 0);
	}
	
	static int answ = Integer.MAX_VALUE;
	static boolean[] visited = new b
	static void func(int screen, int S, int cnt) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(screen, 0));
		
		while(!queue.isEmpty()) {
			System.out.println(queue);
			Point p = queue.poll();
			
			if(p.s == S) {
				System.out.println(p.cnt);
				break;
			}
			
			int clip = screen;
			screen += clip;
			queue.add(new Point(screen, cnt+1));
			screen--;
			queue.add(new Point(screen, cnt+1));
			
		}
	}
}
