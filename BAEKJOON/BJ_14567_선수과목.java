import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_14567_선수과목 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	
	int[] subjects = new int[N];
	Arrays.fill(subjects, 1); // 과목 수
	
	int[][] arr = new int[M][2];
	for(int m = 0; m < M; m++) {
		st = new StringTokenizer(br.readLine());
		arr[m][0] =  Integer.parseInt(st.nextToken());
		arr[m][1] = Integer.parseInt(st.nextToken());
	}

	Arrays.sort(arr, new Comparator<int[]>() {
			@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[1] - o2[1];
		}
	});
	
	for(int i = 0; i < M; i++) {
		subjects[arr[i][1]-1] += arr[i][0];
	}
	
	System.out.println(Arrays.toString(subjects));

	
	

}
}
