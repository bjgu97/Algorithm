/**
* @since 2021. 2. 9.
* @author bjgu9
* @see https://www.acmicpc.net/problem/13458
* @mem
* @time
* @caution
* 
* 첫째 줄에 시험장의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
둘째 줄에는 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)가 주어진다.
셋째 줄에는 B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000)
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13458_시험감독 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long answer = 0;
		// 시험장 수
		int N = Integer.parseInt(br.readLine());
		
		// 각 시험장에 있는 응시자 수
		st = new StringTokenizer(br.readLine());
		int[] people = new int[N];
		for(int n = 0; n < N; n++) {
			people[n] = Integer.parseInt(st.nextToken());
		}
		
		// 총감독관이 감시 가능 학생 수, 
		// 부감독관이 감시 가능 학생 수
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 일단 각 시험장에 B 배치 하고
		// 남은 개수에는 부감독관 배치
		for(int n = 0; n < N; n++) {
			people[n] = people[n] - B;
		}
		answer = N;
		//System.out.println(Arrays.toString(people));
		//System.out.println(answer);
		
		for(int n = 0; n < N; n++) {
			if(people[n] <= 0)
				answer += 0;
			else
				answer += Math.ceil(people[n]/(double)C);
		}
		
		System.out.println(answer);
	}
}
