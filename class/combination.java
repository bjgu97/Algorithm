import java.util.Arrays;

public class combination {
	static char[] src = {'a', 'b', 'c', 'd', 'e', 'f'};
	static int r = 3; //3개 고른다 
	static int cnt; // 조합 몇개 만들어지는지
	
	static void combinationLoop() {
		for(int i = 0; i < src.length; i++) {
			// 다음꺼부터,,,
			for(int j = i+1; j < src.length; j++) {
				for(int k = j+1; k < src.length; k++) {
					System.out.println(++cnt + ": " + Arrays.asList(src[i], src[j], src[k]));
				}
			}
		}
	}
	
	//중복조합 (j, k를 0부터 하면 순열이 되어버림)
	static void combinationLoopDup() {
		for(int i = 0; i < src.length; i++) {
			// 다음꺼부터,,,
			for(int j = i; j < src.length; j++) {
				for(int k = j; k < src.length; k++) {
					System.out.println(++cnt + ": " + Arrays.asList(src[i], src[j], src[k]));
				}
			}
		}
	}
	
	/**
	 * 
	 * @param toChoose 뽑아야할 것들의 개수
	 * @param choosed 뽑힌 것들
	 * @param idx 뽑기 시작할 위치 
	 */
	static void combination(int toChoose, char[] choosed, int startIdx) {
		if(toChoose == 0) {
			System.out.println(++cnt + Arrays.toString(choosed));
			return;
		}
		
		for(int i = startIdx; i < src.length; i++) {
			choosed[choosed.length-toChoose] = src[i];
			combination(toChoose-1, choosed, i+1);
		}
	}
	
	static void combinationDup(int toChoose, char[] choosed, int startIdx) {
		if(toChoose == 0) {
			System.out.println(++cnt + Arrays.toString(choosed));
			return;
		}
		
		for(int i = startIdx; i < src.length; i++) {
			choosed[choosed.length-toChoose] = src[i];
			
			//이번꺼부터 다시 탐색
			combinationDup(toChoose-1, choosed, i);
		}
	}
	
	public static void main(String[] args) {
		cnt = 0;
		//combinationLoop();
		//combinationLoopDup();
		//combination(r, new char[r], 0);
		combinationDup(r, new char[r], 0);
	}
}
