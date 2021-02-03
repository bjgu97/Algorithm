package 워밍업;

public class BAEKJOON_15596_정수N개의합 {

	long sum(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}
