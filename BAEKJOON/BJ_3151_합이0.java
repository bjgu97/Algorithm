import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_3151_합이0 {
	static int N;
	static List<Integer> plusList;
	static List<Integer> minusList;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 코딩실력 좋으면 팀워크 떨어지고,
		// 팀워크 좋으면 코딩실력 떨어짐
		// 코딩실력 A : -10000 ~ 10000
		// 세 팀원 코딩실력 합 0
		// N명의 학생들 코딩실력 0인 3인조 만드는 경우의 수?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		plusList = new ArrayList<>();
		minusList = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			int num  = Integer.parseInt(st.nextToken());
			if(num < 0)
				minusList.add(num);
			else
				plusList.add(num);
		}
		
		// minus 2 plus 1
		chooseTwoComb(0, 0, minusList, plusList);
		chooseTwoComb(0, 0, plusList, minusList);
		
		System.out.println(answer);
		// minus 1 plus 2
//		comb2(0, 0);
		
	}
	
	static int[] twoNumbers = new int[2];
	static int[] oneNumbers = new int[1];
	static void chooseTwoComb(int cnt, int start, List<Integer> list, List<Integer> list2) {
		if(cnt == 2) {
			for(int i = 0; i < list2.size(); i++) {
				if(twoNumbers[0] + twoNumbers[1] + list2.get(i) == 0)
					answer++;
			}
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			twoNumbers[cnt] = list.get(i);
			chooseTwoComb(cnt+1, i+1, list, list2);
		}
	}
	

}
