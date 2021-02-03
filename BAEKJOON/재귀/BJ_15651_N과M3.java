package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		// 자연수 N, M 주어져을 때 길이 M인 수열을 모두 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		List<String> arr = new ArrayList<>();
		arr.add("a");
		arr.add("b");
		arr.add("c");

		List<String> result = new ArrayList<>();
		reculsion(arr, result, arr.size(), 2);

	}

	/**
	 * 순열 구하기
	 * 
	 * @param arr    : 기준 리스트
	 * @param result : 결과를 담아줄 리스트
	 * @param n      : 전체 갯수
	 * @param r      : 뽑을 갯수
	 */
	private static void reculsion(List<String> arr, List<String> result, int n, int r) {

		if (r == 0) {

			System.out.println(result.toString());
			return;
		}

		for (int i = 0; i < n; i++) {

			result.add(arr.remove(i));
			reculsion(arr, result, n - 1, r - 1);
			arr.add(i, result.remove(result.size() - 1));
		}
	}
}