import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10974_모든순열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		int[] numbers = new int[N];
		
		for(int n = 1; n <= N; n++) {
			arr[n-1] = n;
		}
				
		perm(0, arr, numbers, visited, N);
	}
	
	static void perm(int cnt, int[] arr, int[] numbers, boolean[] visited, int N) {
		if(cnt == N) {
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == true)
				continue;
			numbers[cnt] = arr[i];
			visited[i] = true;
			perm(cnt+1, arr, numbers, visited, N);
			visited[i] = false;
		}
	}
}
