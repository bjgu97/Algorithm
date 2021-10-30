import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16943_숫자재배치 {
	static char[] AArr;
	static int[] numbers;
	static int N;
	static boolean[] selected;
	static int B;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		
		AArr = A.toCharArray();
		N = AArr.length;
		numbers = new int[N];
		selected = new boolean[N];
		perm(0);
		
		if(answer == 0)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			if(numbers[0] == 0)
				return;
			
			int C = 0;
			for(int i = 0; i < numbers.length; i++) {
				C += numbers[i] * Math.pow(10, numbers.length-1-i);
			}
//			System.out.println("C: " + C);
//			System.out.println( Arrays.toString(numbers));
			
			if(C >= B)
				return;
			
			answer = Math.max(answer, C);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(selected[i])
				continue;
			
			numbers[cnt] = AArr[i] - '0';
			
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}
}
