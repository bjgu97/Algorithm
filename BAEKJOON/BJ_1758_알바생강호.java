import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class BJ_1758_알바생강호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer[] line = new Integer[N];
		
		for(int n = 0; n < N; n++) {
			line[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(line, Comparator.reverseOrder());

		long max = 0;
		for(int n = 0; n < N; n++) {
			if(line[n] - n < 0)
				continue;
			max += (line[n] - (n));
			
		}
		
		System.out.println(max);
	}
}