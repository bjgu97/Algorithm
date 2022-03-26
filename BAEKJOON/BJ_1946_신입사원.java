import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1946_신입사원 {
	// 1차 서류, 2차 면접
	
	// 서류와 면접 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만.
	// A가 B에 비해 서류와 면접 모두 떨어지면ㄴ, A 선발 안됨.
	
	static class Score implements Comparable<Score>{
		int paper;
		int inter;
		
		Score(int paper, int inter) {
			this.paper = paper;
			this.inter = inter;
		}

		@Override
		public String toString() {
			return "Score [paper=" + paper + ", inter=" + inter + "]";
		}
		
		public int compareTo(Score score) {
			return this.paper - score.paper;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 지원자 수
			
			Score[] array = new Score[N];
			
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				
				array[n] = new Score(paper, inter);
			}
			
//			System.out.println(Arrays.toString(array));
			Arrays.sort(array);
//			System.out.println(Arrays.toString(array));
			
			int cnt = 1;
			int num = array[0].inter;
			for(int a = 1; a < array.length; a++) {
				num = Math.min(num, array[a].inter);
				if(num == array[a].inter) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
