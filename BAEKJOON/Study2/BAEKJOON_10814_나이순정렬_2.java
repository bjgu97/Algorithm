/**
* @since 2021. 1. 26.
* @author bjgu9
* @see
* @mem 44828 KB
* @time 368 ms
* @caution 
*/

//(1 ≤ N ≤ 100,000)
// 처음 시도: hashmap -> 중복 허용 안됨
// 두번쨰시도: 카운팅정렬 (배열) -> 나이 중복될 경우,,
package Study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BAEKJOON_10814_나이순정렬_2 {

	public static void main(String[] args) throws IOException {
		
		/* 방법 1 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		//2차원 배열 이용해서 카운팅 정렬 (첫번째 대괄호: 나이, 두번째 대괄호: 학생 수)
		String[][] arr = new String[201][N]; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			
			String name = st.nextToken();
			arr[age][i] = name; //나이 인덱스에 이름 저장! (가입 순으로)
		}
		
		for(int i = 0; i < 201; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] != null) {
					sb.append(i).append(' ').append(arr[i][j]).append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
		
		
		/* 방법 2 */
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int N = Integer.parseInt(br.readLine());
//		
//		StringBuilder[] sb = new StringBuilder[201]; // 나이(<=200)로 정렬. 
//		// 각 나이 인덱스에 이름 저장 => 순서대로 인덱스와 이름 출력 
//		
//		for(int i = 0; i < 201; i++) {
//			sb[i] = new StringBuilder();
//		}
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//			int age = Integer.parseInt(st.nextToken());
//			String name = st.nextToken();
//			
//			// sb의 age번쨰 인덱스에 나이, 이름 저장 
//			sb[age].append(age).append(" ").append(name).append("\n"); 
//		}
//
//		
//		for(StringBuilder a : sb) {
//			System.out.print(a);
//		}
		

		
		
	/* 방법3 */
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int N = Integer.parseInt(br.readLine());
	
	String[][] arr = new String[N][2];
	
	for(int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		arr[i][0] = st.nextToken();
		arr[i][1] = st.nextToken();
	}
	
	 Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
		}
		
		System.out.println(sb);
	 
}
}
